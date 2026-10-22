package com.lynx.clay.embedding.android;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.PixelCopy;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class SurfaceSnapshotTracker {
    public final FlutterSurfaceView a;
    public final Handler b;
    public final ArrayList<Runnable> c;
    public boolean d;
    public boolean e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public double l;
    public c m;
    public FlutterSurfaceView.c n;

    public static final enum FlutterUiDisplayResult extends Enum<FlutterUiDisplayResult> {
        public static final FlutterUiDisplayResult DISPLAYED = null;
        public static final FlutterUiDisplayResult REJECTED = null;
        public static final FlutterUiDisplayResult WAITING_FOR_SURFACE_CONNECTION = null;
        public static final /* synthetic */ FlutterUiDisplayResult[] a = null;

        static {
            FlutterUiDisplayResult r0 = new FlutterUiDisplayResult("DISPLAYED", 0);
            DISPLAYED = r0;
            FlutterUiDisplayResult r1 = new FlutterUiDisplayResult("WAITING_FOR_SURFACE_CONNECTION", 1);
            WAITING_FOR_SURFACE_CONNECTION = r1;
            FlutterUiDisplayResult r3 = new FlutterUiDisplayResult("REJECTED", 2);
            REJECTED = r3;
            a = new FlutterUiDisplayResult[]{r0, r1, r3};
        }

        public static FlutterUiDisplayResult[] values() {
            return (FlutterUiDisplayResult[]) a.clone();
        }

        public static FlutterUiDisplayResult valueOf(String r1) {
            return (FlutterUiDisplayResult) r27.a.a(FlutterUiDisplayResult.class, r1);
        }

        public FlutterUiDisplayResult(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        private a() {
        }

        public static void a(SurfaceView r0, boolean r1) {
            r0.setSecure(r1);
        }
    }

    public static final class b {
        private b() {
        }

        public static /* synthetic */ void a(c r0, SurfaceSnapshotTracker r1, int r2) {
            b(r0, r1, r2);
        }

        public static void c(final SurfaceSnapshotTracker r7, final c r8) {
            if (r7.e(r8) == true) goto L5;
            return;
        L5:
            SurfaceHolder r0 = r7.a.getHolder();
            if (r0 != null) goto L8;
        L25:
            SurfaceSnapshotTracker.a(r7, r8, 4, Double.NaN);
            return;
        L8:
            if (r0.getSurface() == null) goto L25;
            if (r0.getSurface().isValid() == false) goto L25;
            r8.c++;
            Bitmap r1 = r8.f;     // Catch: Throwable -> L20 IllegalArgumentException -> L22
            if (r1 != null) goto L16;
        L17:
            r8.f = Bitmap.createBitmap(8, 8, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L20 IllegalArgumentException -> L22
        L18:
            Bitmap r2 = r8.f;     // Catch: Throwable -> L20 IllegalArgumentException -> L22
            r8.d = true;     // Catch: Throwable -> L20 IllegalArgumentException -> L22
            PixelCopy.request(r7.a, r2, new v(r8, r7), r7.b);     // Catch: Throwable -> L20 IllegalArgumentException -> L22
            return;
        L16:
            if (r1.isRecycled() == false) goto L18;
        L20:
            e = move-exception;
            r8.d = false;
            r8.a();
            c5a.c.f("FlutterSurfaceSnapshot", "Failed to request Surface frame PixelCopy.", e);
            SurfaceSnapshotTracker.a(r7, r8, 4, Double.NaN);
        }

        private static void b(c r17, SurfaceSnapshotTracker r18, int r19) {
            boolean r4 = false;
            r17.d = false;
            r17.a();
            if (r18.e(r17) == true) goto L6;
            r17.e = true;
            r17.a();
            return;
        L6:
            if (r19 != 0) goto L25;
            Bitmap r6 = r17.f;
            if (r6 == null) goto L25;
            if (r6.isRecycled() == true) goto L25;
        L23:
            e = move-exception;
            c5a.c.f("FlutterSurfaceSnapshot", "Failed to sample Surface frame luminance.", e);
            goto L25
        L13:
            if (r17.g != null) goto L15;
            r17.g = new int[64];     // Catch: RuntimeException -> L23
        L15:
            int[] r0 = r17.g;     // Catch: RuntimeException -> L23
            r6.getPixels(r0, 0, r6.getWidth(), 0, 0, r6.getWidth(), r6.getHeight());     // Catch: RuntimeException -> L23
            int r7 = r0.length;     // Catch: RuntimeException -> L23
            long r8 = 0;
            int r9 = 0;
        L16:
            if (r9 >= r7) goto L19;
            int r10 = r0[r9];     // Catch: RuntimeException -> L23
            r8 = r8 + ((((((long) Color.red(r10)) * 299) + (((long) Color.green(r10)) * 587)) + (((long) Color.blue(r10)) * 114)) / 1000);     // Catch: RuntimeException -> L23
            r9 = r9 + 1;     // Catch: RuntimeException -> L23
            goto L16
        L19:
            if (r0.length == 0) goto L25;
            double r11 = r8 / ((double) r0.length);
        L27:
            if (Double.isNaN(r18.l) == false) goto L29;
        L31:
            boolean r1 = false;
        L33:
            if (Double.isNaN(r11) == false) goto L35;
        L37:
            if (r19 == 0) goto L39;
        L43:
            SurfaceSnapshotTracker.a(r18, r17, r19, r11);
            return;
        L39:
            if (Double.isNaN(r11) == true) goto L43;
            if (r1 == false) goto L42;
            if (r4 == true) goto L43;
        L42:
            r18.f(r17);
            return;
        L35:
            if (r11 > 8.0d) goto L37;
            r4 = true;
            goto L37
        L29:
            if (r18.l < 32.0d) goto L31;
            r1 = true;
        L25:
            r11 = Double.NaN;
            goto L27
        }
    }

    public static final class c {
        public final int a;
        public final long b;
        public int c;
        public boolean d;
        public boolean e;
        public Bitmap f;
        public int[] g;

        public final void a() {
            if (this.e == true) goto L5;
            return;
        L5:
            if (this.d == true) goto L15;
            Bitmap r0 = this.f;
            if (r0 != null) goto L10;
        L12:
            this.f = null;
            this.g = null;
            return;
        L10:
            if (r0.isRecycled() == true) goto L12;
            this.f.recycle();
            goto L12
        }

        public c(int r3) {
            this.b = SystemClock.uptimeMillis();
            this.c = 0;
            this.d = false;
            this.e = false;
            this.a = r3;
        }
    }

    public final void c() {
        if (this.c.isEmpty() == false) goto L5;
        return;
    L5:
        ArrayList r0 = new ArrayList(this.c);
        this.c.clear();
        Iterator r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((Runnable) r1.next()).run();
        goto L7
    }

    public final void i() {
        c r0 = this.m;
        this.m = null;
        this.k = -1;
        if (r0 == null) goto L6;
        r0.e = true;
        r0.a();
        return;
    }

    public final void j() {
        if (this.e == true) goto L5;
        return;
    L5:
        this.a.setZOrderOnTop(false);
        this.e = false;
    }

    public SurfaceSnapshotTracker(FlutterSurfaceView r7) {
        this.b = new Handler(Looper.getMainLooper());
        this.c = new ArrayList();
        this.d = false;
        this.e = false;
        this.f = 0;
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.j = -1;
        this.k = -1;
        this.l = Double.NaN;
        this.a = r7;
        int r1 = Build.VERSION.SDK_INT;
        a.a(r7, false);
        if (r1 < 34) goto L14;
        SurfaceView.class.getMethod("setSurfaceLifecycle", new Class[]{Integer.TYPE}).invoke(r7, new Object[]{2});     // Catch: Throwable -> L7 ReflectiveOperationException -> L9
        return;
    L7:
        e = move-exception;
        c5a.c.d(5, "FlutterSurfaceSnapshot", "Failed to use attachment-bound SurfaceView lifecycle: " + e.getMessage());
        return;
    }

    public static double b(Bitmap r21) {
        if (r21.isRecycled() == false) goto L5;
    L30:
        return Double.NaN;
    L5:
        if (r21.getWidth() <= 0) goto L30;
        if (r21.getHeight() <= 0) goto L30;
        int r0 = Math.min(5, r21.getWidth());     // Catch: RuntimeException -> L28
        int r3 = Math.min(5, r21.getHeight());     // Catch: RuntimeException -> L28
        long r5 = 0;
        int r7 = 0;
        int r8 = 0;
    L10:
        if (r7 >= r3) goto L24;
        int r9 = 1;
        if (r3 != 1) goto L14;
        int r10 = 0;
    L15:
        int r11 = 0;
    L16:
        if (r11 >= r0) goto L23;
        if (r0 != r9) goto L20;
        int r12 = 0;
    L21:
        int r13 = r21.getPixel(r12, r10);     // Catch: RuntimeException -> L28
        int r18 = r10;
        r5 = r5 + ((((((long) Color.red(r13)) * 299) + (((long) Color.green(r13)) * 587)) + (((long) Color.blue(r13)) * 114)) / 1000);
        r8 = r8 + 1;
        r11 = r11 + 1;
        r10 = r18;
        r9 = 1;
        goto L16
    L20:
        r12 = ((r21.getWidth() - r9) * r11) / (r0 - 1);     // Catch: RuntimeException -> L28
        goto L21
    L23:
        r7 = r7 + 1;
        goto L10
    L14:
        r10 = ((r21.getHeight() - 1) * r7) / (r3 - 1);     // Catch: RuntimeException -> L28
        goto L15
    L24:
        if (r8 != 0) goto L27;
        return Double.NaN;
    L27:
        return r5 / ((double) r8);
    L28:
        e = move-exception;
        c5a.c.f("FlutterSurfaceSnapshot", "Failed to sample bitmap luminance.", e);
        goto L30
    }

    public final void d(int r3) {
        if (this.j == r3) goto L5;
        return;
    L5:
        this.j = -1;
        FlutterSurfaceView.c r0 = this.n;
        if (r0 == null) goto L15;
        SurfaceSnapshotController r1 = (SurfaceSnapshotController) r0;
        if (r3 != r1.j) goto L15;
        if (r1.j() == false) goto L15;
        if (r1.f(1) == false) goto L15;
        r1.i |= 2;
        r1.k();
        r1.l();
    L15:
        h(r3);
        c();
    }

    public final boolean e(c r2) {
        if (this.m == r2) goto L5;
    L11:
        return false;
    L5:
        if (r2.a != this.f) goto L11;
        if (this.a.c == false) goto L11;
        if (this.d == false) goto L11;
        return true;
    }

    public final void f(c r3) {
        if (e(r3) == true) goto L5;
        return;
    L5:
        this.m = null;
        this.k = r3.a;
        r3.e = true;
        r3.a();
        FlutterSurfaceView.c r0 = this.n;
        if (r0 == null) goto L14;
        SurfaceSnapshotController r1 = (SurfaceSnapshotController) r0;
        if (r3.a == r1.j) goto L10;
        return;
    L10:
        if (r1.j() == false) goto L16;
        r1.i |= 4;
        r1.k();
        r1.l();
        return;
    L16:
        return;
    }

    public final void g(final Runnable r6) {
        if (this.a.c == false) goto L14;
        final int r0 = this.f;
        if (r0 <= 0) goto L14;
        this.j = r0;
        if (r6 == null) goto L11;
        this.c.add(r6);
        this.a.postDelayed(new u(this, r6, r0), 1000);
    L11:
        if (this.i != r0) goto L17;
        d(r0);
        return;
    L17:
        return;
    L14:
        if (r6 == null) goto L18;
        r6.run();
        return;
    }

    public final void h(int r8) {
        if (this.d == true) goto L5;
        return;
    L5:
        if (this.n != null) goto L7;
        return;
    L7:
        if (r8 == this.f) goto L9;
        return;
    L9:
        if (this.a.c == true) goto L11;
        return;
    L11:
        if (this.k != r8) goto L13;
        return;
    L13:
        if (this.m != null) goto L38;
        c r0 = new c(r8);
        this.m = r0;
        int r9 = Build.VERSION.SDK_INT;
        if (r9 >= 24) goto L18;
    L30:
        f(r0);
        return;
    L18:
        if (com.lynx.clay.util.d.a(this.a) == false) goto L30;
        if (Double.isNaN(this.l) == false) goto L23;
    L26:
        if (r9 >= 24) goto L28;
        f(r0);
        return;
    L28:
        b.c(this, r0);
        return;
    L23:
        if (this.l >= 32.0d) goto L26;
        f(r0);
        return;
    }

    public static void a(final SurfaceSnapshotTracker r6, final c r7, int r8, double r9) {
        if (r6.e(r7) == false) goto L21;
        long r0 = SystemClock.uptimeMillis() - r7.b;
        int r2 = r7.c;
        if (r2 < 12) goto L8;
    L18:
        c5a.c.d(5, "FlutterSurfaceSnapshot", "Surface frame remains unverified; reveal it after verification limit, generation=" + r7.a + ", result=" + r8 + ", surfaceLuminance=" + r9 + ", snapshotLuminance=" + r6.l + ", pixelCopyAttempts=" + r7.c);
        r6.f(r7);
        return;
    L8:
        if (r0 >= 3000) goto L18;
        Handler r10 = r6.b;
        Runnable r11 = new t(r6, r7);
        if (r2 > 3) goto L14;
        long r12 = 32;
    L17:
        r10.postDelayed(r11, r12);
        return;
    L14:
        if (r2 > 6) goto L16;
        r12 = 64;
        goto L17
    L16:
        r12 = 128;
        goto L17
    }
}
