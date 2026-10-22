package com.lynx.tasm.performance.longtasktiming;

import com.lynx.tasm.LynxBooleanOption;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxEnvKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxLongTaskMonitor {
    public static final boolean a = false;
    public static volatile boolean b;

    public LynxLongTaskMonitor() {
    }

    private static native void nativeDidProcessTask();

    private static native void nativeUpdateLongTaskTimingIfNeed(String r0, String r1, String r2);

    private static native void nativeWillProcessTask(String r0, String r1, String r2, int r3);

    static {
        a = LynxEnv.getBooleanFromExternalEnv(LynxEnvKey.ENABLE_LONG_TASK_TIMING, false);
        b = false;
    }

    public static void a() {
        if (a == true) goto L5;
        boolean r0 = false;
    L9:
        if (r0 == false) goto L12;
        nativeDidProcessTask();
        return;
    L12:
        return;
    L5:
        if (b == true) goto L7;
        b = LynxEnv.inst().isNativeLibraryLoaded();
    L7:
        r0 = b;
        goto L9
    }

    public static boolean b(String r2, int r3, LynxBooleanOption r4) {
        if (r4 != LynxBooleanOption.FALSE) goto L5;
        return false;
    L5:
        if (a == true) goto L7;
        boolean r5 = false;
    L11:
        if (r5 == false) goto L15;
        nativeWillProcessTask("platform_func_task", r2, null, r3);
        return true;
    L15:
        return false;
    L7:
        if (b == true) goto L9;
        b = LynxEnv.inst().isNativeLibraryLoaded();
    L9:
        r5 = b;
        goto L11
    }
}
