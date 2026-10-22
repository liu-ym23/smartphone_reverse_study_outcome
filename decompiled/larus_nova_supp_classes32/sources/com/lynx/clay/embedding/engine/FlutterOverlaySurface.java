package com.lynx.clay.embedding.engine;

import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import com.lynx.clay.embedding.android.FlutterImageView;
import com.lynx.clay.embedding.android.FlutterView;
import com.lynx.clay.embedding.android.FunctorView;
import com.lynx.clay.plugin.platform.PlatformViewsController;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class FlutterOverlaySurface {
    public final FlutterImageView a;
    public final PlatformViewsController b;
    public FunctorView c;
    public long d;
    public final boolean e;

    public final View a() {
        if (this.e == false) goto L7;
        return this.a;
    L7:
        if (this.c != null) goto L12;
        if (this.d == 0) goto L12;
        FunctorView r0 = new FunctorView(this.b.c.getContext());
        this.c = r0;
        r0.setSharedImageSink(this.d);
        this.c.setAlpha(1.0f);
    L12:
        return this.c;
    }

    public void dispose() {
        if (this.e == false) goto L6;
        this.a.b();
        this.a.a.close();
        return;
    L6:
        FunctorView r0 = this.c;
        if (r0 == null) goto L9;
        r0.setAlpha(0.0f);
        this.c.invalidate();
        this.c.g();
    L9:
        this.d = 0;
    }

    public Surface getSurface() {
        return this.a.getSurface();
    }

    public boolean onSurfaceUpdated() {
        if (this.e == true) goto L5;
        FunctorView r0 = this.c;
        if (r0 != null) goto L9;
        return false;
    L9:
        r0.l();
        this.c.postInvalidateOnAnimation();
        return true;
    L5:
        return this.a.c(false);
    }

    public void bringToFront() {
        a().bringToFront();
    }

    public void removeFromParent() {
        ViewGroup r0 = (ViewGroup) a().getParent();
        if (r0 == null) goto L6;
        r0.removeView(a());
        return;
    }

    public FlutterOverlaySurface(FlutterImageView r2) {
        this.e = false;
        this.e = true;
        this.a = r2;
        this.b = null;
    }

    public static FlutterOverlaySurface createWithImageView(PlatformViewsController r5) {
        FlutterView r6 = r5.c;
        FlutterImageView r0 = new FlutterImageView(r6.getContext(), r6.getWidth(), r6.getHeight(), FlutterImageView.SurfaceKind.overlay);
        FlutterEngine r7 = r6.r;
        if (r7 == null) goto L6;
        r0.a(r7.b);
    L6:
        return new FlutterOverlaySurface(r0);
    }

    public FlutterOverlaySurface(PlatformViewsController r2, long r3) {
        this.e = false;
        this.e = false;
        this.b = r2;
        this.d = r3;
        this.a = null;
    }

    public static FlutterOverlaySurface createWithFunctorView(PlatformViewsController r1, long r2) {
        return new FlutterOverlaySurface(r1, r2);
    }
}
