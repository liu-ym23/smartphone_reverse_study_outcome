package com.lynx.canvas;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceView;
import com.lynx.tasm.base.LLog;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class UICanvasSurfaceView extends SurfaceView implements android.view.SurfaceHolder.Callback, INativeSurfaceProvider {
    private static final String TAG = "KryptonUISurfaceView";
    static final int Z_ORDER_MODE_MEDIA_OVERLAY = 2;
    static final int Z_ORDER_MODE_NORMAL = 0;
    static final int Z_ORDER_MODE_ON_TOP = 1;
    private long mNativeSurfacePtr;
    private PlatformCanvasView mPlatformCanvasView;
    private final float mRatio;

    private native long nativeCreateSurface(Surface r1);

    @Override // com.lynx.canvas.INativeSurfaceProvider
    public synchronized long acquireNativeSurfacePtr() {
        monitor-enter(this);
        long r0 = this.mNativeSurfacePtr;     // Catch: Throwable -> L6
        this.mNativeSurfacePtr = 0;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public void destroy() {
        LLog.i(TAG, "UICanvasSurfaceView destroy");
        PlatformCanvasView r0 = this.mPlatformCanvasView;
        if (r0 == null) goto L5;
        r0.onSurfaceDestroyed();
        this.mPlatformCanvasView.dispose();
        this.mPlatformCanvasView = null;
    L5:
        monitor-enter(this);
        long r1 = this.mNativeSurfacePtr;     // Catch: Throwable -> L11
        if (r1 == 0) goto L9;
        SurfaceHolder.destroyOrphanSurface(r1);     // Catch: Throwable -> L11
        this.mNativeSurfacePtr = 0;     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public UICanvasSurfaceView(Context r2) {
        this(r2, 1);
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_lynx_canvas_UICanvasSurfaceView_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public void notifyLayout(Rect r4) {
        LLog.i(TAG, "notifyLayout " + r4);
        PlatformCanvasView r0 = this.mPlatformCanvasView;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.notifyLayoutUpdate(r4, getWidth(), getHeight());
    }

    @Override // android.view.SurfaceHolder.Callback
    public synchronized void surfaceCreated(android.view.SurfaceHolder r4) {
        monitor-enter(this);
        LLog.i(TAG, "surfaceCreated " + r4);     // Catch: Throwable -> L7
        this.mNativeSurfacePtr = nativeCreateSurface(r4.getSurface());     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.view.SurfaceHolder.Callback
    public synchronized void surfaceDestroyed(android.view.SurfaceHolder r5) {
        monitor-enter(this);
        LLog.i(TAG, "surfaceDestroyed " + r5);     // Catch: Throwable -> L9
        this.mPlatformCanvasView.onSurfaceDestroyed();     // Catch: Throwable -> L9
        long r0 = this.mNativeSurfacePtr;     // Catch: Throwable -> L9
        if (r0 == 0) goto L7;
        SurfaceHolder.destroyOrphanSurface(r0);     // Catch: Throwable -> L9
        this.mNativeSurfacePtr = 0;     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public UICanvasSurfaceView(Context r2, int r3) {
        super(r2);
        getHolder().addCallback(this);
        if (r3 != 1) goto L6;
        setZOrderOnTop(true);
    L8:
        getHolder().setFormat(1);
        this.mRatio = INVOKEVIRTUAL_com_lynx_canvas_UICanvasSurfaceView_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(getContext().getResources()).density;
        this.mPlatformCanvasView = new PlatformCanvasView();
        return;
    L6:
        if (r3 != 2) goto L8;
        setZOrderMediaOverlay(true);
        goto L8
    }

    public void setup(String r7, KryptonApp r8) {
        this.mPlatformCanvasView.setup(r7, r8, this.mRatio, getWidth(), getHeight());
    }

    public boolean dispatchTouch(MotionEvent r2, Rect r3, Rect r4) {
        PlatformCanvasView r0 = this.mPlatformCanvasView;
        if (r0 == null) goto L7;
        r0.dispatchTouchEvent(r2, r3, r4);
        return false;
    L7:
        return false;
    }

    @Override // android.view.SurfaceHolder.Callback
    public synchronized void surfaceChanged(android.view.SurfaceHolder r4, int r5, int r6, int r7) {
        monitor-enter(this);
        LLog.i(TAG, "surfaceChanged " + r4 + " " + r5 + " " + r6 + " " + r7);     // Catch: Throwable -> L7
        this.mPlatformCanvasView.notifySurfaceChanged(this, r6, r7);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
