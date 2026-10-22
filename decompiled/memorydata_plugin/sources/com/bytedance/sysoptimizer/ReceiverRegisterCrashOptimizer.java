package com.bytedance.sysoptimizer;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ReceiverRegisterCrashOptimizer {
    private static Application sApplication;

    public ReceiverRegisterCrashOptimizer() {
    }

    public static void fix(Application r2) {
        sApplication = (Application) ZeusTransformUtils.wrapperContextForParams(r2, Application.class, "com.obric.memorydata.plugin");
    }

    public static boolean fixedOpen() {
        if (sApplication == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static Intent registerReceiver(PluginBroadcastReceiver r3, IntentFilter r4) {
        Application r0 = sApplication;
        if (r0 != null) goto L7;
        return null;
    L7:
        return ZeusTransformUtils.registerReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getBaseContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r3, r4, "com.obric.memorydata.plugin");
    }

    public static Intent registerReceiver(PluginBroadcastReceiver r3, IntentFilter r4, int r5) {
        Application r0 = sApplication;
        if (r0 != null) goto L7;
        return null;
    L7:
        return ZeusTransformUtils.registerReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getBaseContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r3, r4, r5, "com.obric.memorydata.plugin");
    }

    public static Intent registerReceiver(PluginBroadcastReceiver r7, IntentFilter r8, String r9, Handler r10) {
        Application r0 = sApplication;
        if (r0 != null) goto L7;
        return null;
    L7:
        return ZeusTransformUtils.registerReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getBaseContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r7, r8, r9, r10, "com.obric.memorydata.plugin");
    }

    public static Intent registerReceiver(PluginBroadcastReceiver r8, IntentFilter r9, String r10, Handler r11, int r12) {
        Application r0 = sApplication;
        if (r0 != null) goto L7;
        return null;
    L7:
        return ZeusTransformUtils.registerReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getBaseContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r8, r9, r10, r11, r12, "com.obric.memorydata.plugin");
    }
}
