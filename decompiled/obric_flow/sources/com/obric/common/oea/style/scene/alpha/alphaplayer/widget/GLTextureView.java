package com.obric.common.oea.style.scene.alpha.alphaplayer.widget;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import java.lang.ref.WeakReference;
import tp.a;
import zp.b;
import zp.c;
import zp.d;
import zp.e;
import zp.f;
import zp.g;
import zp.i;
import zp.j;

/* JADX INFO: loaded from: classes2.dex */
public class GLTextureView extends TextureView implements TextureView.SurfaceTextureListener, View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final f f11364k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f11365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f11366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public i f11367c;
    public boolean d;
    public b e;
    public c f;
    public d g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f11368h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f11369i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f11370j;

    static {
        f11364k = new f();
    }

    public GLTextureView(Context r5) {
        super(r5);
        this.f11365a = new WeakReference(this);
        setSurfaceTextureListener(this);
    }

    public final void f() {
        if (this.f11366b != null) goto L6;
        return;
    L6:
        throw new IllegalStateException("setRenderer has already been called for this instance.");
    }

    public final void finalize() {
        e r5 = this.f11366b;     // Catch: Throwable -> L6
        if (r5 == null) goto L8;
        r5.c();     // Catch: Throwable -> L6
    L8:
        super.finalize();
        return;
    L6:
        th = move-exception;
        super.finalize();
        throw th;
    }

    public final void g(int r5, int r10) {
        e r11 = this.f11366b;
        r11.getClass();
        f r12 = f11364k;
        monitor-enter(r12);
        r11.f23566k = r5;     // Catch: Throwable -> L20
        r11.f23567l = r10;     // Catch: Throwable -> L20
        r11.f23572q = true;     // Catch: Throwable -> L20
        r11.f23569n = true;     // Catch: Throwable -> L20
        r11.f23570o = false;     // Catch: Throwable -> L20
        r12.notifyAll();     // Catch: Throwable -> L20
    L6:
        if (r11.f23561b == true) goto L23;
        if (r11.d == true) goto L23;
        if (r11.f23570o == true) goto L23;
        if (r11.f23563h == false) goto L23;
        if (r11.f23564i == false) goto L23;
        if (r11.b() == false) goto L23;
        Log.i("Main thread", "onWindowResize waiting for render complete from tid=" + r11.getId());     // Catch: Throwable -> L20
        f11364k.wait();     // Catch: Throwable -> L20 InterruptedException -> L22
    L22:
        Thread.currentThread().interrupt();     // Catch: Throwable -> L20
    L23:
        monitor-exit(r12);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public int getDebugFlags() {
        return this.f11368h;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.f11370j;
    }

    public int getRenderMode() {
        e r5 = this.f11366b;
        r5.getClass();
        f r10 = f11364k;
        monitor-enter(r10);
        int r11 = r5.f23568m;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.view.TextureView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.d("GLTextureView", "onAttachedToWindow reattach =" + this.d);
        if (this.d == true) goto L5;
    L21:
        this.d = false;
        return;
    L5:
        if (this.f11367c == null) goto L21;
        e r5 = this.f11366b;
        if (r5 == null) goto L16;
        f r10 = f11364k;
        monitor-enter(r10);
        int r11 = r5.f23568m;     // Catch: Throwable -> L13
        monitor-exit(r10);     // Catch: Throwable -> L13
    L17:
        e r12 = new e(this.f11365a);
        this.f11366b = r12;
        if (r11 == 1) goto L20;
        r12.d(r11);
    L20:
        this.f11366b.start();
    L13:
        th = move-exception;
        throw th;
    L16:
        r11 = 1;
        goto L17
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        Log.d("GLTextureView", "onDetachedFromWindow");
        e r5 = this.f11366b;
        if (r5 == null) goto L5;
        r5.c();
    L5:
        this.d = true;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r5, int r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17) {
        getSurfaceTexture();
        g(r12 - r10, r13 - r11);
    }

    public final void onPause() {
        e r10 = this.f11366b;
        r10.getClass();
        f r5 = f11364k;
        monitor-enter(r5);
        Log.i("GLThread", "onPause tid=" + r10.getId());     // Catch: Throwable -> L12
        r10.f23562c = true;     // Catch: Throwable -> L12
        r5.notifyAll();     // Catch: Throwable -> L12
    L6:
        if (r10.f23561b == true) goto L15;
        if (r10.d == true) goto L15;
        Log.i("Main thread", "onPause waiting for mPaused.");     // Catch: Throwable -> L12
        f11364k.wait();     // Catch: Throwable -> L12 InterruptedException -> L14
    L14:
        Thread.currentThread().interrupt();     // Catch: Throwable -> L12
    L15:
        monitor-exit(r5);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture r10, int r11, int r12) {
        e r13 = this.f11366b;
        r13.getClass();
        f r5 = f11364k;
        monitor-enter(r5);
        Log.i("GLThread", "surfaceCreated tid=" + r13.getId());     // Catch: Throwable -> L11
        r13.e = true;     // Catch: Throwable -> L11
        r5.notifyAll();     // Catch: Throwable -> L11
    L6:
        if (r13.g == false) goto L14;
        if (r13.f23561b == true) goto L14;
        f11364k.wait();     // Catch: Throwable -> L11 InterruptedException -> L13
    L13:
        Thread.currentThread().interrupt();     // Catch: Throwable -> L11
    L14:
        monitor-exit(r5);     // Catch: Throwable -> L11
        g(r11, r12);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture r10) {
        e r5 = this.f11366b;
        r5.getClass();
        f r11 = f11364k;
        monitor-enter(r11);
        Log.i("GLThread", "surfaceDestroyed tid=" + r5.getId());     // Catch: Throwable -> L11
        r5.e = false;     // Catch: Throwable -> L11
        r11.notifyAll();     // Catch: Throwable -> L11
    L6:
        if (r5.g == true) goto L14;
        if (r5.f23561b == true) goto L14;
        f11364k.wait();     // Catch: Throwable -> L11 InterruptedException -> L13
    L13:
        Thread.currentThread().interrupt();     // Catch: Throwable -> L11
    L14:
        monitor-exit(r11);     // Catch: Throwable -> L11
        return true;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture r5, int r10, int r11) {
        g(r10, r11);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture r5) {
    }

    public final void requestRender() {
        e r5 = this.f11366b;
        r5.getClass();
        f r10 = f11364k;
        monitor-enter(r10);
        r5.f23569n = true;     // Catch: Throwable -> L8
        r10.notifyAll();     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void setDebugFlags(int r5) {
        this.f11368h = r5;
    }

    public void setEGLConfigChooser(b r5) {
        f();
        this.e = r5;
    }

    public void setEGLContextClientVersion(int r5) {
        f();
        this.f11369i = r5;
    }

    public void setEGLContextFactory(c r5) {
        f();
        this.f = r5;
    }

    public void setEGLWindowSurfaceFactory(d r5) {
        f();
        this.g = r5;
    }

    public void setGLWrapper(g r5) {
    }

    public void setMonitor(a r5) {
    }

    public void setPreserveEGLContextOnPause(boolean r5) {
        this.f11370j = r5;
    }

    public void setRenderMode(int r5) {
        this.f11366b.d(r5);
    }

    public void setRenderer(i r5) {
        f();
        if (this.e != null) goto L6;
        this.e = new j(this, true);
    L6:
        if (this.f != null) goto L9;
        this.f = new mn.i(this);
    L9:
        if (this.g != null) goto L11;
        this.g = new wc.f(17);
    L11:
        this.f11367c = r5;
        e r10 = new e(this.f11365a);
        this.f11366b = r10;
        r10.start();
    }

    public void setEGLConfigChooser(boolean r5) {
        setEGLConfigChooser(new j(this, r5));
    }

    public GLTextureView(Context r5, AttributeSet r10) {
        super(r5, r10);
        this.f11365a = new WeakReference(this);
        setSurfaceTextureListener(this);
    }
}
