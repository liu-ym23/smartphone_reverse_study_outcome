package com.lynx.canvas;

import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class FirstFrameAwareSurfaceTexture extends SurfaceTexture implements SurfaceTexture.OnFrameAvailableListener {
    private static final String TAG = "KryptonFirstFrameAwareSurfaceTexture";
    private FirstFrameAvailableListener mCustomFirstFrameAvailableListener;
    private boolean mFirstFrameHasPassed;
    private Handler mOnFrameAvailableHandler;

    public interface FirstFrameAvailableListener {
        void onFirstFrameAvailable();
    }

    private void setupFirstFrameAvailableListenerInternal() {
        super.setOnFrameAvailableListener(this, new Handler(Looper.getMainLooper()));
    }

    @Override // android.graphics.SurfaceTexture
    public void release() {
        KryptonLLog.i(TAG, "release with " + this);
        super.release();
    }

    public FirstFrameAwareSurfaceTexture(int r1) {
        super(r1);
        setupFirstFrameAvailableListenerInternal();
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture r4) {
        Handler r5 = this.mOnFrameAvailableHandler;
        if (r5 == null) goto L9;
        Message r6 = r5.obtainMessage(0);
        if (Build.VERSION.SDK_INT < 22) goto L7;
        r6.setAsynchronous(true);
    L7:
        this.mOnFrameAvailableHandler.sendMessage(r6);
    L9:
        if (this.mFirstFrameHasPassed == true) goto L14;
        this.mFirstFrameHasPassed = true;
        KryptonLLog.i(TAG, "trigger first frame callback with " + this.mCustomFirstFrameAvailableListener);
        FirstFrameAvailableListener r7 = this.mCustomFirstFrameAvailableListener;
        if (r7 == null) goto L15;
        r7.onFirstFrameAvailable();
        return;
    L15:
        return;
    }

    public void setFirstFrameListener(FirstFrameAvailableListener r2) {
        this.mCustomFirstFrameAvailableListener = r2;
        if (this.mFirstFrameHasPassed == false) goto L6;
        r2.onFirstFrameAvailable();
        return;
    }

    @Override // android.graphics.SurfaceTexture
    public void setOnFrameAvailableListener(SurfaceTexture.OnFrameAvailableListener r2) {
        setOnFrameAvailableListenerInternal(r2, null);
    }

    private void setOnFrameAvailableListenerInternal(final SurfaceTexture.OnFrameAvailableListener r3, Handler r4) {
        final Handler.Callback r0 = null;
        if (r3 == null) goto L8;
        if (r4 == null) goto L6;
        final Looper r5 = r4.getLooper();
    L7:
        this.mOnFrameAvailableHandler = new AnonymousClass1(this, r5, r0, r3);
        return;
    L6:
        r5 = Looper.getMainLooper();
        goto L7
    L8:
        this.mOnFrameAvailableHandler = null;
    }

    @Override // android.graphics.SurfaceTexture
    public void setOnFrameAvailableListener(SurfaceTexture.OnFrameAvailableListener r1, Handler r2) {
        setOnFrameAvailableListenerInternal(r1, r2);
    }
}
