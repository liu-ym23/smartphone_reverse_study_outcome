package com.bytedance.bdinstall.loader;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.InstallOptions;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class PackageLoader extends BaseLoader {
    private final Context mApp;
    private final InstallOptions mConfig;

    PackageLoader(Context r3, InstallOptions r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        super(false, false);
        this.mApp = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
        this.mConfig = r4;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    public boolean doLoad(JSONObject r6) {
        String r0 = this.mApp.getPackageName();
        if (TextUtils.isEmpty(this.mConfig.getZijiePackage()) == false) goto L6;
        r6.put("package", r0);
    L31:
        r6.put("app_version", this.mConfig.getVersion());     // Catch: Throwable -> L26
        r6.put(Api.KEY_APP_VERSION_MINOR, this.mConfig.getVersionMinor());     // Catch: Throwable -> L26
        r6.put("version_code", this.mConfig.getVersionCode());     // Catch: Throwable -> L26
        r6.put("update_version_code", this.mConfig.getUpdateVersionCode());     // Catch: Throwable -> L26
        r6.put("manifest_version_code", this.mConfig.getManifestVersionCode());     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(this.mConfig.getAppName()) == true) goto L14;
        r6.put(Api.KEY_APP_NAME, this.mConfig.getAppName());     // Catch: Throwable -> L26
    L14:
        if (TextUtils.isEmpty(this.mConfig.getTweakedChannel()) == true) goto L29;
        r6.put(Api.KEY_TWEAKED_CHANNEL, this.mConfig.getTweakedChannel());     // Catch: Throwable -> L26
    L29:
        PackageInfo r1 = this.mApp.getPackageManager().getPackageInfo(r0, 0);     // Catch: Throwable -> L22
        if (r1.applicationInfo == null) goto L33;
        int r2 = r1.applicationInfo.labelRes;     // Catch: Throwable -> L22
        if (r2 <= 0) goto L34;
        r6.put(Api.KEY_DISPLAY_NAME, this.mApp.getString(r2));     // Catch: Throwable -> L22
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
        r6.put("package", this.mConfig.getZijiePackage());
        r6.put(Api.KEY_REAL_PACKAGE_NAME, r0);
        goto L31
    }
}
