package com.google.android.material.motion;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.Log;
import android.view.View;
import androidx.activity.BackEventCompat;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class MaterialBackAnimationHelper<V extends View> {
    private static final int CANCEL_DURATION_DEFAULT = 100;
    private static final int HIDE_DURATION_MAX_DEFAULT = 300;
    private static final int HIDE_DURATION_MIN_DEFAULT = 150;
    private static final String TAG = "MaterialBackHelper";

    @Nullable
    private BackEventCompat backEvent;
    protected final int cancelDuration;
    protected final int hideDurationMax;
    protected final int hideDurationMin;

    @NonNull
    private final TimeInterpolator progressInterpolator;

    @NonNull
    protected final V view;

    public MaterialBackAnimationHelper(@NonNull V r5) {
        this.view = r5;
        Context r10 = r5.getContext();
        this.progressInterpolator = MotionUtils.resolveThemeInterpolator(r10, R.attr.motionEasingStandardDecelerateInterpolator, PathInterpolatorCompat.create(0.0f, 0.0f, 0.0f, 1.0f));
        this.hideDurationMax = MotionUtils.resolveThemeDuration(r10, R.attr.motionDurationMedium2, 300);
        this.hideDurationMin = MotionUtils.resolveThemeDuration(r10, R.attr.motionDurationShort3, 150);
        this.cancelDuration = MotionUtils.resolveThemeDuration(r10, R.attr.motionDurationShort2, 100);
    }

    public float interpolateProgress(float r5) {
        return this.progressInterpolator.getInterpolation(r5);
    }

    @Nullable
    public BackEventCompat onCancelBackProgress() {
        if (this.backEvent != null) goto L5;
        Log.w(TAG, "Must call startBackProgress() and updateBackProgress() before cancelBackProgress()");
    L5:
        BackEventCompat r5 = this.backEvent;
        this.backEvent = null;
        return r5;
    }

    @Nullable
    public BackEventCompat onHandleBackInvoked() {
        BackEventCompat r5 = this.backEvent;
        this.backEvent = null;
        return r5;
    }

    public void onStartBackProgress(@NonNull BackEventCompat r5) {
        this.backEvent = r5;
    }

    @Nullable
    public BackEventCompat onUpdateBackProgress(@NonNull BackEventCompat r5) {
        if (this.backEvent != null) goto L5;
        Log.w(TAG, "Must call startBackProgress() before updateBackProgress()");
    L5:
        BackEventCompat r10 = this.backEvent;
        this.backEvent = r5;
        return r10;
    }
}
