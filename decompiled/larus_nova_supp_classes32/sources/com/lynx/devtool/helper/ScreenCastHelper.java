package com.lynx.devtool.helper;

import com.lynx.devtool.DevToolPlatformAndroidDelegate;
import com.lynx.devtoolwrapper.IDevToolDelegate;
import com.lynx.tasm.LynxView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class ScreenCastHelper {
    private WeakReference<LynxView> mLynxView;
    private volatile boolean mPaused;
    private WeakReference<DevToolPlatformAndroidDelegate> mPlatformDelegate;
    private volatile boolean mScreencastEnabled;

    public void stopCasting() {
        this.mScreencastEnabled = false;
        LynxView r1 = this.mLynxView.get();
        if (r1 == null) goto L8;
        ScreenCapturer.getInstance().stopCapture(r1);
        DevToolPlatformAndroidDelegate r2 = this.mPlatformDelegate.get();
        if (r2 == null) goto L9;
        r2.dispatchScreencastVisibilityChanged(false);
        return;
    L9:
        return;
    }

    public void continueCasting() {
        if (this.mScreencastEnabled == true) goto L5;
        return;
    L5:
        if (this.mPaused == false) goto L12;
        ScreenCapturer.getInstance().clearScreenshotBitmapDataCache();
        this.mPaused = false;
        DevToolPlatformAndroidDelegate r0 = this.mPlatformDelegate.get();
        if (r0 == null) goto L9;
        r0.dispatchScreencastVisibilityChanged(true);
    L9:
        ScreenCapturer.getInstance().triggerNextCapture();
        return;
    }

    public void pauseCasting() {
        if (this.mScreencastEnabled == true) goto L5;
        return;
    L5:
        if (this.mPaused == true) goto L11;
        this.mPaused = true;
        DevToolPlatformAndroidDelegate r0 = this.mPlatformDelegate.get();
        if (r0 == null) goto L12;
        r0.dispatchScreencastVisibilityChanged(false);
        return;
    L12:
        return;
    }

    public void onAckReceived() {
        ScreenCapturer.getInstance().onAckReceived();
    }

    public static /* synthetic */ WeakReference access$000(ScreenCastHelper r0) {
        return r0.mPlatformDelegate;
    }

    public void attach(LynxView r2) {
        this.mLynxView = new WeakReference(r2);
        ScreenCapturer.getInstance().attachView(r2);
    }

    public void sendCardPreview(final IDevToolDelegate r5) {
        LynxView r0 = this.mLynxView.get();
        if (r0 == null) goto L7;
        if (r5 == null) goto L8;
        r0.postDelayed(new AnonymousClass2(this, r5), 1500);
        return;
    L8:
        return;
    }

    public ScreenCastHelper(DevToolPlatformAndroidDelegate r2, LynxView r3) {
        this.mPlatformDelegate = new WeakReference(r2);
        this.mLynxView = new WeakReference(r3);
        this.mPaused = false;
        this.mScreencastEnabled = false;
    }

    public void startCasting(int r8, int r9, int r10, String r11, IDevToolDelegate r12) {
        this.mScreencastEnabled = true;
        DevToolPlatformAndroidDelegate r1 = this.mPlatformDelegate.get();
        if (r1 == null) goto L5;
        r1.dispatchScreencastVisibilityChanged(true);
    L5:
        ScreenCapturer.getInstance().attachView(this.mLynxView.get());
        ScreenCapturer.getInstance().setDevToolDelegate(r12);
        ScreenCapturer.getInstance().startCapture(r9, r10, r8, r11, new AnonymousClass1(this));
    }
}
