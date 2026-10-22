package com.lynx.devtool.helper;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.DisplayMetrics;
import android.view.Choreographer;
import android.view.View;
import com.lynx.devtool.framecapture.FrameCapturer;
import com.lynx.devtoolwrapper.IDevToolDelegate;
import com.lynx.devtoolwrapper.ScreenshotBitmapHandler;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.utils.BitmapUtils;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class ScreenCapturer extends FrameCapturer {
    private static final int CARD_PREVIEW_MAX_HEIGHT = 800;
    private static final int CARD_PREVIEW_MAX_WIDTH = 400;
    private static final int CARD_PREVIEW_QUALITY = 100;
    public static final int SCREEN_SHOT_PREVIEW_DELAY_TIME = 1500;
    private static final String TAG = "ScreenCapturer";
    private static final ScreenCapturer mInstance = null;
    private final ExecutorService executorService;
    private final AtomicBoolean mAckReceived;
    private IDevToolDelegate mDevToolDelegate;
    protected AtomicBoolean mIsDirty;
    private boolean mIsEnabled;
    private Choreographer.FrameCallback mResetDirtyCallBack;
    private final ScreenMetadata mScreenMetadata;
    private final ScreenRequest mScreenRequest;
    private ScreenshotListener mScreenshotListener;
    private volatile long mScreenshotOnMainThreadTime;
    private long mScreenshotStartTime;

    public static class ScreenMetadata {
        public float mDeviceHeight;
        public float mDeviceWidth;
        public float mOffsetTop;
        public float mPageScaleFactor;
        public float mScrollOffsetX;
        public float mScrollOffsetY;
        public float mTimestamp;

        public ScreenMetadata() {
        }
    }

    public static class ScreenRequest {
        private int mMaxHeight;
        private int mMaxWidth;
        private int mQuality;
        private String mScreenshotMode;

        private ScreenRequest() {
        }

        public /* synthetic */ ScreenRequest(AnonymousClass1 r1) {
            this();
        }

        public static /* synthetic */ int access$200(ScreenRequest r0) {
            return r0.mMaxWidth;
        }

        public static /* synthetic */ int access$300(ScreenRequest r0) {
            return r0.mMaxHeight;
        }

        public static /* synthetic */ int access$400(ScreenRequest r0) {
            return r0.mQuality;
        }

        public static /* synthetic */ String access$500(ScreenRequest r0) {
            return r0.mScreenshotMode;
        }

        public static /* synthetic */ int access$202(ScreenRequest r0, int r1) {
            r0.mMaxWidth = r1;
            return r1;
        }

        public static /* synthetic */ int access$302(ScreenRequest r0, int r1) {
            r0.mMaxHeight = r1;
            return r1;
        }

        public static /* synthetic */ int access$402(ScreenRequest r0, int r1) {
            r0.mQuality = r1;
            return r1;
        }

        public static /* synthetic */ String access$502(ScreenRequest r0, String r1) {
            r0.mScreenshotMode = r1;
            return r1;
        }
    }

    public interface ScreenshotListener {
        void onNewScreenshotBitmapData(String r1, long r2);
    }

    static {
        mInstance = new ScreenCapturer();
    }

    public void onAckReceived() {
        this.mAckReceived.set(true);
        triggerNextCapture();
    }

    @Override // com.lynx.devtool.framecapture.FrameCapturer
    public void onScreenshotActionEnd() {
        if (this.mScreenshotStartTime != 0) goto L6;
        LLog.e(TAG, "onScreenshotActionEnd: lastTime == 0");
        return;
    L6:
        this.mScreenshotOnMainThreadTime = System.nanoTime() - this.mScreenshotStartTime;
    }

    @Override // com.lynx.devtool.framecapture.FrameCapturer
    public void onScreenshotActionStart() {
        this.mIsDirty.set(false);
        this.mScreenshotStartTime = System.nanoTime();
        this.mScreenshotOnMainThreadTime = 0;
    }

    public void triggerNextCapture() {
        if (this.mIsEnabled == true) goto L6;
        return;
    L6:
        if (this.mScreenshotBitmapDataCache != null) goto L8;
    L11:
        screenshot();
        return;
    L8:
        if (this.mAckReceived.get() == true) goto L10;
        return;
    L10:
        if (this.mIsDirty.get() == true) goto L11;
    }

    private ScreenCapturer() {
        this.mDevToolDelegate = null;
        this.mScreenshotOnMainThreadTime = 0;
        this.mScreenshotStartTime = 0;
        this.executorService = PThreadExecutorsUtils.newCachedThreadPool(new AnonymousClass1(this));
        this.mScreenRequest = new ScreenRequest(null);
        this.mScreenMetadata = new ScreenMetadata();
        this.mIsEnabled = false;
        this.mScreenshotListener = null;
        this.mAckReceived = new AtomicBoolean(false);
        this.mIsDirty = new AtomicBoolean(false);
        this.mFrameChangeListener = new AnonymousClass2(this);
        this.mResetDirtyCallBack = new AnonymousClass3(this);
    }

    private void addResetDirtyStatusCallBack() {
        Choreographer.getInstance().postFrameCallback(this.mResetDirtyCallBack);
    }

    public static ScreenCapturer getInstance() {
        return mInstance;
    }

    public ScreenMetadata getScreenMetadata() {
        return this.mScreenMetadata;
    }

    @Override // com.lynx.devtool.framecapture.FrameCapturer
    public boolean isEnabled() {
        return this.mIsEnabled;
    }

    public static /* synthetic */ Choreographer.FrameCallback access$100(ScreenCapturer r0) {
        return r0.mResetDirtyCallBack;
    }

    public static /* synthetic */ String access$600(ScreenCapturer r0) {
        return r0.mScreenshotBitmapDataCache;
    }

    public static /* synthetic */ String access$800(ScreenCapturer r0) {
        return r0.mScreenshotBitmapDataCache;
    }

    @Override // com.lynx.devtool.framecapture.FrameCapturer
    public void onNewScreenshotBitmapData(String r6) {
        this.mAckReceived.set(false);
        if (this.mScreenshotListener != null) goto L5;
        return;
    L5:
        if (this.mScreenshotOnMainThreadTime != 0) goto L7;
        LLog.e(TAG, "onNewScreenshotBitmapData: screenshotMainTime == 0");
    L7:
        this.mScreenshotListener.onNewScreenshotBitmapData(r6, this.mScreenshotOnMainThreadTime);
    }

    public void onScreenshotBitmapReady(final Bitmap r3) {
        this.executorService.submit(new AnonymousClass4(this, r3));
    }

    public void setDevToolDelegate(IDevToolDelegate r1) {
        this.mDevToolDelegate = r1;
    }

    public void stopCapture(View r2) {
        if (r2 == this.mView.get()) goto L5;
        return;
    L5:
        stopFrameViewTrace();
        this.mIsEnabled = false;
        this.mView.clear();
    }

    public void submit(Runnable r2) {
        this.executorService.submit(r2);
    }

    public static /* synthetic */ String access$702(ScreenCapturer r0, String r1) {
        r0.mScreenshotBitmapDataCache = r1;
        return r1;
    }

    public String getScreenshotDataFromBitmap(Bitmap r3, boolean r4) {
        if (r4 == false) goto L4;
        int r0 = 100;
    L5:
        if (r4 == false) goto L7;
        int r1 = CARD_PREVIEW_MAX_WIDTH;
    L8:
        if (r4 == false) goto L10;
        int r5 = 800;
    L12:
        return BitmapUtils.bitmapToBase64WithQuality(scaleImage(r3, r1, r5), r0);
    L10:
        r5 = ScreenRequest.access$300(this.mScreenRequest);
        goto L12
    L7:
        r1 = ScreenRequest.access$200(this.mScreenRequest);
        goto L8
    L4:
        r0 = ScreenRequest.access$400(this.mScreenRequest);
        goto L5
    }

    @Override // com.lynx.devtool.framecapture.FrameCapturer
    public void screenshot(View r2, ScreenshotBitmapHandler r3) {
        IDevToolDelegate r4 = this.mDevToolDelegate;
        if (r4 == null) goto L5;
        r4.takeScreenshot(r3, ScreenRequest.access$500(this.mScreenRequest));
    L5:
        onScreenshotActionEnd();
    }

    private Bitmap scaleImage(Bitmap r8, int r9, int r10) {
        if (r8 != null) goto L5;
        LLog.e(TAG, "scaleImage: bitmap is null");
        return null;
    L5:
        int r3 = r8.getWidth();
        int r4 = r8.getHeight();
        float r11 = getScale(r3, r4, r9, r10);
        DisplayMetrics r12 = DisplayMetricsHolder.getScreenDisplayMetrics();
        ScreenMetadata r0 = this.mScreenMetadata;
        float r13 = r12.density;
        r0.mDeviceWidth = r3 / r13;
        r0.mDeviceHeight = r4 / r13;
        r0.mPageScaleFactor = 1.0f;
        Matrix r5 = new Matrix();     // Catch: Throwable -> L8
        r5.postScale(r11, r11);     // Catch: Throwable -> L8
        return Bitmap.createBitmap(r8, 0, 0, r3, r4, r5, true);
    L8:
        th = move-exception;
        th.printStackTrace();
        return r8;
    }

    private float getScale(int r1, int r2, int r3, int r4) {
        if (r3 == 0) goto L7;
        if (r4 == 0) goto L7;
        if (r1 > r3) goto L6;
        if (r2 <= r4) goto L7;
    L6:
        float r5 = r3 / r1;
        float r6 = r4 / r2;
    L13:
        return Math.min(r5, r6);
    L10:
        th = move-exception;
        th.printStackTrace();
        return 0.0f;
    L7:
        r5 = 1.0f;
        r6 = 1.0f;
        goto L13
    }

    public void startCapture(int r2, int r3, int r4, String r5, ScreenshotListener r6) {
        ScreenRequest.access$202(this.mScreenRequest, r2);
        ScreenRequest.access$302(this.mScreenRequest, r3);
        ScreenRequest.access$402(this.mScreenRequest, r4);
        ScreenRequest.access$502(this.mScreenRequest, r5);
        this.mScreenshotListener = r6;
        this.mIsEnabled = true;
        addResetDirtyStatusCallBack();
        startFrameViewTrace();
        triggerNextCapture();
    }
}
