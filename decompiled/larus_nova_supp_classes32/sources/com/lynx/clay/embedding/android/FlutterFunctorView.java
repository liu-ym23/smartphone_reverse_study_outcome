package com.lynx.clay.embedding.android;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.lynx.clay.embedding.engine.renderer.FlutterRenderer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class FlutterFunctorView extends FunctorView implements s5a.c {
    public FlutterRenderer v;
    public boolean w;

    @Override // s5a.c
    public final void pause() {
    }

    @Override // s5a.c
    public final void b() {
        if (this.w == true) goto L5;
        return;
    L5:
        invalidate();
        this.v = null;
        this.w = false;
    }

    @Override // com.lynx.clay.embedding.android.FunctorView
    public final void g() {
        FlutterRenderer r0 = this.v;
        if (r0 == null) goto L5;
        r0.a.destroyGLFunctor();
        this.v.getFlutterJNI().setFlutterFunctorView(null);
    L5:
        super.g();
    }

    @Override // com.lynx.clay.embedding.android.FunctorView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        FlutterRenderer r0 = this.v;
        int r1 = getWidth();
        int r2 = getHeight();
        r0.a.onSurfaceChanged(r1, r2);
    }

    @Override // s5a.c
    public FlutterRenderer getAttachedRenderer() {
        return this.v;
    }

    public long getFunctorPtr() {
        return this.d;
    }

    public FlutterFunctorView(Context r2) {
        this(r2, null);
    }

    @Override // s5a.c
    public final void a(FlutterRenderer r2) {
        this.v = r2;
        this.w = true;
        r2.getFlutterJNI().setFlutterFunctorView(this);
    }

    @Override // com.lynx.clay.embedding.android.FunctorView
    public final void notifyFunctorPresent(long r2) {
        FlutterRenderer r0 = this.v;
        if (r0 == null) goto L6;
        r0.a.notifyFunctorPresent(r2);
        return;
    }

    @Override // com.lynx.clay.embedding.android.FunctorView, android.view.View
    public final void onDraw(Canvas r10) {
        h();
        if (this.f != (-1)) goto L8;
        FlutterRenderer r0 = this.v;
        if (r0 == null) goto L8;
        long r1 = r0.a.getSharedImageSink();
        this.f = r1;
        nativeSetSharedImageSink(this.d, r1);
    L8:
        if (this.w == true) goto L10;
        return;
    L10:
        int r5 = getScrollX();
        int r6 = getScrollY();
        int r7 = getWidth();
        int r8 = getHeight();
        FlutterRenderer r2 = this.v;
        boolean r3 = r10.isHardwareAccelerated();
        boolean r4 = this.g;
        boolean r9 = r2.a.onDraw(r10, r3, r4, r5, r6, r7, r8);
        if (this.g == false) goto L13;
        this.g = false;
    L13:
        if (r9 == true) goto L15;
    L17:
        if (r9 == true) goto L20;
        return;
    L20:
        if (this.j == false) goto L23;
        getRootView().invalidate();
        this.j = false;
        return;
    L23:
        return;
    L15:
        if (r10.isHardwareAccelerated() == false) goto L17;
        r9 = j(r10);
        goto L17
    }

    public FlutterFunctorView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public FlutterFunctorView(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4, true);
        this.w = false;
        setWillNotDraw(false);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (this.w == false) goto L8;
        FlutterRenderer r5 = this.v;
        if (r5 == null) goto L9;
        r5.a.onSurfaceChanged(r1, r2);
        return;
    L9:
        return;
    }
}
