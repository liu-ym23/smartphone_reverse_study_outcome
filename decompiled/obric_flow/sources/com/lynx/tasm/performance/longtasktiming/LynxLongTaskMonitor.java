package com.lynx.tasm.performance.longtasktiming;

import com.lynx.tasm.LynxBooleanOption;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxEnvKey;

/* JADX INFO: loaded from: classes2.dex */
public class LynxLongTaskMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f10933a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f10934b;

    static {
        f10933a = LynxEnv.getBooleanFromExternalEnv(LynxEnvKey.e, false);
        f10934b = false;
    }

    public static void a() {
        if (f10933a == true) goto L5;
        boolean r5 = false;
    L9:
        if (r5 == false) goto L12;
        nativeDidProcessTask();
        return;
    L12:
        return;
    L5:
        if (f10934b == true) goto L7;
        f10934b = LynxEnv.inst().isNativeLibraryLoaded();
    L7:
        r5 = f10934b;
        goto L9
    }

    public static boolean b(String r5, int r10, LynxBooleanOption r11) {
        if (r11 != LynxBooleanOption.f9964c) goto L5;
    L14:
        return false;
    L5:
        if (f10933a == true) goto L7;
        boolean r12 = false;
    L11:
        if (r12 == false) goto L14;
        nativeWillProcessTask("platform_func_task", r5, null, r10);
        return true;
    L7:
        if (f10934b == true) goto L9;
        f10934b = LynxEnv.inst().isNativeLibraryLoaded();
    L9:
        r12 = f10934b;
        goto L11
    }

    private static native void nativeDidProcessTask();

    private static native void nativeUpdateLongTaskTimingIfNeed(String r5, String r10, String r11);

    private static native void nativeWillProcessTask(String r5, String r10, String r11, int r12);
}
