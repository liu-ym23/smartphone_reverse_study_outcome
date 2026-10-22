package com.volcengine.zeus;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.volcengine.zeus.log.ZeusLogger;
import com.volcengine.zeus.plugin.PluginManager;
import com.volcengine.zeus.servermanager.ServerManagerHelper;
import com.volcengine.zeus.service.server.PluginProcessManager;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class h {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r9, "pluginPackageName");
        ZeusLogger.i("Zeus/load_zeus", "trigger plugin load: " + r9 + ", shouldRegisterProcessPlugin = " + r10);
        String r2 = PluginManager.getInstance().getPlugin(r9).getPluginProcess();
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L24;
        if (StringsKt.contains$default(r2, ":", false, 2, null) == false) goto L13;
        r2 = (String) ListProtector.get(StringsKt.split$default(r2, new String[]{":"}, false, 0, 6, null), 1);
    L13:
        if (r10 == true) goto L25;
    L15:
        IPluginProcessManager r11 = ServerManagerHelper.getPluginProcessManager(r2);     // Catch: Throwable -> L20
        if (r11 == null) goto L19;
        r11.warmUpPlugin(r9);     // Catch: Throwable -> L20
        return;
    L19:
        throw new IllegalStateException("pluginProcessManager nullptr");     // Catch: Throwable -> L20
    L25:
        PluginProcessManager.INSTANCE.registerProcessPlugin(r2, r9);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        ZeusLogger.w("Zeus/load_zeus", "warmUpPlugin failed", th);
        return;
    L24:
        throw new IllegalArgumentException("not a cross process plugin");
    L5:
        if (r2.length() == 0) goto L8;
        r3 = false;
        goto L9
    }
}
