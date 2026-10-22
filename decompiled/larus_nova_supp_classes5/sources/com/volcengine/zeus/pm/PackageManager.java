package com.volcengine.zeus.pm;

import android.os.Looper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.volcengine.zeus.IPackageManager;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.log.ZeusLogger;
import com.volcengine.zeus.plugin.PluginManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class PackageManager extends IPackageManager.Stub {
    private static volatile PackageManager sInstance;

    public static PackageManager getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(PackageManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new PackageManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(PackageManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public PackageManager() {
    }

    public int getInstalledVersion(String r2) {
        return PluginManager.getInstance().getPlugin(r2).getVersion();
    }

    public boolean isPluginInstalled(String r4) {
        ZeusLogger.d("Zeus/load_zeus", "isPluginInstalled. packageName = " + r4);
        if (Zeus.hasInit() == true) goto L10;
        if (Looper.myLooper() != Looper.getMainLooper()) goto L8;
        ZeusLogger.w("Zeus/load_zeus", "call isPluginInstalled in main thread before Zeus init.");
        return false;
    L8:
        Zeus.waitInit(-1);
    L10:
        return PluginManager.getInstance().checkPluginInstalled(r4);
    }

    public boolean syncInstallPackage(String r3, String r4) {
        return PluginManager.getInstance().syncInstall(r3, new PolarisFileWrapper(r4), "sub_process");
    }
}
