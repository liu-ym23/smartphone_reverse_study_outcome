package com.bytedance.bdinstall;

import android.content.Context;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
final class OpInstallOptionsHelper implements IInstallListener {
    private static final String kEY_INSTALL_INFO = "install_info";
    private final Context mContext;
    private InstallOptions sOptions;

    interface OnDataChangedListener {
        void onInstallInfoChanged(InstallInfo r10, String r11);
    }

    OpInstallOptionsHelper(Context r10) {
        this.mContext = r10;
    }

    InstallInfo getSavedInstallInfo() {
        return InstallInfo.parse(this.mContext.getSharedPreferences("ug_install_op_pref", 0).getString(kEY_INSTALL_INFO, null));
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.bytedance.bdinstall.IInstallListener
    public void installFinished(@NonNull InstallInfo r10) {
        if (this.sOptions != null) goto L5;
        return;
    L5:
        String r11 = r10.toJson().toString();
        if (this.sOptions.isMainInstance == false) goto L8;
        this.mContext.getSharedPreferences("ug_install_op_pref", 0).edit().putString(kEY_INSTALL_INFO, r11).apply();
    L8:
        SubpSyncManager.inst(this.mContext).sendSubpEvent(this.sOptions.getAidString(), kEY_INSTALL_INFO, r11);
    }

    public void setInstallOptions(InstallOptions r10) {
        this.sOptions = r10;
    }

    void startObserver(Context r10, final OnDataChangedListener r11) {
        if (this.sOptions != null) goto L5;
        return;
    L5:
        SubpSyncManager.inst(r10).observer(this.sOptions.getAidString(), kEY_INSTALL_INFO, new AnonymousClass1(this, r11));
    }

    void trySync() {
        InstallOptions r10 = this.sOptions;
        if (r10 != null) goto L5;
        return;
    L5:
        BDInstall.getInstance(String.valueOf(r10.getAid())).addInstallListener(true, this);
    }
}
