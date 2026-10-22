package com.bytedance.bdinstall;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.bdinstall.appstate.AppStateListener;
import com.bytedance.bdinstall.callback.RegisterResultListener;
import com.bytedance.bdinstall.dtrait.DTraitService;
import com.bytedance.bdinstall.dtrait.config.DTraitConfig;
import com.bytedance.bdinstall.dtrait.manager.DTraitServiceManager;
import com.bytedance.bdinstall.dtrait.model.DTraitTimeMonitorEvent;
import com.bytedance.bdinstall.event.RegisterMonitor;
import com.bytedance.bdinstall.loader.DeviceManager;
import com.bytedance.bdinstall.network.TTResponse;
import com.bytedance.bdinstall.service.IInstallParameters;
import com.bytedance.bdinstall.service.ServiceManager;
import com.bytedance.bdinstall.util.EventUtils;
import com.bytedance.bdinstall.util.LocalConstants;
import com.bytedance.bdinstall.util.RequestIdGenerator;
import com.obric.cae.userAware.SubwayFusionAware.SubwayUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class Register extends BaseWorker {
    private static final int REFRESH_BG = 43200000;
    private static final int REFRESH_UI = 21600000;
    static final long[] RETRY_DIFF = null;
    private static final long[] RETRY_EMPTY = null;
    private static final long[] RETRY_SAME = null;
    private final AppStateListener mAppStateListener;
    private final InstallOptions mConfig;
    private final Env mEnv;
    private final DeviceManager mManager;
    private final RegisterResultListener mRegisterResultListener;
    private final IInstallParameters provider;

    static {
        RETRY_DIFF = new long[]{10000, 30000, 60000, 120000, 120000, 120000, 180000, 180000};
        RETRY_SAME = new long[]{180000, 360000, 540000, 540000, 900000, 1800000};
        RETRY_EMPTY = new long[]{100, SubwayUtils.OUTDOOR_PUNISH_DELAY_TIME, 20000, 20000, 60000, 60000, 180000, 180000, 540000, 540000};
    }

    Register(InstallOptions r5, DeviceManager r6, Env r7, AppStateListener r8) {
        AppStateListener r9 = (AppStateListener) ZeusTransformUtils.wrapperContextForParams(r8, AppStateListener.class, "com.obric.memorydata.plugin");
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r5, getLastRegisterTime((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r5, r6, r7));
        this.mManager = r6;
        this.mConfig = r5;
        this.mAppStateListener = r9;
        this.mEnv = r7;
        this.mRegisterResultListener = r6;
        this.provider = (IInstallParameters) ZeusTransformUtils.preCheckCast(ServiceManager.getService(IInstallParameters.class, String.valueOf(r5.getAid())), IInstallParameters.class, "com.obric.memorydata.plugin");
    }

    private void doSaveRequestTime(long r2) {
        SharedPreferences r1 = this.mEnv.getEnvIsolateSp(this.mConfig);
        if (r1 == null) goto L6;
        r1.edit().putLong(Api.KEY_REGISTER_TIME, r2).apply();
        return;
    }

    private static long getLastRegisterTime(Context r4, InstallOptions r5, DeviceManager r6, Env r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L5;
        return 0;
    L5:
        SharedPreferences r9 = r7.getEnvIsolateSp(r5);
        if (r9 != null) goto L8;
        return 0;
    L8:
        long r2 = r9.getLong(Api.KEY_REGISTER_TIME, 0);
        InstallInfo r10 = r6.getInstallInfo();
        if (r10 == null) goto L15;
        if (Utils.checkId(r10.getDid()) == false) goto L15;
        if (Utils.checkId(r10.getIid()) == false) goto L15;
    L18:
        return r2;
    L15:
        if (r2 == 0) goto L18;
        r9.edit().putLong(Api.KEY_REGISTER_TIME, 0).apply();
        return 0;
    }

    JSONObject buildHeader() {
        JSONObject r0 = this.mManager.getConstHeader();
        JSONObject r1 = new JSONObject();
        Utils.copy(r1, r0);
        this.mManager.updateDrSpecialHeader(r1, this.mEnv);
        return r1;
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    public void doEventTrack() {
        RegisterMonitor r0 = EventUtils.getInstance().getRegisterMonitor(this.mConfig.getAid());
        SharedPreferences r1 = LocalConstants.getCommonSp((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this.mConfig);
        SharedPreferences.Editor r2 = r1.edit();
        if (r1.getBoolean(Api.SP_KEY_IS_FIRST_REGISTER_FOR_APP, false) == true) goto L6;
        if (r2 == null) goto L6;
        r2.putBoolean(Api.SP_KEY_IS_FIRST_REGISTER_FOR_APP, true);
        r2.apply();
        r0.setNewUser(true);
    L6:
        EventUtils.onRegisterResult(this.mConfig);
    }

    public TTResponse doRequest() {
        String r0 = "{}";
        JSONObject r1 = buildHeader();
        TTResponse r2 = null;
        if (r1 != null) goto L5;
        return null;
    L5:
        JSONObject r6 = new JSONObject();
        r6.put("header", r1);
        r6.put(Api.KEY_MAGIC, Api.MSG_MAGIC);
        r6.put("_gen_time", System.currentTimeMillis());
        if (DrLog.debug() == false) goto L8;
        DrLog.d("register request header = " + r6);
    L8:
        String r5 = Uri.parse(this.mEnv.getConfig().getRegisterUri()).buildUpon().appendQueryParameter("req_id", RequestIdGenerator.getRequestId()).build().toString();
        this.mBdInstallInstance.getsInstallLock().setRequestingRegister(true);
        if (TextUtils.isEmpty(r1.optString("device_id")) == false) goto L11;
    L13:
        boolean r9 = false;
    L35:
        RegisterMonitor r12 = EventUtils.getInstance().getRegisterMonitor(this.mConfig.getAid());     // Catch: Throwable -> L26
        if (r12 == null) goto L17;
        r12.onRegisterRequestStart();     // Catch: Throwable -> L26
    L17:
        r2 = Api.register(this.mConfig.getNetworkClient(), BDInstall.getBDInstallConfig().getNetworkClientWrapper(), r5, r6, this.mConfig.encryptAndCompress(), this.mConfig.getEncryptor(), r9, this.mManager.getTicketGuardHelper().getTicketHeader(r5, true, true));     // Catch: Throwable -> L26
        if (r12 == null) goto L20;
        r12.onRegisterRequestFinish();     // Catch: Throwable -> L26
    L20:
        this.mBdInstallInstance.getsInstallLock().setRequestingRegister(false);
        InstallOptions r14 = this.mConfig;     // Catch: Exception -> L33
        if (r2 == null) goto L24;
        r0 = r2.getBody();     // Catch: Exception -> L33
    L24:
        EventUtils.onDidFetchResult(r14, r1, new JSONObject(r0));     // Catch: Exception -> L33
    L25:
        return r2;
    L26:
        th = move-exception;
        this.mBdInstallInstance.getsInstallLock().setRequestingRegister(false);
        InstallOptions r15 = this.mConfig;     // Catch: Exception -> L34
        if (r2 == null) goto L31;
        r0 = r2.getBody();     // Catch: Exception -> L34
    L31:
        EventUtils.onDidFetchResult(r15, r1, new JSONObject(r0));     // Catch: Exception -> L34
    L32:
        throw th;
    L11:
        if (TextUtils.isEmpty(r1.optString("install_id")) == true) goto L13;
        r9 = true;
        goto L35
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    public boolean doWork() {
        DrLog.d("Register#doRegister");
        DTraitTimeMonitorEvent.setDeviceRegisterStart();
        TTResponse r0 = doRequest();
        if (DrLog.debug() == false) goto L5;
        DrLog.d("Register#doRegister result = " + r0);
    L5:
        if (r0 == null) goto L21;
        int r1 = r0.getStatus();
        if (r1 != (-555)) goto L9;
    L19:
        DrLog.e("doRegister# hit net fallback,code=" + r1);
        return true;
    L9:
        if (r1 == 429) goto L19;
        boolean r2 = this.mRegisterResultListener.onRegisterResult(r0, this.mEnv, this.provider);
        if (r2 == false) goto L18;
        doSaveRequestTime(System.currentTimeMillis());
        if (DTraitConfig.isEnableDTrait() == false) goto L18;
        DTraitService r3 = (DTraitService) ZeusTransformUtils.preCheckCast(DTraitServiceManager.getService(DTraitService.class), DTraitService.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L18;
        r3.getDTraitManager().collectLoaderReport(this.mManager.getHeader());
        DrLog.d("enable bypass finger collect...... ");
    L18:
        return r2;
    L21:
        return false;
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    public String getName() {
        return "r";
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    public long[] getRetryIntervals() {
        int r1 = this.mManager.getRegisterState();
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L14;
        if (r1 == 2) goto L13;
        DrLog.ysnp(null);
        goto L14
    L13:
        return RETRY_DIFF;
    L14:
        return RETRY_SAME;
    L12:
        return RETRY_EMPTY;
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    public boolean needListenNetChange() {
        return true;
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    public boolean needNet() {
        return true;
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    public long nextInterval() {
        if (this.mAppStateListener.isForeground() == false) goto L5;
        return 21600000;
    L5:
        return 43200000;
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    public void onResult(boolean r2) {
        EventUtils.getInstance().getRegisterMonitor(this.mConfig.getAid()).setResult(r2);
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    public void updateFailCount(int r2) {
        RegisterMonitor r1 = EventUtils.getInstance().getRegisterMonitor(this.sOptions.getAid());
        if (r1 == null) goto L6;
        r1.setRegisterFailCount(r2);
        return;
    }
}
