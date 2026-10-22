package com.bytedance.android.live.ktv.common.canvasgl.glview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.opengl.GLES11;
import android.opengl.GLES20;
import android.opengl.GLException;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import fb0.e;
import ib0.d;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class GLView extends GLSurfaceView implements GLSurfaceView.Renderer, lb0.c {
    protected GL10 gl;
    private long glThreadId;
    private boolean isFirstFrame;
    protected eb0.b mCanvas;
    private c onSizeChangeCallback;

    public class a implements Runnable {
        public final /* synthetic */ Rect a;
        public final /* synthetic */ GLView b;

        /* JADX INFO: renamed from: com.bytedance.android.live.ktv.common.canvasgl.glview.GLView$a$a, reason: collision with other inner class name */
        public class RunnableC0205a implements Runnable {
            public final /* synthetic */ a a;

            @Override // java.lang.Runnable
            public final void run() {
                this.a.getClass();     // Catch: Throwable -> L4
                throw null;     // Catch: Throwable -> L4
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public RunnableC0205a(a r1, Bitmap r2) {
                this.a = r1;
            }
        }

        public final void a() {
            GLView r0 = this.b;
            GL10 r1 = r0.gl;
            if (r1 != null) goto L5;
            return;
        L5:
            r0.onDrawFrame(r1);
            GLView r2 = this.b;
            r2.onDrawFrame(r2.gl);
            Rect r3 = this.a;
            int r4 = r3.left;
            int r5 = r3.top;
            int r8 = r3.right;
            int r6 = r3.bottom;
            int r7 = this.b.getHeight();
            int r9 = r8 * r6;
            int[] r11 = new int[r9];
            int[] r12 = new int[r9];
            IntBuffer r13 = IntBuffer.wrap(r11);
            r13.position(0);
            GLES11.glReadPixels(r4, (r7 - r6) - r5, r8, r6, 6408, 5121, r13);     // Catch: GLException -> L14
            int r14 = 0;
        L7:
            if (r14 >= r6) goto L13;
            int r15 = r14 * r8;     // Catch: GLException -> L14
            int r16 = ((r6 - r14) - 1) * r8;     // Catch: GLException -> L14
            int r17 = 0;
        L9:
            if (r17 >= r8) goto L12;
            int r18 = r11[r15 + r17];     // Catch: GLException -> L14
            r12[r16 + r17] = ((r18 & (-16711936)) | ((r18 << 16) & 16711680)) | ((r18 >> 16) & 255);     // Catch: GLException -> L14
            r17 = r17 + 1;
            goto L9
        L12:
            r14 = r14 + 1;
            goto L7
        L13:
            Bitmap r19 = Bitmap.createBitmap(r12, r8, r6, Bitmap.Config.ARGB_8888);
        L15:
            this.b.post(new RunnableC0205a(this, r19));
            return;
        L14:
            r19 = null;
            goto L15
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

        public a(GLView r1, Rect r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public interface b {
    }

    public interface c {
    }

    public void init() {
        setZOrderOnTop(true);
        setEGLContextClientVersion(2);
        setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        setPreserveEGLContextOnPause(true);
        getHolder().setFormat(-3);
        setRenderer(this);
        setRenderMode(0);
    }

    public abstract void onGLDraw(eb0.c r1);

    public void setOnSizeChangeCallback(c r1) {
    }

    public abstract boolean useGLChoreographer();

    public void clearBitmapCache() {
        eb0.b r0 = this.mCanvas;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (useGLChoreographer() == false) goto L11;
        long r0 = this.glThreadId;
        gb0.a r2 = gb0.a.k.get(Long.valueOf(r0));
        if (r2 != null) goto L7;
        r2 = gb0.a.l.get(Long.valueOf(r0));
    L7:
        if (r2 == null) goto L9;
        r2.e();
    L9:
        this.isFirstFrame = true;
        return;
    }

    public void stop() {
        onPause();
        eb0.b r0 = this.mCanvas;
        if (r0 == null) goto L8;
        d r1 = r0.g;
        if (r1 == null) goto L9;
        r1.destroy();
        return;
    L9:
        return;
    }

    @Override // android.opengl.GLSurfaceView, lb0.c
    public void requestRender() {
        super.requestRender();
    }

    public void restart() {
        onResume();
    }

    public GLView(Context r1) {
        super(r1);
        this.isFirstFrame = true;
        init();
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 r6) {
        if (useGLChoreographer() == false) goto L8;
        gb0.a r0 = gb0.a.c();
        if (this.isFirstFrame == false) goto L8;
        if (r0 == null) goto L8;
        requestRender();
        gb0.a.b r2 = r0.e;
        long r3 = r0.a;
        r2.postDelayed(new gb0.a.c(r2, this, r3), r3);
        this.isFirstFrame = false;
    L8:
        this.gl = r6;
        ((e) this.mCanvas.b).getClass();
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        onGLDraw(this.mCanvas);
    }

    public GLView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.isFirstFrame = true;
        init();
    }

    public void getDrawingBitmap(Rect r1, b r2) {
        queueEvent(new a(this, r1));
        requestRender();
    }

    public void onSurfaceCreated(GL10 r1, EGLConfig r2) {
        this.mCanvas = new eb0.b();
        this.glThreadId = ThreadMethodProxy.currentThread().getId();
        if (useGLChoreographer() == false) goto L6;
        gb0.a.d();
        return;
    }

    public void onSurfaceChanged(GL10 r1, int r2, int r3) {
        eb0.b r4 = this.mCanvas;
        r4.e = r2;
        r4.f = r3;
        ((e) r4.b).c(r2, r3);
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
    }
}
