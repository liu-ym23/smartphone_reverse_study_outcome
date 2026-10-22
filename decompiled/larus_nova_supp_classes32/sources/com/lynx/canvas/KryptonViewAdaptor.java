package com.lynx.canvas;

import android.graphics.Rect;
import android.view.Surface;
import android.view.SurfaceView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class KryptonViewAdaptor implements INativeSurfaceProvider {
    private static final String TAG = "KryptonViewAdaptor";
    private Rect mCurrentRect;
    private long mNativeSurfacePtr;
    private PlatformCanvasView mPlatformCanvasView;
    private final SurfaceScaleMode mSurfaceScaleMode;
    private WeakReference<KryptonSurfaceView> mSurfaceView;

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

    public void dispose() {
        this.mPlatformCanvasView.dispose();
        monitor-enter(this);
        long r0 = this.mNativeSurfacePtr;     // Catch: Throwable -> L9
        if (r0 == 0) goto L7;
        SurfaceHolder.destroyOrphanSurface(r0);     // Catch: Throwable -> L9
        this.mNativeSurfacePtr = 0;     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private KryptonViewAdaptor(SurfaceScaleMode r1) {
        this.mSurfaceScaleMode = r1;
    }

    public static /* synthetic */ SurfaceScaleMode access$000(KryptonViewAdaptor r0) {
        return r0.mSurfaceScaleMode;
    }

    public static /* synthetic */ long access$100(KryptonViewAdaptor r2) {
        return r2.mNativeSurfacePtr;
    }

    public static /* synthetic */ WeakReference access$300(KryptonViewAdaptor r0) {
        return r0.mSurfaceView;
    }

    public static /* synthetic */ PlatformCanvasView access$400(KryptonViewAdaptor r0) {
        return r0.mPlatformCanvasView;
    }

    public static KryptonViewAdaptor from(SurfaceView r1) {
        return from(r1, SurfaceScaleMode.SCALE_TO_FILL);
    }

    public void notifyLayoutUpdate(Rect r5) {
        if (this.mSurfaceView.get() != null) goto L6;
        KryptonLLog.e(TAG, "ignore layout update, surfaceView has been released");
        return;
    L6:
        this.mCurrentRect = r5;
        this.mPlatformCanvasView.notifyLayoutUpdate(r5, r5.right - r5.left, r5.bottom - r5.top);
    }

    public void setContentScaleOverride(float r5) {
        if (r5 > 0.0f) goto L5;
        return;
    L5:
        this.mPlatformCanvasView.setContentScaleOverride(r5);
        KryptonSurfaceView r6 = this.mSurfaceView.get();
        if (r6 == null) goto L8;
        this.mPlatformCanvasView.notifySurfaceChangedWithScaleMode(this, r6.getWidth(), r6.getHeight(), this.mSurfaceScaleMode);
    L8:
        Rect r7 = this.mCurrentRect;
        if (r7 == null) goto L12;
        this.mPlatformCanvasView.notifyLayoutUpdate(r7, r7.right - r7.left, r7.bottom - r7.top);
        return;
    }

    public static /* synthetic */ long access$102(KryptonViewAdaptor r0, long r1) {
        r0.mNativeSurfacePtr = r1;
        return r1;
    }

    public static /* synthetic */ long access$200(KryptonViewAdaptor r0, Surface r1) {
        return r0.nativeCreateSurface(r1);
    }

    public static KryptonViewAdaptor from(final KryptonSurfaceView r2, SurfaceScaleMode r3) {
        if (r2 != null) goto L5;
        KryptonLLog.i(TAG, "surface view should not be null");
        return null;
    L5:
        final KryptonViewAdaptor r0 = new KryptonViewAdaptor(r3);
        r0.mSurfaceView = new WeakReference(r2);
        r0.mPlatformCanvasView = new PlatformCanvasView();
        r2.getHolder().addCallback(new AnonymousClass2(r0));
        r2.setOnTouchListener(new AnonymousClass3(r2, r0));
        return r0;
    }

    public void setup(String r8, KryptonApp r9) {
        KryptonSurfaceView r0 = this.mSurfaceView.get();
        if (r0 != null) goto L6;
        KryptonLLog.e(TAG, "ignore setup, surfaceView has been released");
        return;
    L6:
        float r4 = r0.getDensity();
        this.mPlatformCanvasView.setup(r8, r9, r4, r0.getWidth(), r0.getHeight());
        Surface r10 = r0.getHolder().getSurface();
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L9:
        if (this.mNativeSurfacePtr != 0) goto L14;
        if (r10 == null) goto L14;
        if (r10.isValid() == false) goto L14;
        KryptonLLog.i(TAG, "create surface for surfaceCreated event missed.");     // Catch: Throwable -> L17
        this.mNativeSurfacePtr = nativeCreateSurface(r10);     // Catch: Throwable -> L17
    L14:
        this.mPlatformCanvasView.notifySurfaceChangedWithScaleMode(this, r0.getWidth(), r0.getHeight(), this.mSurfaceScaleMode);     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
    }

    public static KryptonViewAdaptor from(final SurfaceView r1, SurfaceScaleMode r2) {
        return from(new AnonymousClass1(r1), r2);
    }
}
