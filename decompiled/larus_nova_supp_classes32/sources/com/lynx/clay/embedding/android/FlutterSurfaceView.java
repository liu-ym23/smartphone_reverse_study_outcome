package com.lynx.clay.embedding.android;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.lynx.clay.embedding.engine.renderer.FlutterRenderer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class FlutterSurfaceView extends SurfaceView implements s5a.c {
    public final boolean a;
    public final SurfaceSnapshotTracker b;
    public boolean c;
    public boolean d;
    public FlutterRenderer e;
    public final b f;

    public class a implements SurfaceHolder.Callback2 {
        public final /* synthetic */ FlutterSurfaceView a;

        public a(FlutterSurfaceView r1) {
            this.a = r1;
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceCreated(SurfaceHolder r3) {
            c5a.c.e();
            FlutterSurfaceView r4 = this.a;
            r4.c = true;
            SurfaceSnapshotTracker r5 = r4.b;
            r5.f++;
            r5.h = -1;
            r5.i = -1;
            r5.j = -1;
            r5.i();
            r5.c();
            c r0 = r5.n;
            if (r0 == null) goto L10;
            SurfaceSnapshotController r1 = (SurfaceSnapshotController) r0;
            r1.j = r5.f;
            r1.t();
            r1.r();
            if (r1.e != SurfaceSnapshotController.OverlayState.FOREGROUND_VISIBLE) goto L8;
            r1.v();
            goto L10
        L8:
            if (r1.j() == false) goto L10;
            r1.k();
        L10:
            FlutterSurfaceView r6 = this.a;
            if (r6.d == false) goto L14;
            r6.f();
            this.a.d();
            return;
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceDestroyed(SurfaceHolder r7) {
            c5a.c.e();
            FlutterSurfaceView r8 = this.a;
            r8.c = false;
            r8.e();
            SurfaceSnapshotTracker r9 = this.a.b;
            r9.j();
            r9.h = -1;
            r9.i = -1;
            r9.j = -1;
            r9.i();
            r9.c();
            c r2 = r9.n;
            if (r2 == null) goto L25;
            SurfaceSnapshotController r3 = (SurfaceSnapshotController) r2;
            if (r9.f != r3.j) goto L25;
            r3.j = -1;
            r3.t();
            r3.r();
            if (r3.g == false) goto L10;
        L11:
            SurfaceSnapshotController.OverlayState r10 = r3.e;
            SurfaceSnapshotController.OverlayState r1 = SurfaceSnapshotController.OverlayState.ARMED_FOR_FOREGROUND;
            if (r10 == r1) goto L25;
            if (r3.g() == false) goto L25;
            if (r3.e != SurfaceSnapshotController.OverlayState.TASK_SNAPSHOT_VISIBLE) goto L19;
            boolean r11 = true;
        L20:
            r3.s(r11);
            r3.r();
            r3.e = r1;
            r3.c.setVisibility(0);
            k r0 = r3.c;
            if (r11 == false) goto L23;
            float r12 = 1.0f;
        L24:
            r0.setAlpha(r12);
            r3.k();
            goto L25
        L23:
            r12 = 0.0f;
            goto L24
        L19:
            r11 = false;
            goto L20
        L10:
            if (r3.e == SurfaceSnapshotController.OverlayState.TASK_SNAPSHOT_VISIBLE) goto L11;
        L25:
            FlutterSurfaceView r13 = this.a;
            if (r13.d == false) goto L32;
            r13.setAlpha(0.0f);
            FlutterRenderer r14 = this.a.e;
            if (r14 == null) goto L31;
            r14.b(true);
            return;
        L31:
            throw new IllegalStateException("disconnectRenderSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
        }

        @Override // android.view.SurfaceHolder.Callback2
        public final void surfaceRedrawNeeded(SurfaceHolder r2) {
            this.a.b.g(null);
        }

        @Override // android.view.SurfaceHolder.Callback2
        public final void surfaceRedrawNeededAsync(SurfaceHolder r1, Runnable r2) {
            this.a.b.g(r2);
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceChanged(SurfaceHolder r1, int r2, int r3, int r4) {
            c5a.c.e();
            FlutterSurfaceView r5 = this.a;
            if (r5.d == true) goto L5;
            return;
        L5:
            if (r5.e == null) goto L8;
            c5a.c.e();
            r5.e.a.onSurfaceChanged(r3, r4);
            return;
        L8:
            throw new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
        }
    }

    public class b implements s5a.b {
        public final /* synthetic */ FlutterSurfaceView a;

        @Override // s5a.b
        public final void a() {
        }

        @Override // s5a.b
        public final void b() {
            SurfaceSnapshotTracker r0 = this.a.b;
            int r1 = r0.g;
            FlutterSurfaceView r2 = r0.a;
            if (r2.c == false) goto L29;
            if (r1 <= 0) goto L29;
            if (r1 != r0.f) goto L29;
            if (r0.h == r1) goto L12;
            SurfaceSnapshotTracker.FlutterUiDisplayResult r3 = SurfaceSnapshotTracker.FlutterUiDisplayResult.WAITING_FOR_SURFACE_CONNECTION;
        L31:
            if (r3 != SurfaceSnapshotTracker.FlutterUiDisplayResult.WAITING_FOR_SURFACE_CONNECTION) goto L33;
            return;
        L33:
            this.a.e();
            if (r3 == SurfaceSnapshotTracker.FlutterUiDisplayResult.DISPLAYED) goto L36;
            return;
        L36:
            c5a.c.e();
            return;
        L12:
            if (r0.d == false) goto L14;
            float r4 = 0.0f;
        L15:
            r2.setAlpha(r4);
            r0.i = r1;
            c r5 = r0.n;
            if (r5 == null) goto L28;
            final SurfaceSnapshotController r6 = (SurfaceSnapshotController) r5;
            if (r1 != r6.j) goto L28;
            if (r6.j() == false) goto L23;
            r6.i |= 1;
            r6.k();
            r6.l();
            goto L28
        L23:
            if (r6.g() == true) goto L28;
            if (r6.a.hasWindowFocus() == false) goto L28;
            r6.a.post(new n(r6));
        L28:
            r0.h(r1);
            r0.d(r1);
            r0.g = -1;
            r3 = SurfaceSnapshotTracker.FlutterUiDisplayResult.DISPLAYED;
            goto L31
        L14:
            r4 = 1.0f;
        L29:
            r0.g = -1;
            r3 = SurfaceSnapshotTracker.FlutterUiDisplayResult.REJECTED;
            goto L31
        }

        public b(FlutterSurfaceView r1) {
            this.a = r1;
        }
    }

    public interface c {
    }

    @Override // s5a.c
    public final void b() {
        if (this.e != null) goto L5;
        c5a.c.d(5, "FlutterSurfaceView", "detachFromRenderer() invoked when no FlutterRenderer was attached.");
        return;
    L5:
        if (getWindowToken() == null) goto L11;
        c5a.c.e();
        FlutterRenderer r0 = this.e;
        if (r0 == null) goto L10;
        r0.b(false);
        goto L11
    L10:
        throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
    L11:
        setAlpha(0.0f);
        e();
        this.e = null;
        this.d = false;
        SurfaceSnapshotTracker r1 = this.b;
        r1.j();
        r1.h = -1;
        r1.i = -1;
        r1.j = -1;
        r1.i();
        r1.l = Double.NaN;
        r1.c();
    }

    public final Bitmap c() {
        SurfaceSnapshotTracker r0 = this.b;
        FlutterRenderer r1 = this.e;
        if (r1 != null) goto L5;
        r0.getClass();
    L33:
        return null;
    L5:
        if (r0.i != r0.f) goto L33;
        Bitmap r2 = r1.a.getBitmap();     // Catch: RuntimeException -> L30
        if (r2 != null) goto L11;
        c5a.c.d(5, "FlutterSurfaceSnapshot", "Flutter surface snapshot capture returned null.");     // Catch: RuntimeException -> L30
        goto L33
    L11:
        if (r2.isRecycled() == false) goto L13;
        c5a.c.d(5, "FlutterSurfaceSnapshot", "Flutter surface snapshot capture returned a recycled bitmap.");     // Catch: RuntimeException -> L30
        goto L33
    L13:
        int r3 = r2.getWidth();     // Catch: RuntimeException -> L30
        int r4 = r2.getHeight();     // Catch: RuntimeException -> L30
        long r5 = ((long) r3) * ((long) r4);     // Catch: RuntimeException -> L30
        if (r3 <= 0) goto L28;
        if (r4 <= 0) goto L28;
        if (r5 <= 921600) goto L28;
        double r6 = Math.sqrt(921600.0d / r5);     // Catch: RuntimeException -> L30
        Bitmap r7 = Bitmap.createScaledBitmap(r2, Math.max(1, (int) Math.floor(((double) r3) * r6)), Math.max(1, (int) Math.floor(((double) r4) * r6)), true);     // Catch: OutOfMemoryError -> L24 Throwable -> L26
        if (r7 == r2) goto L23;
        r2.recycle();     // Catch: OutOfMemoryError -> L24 Throwable -> L26
    L23:
        r2 = r7;
    L26:
        e = move-exception;
        c5a.c.f("FlutterSurfaceSnapshot", "Failed to downscale Flutter surface snapshot.", e);     // Catch: RuntimeException -> L30
    L28:
        r0.l = SurfaceSnapshotTracker.b(r2);     // Catch: RuntimeException -> L30
        return r2;
    L30:
        e = move-exception;
        c5a.c.f("FlutterSurfaceSnapshot", "Failed to cache current Flutter surface frame.", e);
        goto L33
    }

    public final void d() {
        if (this.e == null) goto L9;
        if (getHolder() == null) goto L9;
        SurfaceSnapshotTracker r0 = this.b;
        r0.h = r0.f;
        this.e.a(getHolder().getSurface(), true);
        return;
    L9:
        throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getHolder() are non-null.");
    }

    public final void e() {
        FlutterRenderer r0 = this.e;
        if (r0 == null) goto L5;
        b r1 = this.f;
        r0.a.removeIsDisplayingFlutterUiListener(r1);
    L5:
        this.b.g = -1;
    }

    public final void f() {
        SurfaceSnapshotTracker r0 = this.b;
        r0.a.setAlpha(0.0f);
        r0.i = -1;
        r0.g = r0.f;
        r0.h = -1;
        FlutterRenderer r1 = this.e;
        if (r1 == null) goto L8;
        b r2 = this.f;
        r1.a.removeIsDisplayingFlutterUiListener(r2);
        FlutterRenderer r3 = this.e;
        b r4 = this.f;
        r3.a.addIsDisplayingFlutterUiListener(r4);
        if (r3.d == false) goto L9;
        r4.b();
        return;
    L9:
        return;
    }

    @Override // s5a.c
    public final void pause() {
        if (this.e == null) goto L5;
        e();
        this.e = null;
        this.d = false;
        SurfaceSnapshotTracker r0 = this.b;
        r0.j();
        r0.h = -1;
        r0.i = -1;
        r0.j = -1;
        r0.i();
        r0.l = Double.NaN;
        r0.c();
        return;
    L5:
        c5a.c.d(5, "FlutterSurfaceView", "pause() invoked when no FlutterRenderer was attached.");
    }

    @Override // s5a.c
    public FlutterRenderer getAttachedRenderer() {
        return this.e;
    }

    public FlutterSurfaceView(Context r3) {
        this(r3, null, false);
    }

    @Override // s5a.c
    public final void a(FlutterRenderer r3) {
        c5a.c.e();
        if (this.e == null) goto L5;
        c5a.c.e();
        e();
        this.e.b(false);
    L5:
        this.e = r3;
        this.d = true;
        if (this.c == false) goto L8;
        c5a.c.e();
        f();
        d();
        return;
    L8:
        setAlpha(0.0f);
    }

    @Override // android.view.SurfaceView, android.view.View
    public final boolean gatherTransparentRegion(Region r10) {
        if (getAlpha() >= 1.0f) goto L5;
        return false;
    L5:
        int[] r0 = new int[2];
        getLocationInWindow(r0);
        int r4 = r0[0];
        r10.op(r4, r0[1], (getRight() + r4) - getLeft(), (r0[1] + getBottom()) - getTop(), Region.Op.DIFFERENCE);
        return true;
    }

    public void setSurfaceSnapshotDelegate(c r2) {
        this.b.n = r2;
    }

    public FlutterSurfaceView(Context r2, AttributeSet r3) {
        this(r2, r3, false);
    }

    public FlutterSurfaceView(Context r1, AttributeSet r2, boolean r3) {
        super(r1, r2);
        this.c = false;
        this.d = false;
        a r4 = new a(this);
        this.f = new b(this);
        this.a = r3;
        this.b = new SurfaceSnapshotTracker(this);
        if (r3 == false) goto L5;
        getHolder().setFormat(-2);
        setZOrderOnTop(true);
        setZOrderMediaOverlay(true);
    L5:
        getHolder().addCallback(r4);
        setAlpha(0.0f);
    }
}
