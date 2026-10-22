package com.lynx.canvas;

import android.graphics.Rect;
import android.view.MotionEvent;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class PlatformCanvasView {
    private static final int MAX_POINTER_COUNT = 5;
    private static final String[] MEMORY_DETAIL_KEYS = null;
    private static final String TAG = "PlatformCanvasView";
    private static final int TOUCH_EVENT_BUFFER_SIZE = 112;
    private WeakReference<KryptonApp> mApp;
    private float mContentScaleOverride;
    private Rect mCurrentRect;
    private boolean mHasNotifySurfaceCreate;
    private int mHeight;
    private Boolean mInitialized;
    private String mName;
    private long mNativeCanvasViewPtr;
    private float mScale;
    private int mSurfaceHeight;
    private int mSurfaceWidth;
    private int mWidth;

    private native long nativeCreateCanvasView(String r1, long r2, int r4, int r5);

    private native void nativeDestroyCanvasView(long r1);

    private native void nativeDispatchTouchEvent(long r1, ByteBuffer r3);

    private native long nativeGetMemoryUsageBytes(long r1);

    private native long[] nativeGetMemoryUsageDetail(long r1);

    private native void nativeOnSurfaceChanged(long r1, int r3, int r4);

    private native void nativeOnSurfaceCreated(long r1, long r3, int r5, int r6, int r7);

    private native void nativeOnSurfaceDestroyed(long r1);

    private native void nativeViewLayoutUpdate(long r1, int r3, int r4, int r5, int r6, int r7, int r8);

    static {
        MEMORY_DETAIL_KEYS = new String[]{"krypton.total.estimated_bytes", "krypton.total.object_count", "krypton.canvas_element.bytes", "krypton.canvas_element.count", "krypton.image_element.bytes", "krypton.image_element.count", "krypton.video_element.count", "krypton.video_context.count", "krypton.webgl_generic.count", "krypton.webgl_buffer.bytes", "krypton.webgl_buffer.count", "krypton.webgl_texture.bytes", "krypton.webgl_texture.count", "krypton.webgl_renderbuffer.bytes", "krypton.webgl_renderbuffer.count", "krypton.external_data.bytes", "krypton.external_data.count", "krypton.gl_surface.count"};
    }

    public void dispose() {
        long r0 = this.mNativeCanvasViewPtr;
        if (r0 != 0) goto L5;
        return;
    L5:
        this.mNativeCanvasViewPtr = 0;
        nativeDestroyCanvasView(r0);
    }

    public long getMemoryUsageBytes() {
        long r0 = this.mNativeCanvasViewPtr;
        if (r0 != 0) goto L6;
        return 0;
    L6:
        return nativeGetMemoryUsageBytes(r0);
    }

    public Map<String, String> getMemoryUsageDetail() {
        long r0 = this.mNativeCanvasViewPtr;
        if (r0 != 0) goto L5;
        return null;
    L5:
        long[] r1 = nativeGetMemoryUsageDetail(r0);
        if (r1 != null) goto L8;
        return null;
    L8:
        HashMap r2 = new HashMap();
        int r3 = Math.min(r1.length, MEMORY_DETAIL_KEYS.length);
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L11;
        r2.put(MEMORY_DETAIL_KEYS[r4], String.valueOf(r1[r4]));
        r4 = r4 + 1;
        goto L9
    L11:
        return r2;
    }

    public void onSurfaceDestroyed() {
        long r0 = this.mNativeCanvasViewPtr;
        if (r0 != 0) goto L5;
        return;
    L5:
        this.mHasNotifySurfaceCreate = false;
        nativeOnSurfaceDestroyed(r0);
    }

    public PlatformCanvasView() {
        this.mInitialized = Boolean.FALSE;
        this.mContentScaleOverride = 0.0f;
        this.mHasNotifySurfaceCreate = false;
    }

    private boolean initInternal() {
        if (Krypton.inst().hasInitialized() == true) goto L6;
        KryptonLLog.w(TAG, "initCanvasInternal but krypton do not init.");
        return false;
    L6:
        KryptonApp r0 = this.mApp.get();
        if (r0 != null) goto L10;
        KryptonLLog.w(TAG, "krypton app has been released.");
        return false;
    L10:
        long r5 = r0.newNativeWeakPtr();
        if (r5 != 0) goto L14;
        KryptonLLog.w(TAG, "canvas app has been destroyed.");
        return false;
    L14:
        this.mNativeCanvasViewPtr = nativeCreateCanvasView(this.mName, r5, this.mWidth, this.mHeight);
        return true;
    }

    public float getScale() {
        return this.mScale;
    }

    private int px2dip(float r2) {
        return (int) ((r2 / this.mScale) + 0.5f);
    }

    private int px2overriden(float r2) {
        return (int) (((r2 / this.mScale) * this.mContentScaleOverride) + 0.5f);
    }

    public void dispatchTransformedTouchEvent(ByteBuffer r6) {
        long r0 = this.mNativeCanvasViewPtr;
        if (r0 == 0) goto L6;
        nativeDispatchTouchEvent(r0, r6);
        return;
    }

    public void setContentScaleOverride(float r4) {
        KryptonLLog.i(TAG, "setContentScaleOverride " + r4);
        monitor-enter(this);
        this.mContentScaleOverride = r4;     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        if (this.mInitialized.booleanValue() == false) goto L17;
        KryptonApp r0 = this.mApp.get();
        if (r0 == null) goto L18;
        r0.setDevicePixelRatio(r4);
        return;
    L18:
        return;
    L17:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private void onSurfaceChanged(int r6, int r7) {
        long r0 = this.mNativeCanvasViewPtr;
        if (r0 != 0) goto L6;
        KryptonLLog.e(TAG, "surface changed but mNativeCanvasViewPtr " + this.mNativeCanvasViewPtr);
        return;
    L6:
        nativeOnSurfaceChanged(r0, r6, r7);
    }

    public void dispatchTouchEvent(MotionEvent r10, Rect r11, Rect r12) {
        int r0 = r10.getActionIndex();
        int r1 = 5;
        if (r0 < 5) goto L5;
        return;
    L5:
        int r2 = r10.getPointerCount();
        if (r2 > 5) goto L9;
        r1 = r2;
    L9:
        ByteBuffer r3 = ByteBuffer.allocateDirect(112);
        r3.order(ByteOrder.LITTLE_ENDIAN);
        r3.clear();
        r3.put((byte) r10.getActionMasked()).put((byte) r1).put((byte) r0).put((byte) 1).putInt(px2dip(r12.left)).putInt(px2dip(r12.top));
        float r4 = r10.getRawX() - r10.getX();
        float r5 = r10.getRawY() - r10.getY();
        int r6 = 0;
    L10:
        if (r6 >= r1) goto L12;
        r3.putInt(r10.getPointerId(r6)).putFloat(((r11.left - r12.left) + r10.getX(r6)) / this.mScale).putFloat(((r11.top - r12.top) + r10.getY(r6)) / this.mScale).putFloat((r10.getX(r6) + r4) / this.mScale).putFloat((r10.getY(r6) + r5) / this.mScale);
        r6 = r6 + 1;
        goto L10
    L12:
        long r13 = this.mNativeCanvasViewPtr;
        if (r13 == 0) goto L17;
        nativeDispatchTouchEvent(r13, r3);
        return;
    }

    public void notifyLayoutUpdate(Rect r10, int r11, int r12) {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L4:
        if (this.mContentScaleOverride <= 0.0f) goto L6;
        Rect r0 = new Rect(px2overriden(r10.left), px2overriden(r10.top), px2overriden(r10.right), px2overriden(r10.bottom));     // Catch: Throwable -> L20
        int r7 = px2overriden(r11);     // Catch: Throwable -> L20
        int r8 = px2overriden(r12);     // Catch: Throwable -> L20
        r10 = r0;
    L8:
        if (r10.equals(this.mCurrentRect) == true) goto L10;
    L15:
        this.mCurrentRect = r10;     // Catch: Throwable -> L20
        this.mWidth = r7;     // Catch: Throwable -> L20
        this.mHeight = r8;     // Catch: Throwable -> L20
        long r1 = this.mNativeCanvasViewPtr;     // Catch: Throwable -> L20
        if (r1 == 0) goto L18;
        nativeViewLayoutUpdate(r1, r10.left, r10.right, r10.top, r10.bottom, r7, r8);     // Catch: Throwable -> L20
    L18:
        monitor-exit(this);     // Catch: Throwable -> L20
        return;
    L10:
        if (this.mWidth != r7) goto L15;
        if (this.mHeight != r8) goto L15;
        monitor-exit(this);     // Catch: Throwable -> L20
        return;
    L6:
        r7 = r11;
        r8 = r12;
        goto L8
    }

    public void notifySurfaceChanged(INativeSurfaceProvider r2, int r3, int r4) {
        notifySurfaceChangedWithScaleMode(r2, r3, r4, SurfaceScaleMode.SCALE_TO_FILL);
    }

    public void notifySurfaceChangedWithScaleMode(INativeSurfaceProvider r9, int r10, int r11, SurfaceScaleMode r12) {
        monitor-enter(this);
        if (r10 == 0) goto L34;
        if (r11 == 0) goto L34;
        if (this.mContentScaleOverride <= 0.0f) goto L10;
        r10 = px2overriden(r10);     // Catch: Throwable -> L37
        r11 = px2overriden(r11);     // Catch: Throwable -> L37
    L10:
        int r5 = r10;
        int r6 = r11;
        if (this.mHasNotifySurfaceCreate == true) goto L26;
        if (this.mNativeCanvasViewPtr != 0) goto L17;
        KryptonLLog.e(TAG, "surface created but mNativeCanvasViewPtr is 0");     // Catch: Throwable -> L37
        monitor-exit(this);     // Catch: Throwable -> L37
        return;
    L17:
        long r3 = r9.acquireNativeSurfacePtr();     // Catch: Throwable -> L37
        if (r3 != 0) goto L22;
        KryptonLLog.e(TAG, "notify surface created but provider already drained");     // Catch: Throwable -> L37
        monitor-exit(this);     // Catch: Throwable -> L37
        return;
    L22:
        KryptonLLog.i(TAG, "notify surface created w " + r5 + " h " + r6 + " scaleMode " + r12);     // Catch: Throwable -> L37
        this.mSurfaceWidth = r5;     // Catch: Throwable -> L37
        this.mSurfaceHeight = r6;     // Catch: Throwable -> L37
        this.mHasNotifySurfaceCreate = true;     // Catch: Throwable -> L37
        nativeOnSurfaceCreated(this.mNativeCanvasViewPtr, r3, r5, r6, r12.value);     // Catch: Throwable -> L37
        monitor-exit(this);     // Catch: Throwable -> L37
        return;
    L26:
        if (this.mSurfaceWidth == r5) goto L28;
    L31:
        KryptonLLog.i(TAG, "notify surface changed w " + r5 + " h " + r6);     // Catch: Throwable -> L37
        this.mSurfaceWidth = r5;     // Catch: Throwable -> L37
        this.mSurfaceHeight = r6;     // Catch: Throwable -> L37
        onSurfaceChanged(r5, r6);     // Catch: Throwable -> L37
        monitor-exit(this);     // Catch: Throwable -> L37
        return;
    L28:
        if (this.mSurfaceHeight != r6) goto L31;
        monitor-exit(this);     // Catch: Throwable -> L37
        return;
    L34:
        KryptonLLog.i(TAG, "ignore notify surface changed w " + r10 + " h " + r11 + " or platform view disposed");     // Catch: Throwable -> L37
        monitor-exit(this);     // Catch: Throwable -> L37
        return;
    L37:
        th = move-exception;
        throw th;
    }

    public boolean setup(String r4, KryptonApp r5, float r6, int r7, int r8) {
        if (this.mInitialized.booleanValue() == false) goto L6;
        KryptonLLog.e(TAG, "Set name to initialized canvas with old name " + this.mName + " new name " + r4);
        return true;
    L6:
        this.mScale = r6;
        this.mName = r4;
        if (this.mContentScaleOverride <= 0.0f) goto L9;
        this.mWidth = px2overriden(r7);
        this.mHeight = px2overriden(r8);
        r5.setDevicePixelRatio(this.mContentScaleOverride);
    L10:
        this.mApp = new WeakReference(r5);
        if (initInternal() == true) goto L14;
        KryptonLLog.e(TAG, "init canvas internal failed " + r4);
        return false;
    L14:
        this.mInitialized = Boolean.TRUE;
        return true;
    L9:
        this.mWidth = r7;
        this.mHeight = r8;
        goto L10
    }
}
