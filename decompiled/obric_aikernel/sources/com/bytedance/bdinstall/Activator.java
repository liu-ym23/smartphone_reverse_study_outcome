package com.bytedance.bdinstall;

import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.bdinstall.event.ActivateMonitor;
import com.bytedance.bdinstall.intf.IAppTraitCallback;
import com.bytedance.bdinstall.util.EventUtils;
import com.bytedance.bdinstall.util.LocalConstants;
import com.bytedance.bdinstall.util.RequestIdGenerator;
import com.bytedance.bdinstall.util.SensitiveUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
class Activator extends BaseWorker {
    private ApiParamsUtil mApiParamsUtil;
    private final InstallOptions mConfig;
    private final Env mEnv;
    private boolean sHasSucceed;

    Activator(InstallOptions r10, Env r11) {
        super(r10.getContext(), r10);
        this.sHasSucceed = false;
        this.mConfig = r10;
        this.mEnv = r11;
        BdInstallInstance r12 = this.mBdInstallInstance;
        if (r12 == null) goto L6;
        this.mApiParamsUtil = r12.getApiParamsUtil();
        return;
    }

    private String buildUri() {
        String r10 = this.mEnv.getConfig().getActiveUri();
        ApiParamsUtil r11 = this.mApiParamsUtil;
        if (r11 == null) goto L5;
        r10 = r11.appendNetParams(this.mApp, new StringBuilder(r10), null, true, Level.L0);
    L5:
        StringBuilder r12 = new StringBuilder(r10);
        float r13 = getTimeZoneOffset();     // Catch: Throwable -> L26
        Api.addParams(r12, "req_id", RequestIdGenerator.getRequestId());     // Catch: Throwable -> L26
        IAppTraitCallback r14 = this.mConfig.getAppTraitCallback();     // Catch: Throwable -> L26
        if (r14 == null) goto L9;
        Api.addParams(r12, "app_trait", r14.get(this.mConfig.getContext()));     // Catch: Throwable -> L26
    L9:
        Api.addParams(r12, Api.KEY_TIMEZONE, r13 + "");     // Catch: Throwable -> L26
        String r15 = this.mConfig.getZijiePackage();     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(r15) == true) goto L29;
        Api.addParams(r12, "package", r15);     // Catch: Throwable -> L26
        Api.addParams(r12, Api.KEY_REAL_PACKAGE_NAME, this.mApp.getPackageName());     // Catch: Throwable -> L26
    L29:
        Api.addParams(r12, Api.KEY_CARRIER, SensitiveUtils.getNetworkOperatorName(this.mConfig));     // Catch: Exception -> L14 Throwable -> L26
        Api.addParams(r12, Api.KEY_MCC_MNC, SensitiveUtils.getNetworkOperator(this.mConfig));     // Catch: Exception -> L14 Throwable -> L26
        Api.addParams(r12, Api.KEY_SIM_REGION, SensitiveUtils.getSimCountryIso(this.mConfig));     // Catch: Exception -> L14 Throwable -> L26
    L16:
        ApiParamsForFlavor.addActiveParams(this.mApp, this.mConfig, r12);     // Catch: Throwable -> L26
        Api.addParams(r12, Api.KEY_APP_VERSION_MINOR, this.mConfig.getVersionMinor());     // Catch: Throwable -> L26
        Api.addParams(r12, "custom_bt", String.valueOf(getBootTime()));     // Catch: Throwable -> L26
        IExtraParams r16 = this.mConfig.getActiveParam();     // Catch: Throwable -> L26
        if (r16 == null) goto L24;
        HashMap<String, String> r17 = r16.getExtraParams(Level.L0);     // Catch: Throwable -> L26
        if (r17 == null) goto L24;
        Iterator<Map.Entry<String, String>> r18 = r17.entrySet().iterator();     // Catch: Throwable -> L26
    L22:
        if (r18.hasNext() == false) goto L24;
        Map.Entry<String, String> r19 = r18.next();     // Catch: Throwable -> L26
        Api.addParams(r12, r19.getKey(), r19.getValue());     // Catch: Throwable -> L26
    L24:
        return r12.toString();
    L14:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        DrLog.ysnp(th);
        return r12.toString();
    }

    private long getBootTime() {
        return System.currentTimeMillis() - SystemClock.elapsedRealtime();
    }

    private float getTimeZoneOffset() {
        float r10 = (TimeZone.getDefault().getRawOffset() * 1.0f) / 3600000.0f;
        if (r10 >= (-12.0f)) goto L6;
        r10 = -12.0f;
    L6:
        if (r10 > 12.0f) goto L8;
        return r10;
    L8:
        return 12.0f;
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    protected void doEventTrack() {
        ActivateMonitor r10 = EventUtils.getInstance().getActivateMonitor(this.mConfig.getAid());
        SharedPreferences r11 = LocalConstants.getCommonSp(this.mConfig.getContext(), this.mConfig);
        SharedPreferences.Editor r12 = r11.edit();
        if (r11.getBoolean(Api.SP_KEY_IS_FIRST_ACTIVATE_FOR_APP, false) == true) goto L6;
        if (r12 == null) goto L6;
        r12.putBoolean(Api.SP_KEY_IS_FIRST_ACTIVATE_FOR_APP, true);
        r12.apply();
        r10.setFirstActivate(true);
    L6:
        EventUtils.onActiveResult(this.mConfig);
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    protected boolean doWork() {
        String r10 = buildUri();
        if (TextUtils.isEmpty(r10) == false) goto L27;
        return false;
    L27:
        BdInstallInstance r11 = this.mBdInstallInstance;     // Catch: Throwable -> L22
        if (r11 == null) goto L8;
        r11.getsInstallLock().setRequestingActive(true);     // Catch: Throwable -> L22
    L8:
        ActivateMonitor r12 = EventUtils.getInstance().getActivateMonitor(this.mConfig.getAid());     // Catch: Throwable -> L22
        if (r12 == null) goto L11;
        r12.onActivateRequestStart();     // Catch: Throwable -> L22
    L11:
        boolean r13 = Api.active(this.mConfig.getNetworkClient(), r10, this.mConfig.encryptAndCompress(), this.mConfig.getEncryptor(), this.sHasSucceed);     // Catch: Throwable -> L22
        if (r12 == null) goto L14;
        r12.onActivateRequestFinish();     // Catch: Throwable -> L22
    L14:
        if (r13 == false) goto L16;
        this.sHasSucceed = true;     // Catch: Throwable -> L22
    L16:
        BdInstallInstance r14 = this.mBdInstallInstance;
        if (r14 == null) goto L19;
        r14.getsInstallLock().setRequestingActive(false);
    L19:
        if (r13 == false) goto L21;
        stop();
    L21:
        return r13;
    L22:
        th = move-exception;
        BdInstallInstance r15 = this.mBdInstallInstance;
        if (r15 == null) goto L26;
        r15.getsInstallLock().setRequestingActive(false);
    L26:
        throw th;
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    protected String getName() {
        return Api.KEY_AC;
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    protected long[] getRetryIntervals() {
        return Register.RETRY_DIFF;
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
        return 0;
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    protected void onResult(boolean r10) {
        EventUtils.getInstance().getActivateMonitor(this.mConfig.getAid()).setResult(r10);
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    protected void updateFailCount(int r10) {
        ActivateMonitor r11 = EventUtils.getInstance().getActivateMonitor(this.sOptions.getAid());
        if (r11 == null) goto L6;
        r11.setActivateFailCount(r10);
        return;
    }
}
