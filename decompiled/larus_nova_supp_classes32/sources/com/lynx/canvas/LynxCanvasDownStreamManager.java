package com.lynx.canvas;

import android.os.Looper;
import android.view.Surface;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.behavior.ui.krypton.LynxKryptonHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxCanvasDownStreamManager {
    private static final String TAG = "KryptonDownStreamMgr";

    /* JADX INFO: renamed from: com.lynx.canvas.LynxCanvasDownStreamManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Holder {
        private static final LynxCanvasDownStreamManager INSTANCE = null;

        private Holder() {
        }

        static {
            INSTANCE = new LynxCanvasDownStreamManager(null);
        }

        public static /* synthetic */ LynxCanvasDownStreamManager access$000() {
            return INSTANCE;
        }
    }

    private static native long nativeAddSurface(long r0, String r2, Surface r3, int r4, int r5, int r6);

    private static native void nativeRemoveSurface(long r0, String r2, long r3);

    private LynxCanvasDownStreamManager() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L6;
        return;
    L6:
        throw new IllegalStateException("CanvasDownStreamSurfaceManager should be used on main thread only.");
    }

    public static LynxCanvasDownStreamManager getInstance() {
        return Holder.access$000();
    }

    public /* synthetic */ LynxCanvasDownStreamManager(AnonymousClass1 r1) {
        this();
    }

    private long newNativeCanvasAppWeakPtr(LynxView r3) {
        LynxKryptonHelper r4 = LynxKryptonUtils.getLynxKryptonHelper(r3);
        if (r4 != null) goto L7;
        KryptonLLog.e(TAG, "LynxView may be not inited / destroyed or current card do not enable canvas.");
        return 0;
    L7:
        return r4.getCanvasManager().newNativeCanvasAppWeakPtr();
    }

    public void RemoveDownStreamSurface(LynxView r5, String r6, long r7) {
        long r0 = newNativeCanvasAppWeakPtr(r5);
        if (r0 != 0) goto L6;
        KryptonLLog.e(TAG, "canvas app weak ptr is nullptr.");
        return;
    L6:
        nativeRemoveSurface(r0, r6, r7);
    }

    public long AddDownStreamSurface(LynxView r8, String r9, Surface r10, int r11, int r12) {
        return addDownStreamSurface(r8, r9, r10, r11, r12, 0);
    }

    public long addDownStreamSurface(LynxView r8, String r9, Surface r10, int r11, int r12, int r13) {
        long r0 = newNativeCanvasAppWeakPtr(r8);
        if (r0 != 0) goto L7;
        KryptonLLog.e(TAG, "canvas app weak ptr is nullptr.");
        return 0;
    L7:
        return nativeAddSurface(r0, r9, r10, r11, r12, r13);
    }
}
