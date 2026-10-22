package com.lynx.devtool.tracing;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.view.View;
import com.lynx.devtool.framecapture.FrameCapturer;
import com.lynx.devtoolwrapper.ScreenshotBitmapHandler;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.utils.BitmapUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class FrameViewTrace extends FrameCapturer {
    private long mNativeFrameViewTrace;

    public static class FrameViewTraceLoader {
        private static final FrameViewTrace INSTANCE = null;

        private FrameViewTraceLoader() {
        }

        static {
            INSTANCE = new FrameViewTrace();
        }

        public static /* synthetic */ FrameViewTrace access$000() {
            return INSTANCE;
        }
    }

    private native long nativeCreateFrameViewTrace();

    @Override // com.lynx.devtool.framecapture.FrameCapturer
    public boolean isEnabled() {
        return TraceEvent.categoryEnabled(2);
    }

    public FrameViewTrace() {
        this.mNativeFrameViewTrace = 0;
        this.mNativeFrameViewTrace = nativeCreateFrameViewTrace();
    }

    public static FrameViewTrace getInstance() {
        return FrameViewTraceLoader.access$000();
    }

    public long getNativeFrameViewTrace() {
        return this.mNativeFrameViewTrace;
    }

    @Override // com.lynx.devtool.framecapture.FrameCapturer
    public void startFrameViewTrace() {
        super.startFrameViewTrace();
    }

    @Override // com.lynx.devtool.framecapture.FrameCapturer
    public void stopFrameViewTrace() {
        super.stopFrameViewTrace();
    }

    private String takeScreenshot(View r10) {
        r10.setDrawingCacheEnabled(true);     // Catch: Throwable -> L10
        Bitmap r2 = Bitmap.createBitmap(r10.getDrawingCache());     // Catch: Throwable -> L10
        r10.setDrawingCacheEnabled(false);     // Catch: Throwable -> L10
        if (r2 == null) goto L15;
        int r5 = r2.getWidth();     // Catch: Throwable -> L10
        int r6 = r2.getHeight();     // Catch: Throwable -> L10
        float r11 = r6 * r5;     // Catch: Throwable -> L10
        long r3 = this.mMaxScreenshotAreaSize;     // Catch: Throwable -> L10
        if (r11 <= r3) goto L8;
        float r12 = (float) Math.sqrt(r3 / r11);     // Catch: Throwable -> L10
        Matrix r7 = new Matrix();     // Catch: Throwable -> L10
        r7.setScale(r12, r12);     // Catch: Throwable -> L10
        r2 = Bitmap.createBitmap(r2, 0, 0, r5, r6, r7, false);     // Catch: Throwable -> L10
    L8:
        return BitmapUtils.bitmapToBase64WithQuality(r2, this.mScreenshotQuality);
    L15:
        return null;
    L10:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    @Override // com.lynx.devtool.framecapture.FrameCapturer
    public void onNewScreenshotBitmapData(String r2) {
        if (isEnabled() == false) goto L6;
        FrameTraceService.getInstance().screenshot(r2);
        return;
    }

    @Override // com.lynx.devtool.framecapture.FrameCapturer
    public void screenshot(View r1, ScreenshotBitmapHandler r2) {
        String r3 = takeScreenshot(r1);
        onScreenshotActionEnd();
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.equals(this.mScreenshotBitmapDataCache) == true) goto L10;
        this.mScreenshotBitmapDataCache = r3;
        onNewScreenshotBitmapData(r3);
        return;
    }
}
