package com.bytedance.android.live.ktv.common.canvasgl.glview.texture;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import com.bytedance.android.live.core.log.ALogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import hb0.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
abstract class BaseGLTextureView extends TextureView implements TextureView.SurfaceTextureListener {
    public static final /* synthetic */ int g = 0;
    public d a;
    public d.b b;
    public final List<Runnable> c;
    public TextureView.SurfaceTextureListener d;
    public boolean e;
    public c f;

    public class a implements d.l {
        public final /* synthetic */ BaseGLTextureView a;

        public a(BaseGLTextureView r1) {
            this.a = r1;
        }
    }

    public int getRenderMode() {
        return 0;
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [hb0.d, java.lang.Thread] */
    public void c() {
        if (this.e == true) goto L5;
        return;
    L5:
        d.b r0 = this.b;
        if (r0.d == null) goto L41;
        if (r0.f != null) goto L15;
        if (r0.c != null) goto L15;
        throw new NullPointerException("surface has not been set");
    L15:
        if (r0.a != null) goto L18;
        r0.a = new d.m();
    L18:
        if (r0.b != null) goto L21;
        r0.b = new d.f();
    L21:
        if (r0.c != null) goto L23;
        r0.c = new d.g();
    L23:
        ?? r1 = new d(r0.a, r0.b, r0.c, r0.d, r0.e, r0.f, r0.g);
        this.a = r1;
        r1.C = new a(this);
        ThreadMethodProxy.start(r1);
        d(getWidth(), getHeight());
        Iterator r2 = ((ArrayList) this.c).iterator();
    L25:
        if (r2.hasNext() == false) goto L38;
        Runnable r3 = (Runnable) r2.next();
        d r4 = this.a;
        if (r3 == null) goto L36;
        d.k r5 = r4.v;
        monitor-enter(r5);
        r4.Q.add(r3);     // Catch: Throwable -> L33
        r4.v.notifyAll();     // Catch: Throwable -> L33
        monitor-exit(r5);     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        throw th;
    L36:
        r4.getClass();
        throw new IllegalArgumentException("r must not be null");
    L38:
        ((ArrayList) this.c).clear();
        return;
    L41:
        throw new NullPointerException("renderer has not been set");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [hb0.d, java.lang.Thread] */
    public void f() {
        ?? r0 = this.a;
        if (r0 == 0) goto L19;
        d.k r3 = r0.v;
        monitor-enter(r3);
        ALogger.i("GLThread", "surfaceDestroyed tid=" + r0.getId());     // Catch: Throwable -> L16
        r0.F = false;     // Catch: Throwable -> L16
        r0.v.notifyAll();     // Catch: Throwable -> L16
    L8:
        if (r0.H == true) goto L14;
        if (r0.E == true) goto L14;
        r0.v.wait();     // Catch: InterruptedException -> L13 Throwable -> L16
    L13:
        ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L16
    L14:
        monitor-exit(r3);     // Catch: Throwable -> L16
        this.a.requestExitAndWait();
    L16:
        th = move-exception;
        throw th;
    L19:
        this.e = false;
        this.a = null;
    }

    public final void finalize() throws Throwable {
        d r0 = this.a;     // Catch: Throwable -> L7
        if (r0 == null) goto L5;
        r0.requestExitAndWait();     // Catch: Throwable -> L7
    L5:
        super.finalize();
        return;
    L7:
        th = move-exception;
        super.finalize();
        throw th;
    }

    public final void g() {
        d r0 = this.a;
        if (r0 == null) goto L43;
        d.k r1 = r0.v;
        monitor-enter(r1);
    L40:
        th = move-exception;
        throw th;
    L7:
        if (ThreadMethodProxy.currentThread() != r0) goto L10;
        monitor-exit(r1);     // Catch: Throwable -> L40
        return;
    L10:
        r0.O = true;     // Catch: Throwable -> L40
        r0.N = true;     // Catch: Throwable -> L40
        r0.P = false;     // Catch: Throwable -> L40
        r0.v.notifyAll();     // Catch: Throwable -> L40
    L12:
        if (r0.E == true) goto L38;
        if (r0.P == true) goto L38;
        if (r0.I == true) goto L18;
    L33:
        boolean r4 = false;
    L34:
        if (r4 == false) goto L38;
        r0.v.wait();     // Catch: InterruptedException -> L37 Throwable -> L40
    L37:
        ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L40
        goto L12
    L18:
        if (r0.J == false) goto L33;
        if (r0.F == true) goto L22;
    L30:
        boolean r5 = false;
    L31:
        if (r5 == false) goto L33;
        r4 = true;
        goto L34
    L22:
        if (r0.G == true) goto L30;
        if (r0.L <= 0) goto L30;
        if (r0.M <= 0) goto L30;
        if (r0.N == false) goto L30;
        r5 = true;
    L38:
        monitor-exit(r1);     // Catch: Throwable -> L40
        return;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        d r0 = this.a;
        if (r0 == null) goto L5;
        r0.requestExitAndWait();
    L5:
        super.onDetachedFromWindow();
    }

    public void e() {
        super.setSurfaceTextureListener(this);
    }

    public BaseGLTextureView(Context r1) {
        super(r1);
        this.c = new ArrayList();
        this.e = false;
        e();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture r2) {
        f();
        TextureView.SurfaceTextureListener r0 = this.d;
        if (r0 == null) goto L7;
        r0.onSurfaceTextureDestroyed(r2);
        return true;
    L7:
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture r2) {
        TextureView.SurfaceTextureListener r0 = this.d;
        if (r0 == null) goto L6;
        r0.onSurfaceTextureUpdated(r2);
        return;
    }

    public void setRenderer(c r1) {
        this.f = r1;
    }

    @Override // android.view.TextureView
    public void setSurfaceTextureListener(TextureView.SurfaceTextureListener r1) {
        this.d = r1;
    }

    public BaseGLTextureView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.c = new ArrayList();
        this.e = false;
        e();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [hb0.d, java.lang.Thread] */
    public final void d(int r8, int r9) {
        ?? r0 = this.a;
        d.k r2 = r0.v;
        monitor-enter(r2);
        ALogger.i("GLThread", "surfaceCreated tid=" + r0.getId());     // Catch: Throwable -> L17
        r0.F = true;     // Catch: Throwable -> L17
        r0.K = false;     // Catch: Throwable -> L17
        r0.v.notifyAll();     // Catch: Throwable -> L17
    L6:
        if (r0.H == false) goto L14;
        if (r0.K == true) goto L14;
        if (r0.E == true) goto L14;
        r0.v.wait();     // Catch: InterruptedException -> L13 Throwable -> L17
    L13:
        ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L17
    L14:
        monitor-exit(r2);     // Catch: Throwable -> L17
        this.a.onWindowResize(r8, r9);
        g();
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public BaseGLTextureView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.c = new ArrayList();
        this.e = false;
        e();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture r4, int r5, int r6) {
        this.e = true;
        d.b r1 = new d.b();
        this.b = r1;
        d r2 = this.a;
        if (r2 != null) goto L6;
        r1.e = getRenderMode();
        r1.f = r4;
        r1.d = this.f;
        c();
    L9:
        TextureView.SurfaceTextureListener r0 = this.d;
        if (r0 == null) goto L13;
        r0.onSurfaceTextureAvailable(r4, r5, r6);
        return;
    L13:
        return;
    L6:
        if (r2.B == r4) goto L8;
        r2.S = true;
    L8:
        r2.B = r4;
        d(r5, r6);
        goto L9
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture r2, int r3, int r4) {
        this.a.onWindowResize(r3, r4);
        g();
        TextureView.SurfaceTextureListener r0 = this.d;
        if (r0 == null) goto L6;
        r0.onSurfaceTextureSizeChanged(r2, r3, r4);
        return;
    }

    @Override // android.view.TextureView, android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        d r5 = this.a;
        if (r5 == null) goto L6;
        r5.onWindowResize(r1, r2);
        return;
    }
}
