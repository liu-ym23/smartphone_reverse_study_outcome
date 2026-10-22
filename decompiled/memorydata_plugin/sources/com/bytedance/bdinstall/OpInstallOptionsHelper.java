package com.bytedance.bdinstall;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
final class OpInstallOptionsHelper implements IInstallListener {
    private static final String SP_KEY_APPLOG_STATS = "applog_stats";
    private static final String SP_KEY_SNSSDK = "snssdk_openudid";
    private static final String kEY_INSTALL_INFO = "install_info";
    private final Context mContext;
    private InstallOptions sOptions;

    interface OnDataChangedListener {
        void onInstallInfoChanged(InstallInfo r1, String r2);
    }

    OpInstallOptionsHelper(Context r3) {
        this.mContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }

    private String offsetInstallInfo() {
        HashMap r1 = new HashMap();
        SharedPreferences r2 = this.mContext.getSharedPreferences(SP_KEY_APPLOG_STATS, 0);     // Catch: Exception -> L5
        SharedPreferences r6 = this.mContext.getSharedPreferences("snssdk_openudid", 0);     // Catch: Exception -> L5
        r1.put("did", r2.getString("device_id", null));     // Catch: Exception -> L5
        r1.put("iid", r2.getString("install_id", null));     // Catch: Exception -> L5
        r1.put("client_udid", r6.getString("clientudid", null));     // Catch: Exception -> L5
        r1.put("openudid", r6.getString("openudid", null));     // Catch: Exception -> L5
        DrLog.d("offset_did offset installinfo is " + r1);     // Catch: Exception -> L5
    L8:
        return r1.toString();
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    InstallInfo getSavedInstallInfo() {
        String r1 = this.mContext.getSharedPreferences("ug_install_op_pref", 0).getString(kEY_INSTALL_INFO, null);     // Catch: Exception -> L10
        if (TextUtils.isEmpty(r1) == true) goto L6;
    L8:
        return InstallInfo.parse(r1);
    L6:
        if (Utils.isOffsetInstallInfo() == false) goto L8;
        r1 = offsetInstallInfo();     // Catch: Exception -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.bytedance.bdinstall.IInstallListener
    public void installFinished(InstallInfo r5) {
        if (this.sOptions != null) goto L5;
        return;
    L5:
        String r6 = r5.toJson().toString();
        if (this.sOptions.isMainInstance == false) goto L8;
        this.mContext.getSharedPreferences("ug_install_op_pref", 0).edit().putString(kEY_INSTALL_INFO, r6).apply();
    L8:
        SubpSyncManager.inst(this.mContext).sendSubpEvent(this.sOptions.getAidString(), kEY_INSTALL_INFO, r6);
    }

    public void setInstallOptions(InstallOptions r1) {
        this.sOptions = r1;
    }

    void startObserver(Context r3, OnDataChangedListener r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        final OnDataChangedListener r6 = (OnDataChangedListener) ZeusTransformUtils.wrapperContextForParams(r4, OnDataChangedListener.class, "com.obric.memorydata.plugin");
        if (this.sOptions != null) goto L5;
        return;
    L5:
        SubpSyncManager.inst(r5).observer(this.sOptions.getAidString(), kEY_INSTALL_INFO, new AnonymousClass1(this, r6));
    }

    void trySync() {
        InstallOptions r0 = this.sOptions;
        if (r0 != null) goto L5;
        return;
    L5:
        BDInstall.getInstance(String.valueOf(r0.getAid())).addInstallListener(true, this);
    }
}
