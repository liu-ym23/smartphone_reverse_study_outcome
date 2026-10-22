package com.volcengine.zeus.download;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.log.ZeusLogger;
import com.volcengine.zeus.plugin.Plugin;
import com.volcengine.zeus.plugin.PluginManager;
import java.io.File;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class a {
    public a() {
    }

    public static boolean a(PluginDownloadBean r6) {
        Plugin r0 = Zeus.getPlugin(r6.mPackageName);
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L13;
        String r2 = r6.mPackageName;
        int r3 = r6.mVersionCode;
        StringBuilder r4 = new StringBuilder();
        dqc.c.k();
        r4.append(dqc.c.a.getPath());
        String r5 = File.separator;
        r4.append(r5);
        r4.append(r2);
        r4.append(r5);
        r4.append("version-");
        r4.append(r3);
        if (new PolarisFileWrapper(r4.toString()).exists() == false) goto L13;
        ZeusLogger.w("Zeus/download_zeus", "interceptPluginDownload, packageName:" + r6.mPackageName + " downloadVersionCode:" + r6.mVersionCode);
        return true;
    L13:
        return false;
    L5:
        if (r0.isVersionInstalled(r6.mVersionCode) == false) goto L7;
        r1 = true;
        goto L8
    }

    public static boolean b(PluginDownloadBean r4) {
        if (r4.isUnInstall() == true) goto L10;
        if (r4.isRevert() == true) goto L10;
        return true;
    L10:
        if (r4.isUnInstall() == false) goto L12;
        String r0 = "unInstall";
    L14:
        if (r4.isUnInstall() == false) goto L16;
        PluginManager.getInstance().tryOfflineInternalPlugin(r4.mPackageName, r4.mVersionCode);
    L16:
        ZeusLogger.d("pluginDownloadBean.".concat(r0));
        Zeus.unInstallPlugin(r4.mPackageName);
        return false;
    L12:
        r0 = "revert";
        goto L14
    }
}
