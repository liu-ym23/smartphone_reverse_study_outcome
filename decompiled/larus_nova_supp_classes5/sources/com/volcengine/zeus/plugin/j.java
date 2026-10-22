package com.volcengine.zeus.plugin;

import com.volcengine.zeus.log.ZeusLogger;
import java.io.File;
import java.io.FileFilter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class j implements FileFilter {
    public j() {
    }

    @Override // java.io.FileFilter
    public final boolean accept(File r8) {
        if (r8 != null) goto L6;
        return false;
    L6:
        if (r8.getName().endsWith(".apk") == false) goto L8;
    L19:
        PluginManager.getInstance().asyncInstall(null, r8, "hot_update_after_reboot");
        return true;
    L8:
        if (r8.getName().endsWith(".jar") == true) goto L19;
        if (r8.getAbsolutePath().endsWith(".temp") == true) goto L15;
        if (r8.getAbsolutePath().endsWith(".tp") == true) goto L15;
    L17:
        mqc.i.e(r8);
        ZeusLogger.w("Zeus/init_zeus", "ZeusScanRunnable installPluginDir deleted : " + r8);
    L18:
        return false;
    L15:
        if ((System.currentTimeMillis() - r8.lastModified()) >= 259200000) goto L17;
        ZeusLogger.w("Zeus/init_zeus", "ZeusScanRunnable installPluginDir find : " + r8);
        goto L18
    }
}
