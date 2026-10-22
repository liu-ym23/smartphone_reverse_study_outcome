package com.lynx.canvas;

import android.graphics.RectF;
import android.os.Looper;
import android.view.Surface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class KryptonDownStreamManager {
    private static final String TAG = "KryptonDownStreamManager";

    /* JADX INFO: renamed from: com.lynx.canvas.KryptonDownStreamManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Holder {
        private static final KryptonDownStreamManager INSTANCE = null;

        private Holder() {
        }

        static {
            INSTANCE = new KryptonDownStreamManager(null);
        }

        public static /* synthetic */ KryptonDownStreamManager access$000() {
            return INSTANCE;
        }
    }

    private static native long nativeAddSurface(long r0, String r2, Surface r3, int r4, int r5, int r6, float r7, float r8, float r9, float r10, int r11);

    private static native void nativeRemoveSurface(long r0, String r2, long r3);

    private KryptonDownStreamManager() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L6;
        return;
    L6:
        throw new IllegalStateException("KryptonDownStreamManager should be used on main thread only.");
    }

    public static KryptonDownStreamManager getInstance() {
        return Holder.access$000();
    }

    public /* synthetic */ KryptonDownStreamManager(AnonymousClass1 r1) {
        this();
    }

    public void removeDownStreamSurface(KryptonApp r5, String r6, long r7) {
        long r0 = r5.newNativeWeakPtr();
        if (r0 != 0) goto L6;
        KryptonLLog.e(TAG, "canvas app weak ptr is nullptr.");
        return;
    L6:
        nativeRemoveSurface(r0, r6, r7);
    }

    public long addDownStreamSurface(KryptonApp r10, String r11, Surface r12, int r13, int r14, SurfaceScaleMode r15, RectF r16) {
        return addDownStreamSurface(r10, r11, r12, r13, r14, r15, r16, 0);
    }

    public long addDownStreamSurface(KryptonApp r13, String r14, Surface r15, int r16, int r17, SurfaceScaleMode r18, RectF r19, int r20) {
        long r2 = r13.newNativeWeakPtr();
        if (r2 != 0) goto L7;
        KryptonLLog.e(TAG, "canvas app weak ptr is nullptr.");
        return 0;
    L7:
        if (r18 != SurfaceScaleMode.SCALE_TO_FILL_WITH_SOURCE_CROP) goto L14;
        if (r19 == null) goto L12;
        return nativeAddSurface(r2, r14, r15, r16, r17, r18.value, r19.left, (1.0f - r19.top) - r19.height(), r19.width(), r19.height(), r20);
    L12:
        throw new IllegalArgumentException("sourceRect must be passed if use SCALE_TO_FILL_WITH_SOURCE_CROP");
    L14:
        return nativeAddSurface(r2, r14, r15, r16, r17, r18.value, 0.0f, 0.0f, 0.0f, 0.0f, r20);
    }
}
