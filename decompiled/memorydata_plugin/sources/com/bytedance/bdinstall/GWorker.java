package com.bytedance.bdinstall;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.bdinstall.appstate.AppStateListener;
import com.bytedance.bdinstall.loader.DeviceManager;
import com.bytedance.bdinstall.network.TTResponse;
import com.bytedance.bdinstall.util.LocalConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class GWorker extends Register {
    public static final long INTERVAL = 10000;
    private final long[] RETRY_INTERVAL;
    private final InstallOptions mConfig;

    GWorker(InstallOptions r3, DeviceManager r4, Env r5, AppStateListener r6) {
        super(r3, r4, r5, (AppStateListener) ZeusTransformUtils.wrapperContextForParams(r6, AppStateListener.class, "com.obric.memorydata.plugin"));
        this.RETRY_INTERVAL = new long[]{10000, 10000, 10000};
        this.mConfig = r3;
    }

    @Override // com.bytedance.bdinstall.Register, com.bytedance.bdinstall.BaseWorker
    public void doEventTrack() {
    }

    @Override // com.bytedance.bdinstall.Register, com.bytedance.bdinstall.BaseWorker
    public boolean doWork() {
        if (this.mFailCount < this.RETRY_INTERVAL.length) goto L6;
        DrLog.d("[egdi]  retry count has limited and stop worker");
        stop();
        return true;
    L6:
        TTResponse r1 = doRequest();
        if (r1 != null) goto L9;
        return false;
    L9:
        int r4 = r1.getStatus();
        if (r4 != (-555)) goto L12;
    L27:
        DrLog.e("doEgdi# hit net fallback,code=" + r4);
        return true;
    L12:
        if (r4 == 429) goto L27;
        String r2 = new JSONObject(r1.getBody()).optString(Api.KEY_KLINK_EGDI, "");     // Catch: JSONException -> L24
        if (TextUtils.isEmpty(r2) == false) goto L18;
        DrLog.d("[egdi]  egdi is null");     // Catch: JSONException -> L24
        return false;
    L18:
        SharedPreferences r3 = this.mConfig.getSp();     // Catch: JSONException -> L24
        SharedPreferences r6 = LocalConstants.getCommonSp(this.mApp, this.mConfig);     // Catch: JSONException -> L24
        if (r3 == null) goto L21;
        r3.edit().putString(Api.KEY_KLINK_EGDI, r2).apply();     // Catch: JSONException -> L24
        DrLog.d("[egdi]  egdi is cached to olad sp applog_stats");     // Catch: JSONException -> L24
    L21:
        if (r6 == null) goto L26;
        r6.edit().putString(Api.KEY_KLINK_EGDI, r2).apply();     // Catch: JSONException -> L24
        DrLog.d("[egdi]  egdi is cached to global sp ug_install_settings_pref_aid");     // Catch: JSONException -> L24
    L26:
        return true;
    L24:
        e = move-exception;
        DrLog.e("[egdi] " + e.getMessage(), e);
        goto L26
    }

    @Override // com.bytedance.bdinstall.Register, com.bytedance.bdinstall.BaseWorker
    public String getName() {
        return "GWorker";
    }

    @Override // com.bytedance.bdinstall.Register, com.bytedance.bdinstall.BaseWorker
    public long[] getRetryIntervals() {
        int r0 = BDInstall.getBDInstallConfig().getEgdiRetryInterval();
        if (r0 <= 0) goto L7;
        long r2 = r0;
        return new long[]{r2, r2, r2};
    L7:
        return this.RETRY_INTERVAL;
    }

    @Override // com.bytedance.bdinstall.Register, com.bytedance.bdinstall.BaseWorker
    public /* bridge */ /* synthetic */ boolean needListenNetChange() {
        return super.needListenNetChange();
    }

    @Override // com.bytedance.bdinstall.Register, com.bytedance.bdinstall.BaseWorker
    public long nextInterval() {
        return super.nextInterval();
    }

    @Override // com.bytedance.bdinstall.Register, com.bytedance.bdinstall.BaseWorker
    public void onResult(boolean r1) {
    }

    @Override // com.bytedance.bdinstall.Register, com.bytedance.bdinstall.BaseWorker
    public void updateFailCount(int r1) {
    }
}
