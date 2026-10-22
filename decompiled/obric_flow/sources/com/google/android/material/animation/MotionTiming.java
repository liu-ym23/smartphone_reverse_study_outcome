package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class MotionTiming {
    private long delay;
    private long duration;

    @Nullable
    private TimeInterpolator interpolator;
    private int repeatCount;
    private int repeatMode;

    public MotionTiming(long r5, long r10) {
        this.interpolator = null;
        this.repeatCount = 0;
        this.repeatMode = 1;
        this.delay = r5;
        this.duration = r10;
    }

    @NonNull
    public static MotionTiming createFromAnimator(@NonNull ValueAnimator r10) {
        MotionTiming r11 = new MotionTiming(r10.getStartDelay(), r10.getDuration(), getInterpolatorCompat(r10));
        r11.repeatCount = r10.getRepeatCount();
        r11.repeatMode = r10.getRepeatMode();
        return r11;
    }

    private static TimeInterpolator getInterpolatorCompat(@NonNull ValueAnimator r5) {
        TimeInterpolator r10 = r5.getInterpolator();
        if ((r10 instanceof AccelerateDecelerateInterpolator) == true) goto L15;
        if (r10 == null) goto L15;
        if ((r10 instanceof AccelerateInterpolator) == false) goto L11;
        return AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
    L11:
        if ((r10 instanceof DecelerateInterpolator) == true) goto L13;
        return r10;
    L13:
        return AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR;
    L15:
        return AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
    }

    public void apply(@NonNull Animator r5) {
        r5.setStartDelay(getDelay());
        r5.setDuration(getDuration());
        r5.setInterpolator(getInterpolator());
        if ((r5 instanceof ValueAnimator) == false) goto L6;
        ValueAnimator r10 = (ValueAnimator) r5;
        r10.setRepeatCount(getRepeatCount());
        r10.setRepeatMode(getRepeatMode());
        return;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof MotionTiming) == true) goto L8;
        return false;
    L8:
        MotionTiming r11 = (MotionTiming) r10;
        if (getDelay() == r11.getDelay()) goto L12;
        return false;
    L12:
        if (getDuration() == r11.getDuration()) goto L15;
        return false;
    L15:
        if (getRepeatCount() == r11.getRepeatCount()) goto L18;
        return false;
    L18:
        if (getRepeatMode() == r11.getRepeatMode()) goto L21;
        return false;
    L21:
        return getInterpolator().getClass().equals(r11.getInterpolator().getClass());
    }

    public long getDelay() {
        return this.delay;
    }

    public long getDuration() {
        return this.duration;
    }

    @Nullable
    public TimeInterpolator getInterpolator() {
        TimeInterpolator r5 = this.interpolator;
        if (r5 == null) goto L6;
        return r5;
    L6:
        return AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
    }

    public int getRepeatCount() {
        return this.repeatCount;
    }

    public int getRepeatMode() {
        return this.repeatMode;
    }

    public int hashCode() {
        int r5 = ((((int) (getDelay() ^ (getDelay() >>> 32))) * 31) + ((int) (getDuration() ^ (getDuration() >>> 32)))) * 31;
        int r10 = (getInterpolator().getClass().hashCode() + r5) * 31;
        int r11 = (getRepeatCount() + r10) * 31;
        return getRepeatMode() + r11;
    }

    @NonNull
    public String toString() {
        return "\n" + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + getDelay() + " duration: " + getDuration() + " interpolator: " + getInterpolator().getClass() + " repeatCount: " + getRepeatCount() + " repeatMode: " + getRepeatMode() + "}\n";
    }

    public MotionTiming(long r5, long r10, @NonNull TimeInterpolator r11) {
        this.repeatCount = 0;
        this.repeatMode = 1;
        this.delay = r5;
        this.duration = r10;
        this.interpolator = r11;
    }
}
