package com.ss.android.lark.chameleon.widget.emptyview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.ss.android.lark.chameleon.idependency.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class BearLottieView extends LottieAnimationView {
    private static final String TAG = "BearLottieView";
    private boolean mHasInit;
    private boolean needPlay;

    public void playAnimation() {
        Log.i(TAG, "xxx:playAnimation: ");
        if (isVisible() == false) goto L5;
        forcePlayAnimation();
        return;
    L5:
        this.needPlay = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void forcePlayAnimation() {
        super.playAnimation();
        if (isAnimating() == false) goto L5;
        return;
    L5:
        if ((getDrawable() instanceof LottieDrawable) == false) goto L9;
        getDrawable().k();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isVisible() {
        if (getVisibility() == 0) goto L5;
    L9:
        return false;
    L5:
        if (getHeight() <= 0) goto L9;
        if (getWidth() <= 0) goto L9;
        return true;
    }

    public void cancelAnimation() {
        super.cancelAnimation();
        this.needPlay = false;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isAnimating() == false) goto L6;
        Log.i(TAG, "xxx: onAttachedToWindow: cancel animator");
        super.cancelAnimation();
        this.needPlay = true;
        return;
    }

    public BearLottieView(Context r2) {
        super(r2);
        init(null, null, 0);
    }

    private void checkAnimation(int r3) {
        if (this.mHasInit == true) goto L6;
        return;
    L6:
        if (r3 != 0) goto L13;
        if (isVisible() == false) goto L13;
        if (this.needPlay == false) goto L13;
        Log.i(TAG, "xxx: checkAnimation: play " + hashCode());
        super.playAnimation();
        return;
    L13:
        if (isAnimating() == false) goto L17;
        this.needPlay = true;
        Log.d(TAG, "xxx: checkAnimation: cancel " + hashCode());
        super.cancelAnimation();
        return;
    }

    public void invalidateDrawable(Drawable r2) {
        if (this.mHasInit == true) goto L7;
        super.invalidateDrawable(r2);
        return;
    L7:
        if (isVisible() == true) goto L13;
        Log.i(TAG, "invalidateDrawable not visible, return");
        if (isAnimating() == false) goto L11;
        this.needPlay = true;
    L11:
        super.cancelAnimation();
        return;
    L13:
        super.invalidateDrawable(r2);
    }

    public BearLottieView(Context r2, AttributeSet r3) {
        super(r2, r3);
        init(r2, r3, 0);
    }

    public void onVisibilityChanged(View r2, int r3) {
        Log.i(TAG, "xxx: onVisibilityChanged: " + r3);
        checkAnimation(r3);
    }

    public BearLottieView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        init(r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void init(Context r9, AttributeSet r10, int r11) {
        if (r10 == null) goto L21;
        if (r9 == null) goto L21;
        TypedArray r12 = null;
        r12 = getContext().obtainStyledAttributes(r10, new int[]{2130972609, 2130972610, 2130972611, 2130972626, 2130972627, 2130972628, 2130972629, 2130972630, 2130972631, 2130972632, 2130972633, 2130972634, 2130972635, 2130972636}, r11, 0);     // Catch: Throwable -> L11 Exception -> L13
        if (r12.getBoolean(0, false) == false) goto L9;
        this.needPlay = true;     // Catch: Throwable -> L11 Exception -> L13
    L9:
        Log.i(TAG, "init, needPlay = " + this.needPlay);     // Catch: Throwable -> L11 Exception -> L13
    L16:
        r12.recycle();
        goto L21
    L13:
        e = move-exception;
        Log.e(TAG, e.toString());     // Catch: Throwable -> L11
        if (r12 == null) goto L21;
    L11:
        th = move-exception;
        if (r12 == null) goto L19;
        r12.recycle();
    L19:
        throw th;
    L21:
        if (isAnimating() == false) goto L23;
        Log.i(TAG, "xxx:init: cancel animator");
        super.cancelAnimation();
        this.needPlay = true;
    L23:
        this.mHasInit = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        Log.i(TAG, "xxx: onSizeChanged: ");
        checkAnimation(getVisibility());
    }
}
