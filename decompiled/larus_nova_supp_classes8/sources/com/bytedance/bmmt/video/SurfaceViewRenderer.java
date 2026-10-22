package com.bytedance.bmmt.video;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.bytedance.bmmt.base.Logging;
import com.bytedance.bmmt.base.ThreadUtils;
import com.bytedance.bmmt.video.memory.BmmtVideoFrameInterface;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class SurfaceViewRenderer extends SurfaceView implements SurfaceHolder.Callback, VideoSink, RendererCommon.RendererEvents {
    private static final String TAG = "SurfaceViewRenderer";
    private final SurfaceEglRenderer eglRenderer;
    private boolean enableFixedSize;
    private float radius;
    private RendererCommon.RendererEvents rendererEvents;
    private final String resourceName;
    private int rotatedFrameHeight;
    private int rotatedFrameWidth;
    private int surfaceHeight;
    private int surfaceWidth;
    private final RendererCommon.VideoLayoutMeasure videoLayoutMeasure;

    public static /* synthetic */ void a(SurfaceViewRenderer r0, int r1, int r2) {
        r0.lambda$onFrameResolutionChanged$0(r1, r2);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder r1, int r2, int r3, int r4) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder r1) {
    }

    public void clearImage() {
        this.eglRenderer.clearImage();
    }

    public void disableFpsReduction() {
        this.eglRenderer.disableFpsReduction();
    }

    @Override // com.bytedance.bmmt.video.RendererCommon.RendererEvents
    public void onFirstFrameRendered() {
        RendererCommon.RendererEvents r0 = this.rendererEvents;
        if (r0 == null) goto L6;
        r0.onFirstFrameRendered();
        return;
    }

    public void pauseVideo() {
        this.eglRenderer.pauseVideo();
    }

    public void release() {
        this.eglRenderer.release();
    }

    private String getResourceName() {
        return getResources().getResourceEntryName(getId());
    L4:
        return "";
    }

    private void updateSurfaceSize() {
        ThreadUtils.checkIsOnMainThread();
        if (this.enableFixedSize == true) goto L5;
    L21:
        this.surfaceHeight = 0;
        this.surfaceWidth = 0;
        getHolder().setSizeFromLayout();
        return;
    L5:
        if (this.rotatedFrameWidth == 0) goto L21;
        if (this.rotatedFrameHeight == 0) goto L21;
        if (getWidth() == 0) goto L21;
        if (getHeight() == 0) goto L21;
        float r0 = getWidth() / getHeight();
        int r1 = this.rotatedFrameWidth;
        int r3 = this.rotatedFrameHeight;
        if ((r1 / r3) <= r0) goto L15;
        r1 = (int) (r3 * r0);
    L16:
        int r2 = Math.min(getWidth(), r1);
        int r4 = Math.min(getHeight(), r3);
        logD("updateSurfaceSize. Layout size: " + getWidth() + "x" + getHeight() + ", frame size: " + this.rotatedFrameWidth + "x" + this.rotatedFrameHeight + ", requested surface size: " + r2 + "x" + r4 + ", old surface size: " + this.surfaceWidth + "x" + this.surfaceHeight);
        if (r2 == this.surfaceWidth) goto L19;
    L20:
        this.surfaceWidth = r2;
        this.surfaceHeight = r4;
        getHolder().setFixedSize(r2, r4);
        return;
    L19:
        if (r4 != this.surfaceHeight) goto L20;
        return;
    L15:
        r3 = (int) (r1 / r0);
        goto L16
    }

    public SurfaceViewRenderer(Context r3) {
        super(r3);
        this.videoLayoutMeasure = new RendererCommon.VideoLayoutMeasure();
        String r4 = getResourceName();
        this.resourceName = r4;
        SurfaceEglRenderer r0 = new SurfaceEglRenderer(r4);
        this.eglRenderer = r0;
        getHolder().addCallback(this);
        getHolder().addCallback(r0);
        this.radius = 0.0f;
        setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.transparent)));
    }

    private void logD(String r3) {
        Logging.i(TAG, this.resourceName + ": " + r3);
    }

    private void postOrRun(Runnable r3) {
        if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) goto L5;
        r3.run();
        return;
    L5:
        post(r3);
    }

    @Override // android.view.SurfaceView, android.view.View
    public void draw(Canvas r6) {
        if (this.radius <= 0.0f) goto L5;
        Path r0 = new Path();
        RectF r2 = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        float r1 = this.radius;
        r0.addRoundRect(r2, r1, r1, Path.Direction.CCW);
        r6.clipPath(r0, Region.Op.REPLACE);
    L5:
        super.draw(r6);
    }

    @Override // com.bytedance.bmmt.video.VideoSink
    public void onFrame(BmmtVideoFrameInterface r2) {
        this.eglRenderer.onFrame(r2);
    }

    public void removeFrameListener(EglRenderer.FrameListener r2) {
        this.eglRenderer.removeFrameListener(r2);
    }

    public void setEnableHardwareScaler(boolean r1) {
        ThreadUtils.checkIsOnMainThread();
        this.enableFixedSize = r1;
        updateSurfaceSize();
    }

    public void setFpsReduction(float r2) {
        this.eglRenderer.setFpsReduction(r2);
    }

    public void setMirror(boolean r2) {
        this.eglRenderer.setMirror(r2);
    }

    public void setRadius(float r2) {
        this.radius = Math.max(0.0f, r2);
    }

    public void setScalingType(RendererCommon.ScalingType r2) {
        ThreadUtils.checkIsOnMainThread();
        this.videoLayoutMeasure.setScalingType(r2);
        requestLayout();
        this.eglRenderer.setRenderModel(r2);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder r1) {
        ThreadUtils.checkIsOnMainThread();
        this.surfaceHeight = 0;
        this.surfaceWidth = 0;
        updateSurfaceSize();
    }

    public SurfaceViewRenderer(Context r2, AttributeSet r3) {
        super(r2, r3);
        this.videoLayoutMeasure = new RendererCommon.VideoLayoutMeasure();
        String r4 = getResourceName();
        this.resourceName = r4;
        SurfaceEglRenderer r5 = new SurfaceEglRenderer(r4);
        this.eglRenderer = r5;
        getHolder().addCallback(this);
        getHolder().addCallback(r5);
        this.radius = 0.0f;
        setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.transparent)));
    }

    private /* synthetic */ void lambda$onFrameResolutionChanged$0(int r1, int r2) {
        this.rotatedFrameWidth = r1;
        this.rotatedFrameHeight = r2;
        updateSurfaceSize();
        requestLayout();
    }

    public void addFrameListener(EglRenderer.FrameListener r2, float r3) {
        this.eglRenderer.addFrameListener(r2, r3);
    }

    public void init(EglBase.Context r3, RendererCommon.RendererEvents r4) {
        init(r3, r4, EglBase.CC.getEGLConfig(EglBase.EglVersion.getPreferredEglVersion(), EglBase.Config.CONFIG_PLAIN), new GlRectDrawer());
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int r4, int r5) {
        ThreadUtils.checkIsOnMainThread();
        Point r6 = this.videoLayoutMeasure.measure(r4, r5, this.rotatedFrameWidth, this.rotatedFrameHeight);
        setMeasuredDimension(r6.x, r6.y);
        logD("onMeasure(). New size: " + r6.x + "x" + r6.y);
    }

    public void setScalingType(RendererCommon.ScalingType r2, RendererCommon.ScalingType r3) {
        ThreadUtils.checkIsOnMainThread();
        this.videoLayoutMeasure.setScalingType(r2, r3);
        requestLayout();
    }

    public void addFrameListener(EglRenderer.FrameListener r2, float r3, RendererCommon.GlDrawer r4) {
        this.eglRenderer.addFrameListener(r2, r3, r4);
    }

    @Override // com.bytedance.bmmt.video.RendererCommon.RendererEvents
    public void onFrameResolutionChanged(final int r3, int r4, int r5) {
        RendererCommon.RendererEvents r0 = this.rendererEvents;
        if (r0 == null) goto L6;
        r0.onFrameResolutionChanged(r3, r4, r5);
    L6:
        if (r5 == 0) goto L10;
        if (r5 == 180) goto L10;
        final int r1 = r4;
    L11:
        if (r5 == 0) goto L13;
        if (r5 == 180) goto L13;
    L14:
        postOrRun(new u(this, r1, r3));
        return;
    L13:
        r3 = r4;
    L10:
        r1 = r3;
        goto L11
    }

    public void init(EglBase.Context r1, RendererCommon.RendererEvents r2, int[] r3, RendererCommon.GlDrawer r4) {
        ThreadUtils.checkIsOnMainThread();
        this.rendererEvents = r2;
        this.rotatedFrameWidth = 0;
        this.rotatedFrameHeight = 0;
        this.eglRenderer.init(r1, this, r3, r4);
    }

    @Override // android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        ThreadUtils.checkIsOnMainThread();
        this.eglRenderer.setLayoutAspectRatio((r4 - r2) / (r5 - r3));
        updateSurfaceSize();
    }
}
