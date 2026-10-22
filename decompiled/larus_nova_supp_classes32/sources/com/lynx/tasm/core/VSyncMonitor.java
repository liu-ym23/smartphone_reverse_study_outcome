package com.lynx.tasm.core;

import android.hardware.display.DisplayManager;
import android.view.Choreographer;
import android.view.WindowManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.utils.CallStackUtil;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class VSyncMonitor {
    public static WeakReference<WindowManager> a = null;
    public static DisplayManager b = null;
    public static Choreographer c = null;
    public static boolean d = false;
    public static d e = null;
    public static long f = -1;

    public static class a implements Choreographer.FrameCallback {
        public final /* synthetic */ long a;

        public a(long r1) {
            this.a = r1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long r3) {
            VSyncMonitor.a(this.a, r3);
        }
    }

    public static class b implements Runnable {
        public final /* synthetic */ long a;

        @Override // java.lang.Runnable
        public final void run() {
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L12;
            return;
        L12:
            throw th;
        L3:
            if (VSyncMonitor.c != null) goto L6;
            UIThreadUtils.runOnUiThreadImmediately(new o());     // Catch: Throwable -> L8
        L6:
            VSyncMonitor.requestOnUIThread(this.a);     // Catch: Throwable -> L8
        }

        public b(long r1) {
            this.a = r1;
        }
    }

    public static class c implements Choreographer.FrameCallback {
        public final /* synthetic */ long a;

        public c(long r1) {
            this.a = r1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long r3) {
            VSyncMonitor.a(this.a, r3);
        }
    }

    public static class d implements DisplayManager.DisplayListener {
        public d() {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayAdded(int r1) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayRemoved(int r1) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayChanged(int r1) {
            if (r1 == 0) goto L4;
            return;
        L4:
            if (VSyncMonitor.b == null) goto L8;
            VSyncMonitor.b();
            return;
        }
    }

    public VSyncMonitor() {
    }

    private static native void nativeOnVSync(long r0, long r2, long r4);

    public static void b() {
        f = (long) (1.0E9f / b.getDisplay(0).getRefreshRate());     // Catch: RuntimeException -> L4
        return;
    L4:
        e = move-exception;
        LLog.e("VSyncMonitor", "onDisplayChanged failed: " + CallStackUtil.a(e));
    }

    public static void request(long r2) {
        Choreographer.getInstance().postFrameCallback(new a(r2));
    }

    public static void requestOnUIThread(long r2) {
        Choreographer r0 = c;
        if (r0 != null) goto L5;
        UIThreadUtils.runOnUiThreadImmediately(new b(r2));
        return;
    L5:
        r0.postFrameCallback(new c(r2));
    }

    public static void a(long r8, long r10) {
        if (d == false) goto L13;
    L11:
        nativeOnVSync(r8, r10, r10 + f);
        return;
    L13:
        f = 16666666;     // Catch: RuntimeException -> L9
        WindowManager r0 = a.get();     // Catch: RuntimeException -> L9
        if (r0 == null) goto L11;
        f = (long) (1.0E9d / ((double) r0.getDefaultDisplay().getRefreshRate()));     // Catch: RuntimeException -> L9
    L9:
        e = move-exception;
        LLog.e("VSyncMonitor", "getRefreshRate failed: " + e.getMessage());
        goto L11
    }
}
