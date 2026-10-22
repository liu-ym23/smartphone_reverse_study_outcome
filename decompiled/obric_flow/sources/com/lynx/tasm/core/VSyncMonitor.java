package com.lynx.tasm.core;

import android.hardware.display.DisplayManager;
import android.view.Choreographer;
import android.view.WindowManager;
import bm.a;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.base.CalledByNative;
import com.lynx.tasm.utils.CallStackUtil;
import java.lang.ref.WeakReference;
import mn.j;

/* JADX INFO: loaded from: classes2.dex */
public class VSyncMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WeakReference f10831a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static DisplayManager f10832b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Choreographer f10833c = null;
    public static boolean d = false;
    public static j e = null;
    public static long f = -1;

    public static void a(long r10, long r11) {
        if (d == false) goto L13;
    L11:
        nativeOnVSync(r10, r11, r11 + f);
        return;
    L13:
        f = 16666666;     // Catch: RuntimeException -> L9
        WindowManager r5 = (WindowManager) f10831a.get();     // Catch: RuntimeException -> L9
        if (r5 == null) goto L11;
        f = (long) (1.0E9d / ((double) r5.getDefaultDisplay().getRefreshRate()));     // Catch: RuntimeException -> L9
    L9:
        e = move-exception;
        LynxLog.b(4, "VSyncMonitor", "getRefreshRate failed: " + e.getMessage());
        goto L11
    }

    public static void b() {
        f = (long) (1.0E9f / f10832b.getDisplay(0).getRefreshRate());     // Catch: RuntimeException -> L4
        return;
    L4:
        e = move-exception;
        LynxLog.b(4, "VSyncMonitor", "onDisplayChanged failed: " + CallStackUtil.a(e));
    }

    private static native void nativeOnVSync(long r5, long r10, long r11);

    @CalledByNative
    public static void request(long r5) {
        Choreographer.getInstance().postFrameCallback(new com.lynx.animax.j(1, r5));
    }

    @CalledByNative
    public static void requestOnUIThread(long r5) {
        Choreographer r10 = f10833c;
        if (r10 != null) goto L6;
        com.lynx.tasm.utils.j.f(new a(5, r5));
        return;
    L6:
        r10.postFrameCallback(new com.lynx.animax.j(2, r5));
    }
}
