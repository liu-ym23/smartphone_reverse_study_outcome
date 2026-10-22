package com.bytedance.bdinstall;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.bdinstall.event.ActivateMonitor;
import com.bytedance.bdinstall.intf.IAppTraitCallback;
import com.bytedance.bdinstall.network.TTResponse;
import com.bytedance.bdinstall.util.EventUtils;
import com.bytedance.bdinstall.util.LocalConstants;
import com.bytedance.bdinstall.util.RequestIdGenerator;
import com.bytedance.bdinstall.util.SensitiveUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class Activator extends BaseWorker {
    private ApiParamsUtil mApiParamsUtil;
    private final InstallOptions mConfig;
    private final Env mEnv;
    private boolean sHasSucceed;
    private final SharedPreferences sp;

    Activator(InstallOptions r4, Env r5) {
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4);
        this.sHasSucceed = false;
        this.mConfig = r4;
        this.mEnv = r5;
        if (this.mBdInstallInstance == null) goto L5;
        this.mApiParamsUtil = this.mBdInstallInstance.getApiParamsUtil();
    L5:
        this.sp = LocalConstants.getCommonSp(this.mApp, r4);
        parseActiveFlag();
    }

    private String buildUri() {
        String r0 = this.mEnv.getConfig().getActiveUri();
        ApiParamsUtil r1 = this.mApiParamsUtil;
        if (r1 == null) goto L5;
        r0 = r1.appendNetParams(this.mApp, new StringBuilder(r0), null, true, Level.L0);
    L5:
        StringBuilder r2 = new StringBuilder(r0);
        float r3 = getTimeZoneOffset();     // Catch: Throwable -> L27
        Api.addParams(r2, "req_id", RequestIdGenerator.getRequestId());     // Catch: Throwable -> L27
        IAppTraitCallback r4 = this.mConfig.getAppTraitCallback();     // Catch: Throwable -> L27
        if (r4 == null) goto L10;
        Api.addParams(r2, "app_trait", r4.get((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L27
    L10:
        Api.addParams(r2, Api.KEY_TIMEZONE, r3 + "");     // Catch: Throwable -> L27
        String r5 = this.mConfig.getZijiePackage();     // Catch: Throwable -> L27
        if (TextUtils.isEmpty(r5) == true) goto L30;
        Api.addParams(r2, "package", r5);     // Catch: Throwable -> L27
        Api.addParams(r2, Api.KEY_REAL_PACKAGE_NAME, this.mApp.getPackageName());     // Catch: Throwable -> L27
    L30:
        Api.addParams(r2, Api.KEY_CARRIER, SensitiveUtils.getNetworkOperatorName(this.mConfig));     // Catch: Exception -> L15 Throwable -> L27
        Api.addParams(r2, Api.KEY_MCC_MNC, SensitiveUtils.getNetworkOperator(this.mConfig));     // Catch: Exception -> L15 Throwable -> L27
        Api.addParams(r2, Api.KEY_SIM_REGION, SensitiveUtils.getSimCountryIso(this.mConfig));     // Catch: Exception -> L15 Throwable -> L27
    L17:
        ApiParamsForFlavor.addActiveParams(this.mApp, this.mConfig, r2);     // Catch: Throwable -> L27
        Api.addParams(r2, Api.KEY_APP_VERSION_MINOR, this.mConfig.getVersionMinor());     // Catch: Throwable -> L27
        Api.addParams(r2, "custom_bt", String.valueOf(getBootTime()));     // Catch: Throwable -> L27
        IExtraParams r7 = this.mConfig.getActiveParam();     // Catch: Throwable -> L27
        if (r7 == null) goto L25;
        HashMap<String, String> r8 = r7.getExtraParams(Level.L0);     // Catch: Throwable -> L27
        if (r8 == null) goto L25;
        Iterator<Map.Entry<String, String>> r9 = r8.entrySet().iterator();     // Catch: Throwable -> L27
    L23:
        if (r9.hasNext() == false) goto L25;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        Api.addParams(r2, (String) ZeusTransformUtils.preCheckCast(r6.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r6.getValue(), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L27
    L25:
        return r2.toString();
    L15:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        DrLog.ysnp(th);
        return r2.toString();
    }

    private long getBootTime() {
        return System.currentTimeMillis() - SystemClock.elapsedRealtime();
    }

    private float getTimeZoneOffset() {
        float r2 = (TimeZone.getDefault().getRawOffset() * 1.0f) / 3600000.0f;
        if (r2 >= (-12.0f)) goto L6;
        r2 = -12.0f;
    L6:
        if (r2 > 12.0f) goto L8;
        return r2;
    L8:
        return 12.0f;
    }

    private void parseActiveFlag() {
        String r0 = this.mBdInstallInstance.getInstallInfo().getIid();     // Catch: Exception -> L9
        if (TextUtils.isEmpty(r0) == false) goto L6;
        return;
    L6:
        if (this.sp.contains(r0) == false) goto L12;
        this.sHasSucceed = this.sp.getBoolean(r0, false);     // Catch: Exception -> L9
        DrLog.d("active# is_activated:" + this.sHasSucceed);     // Catch: Exception -> L9
        return;
    L12:
        return;
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    public void doEventTrack() {
        ActivateMonitor r0 = EventUtils.getInstance().getActivateMonitor(this.mConfig.getAid());
        SharedPreferences r1 = LocalConstants.getCommonSp((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this.mConfig);
        SharedPreferences.Editor r2 = r1.edit();
        if (r1.getBoolean(Api.SP_KEY_IS_FIRST_ACTIVATE_FOR_APP, false) == true) goto L6;
        if (r2 == null) goto L6;
        r2.putBoolean(Api.SP_KEY_IS_FIRST_ACTIVATE_FOR_APP, true);
        r2.apply();
        r0.setFirstActivate(true);
    L6:
        EventUtils.onActiveResult(this.mConfig);
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    public boolean doWork() {
        String r2 = buildUri();
        if (TextUtils.isEmpty(r2) == false) goto L65;
        return false;
    L65:
    L55:
        th = move-exception;
        if (this.mBdInstallInstance == null) goto L59;
        this.mBdInstallInstance.getsInstallLock().setRequestingActive(false);
    L59:
        throw th;
    L6:
        if (this.mBdInstallInstance == null) goto L8;
        this.mBdInstallInstance.getsInstallLock().setRequestingActive(true);     // Catch: Throwable -> L55
    L8:
        ActivateMonitor r8 = EventUtils.getInstance().getActivateMonitor(this.mConfig.getAid());     // Catch: Throwable -> L55
        if (r8 == null) goto L11;
        r8.onActivateRequestStart();     // Catch: Throwable -> L55
    L11:
        TTResponse r0 = Api.active(this.mConfig.getNetworkClient(), BDInstall.getBDInstallConfig().getNetworkClientWrapper(), r2, this.mConfig.encryptAndCompress(), this.mConfig.getEncryptor(), this.sHasSucceed);     // Catch: Throwable -> L55
        if (r0 == null) goto L37;
        int r1 = r0.getStatus();     // Catch: Throwable -> L55
        if (r1 != (-555)) goto L17;
    L32:
        DrLog.e("doActive# hit net fallback and stop,code=" + r1);     // Catch: Throwable -> L55
        stop();     // Catch: Throwable -> L55
        if (this.mBdInstallInstance == null) goto L36;
        this.mBdInstallInstance.getsInstallLock().setRequestingActive(false);
    L36:
        return true;
    L17:
        if (r1 == 429) goto L32;
        JSONObject r3 = new JSONObject(r0.getBody());     // Catch: JSONException -> L29 Throwable -> L55
        JSONObject r4 = r3.optJSONObject("data");     // Catch: JSONException -> L29 Throwable -> L55
        if (r4 == null) goto L24;
        if (r4.optInt(Api.SP_KEY_IS_ACTIVATED, -1) != 1) goto L24;
        boolean r5 = true;
    L66:
        DrLog.d("active response body " + r3);     // Catch: JSONException -> L27 Throwable -> L55
    L38:
        if (r8 == null) goto L40;
        r8.onActivateRequestFinish();     // Catch: Throwable -> L55
    L40:
        if (r5 == false) goto L50;
        if (this.mBdInstallInstance != null) goto L63;
    L48:
        this.sHasSucceed = true;     // Catch: Throwable -> L55
        goto L50
    L63:
        String r6 = this.mBdInstallInstance.getInstallInfo().getIid();     // Catch: Exception -> L60 Throwable -> L55
        if (this.sp.contains(r6) == true) goto L48;
        if (TextUtils.isEmpty(r6) == true) goto L48;
        this.sp.edit().putBoolean(r6, true).apply();     // Catch: Exception -> L60 Throwable -> L55
    L50:
        if (this.mBdInstallInstance == null) goto L52;
        this.mBdInstallInstance.getsInstallLock().setRequestingActive(false);
    L52:
        if (r5 == false) goto L54;
        stop();
    L54:
        return r5;
    L27:
        e = e;
    L31:
        DrLog.e("active parse json error " + r0 + ", ", e);     // Catch: Throwable -> L55
    L24:
        r5 = false;
    L29:
        e = e;
        r5 = false;
        goto L31
    L37:
        r5 = false;
        goto L38
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    public String getName() {
        return Api.KEY_AC;
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    public long[] getRetryIntervals() {
        return Register.RETRY_DIFF;
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
        return 0;
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    public void onResult(boolean r2) {
        EventUtils.getInstance().getActivateMonitor(this.mConfig.getAid()).setResult(r2);
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    public void updateFailCount(int r3) {
        ActivateMonitor r2 = EventUtils.getInstance().getActivateMonitor(this.sOptions.getAid());
        if (r2 == null) goto L6;
        r2.setActivateFailCount(r3);
        return;
    }
}
