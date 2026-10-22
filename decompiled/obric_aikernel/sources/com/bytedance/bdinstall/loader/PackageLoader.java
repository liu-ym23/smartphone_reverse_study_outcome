package com.bytedance.bdinstall.loader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.InstallOptions;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class PackageLoader extends BaseLoader {
    private final Context mApp;
    private final InstallOptions mConfig;

    PackageLoader(Context r10, InstallOptions r11) {
        super(false, false);
        this.mApp = r10;
        this.mConfig = r11;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    protected boolean doLoad(JSONObject r10) {
        String r11 = this.mApp.getPackageName();
        if (TextUtils.isEmpty(this.mConfig.getZijiePackage()) == false) goto L6;
        r10.put("package", r11);
    L31:
        r10.put("app_version", this.mConfig.getVersion());     // Catch: Throwable -> L26
        r10.put(Api.KEY_APP_VERSION_MINOR, this.mConfig.getVersionMinor());     // Catch: Throwable -> L26
        r10.put("version_code", this.mConfig.getVersionCode());     // Catch: Throwable -> L26
        r10.put("update_version_code", this.mConfig.getUpdateVersionCode());     // Catch: Throwable -> L26
        r10.put("manifest_version_code", this.mConfig.getManifestVersionCode());     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(this.mConfig.getAppName()) == true) goto L14;
        r10.put(Api.KEY_APP_NAME, this.mConfig.getAppName());     // Catch: Throwable -> L26
    L14:
        if (TextUtils.isEmpty(this.mConfig.getTweakedChannel()) == true) goto L29;
        r10.put(Api.KEY_TWEAKED_CHANNEL, this.mConfig.getTweakedChannel());     // Catch: Throwable -> L26
    L29:
        ApplicationInfo r12 = this.mApp.getPackageManager().getPackageInfo(r11, 0).applicationInfo;     // Catch: Throwable -> L22
        if (r12 == null) goto L33;
        int r13 = r12.labelRes;     // Catch: Throwable -> L22
        if (r13 <= 0) goto L34;
        r10.put(Api.KEY_DISPLAY_NAME, this.mApp.getString(r13));     // Catch: Throwable -> L22
    L35:
        return true;
    L34:
        return true;
    L33:
        return true;
    L22:
        th = move-exception;
        DrLog.e("PackageLoader#getPackageInfo error", th);     // Catch: Throwable -> L26
        return true;
    L26:
        th = move-exception;
        DrLog.ysnp(th);
        return false;
    L6:
        if (DrLog.debug() == false) goto L8;
        DrLog.d("has zijie pkg");
    L8:
        r10.put("package", this.mConfig.getZijiePackage());
        r10.put(Api.KEY_REAL_PACKAGE_NAME, r11);
        goto L31
    }
}
