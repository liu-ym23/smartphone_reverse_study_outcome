package com.bytedance.bdinstall;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.bytedance.bdinstall.appstate.AppStateListener;
import com.bytedance.bdinstall.callback.RegisterResultListener;
import com.bytedance.bdinstall.event.RegisterMonitor;
import com.bytedance.bdinstall.loader.DeviceManager;
import com.bytedance.bdinstall.service.IInstallParameters;
import com.bytedance.bdinstall.service.ServiceManager;
import com.bytedance.bdinstall.util.EventUtils;
import com.bytedance.bdinstall.util.LocalConstants;
import com.bytedance.bdinstall.util.RequestIdGenerator;
import com.bytedance.crash.anr.AnrManager;
import com.bytedance.crash.resource.vmmonitor.VmMonitorConfig;
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
        RETRY_DIFF = new long[]{WorkRequest.MIN_BACKOFF_MILLIS, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, VmMonitorConfig.SLEEP_TIME_BEFORE_RECOVER, AnrManager.ANR_MIN_INTERVAL, AnrManager.ANR_MIN_INTERVAL, AnrManager.ANR_MIN_INTERVAL, 180000, 180000};
        RETRY_SAME = new long[]{180000, 360000, 540000, 540000, 900000, 1800000};
        RETRY_EMPTY = new long[]{100, 15000, 20000, 20000, VmMonitorConfig.SLEEP_TIME_BEFORE_RECOVER, VmMonitorConfig.SLEEP_TIME_BEFORE_RECOVER, 180000, 180000, 540000, 540000};
    }

    Register(InstallOptions r10, DeviceManager r11, Env r12, AppStateListener r13) {
        super(r10.getContext(), r10, getLastRegisterTime(r10.getContext(), r10, r11, r12));
        this.mManager = r11;
        this.mConfig = r10;
        this.mAppStateListener = r13;
        this.mEnv = r12;
        this.mRegisterResultListener = r11;
        this.provider = (IInstallParameters) ServiceManager.getService(IInstallParameters.class, String.valueOf(r10.getAid()));
    }

    private void doSaveRequestTime(long r10) {
        SharedPreferences r11 = this.mEnv.getEnvIsolateSp(this.mConfig);
        if (r11 == null) goto L6;
        r11.edit().putLong(Api.KEY_REGISTER_TIME, r10).apply();
        return;
    }

    private static long getLastRegisterTime(Context r10, InstallOptions r11, DeviceManager r12, Env r13) {
        if (r13 != null) goto L5;
        return 0;
    L5:
        SharedPreferences r14 = r13.getEnvIsolateSp(r11);
        if (r14 != null) goto L8;
        return 0;
    L8:
        long r15 = r14.getLong(Api.KEY_REGISTER_TIME, 0);
        InstallInfo r16 = r12.getInstallInfo();
        if (r16 == null) goto L15;
        if (Utils.checkId(r16.getDid()) == false) goto L15;
        if (Utils.checkId(r16.getIid()) == false) goto L15;
    L18:
        return r15;
    L15:
        if (r15 == 0) goto L18;
        r14.edit().putLong(Api.KEY_REGISTER_TIME, 0).apply();
        return 0;
    }

    JSONObject buildHeader() {
        JSONObject r10 = this.mManager.getConstHeader();
        JSONObject r11 = new JSONObject();
        Utils.copy(r11, r10);
        this.mManager.updateDrSpecialHeader(r11, this.mEnv);
        return r11;
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    protected void doEventTrack() {
        RegisterMonitor r10 = EventUtils.getInstance().getRegisterMonitor(this.mConfig.getAid());
        SharedPreferences r11 = LocalConstants.getCommonSp(this.mConfig.getContext(), this.mConfig);
        SharedPreferences.Editor r12 = r11.edit();
        if (r11.getBoolean(Api.SP_KEY_IS_FIRST_REGISTER_FOR_APP, false) == true) goto L6;
        if (r12 == null) goto L6;
        r12.putBoolean(Api.SP_KEY_IS_FIRST_REGISTER_FOR_APP, true);
        r12.apply();
        r10.setNewUser(true);
    L6:
        EventUtils.onRegisterResult(this.mConfig);
    }

    protected JSONObject doRequest() {
        JSONObject r10 = buildHeader();
        JSONObject r11 = null;
        if (r10 != null) goto L5;
        return null;
    L5:
        JSONObject r12 = new JSONObject();
        r12.put("header", r10);
        r12.put(Api.KEY_MAGIC, Api.MSG_MAGIC);
        r12.put("_gen_time", System.currentTimeMillis());
        if (DrLog.debug() == false) goto L8;
        DrLog.d("register request header = " + r12);
    L8:
        String r13 = Uri.parse(this.mEnv.getConfig().getRegisterUri()).buildUpon().appendQueryParameter("req_id", RequestIdGenerator.getRequestId()).build().toString();
        this.mBdInstallInstance.getsInstallLock().setRequestingRegister(true);
        if (TextUtils.isEmpty(r10.optString("device_id")) == false) goto L11;
    L13:
        boolean r14 = false;
    L25:
        RegisterMonitor r15 = EventUtils.getInstance().getRegisterMonitor(this.mConfig.getAid());     // Catch: Throwable -> L22
        if (r15 == null) goto L17;
        r15.onRegisterRequestStart();     // Catch: Throwable -> L22
    L17:
        r11 = Api.register(this.mConfig.getNetworkClient(), r13, r12, this.mConfig.encryptAndCompress(), this.mConfig.getEncryptor(), r14);     // Catch: Throwable -> L22
        if (r15 == null) goto L20;
        r15.onRegisterRequestFinish();     // Catch: Throwable -> L22
    L20:
        this.mBdInstallInstance.getsInstallLock().setRequestingRegister(false);
        EventUtils.onDidFetchResult(this.mConfig, r10, r11);
        return r11;
    L22:
        th = move-exception;
        this.mBdInstallInstance.getsInstallLock().setRequestingRegister(false);
        EventUtils.onDidFetchResult(this.mConfig, r10, r11);
        throw th;
    L11:
        if (TextUtils.isEmpty(r10.optString("install_id")) == true) goto L13;
        r14 = true;
        goto L25
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    protected boolean doWork() {
        DrLog.d("Register#doRegister");
        JSONObject r10 = doRequest();
        if (DrLog.debug() == false) goto L5;
        DrLog.d("Register#doRegister result = " + r10);
    L5:
        if (r10 == null) goto L10;
        boolean r11 = this.mRegisterResultListener.onRegisterResult(r10, this.mEnv, this.provider);
        if (r11 == false) goto L9;
        doSaveRequestTime(System.currentTimeMillis());
    L9:
        return r11;
    L10:
        return false;
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    protected String getName() {
        return "r";
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    protected long[] getRetryIntervals() {
        int r10 = this.mManager.getRegisterState();
        if (r10 == 0) goto L12;
        if (r10 == 1) goto L14;
        if (r10 == 2) goto L13;
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
    protected boolean needNet() {
        return true;
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    protected long nextInterval() {
        if (this.mAppStateListener.isForeground() == false) goto L5;
        return 21600000;
    L5:
        return 43200000;
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    protected void onResult(boolean r10) {
        EventUtils.getInstance().getRegisterMonitor(this.mConfig.getAid()).setResult(r10);
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    protected void updateFailCount(int r10) {
        RegisterMonitor r11 = EventUtils.getInstance().getRegisterMonitor(this.sOptions.getAid());
        if (r11 == null) goto L6;
        r11.setRegisterFailCount(r10);
        return;
    }
}
