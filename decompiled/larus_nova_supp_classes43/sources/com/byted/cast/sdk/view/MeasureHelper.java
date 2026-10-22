package com.byted.cast.sdk.view;

import android.view.View;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class MeasureHelper {
    private int mCurrentAspectRatio;
    private int mMeasuredHeight;
    private int mMeasuredWidth;
    private int mVideoHeight;
    private int mVideoRotationDegree;
    private int mVideoSarDen;
    private int mVideoSarNum;
    private int mVideoWidth;
    private WeakReference<View> mWeakView;

    public static String getAspectRatioText(int r1) {
        if (r1 != 0) goto L4;
        return "Aspect / Fit parent";
    L4:
        if (r1 != 1) goto L6;
        return "Aspect / Fill parent";
    L6:
        if (r1 != 2) goto L8;
        return "Aspect / Wrap content";
    L8:
        if (r1 != 3) goto L10;
        return "Free / Fill parent";
    L10:
        if (r1 != 4) goto L12;
        return "16:9 / Fit parent";
    L12:
        if (r1 == 5) goto L14;
        return "N/A";
    L14:
        return "4:3 / Fit parent";
    }

    public View getView() {
        WeakReference<View> r0 = this.mWeakView;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get();
    }

    public int getMeasuredHeight() {
        return this.mMeasuredHeight;
    }

    public int getMeasuredWidth() {
        return this.mMeasuredWidth;
    }

    public MeasureHelper(View r10) {
        this.mCurrentAspectRatio = 0;
        this.mWeakView = new WeakReference(r10);
    }

    public void setAspectRatio(int r1) {
        this.mCurrentAspectRatio = r1;
    }

    public void setVideoRotation(int r1) {
        this.mVideoRotationDegree = r1;
    }

    public void doMeasure(int r11, int r12) {
        int r0 = this.mVideoRotationDegree;
        if (r0 == 90) goto L5;
        if (r0 == 270) goto L5;
    L6:
        int r1 = View.getDefaultSize(this.mVideoWidth, r11);
        int r10 = View.getDefaultSize(this.mVideoHeight, r12);
        if (this.mCurrentAspectRatio != 3) goto L10;
    L83:
        this.mMeasuredWidth = r11;
        this.mMeasuredHeight = r12;
        return;
    L10:
        if (this.mVideoWidth > 0) goto L12;
    L82:
        r11 = r1;
        r12 = r10;
        goto L83
    L12:
        if (this.mVideoHeight <= 0) goto L82;
        int r13 = View.MeasureSpec.getMode(r11);
        r11 = View.MeasureSpec.getSize(r11);
        int r14 = View.MeasureSpec.getMode(r12);
        r12 = View.MeasureSpec.getSize(r12);
        if (r13 != Integer.MIN_VALUE) goto L53;
        if (r14 != Integer.MIN_VALUE) goto L53;
        float r15 = r11;
        float r16 = r12;
        float r17 = r15 / r16;
        int r18 = this.mCurrentAspectRatio;
        if (r18 == 4) goto L30;
        if (r18 == 5) goto L24;
        float r19 = this.mVideoWidth / this.mVideoHeight;
        int r20 = this.mVideoSarNum;
        if (r20 <= 0) goto L37;
        int r21 = this.mVideoSarDen;
        if (r21 <= 0) goto L37;
        r19 = (r19 * r20) / r21;
    L37:
        if (r19 <= r17) goto L39;
        boolean r22 = true;
    L40:
        if (r18 == 0) goto L49;
        if (r18 == 1) goto L47;
        if (r18 == 4) goto L49;
        if (r18 == 5) goto L49;
        if (r22 == false) goto L46;
        r11 = Math.min(this.mVideoWidth, r11);
        r12 = (int) (r11 / r19);
        goto L83
    L46:
        int r110 = Math.min(this.mVideoHeight, r12);
        r12 = r110;
        r11 = (int) (r110 * r19);
        goto L83
    L47:
        if (r22 == true) goto L51;
    L50:
        r12 = (int) (r15 / r19);
    L51:
        r11 = (int) (r16 * r19);
    L49:
        if (r22 == false) goto L51;
    L39:
        r22 = false;
        goto L40
    L24:
        int r23 = this.mVideoRotationDegree;
        if (r23 == 90) goto L29;
        if (r23 == 270) goto L29;
        r19 = 1.3333334f;
    L29:
        r19 = 0.75f;
        goto L37
    L30:
        int r24 = this.mVideoRotationDegree;
        if (r24 == 90) goto L35;
        if (r24 == 270) goto L35;
        r19 = 1.7777778f;
    L35:
        r19 = 0.5625f;
    L53:
        if (r13 != 1073741824) goto L61;
        if (r14 != 1073741824) goto L61;
        int r25 = this.mVideoWidth;
        int r26 = r25 * r12;
        int r27 = this.mVideoHeight;
        if (r26 >= (r11 * r27)) goto L59;
        r11 = (r25 * r12) / r27;
        goto L83
    L59:
        if ((r25 * r12) <= (r11 * r27)) goto L83;
        r12 = (r27 * r11) / r25;
    L61:
        if (r13 != 1073741824) goto L67;
        int r28 = (this.mVideoHeight * r11) / this.mVideoWidth;
        if (r14 != Integer.MIN_VALUE) goto L66;
        if (r28 > r12) goto L83;
    L66:
        r12 = r28;
        goto L83
    L67:
        if (r14 != 1073741824) goto L73;
        int r29 = (this.mVideoWidth * r12) / this.mVideoHeight;
        if (r13 != Integer.MIN_VALUE) goto L72;
        if (r29 > r11) goto L83;
    L72:
        r11 = r29;
        goto L83
    L73:
        int r30 = this.mVideoWidth;
        int r31 = this.mVideoHeight;
        if (r14 != Integer.MIN_VALUE) goto L77;
        if (r31 <= r12) goto L77;
        int r32 = (r12 * r30) / r31;
    L78:
        if (r13 != Integer.MIN_VALUE) goto L81;
        if (r32 <= r11) goto L81;
        r12 = (r31 * r11) / r30;
    L81:
        r11 = r32;
    L77:
        r32 = r30;
        r12 = r31;
    L5:
        r12 = r11;
        r11 = r12;
        goto L6
    }

    public void setVideoSampleAspectRatio(int r1, int r10) {
        this.mVideoSarNum = r1;
        this.mVideoSarDen = r10;
    }

    public void setVideoSize(int r1, int r10) {
        this.mVideoWidth = r1;
        this.mVideoHeight = r10;
    }
}
