package com.lynx.clay.embedding.android;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.clay.embedding.engine.renderer.FlutterRenderer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class SurfaceSnapshotController implements FlutterSurfaceView.c {
    public final FlutterView a;
    public FlutterSurfaceView b;
    public k c;
    public Drawable d;
    public OverlayState e;
    public boolean f;
    public boolean g;
    public boolean h;
    public int i;
    public int j;
    public int k;
    public Runnable l;

    public static final enum OverlayState extends Enum<OverlayState> {
        public static final OverlayState ARMED_FOR_FOREGROUND = null;
        public static final OverlayState FADING_OUT = null;
        public static final OverlayState FOREGROUND_VISIBLE = null;
        public static final OverlayState HIDDEN = null;
        public static final OverlayState TASK_SNAPSHOT_VISIBLE = null;
        public static final /* synthetic */ OverlayState[] a = null;

        static {
            OverlayState r0 = new OverlayState("HIDDEN", 0);
            HIDDEN = r0;
            OverlayState r1 = new OverlayState("TASK_SNAPSHOT_VISIBLE", 1);
            TASK_SNAPSHOT_VISIBLE = r1;
            OverlayState r3 = new OverlayState("ARMED_FOR_FOREGROUND", 2);
            ARMED_FOR_FOREGROUND = r3;
            OverlayState r5 = new OverlayState("FOREGROUND_VISIBLE", 3);
            FOREGROUND_VISIBLE = r5;
            OverlayState r7 = new OverlayState("FADING_OUT", 4);
            FADING_OUT = r7;
            a = new OverlayState[]{r0, r1, r3, r5, r7};
        }

        public static OverlayState[] values() {
            return (OverlayState[]) a.clone();
        }

        public static OverlayState valueOf(String r1) {
            return (OverlayState) r27.a.a(OverlayState.class, r1);
        }

        public OverlayState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public class a implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ SurfaceSnapshotController b;

        public final void a() {
            SurfaceSnapshotController r0 = this.b;
            if (r0.l == this) goto L5;
            return;
        L5:
            r0.l = null;
            if (r0.j != this.a) goto L16;
            OverlayState r1 = r0.e;
            OverlayState r2 = OverlayState.FADING_OUT;
            if (r1 != r2) goto L17;
            if (r1 != r2) goto L19;
            k r3 = r0.c;
            if (r3 != null) goto L14;
            r0.h();
            return;
        L14:
            r3.animate().cancel();
            r3.animate().alpha(0.0f).setDuration(120).setListener(new s(r0, r3)).start();
            return;
        L19:
            return;
        L17:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(SurfaceSnapshotController r1, int r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public static final class b {
        private b() {
        }

        public static void a(ViewTreeObserver r0, Runnable r1) {
            r0.registerFrameCommitCallback(r1);
        }
    }

    public final void n() {
        this.g = false;
        if (j() == true) goto L5;
        return;
    L5:
        if (this.c != null) goto L8;
        return;
    L8:
        if (this.e != OverlayState.TASK_SNAPSHOT_VISIBLE) goto L35;
        FlutterSurfaceView r1 = this.b;
        if (r1 == null) goto L35;
        if (r1.getParent() != this.a) goto L35;
        FlutterSurfaceView r2 = this.b;
        SurfaceSnapshotTracker r3 = r2.b;
        boolean r4 = r2.d;
        FlutterRenderer r5 = r2.e;
        SurfaceHolder r6 = r3.a.getHolder();
        if (com.lynx.clay.util.d.a(r3.a) == true) goto L16;
    L31:
        boolean r7 = false;
    L32:
        if (r7 == false) goto L35;
        h();
        this.b.setVisibility(0);
        return;
    L16:
        if (r3.a.c == false) goto L31;
        if (r4 == false) goto L31;
        if (r5 == null) goto L31;
        if (r6 == null) goto L31;
        if (r6.getSurface() == null) goto L31;
        if (r6.getSurface().isValid() == false) goto L31;
        int r8 = r3.h;
        int r9 = r3.f;
        if (r8 != r9) goto L31;
        if (r3.i != r9) goto L31;
        if (r3.d == true) goto L31;
        r7 = true;
    L35:
        this.k++;
        if (this.e != OverlayState.FADING_OUT) goto L39;
        k();
        return;
    L39:
        v();
    }

    public final void a() {
        if (this.b != null) goto L5;
        return;
    L5:
        if (this.a.isShown() == true) goto L8;
        return;
    L8:
        if (this.b.getParent() != null) goto L11;
        this.b.setVisibility(0);
        this.a.addView(this.b, 0, new FrameLayout.LayoutParams(-1, -1));
    L13:
        this.b.setVisibility(0);
        k();
        return;
    L11:
        if (this.b.getParent() == this.a) goto L13;
    }

    public final void b() {
        if (this.f == true) goto L5;
        return;
    L5:
        this.a.setBackground(this.d);
        this.d = null;
        this.f = false;
    }

    public final void c() {
        this.e = OverlayState.HIDDEN;
        r();
        FlutterSurfaceView r0 = this.b;
        if (r0 == null) goto L5;
        SurfaceSnapshotTracker r1 = r0.b;
        r1.j();
        r1.d = false;
        r1.a.animate().cancel();
        r1.i();
    L5:
        this.g = false;
        this.k++;
        b();
        k r2 = this.c;
        if (r2 == null) goto L14;
        r2.animate().cancel();
        this.c.animate().setListener(null);
        k r3 = this.c;
        r3.b = null;
        r3.setLayerType(0, null);
        k r4 = this.c;
        r4.b = null;
        Bitmap r5 = r4.a;
        if (r5 != null) goto L10;
    L12:
        r4.a = null;
        r4.invalidate();
        this.a.removeView(this.c);
        this.c = null;
        return;
    L10:
        if (r5.isRecycled() == true) goto L12;
        r4.a.recycle();
        goto L12
    }

    public final void d() {
        if (this.c == null) goto L5;
        return;
    L5:
        k r0 = new k(this.a.getContext());
        this.c = r0;
        r0.setAlpha(0.0f);
        this.a.addView(this.c, new FrameLayout.LayoutParams(-1, -1));
        k();
    }

    public final void e() {
        FlutterSurfaceView r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getParent() != this.a) goto L8;
        return;
    L8:
        if (this.b.getParent() != null) goto L12;
        this.a.addView(this.b, 0, new FrameLayout.LayoutParams(-1, -1));
        return;
    }

    public final boolean g() {
        k r0 = this.c;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (this.f == false) goto L16;
        Bitmap r1 = r0.a;
        if (r1 != null) goto L9;
    L11:
        boolean r2 = false;
    L12:
        if (r2 == false) goto L17;
        return true;
    L17:
        return false;
    L9:
        if (r1.isRecycled() == true) goto L11;
        r2 = true;
        goto L12
    L16:
        return false;
    }

    public final void h() {
        this.e = OverlayState.HIDDEN;
        r();
        this.g = false;
        this.k++;
        if (this.c == null) goto L5;
        FlutterSurfaceView r1 = this.b;
        if (r1 == null) goto L18;
        SurfaceSnapshotTracker r2 = r1.b;
        r2.j();
        r2.d = false;
        r2.a.animate().cancel();
        r2.i();
        if (this.h == false) goto L13;
        e();
    L13:
        FlutterSurfaceView r3 = this.b;
        if (this.h == false) goto L16;
        int r4 = 0;
    L17:
        r3.setVisibility(r4);
        goto L18
    L16:
        r4 = 4;
    L18:
        this.c.animate().cancel();
        this.c.animate().setListener(null);
        k r5 = this.c;
        r5.b = null;
        r5.setLayerType(0, null);
        this.c.setVisibility(0);
        this.c.setAlpha(0.0f);
        return;
    L5:
        if (this.h == false) goto L20;
        e();
        return;
    }

    public final boolean j() {
        if (this.e == OverlayState.HIDDEN) goto L5;
        return true;
    L5:
        return false;
    }

    public final void k() {
        k r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.bringToFront();
        this.c.invalidate();
    }

    public final void l() {
        if (this.c != null) goto L5;
        return;
    L5:
        if (this.e == OverlayState.FOREGROUND_VISIBLE) goto L7;
        return;
    L7:
        if ((this.i & 13) == 13) goto L10;
        return;
    L10:
        if (f(2) == false) goto L13;
        u(260);
        return;
    L13:
        if (this.l != null) goto L21;
        r r1 = new r(this, this.j);
        this.l = r1;
        this.a.postDelayed(r1, 800);
        return;
    }

    public final void m() {
        if (this.b != null) goto L5;
        return;
    L5:
        this.g = true;
        d();
        if (g() == true) goto L10;
        q();
        return;
    }

    public final void q() {
        if (this.b != null) goto L5;
        return;
    L5:
        if (j() == true) goto L24;
        Bitmap r0 = this.b.c();
        if (r0 == null) goto L23;
        d();
        b();
        s(false);
        k r2 = this.c;
        if (r2.a == r0) goto L12;
    L14:
        r2.b = null;
        Bitmap r4 = r2.a;
        if (r4 != null) goto L17;
    L19:
        r2.a = null;
        r2.invalidate();
        r2.a = r0;
        r2.invalidate();
    L20:
        this.c.setVisibility(0);
        this.c.setAlpha(0.0f);
        i(r0);
        return;
    L17:
        if (r4.isRecycled() == true) goto L19;
        r2.a.recycle();
        goto L19
    L12:
        if (r0.isRecycled() == true) goto L14;
        r2.invalidate();
        goto L20
    L23:
        return;
    }

    public final void r() {
        Runnable r0 = this.l;
        if (r0 == null) goto L6;
        this.a.removeCallbacks(r0);
        this.l = null;
    L6:
        this.i = 0;
    }

    public final void t() {
        if (this.e == OverlayState.FADING_OUT) goto L5;
        return;
    L5:
        this.e = OverlayState.FOREGROUND_VISIBLE;
        s(true);
        k r0 = this.c;
        if (r0 != null) goto L8;
        return;
    L8:
        r0.setVisibility(0);
        this.c.invalidate();
        k();
    }

    public final void v() {
        k r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        OverlayState r1 = OverlayState.FOREGROUND_VISIBLE;
        this.e = r1;
        r0.animate().cancel();
        this.c.animate().setListener(null);
        this.c.setVisibility(0);
        this.c.setAlpha(1.0f);
        this.c.invalidate();
        this.c.requestLayout();
        p(true);
        if (f(8) == true) goto L13;
        final k r2 = this.c;
        if (r2 == null) goto L13;
        if (this.e != r1) goto L13;
        r2.b = new q(this, r2);
        r2.invalidate();
    L13:
        FlutterSurfaceView r3 = this.b;
        if (r3 == null) goto L22;
        SurfaceSnapshotTracker r4 = r3.b;
        boolean r5 = r4.d;
        r4.j();
        r4.d = true;
        r4.a.animate().cancel();
        r4.a.setAlpha(0.0f);
        if (r5 == true) goto L18;
        r4.i();
    L18:
        int r6 = r4.i;
        int r7 = r4.f;
        if (r6 != r7) goto L21;
        r4.h(r7);
    L21:
        a();
    L22:
        k();
        this.c.post(new l(this));
    }

    public SurfaceSnapshotController(FlutterView r3) {
        this.e = OverlayState.HIDDEN;
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = 0;
        this.j = -1;
        this.k = 0;
        this.a = r3;
    }

    public final boolean f(int r2) {
        if ((r2 & this.i) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void i(Bitmap r3) {
        if (r3.isRecycled() == false) goto L6;
        return;
    L6:
        if (this.f == true) goto L8;
        this.d = this.a.getBackground();
        this.f = true;
    L8:
        BitmapDrawable r0 = new BitmapDrawable(this.a.getResources(), r3);
        r0.setGravity(119);
        this.a.setBackground(r0);
    }

    public final void o(boolean r6) {
        OverlayState r0 = this.e;
        OverlayState r1 = OverlayState.TASK_SNAPSHOT_VISIBLE;
        if (r0 != r1) goto L5;
        return;
    L5:
        if (g() == false) goto L21;
        FlutterSurfaceView r2 = this.b;
        if (r2 == null) goto L18;
        SurfaceSnapshotTracker r3 = r2.b;
        if (Build.VERSION.SDK_INT >= 30) goto L12;
        r3.getClass();
        goto L18
    L12:
        if (r3.a.getContext().getApplicationInfo().targetSdkVersion < 30) goto L18;
        if (r3.e == true) goto L18;
        r3.a.setZOrderOnTop(true);
        r3.e = true;
    L18:
        s(true);
        r();
        this.e = r1;
        this.c.setVisibility(0);
        this.c.setAlpha(1.0f);
        p(true);
        k();
        w(r6);
        return;
    }

    public final void p(boolean r4) {
        final k r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        if (j() == true) goto L8;
        return;
    L8:
        if (r0.getLayerType() == 2) goto L10;
        r0.setLayerType(2, null);
    L10:
        k();
        this.a.invalidate();
        View r1 = this.a.getRootView();
        if (r1 == null) goto L14;
        r1.invalidate();
    L14:
        if (r0.getWidth() > 0) goto L16;
        return;
    L16:
        if (r0.getHeight() > 0) goto L18;
        return;
    L18:
        if (com.lynx.clay.util.d.a(r0) == false) goto L32;
        r0.buildLayer();     // Catch: IllegalStateException -> L22
        return;
    L22:
        if (r4 == false) goto L30;
        r0.post(new m(this, r0));
        return;
    L30:
        return;
    }

    public final void s(boolean r4) {
        Runnable r0 = this.l;
        if (r0 == null) goto L6;
        this.a.removeCallbacks(r0);
        this.l = null;
    L6:
        k r1 = this.c;
        if (r1 != null) goto L9;
        return;
    L9:
        r1.animate().cancel();
        this.c.animate().setListener(null);
        k r2 = this.c;
        if (r4 == false) goto L12;
        float r5 = 1.0f;
    L13:
        r2.setAlpha(r5);
        return;
    L12:
        r5 = 0.0f;
        goto L13
    }

    public final void u(long r4) {
        OverlayState r0 = this.e;
        OverlayState r1 = OverlayState.FADING_OUT;
        if (r0 != r1) goto L5;
        return;
    L5:
        Runnable r2 = this.l;
        if (r2 == null) goto L9;
        this.a.removeCallbacks(r2);
        this.l = null;
    L9:
        this.e = r1;
        if (this.b == null) goto L13;
        a();
        SurfaceSnapshotTracker r3 = this.b.b;
        r3.j();
        r3.d = false;
        r3.i();
        r3.a.animate().cancel();
        r3.a.setAlpha(1.0f);
        k();
    L13:
        a r5 = new a(this, this.j);
        this.l = r5;
        this.a.postDelayed(r5, r4);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.lynx.clay.embedding.android.o, java.lang.Runnable] */
    public final void w(final boolean r5) {
        final k r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.e != OverlayState.TASK_SNAPSHOT_VISIBLE) goto L21;
        final int r1 = this.k + 1;
        this.k = r1;
        final ?? r2 = new o(this, r1, r0, r5);
        ViewTreeObserver r6 = this.a.getViewTreeObserver();
        if (Build.VERSION.SDK_INT >= 29) goto L10;
    L14:
        r0.postOnAnimation(new p(r0, r2));
    L15:
        r0.invalidate();
        this.a.invalidate();
        View r7 = this.a.getRootView();
        if (r7 == null) goto L20;
        r7.invalidate();
        return;
    L20:
        return;
    L10:
        if (this.a.isHardwareAccelerated() == false) goto L14;
        if (r6.isAlive() == false) goto L14;
        b.a(r6, r2);
        goto L15
    }
}
