package com.bytedance.bmmt.video;

import android.view.SurfaceHolder;
import com.bytedance.bmmt.base.Logging;
import com.bytedance.bmmt.base.ThreadUtils;
import com.bytedance.bmmt.video.memory.BmmtVideoFrameInterface;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class SurfaceEglRenderer extends EglRenderer implements SurfaceHolder.Callback {
    private static final String TAG = "SurfaceEglRenderer";
    private int frameRotation;
    private boolean isFirstFrameRendered;
    private boolean isRenderingPaused;
    private final Object layoutLock;
    private RendererCommon.RendererEvents rendererEvents;
    private int rotatedFrameHeight;
    private int rotatedFrameWidth;

    @Override // com.bytedance.bmmt.video.EglRenderer
    public void disableFpsReduction() {
        Object r0 = this.layoutLock;
        monitor-enter(r0);
        this.isRenderingPaused = false;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        super.disableFpsReduction();
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.bmmt.video.EglRenderer
    public void pauseVideo() {
        Object r0 = this.layoutLock;
        monitor-enter(r0);
        this.isRenderingPaused = true;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        super.pauseVideo();
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.bmmt.video.EglRenderer
    public void release() {
        super.release();
        CountDownLatch r0 = new CountDownLatch(1);
        releaseEglSurface(new m(r0));
        ThreadUtils.awaitUninterruptibly(r0);
    }

    public SurfaceEglRenderer(String r1) {
        super(r1);
        this.layoutLock = new Object();
    }

    private void logD(String r3) {
        Logging.i(TAG, this.name + ": " + r3);
    }

    private void updateFrameDimensionsAndReportEvents(BmmtVideoFrameInterface r6) {
        Object r1 = this.layoutLock;
        monitor-enter(r1);
    L25:
        th = move-exception;
        throw th;
    L5:
        if (this.isRenderingPaused == false) goto L9;
        monitor-exit(r1);     // Catch: Throwable -> L25
        return;
    L9:
        if (this.isFirstFrameRendered == true) goto L14;
        this.isFirstFrameRendered = true;     // Catch: Throwable -> L25
        logD("Reporting first rendered frame.");     // Catch: Throwable -> L25
        RendererCommon.RendererEvents r2 = this.rendererEvents;     // Catch: Throwable -> L25
        if (r2 == null) goto L14;
        r2.onFirstFrameRendered();     // Catch: Throwable -> L25
    L14:
        if (this.rotatedFrameWidth == r6.getRotatedWidth()) goto L16;
    L19:
        logD("Reporting frame resolution changed to " + r6.getRotatedWidth() + "x" + r6.getHeight() + " with rotation " + r6.getRotation());     // Catch: Throwable -> L25
        RendererCommon.RendererEvents r0 = this.rendererEvents;     // Catch: Throwable -> L25
        if (r0 == null) goto L22;
        r0.onFrameResolutionChanged(r6.getWidth(), r6.getHeight(), r6.getRotation().value());     // Catch: Throwable -> L25
    L22:
        this.rotatedFrameWidth = r6.getRotatedWidth();     // Catch: Throwable -> L25
        this.rotatedFrameHeight = r6.getRotatedHeight();     // Catch: Throwable -> L25
        this.frameRotation = r6.getRotation().value();     // Catch: Throwable -> L25
    L23:
        monitor-exit(r1);     // Catch: Throwable -> L25
        return;
    L16:
        if (this.rotatedFrameHeight != r6.getRotatedHeight()) goto L19;
        if (this.frameRotation == r6.getRotation().value()) goto L23;
        goto L19
    }

    @Override // com.bytedance.bmmt.video.EglRenderer, com.bytedance.bmmt.video.VideoSink
    public void onFrame(BmmtVideoFrameInterface r1) {
        updateFrameDimensionsAndReportEvents(r1);
        super.onFrame(r1);
    }

    @Override // com.bytedance.bmmt.video.EglRenderer
    public void setFpsReduction(float r3) {
        Object r0 = this.layoutLock;
        monitor-enter(r0);
        if (r3 != 0.0f) goto L7;
        boolean r1 = true;
    L15:
        this.isRenderingPaused = r1;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        super.setFpsReduction(r3);
        return;
    L12:
        th = move-exception;
        throw th;
    L7:
        r1 = false;
        goto L15
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder r1) {
        ThreadUtils.checkIsOnMainThread();
        createEglSurface(r1.getSurface());
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder r2) {
        ThreadUtils.checkIsOnMainThread();
        CountDownLatch r3 = new CountDownLatch(1);
        releaseEglSurface(new m(r3));
        ThreadUtils.awaitUninterruptibly(r3);
    }

    @Override // com.bytedance.bmmt.video.EglRenderer
    public void init(EglBase.Context r2, int[] r3, RendererCommon.GlDrawer r4) {
        init(r2, null, r3, r4);
    }

    public void init(EglBase.Context r2, RendererCommon.RendererEvents r3, int[] r4, RendererCommon.GlDrawer r5) {
        ThreadUtils.checkIsOnMainThread();
        Object r0 = this.layoutLock;
        monitor-enter(r0);
        this.rendererEvents = r3;     // Catch: Throwable -> L8
        this.isFirstFrameRendered = false;     // Catch: Throwable -> L8
        this.rotatedFrameWidth = 0;     // Catch: Throwable -> L8
        this.rotatedFrameHeight = 0;     // Catch: Throwable -> L8
        this.frameRotation = 0;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        super.init(r2, r4, r5);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder r2, int r3, int r4, int r5) {
        ThreadUtils.checkIsOnMainThread();
        logD("surfaceChanged: format: " + r3 + " size: " + r4 + "x" + r5);
    }
}
