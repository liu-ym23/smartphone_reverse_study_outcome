package com.lynx.tasm.behavior;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.PixelCopy;
import android.view.Surface;
import android.view.View;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.LynxBooleanOption;
import com.lynx.tasm.LynxEnv;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public class LynxUIRenderer implements i {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Object f10158n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static HandlerThread f10159o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference f10160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public n0 f10161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a1 f10162c;
    public w0 d;
    public PaintingContext e;
    public long f;
    public LynxBooleanOption g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f10163h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f10164i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f10165j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f10166k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f10167l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f10168m;

    static {
        f10158n = new Object();
    }

    public LynxUIRenderer() {
        this.f = 0;
        this.f10164i = "50px";
    }

    public static void a(View r10, Bitmap r11, Canvas r12) {
    L8:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (LynxEnv.inst().isPixelCopyEnabled() == false) goto L24;
        int[] r5 = new int[2];     // Catch: Throwable -> L8
        r10.getLocationInSurface(r5);     // Catch: Throwable -> L8
        Field r13 = Class.forName("android.view.ViewRootImpl").getDeclaredField("mSurface");     // Catch: Throwable -> L8
        if (r10.getRootView().getParent() != null) goto L10;
        r10.draw(r12);     // Catch: Throwable -> L8
        return;
    L10:
        Surface r14 = (Surface) r13.get(r10.getRootView().getParent());     // Catch: Throwable -> L8
        Object r15 = f10158n;     // Catch: Throwable -> L8
        monitor-enter(r15);     // Catch: Throwable -> L8
        int r16 = r5[0];     // Catch: Throwable -> L16
        PixelCopy.request(r14, new Rect(r16, r5[1], r10.getWidth() + r16, r5[1] + r10.getHeight()), r11, new o0(), new Handler(f10159o.getLooper()));     // Catch: Throwable -> L16
        r15.wait(10000);     // Catch: Throwable -> L16 InterruptedException -> L18
    L20:
        monitor-exit(r15);     // Catch: Throwable -> L16
    L33:
        return;
    L18:
        e = move-exception;
        LynxLog.b(4, "DevTool Screenshot", e.toString());     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L24:
        r10.draw(r12);     // Catch: Throwable -> L8
    }

    private static native long nativeCreateUIDelegate(long r5, long r10);

    private static native void nativeDestroyUIDelegate(long r5);

    public final void b() {
        n0 r5 = this.f10161b;
        if (r5 != null) goto L5;
        return;
    L5:
        if (this.f10162c != null) goto L31;
        a1 r10 = new a1(r5);
        this.f10162c = r10;
        n0 r11 = this.f10161b;
        boolean r12 = r11.f10301t;
        boolean r13 = true;
        if (r10.f10192u == true) goto L11;
        if (r12 == true) goto L11;
        boolean r14 = false;
    L12:
        r10.f10192u = r14;
        if (this.f10163h == false) goto L32;
        this.f10163h = false;
        com.lynx.tasm.b0 r15 = r11.f10289c;
        if (r15 == null) goto L33;
        r15.f10140h = r10;
        String r16 = this.f10164i;
        if (r16 != null) goto L19;
    L21:
        a1 r17 = this.f10162c;
        boolean r18 = this.f10166k;
        if (r17.f10192u == true) goto L26;
        if (r18 == true) goto L26;
        r13 = false;
    L26:
        r17.f10192u = r13;
        r17.f10194w = this.f10165j;
        if (this.f10167l == false) goto L34;
        r17.f10181i = this.f10161b.f10297o;
        return;
    L34:
        return;
    L19:
        if (r16.equals("50px") == true) goto L21;
        this.f10162c.f10185m = com.lynx.tasm.utils.k.e(r16, 0.0f, r15.f10152u);
        goto L21
    L33:
        return;
    L32:
        return;
    L11:
        r14 = true;
        goto L12
    }

    public final long c() {
        if (this.f != 0) goto L18;
        PaintingContext r5 = this.e;
        if (r5 == null) goto L7;
        long r10 = r5.e;
    L8:
        w0 r11 = this.d;
        if (r11 == null) goto L11;
        long r12 = r11.f10137c;
    L13:
        if (r10 == 0) goto L18;
        if (r12 == 0) goto L18;
        this.f = nativeCreateUIDelegate(r10, r12);
        goto L18
    L11:
        r12 = 0;
        goto L13
    L7:
        r10 = 0;
    L18:
        return this.f;
    }

    public final void d() {
        w0 r5 = this.d;
        if (r5 == null) goto L5;
        r5.f10136b = true;
        this.d = null;
    L5:
        PaintingContext r10 = this.e;
        if (r10 == null) goto L8;
        r10.f10170b = true;
        this.e = null;
    L8:
        long r11 = this.f;
        if (r11 == 0) goto L12;
        nativeDestroyUIDelegate(r11);
        this.f = 0;
        return;
    }
}
