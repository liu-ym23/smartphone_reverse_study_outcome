package com.ss.ttvideoengine.utils;

import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class DisplayMode {
    private static final String TAG = "DisplayMode";
    private final Runnable applyDisplayMode;
    private int mDisplayMode;
    private View mDisplayView;
    private boolean mEnable;
    private int mVideoHeight;
    private int mVideoWidth;

    public static /* synthetic */ void a(DisplayMode r0) {
        r0.applyDisplayMode();
    }

    private void applyDisplayMode() {
        if (this.mEnable == true) goto L5;
        return;
    L5:
        View r0 = this.mDisplayView;
        if (r0 != null) goto L8;
        return;
    L8:
        Object r1 = r0.getParent();
        if ((r1 instanceof View) == true) goto L12;
        TTVideoEngineLog.d(TAG, "containerView error " + r1);
        return;
    L12:
        View r2 = (View) r1;
        int r3 = r2.getWidth();
        int r4 = r2.getHeight();
        int r5 = this.mDisplayMode;
        int r6 = this.mVideoWidth;
        int r7 = this.mVideoHeight;
        if (r6 <= 0) goto L49;
        if (r7 <= 0) goto L50;
        if (r3 <= 0) goto L51;
        if (r4 <= 0) goto L53;
        float r8 = r6 / r7;
        float r9 = r3;
        float r10 = r4;
        float r11 = r9 / r10;
        if (r5 == 0) goto L36;
        if (r5 != 1) goto L23;
    L38:
        FrameLayout.LayoutParams r12 = (FrameLayout.LayoutParams) r0.getLayoutParams();
        if (r12 != null) goto L42;
        return;
    L42:
        if (r12.height == r4) goto L44;
    L47:
        r12.gravity = 17;
        r12.width = r3;
        r12.height = r4;
        r0.setLayoutParams(r12);
        TTVideoEngineLog.i(TAG, "applyDisplayMode width:" + r12.width + ", height:" + r12.height);
        return;
    L44:
        if (r12.width != r3) goto L47;
        if (r12.gravity != 17) goto L47;
        return;
    L23:
        if (r5 == 2) goto L33;
        if (r5 != 3) goto L27;
    L31:
        r4 = (int) (r9 / r8);
        goto L38
    L27:
        if (r5 != 4) goto L30;
    L28:
        r3 = (int) (r10 * r8);
        goto L38
    L30:
        throw new IllegalArgumentException("unknown displayMode = " + r5);
    L33:
        if (r8 < r11) goto L31;
    L36:
        if (r8 < r11) goto L28;
    L53:
        return;
    L51:
        return;
    L50:
        return;
    }

    public void apply() {
        View r0 = this.mDisplayView;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mEnable == false) goto L15;
        r0.removeCallbacks(this.applyDisplayMode);     // Catch: NullPointerException -> L9
        r0.postOnAnimation(this.applyDisplayMode);     // Catch: NullPointerException -> L9
        return;
    L9:
        e = move-exception;
        TTVideoEngineLog.d(e);
        return;
    }

    public DisplayMode() {
        this.mDisplayMode = 0;
        this.mEnable = true;
        this.applyDisplayMode = new a(this);
    }

    public void setDisplayMode(int r1) {
        this.mDisplayMode = r1;
        apply();
    }

    public void setDisplayView(View r3) {
        TTVideoEngineLog.d(TAG, "setDisplayView " + r3);
        this.mDisplayView = r3;
        if (r3 != null) goto L5;
        return;
    L5:
        apply();
    }

    public void setEnable(boolean r1) {
        this.mEnable = r1;
    }

    public void setVideoSize(int r3, int r4) {
        TTVideoEngineLog.d(TAG, "setVideoSize videoWidth:" + r3 + ", videoHeight:" + r4);
        this.mVideoWidth = r3;
        this.mVideoHeight = r4;
        apply();
    }
}
