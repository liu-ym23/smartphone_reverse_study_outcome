package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ReversableAnimatedValueInterpolator implements TimeInterpolator {
    private final TimeInterpolator sourceInterpolator;

    public ReversableAnimatedValueInterpolator(@NonNull TimeInterpolator r5) {
        this.sourceInterpolator = r5;
    }

    @NonNull
    public static TimeInterpolator of(boolean r5, @NonNull TimeInterpolator r10) {
        if (r5 == false) goto L5;
        return r10;
    L5:
        return new ReversableAnimatedValueInterpolator(r10);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float r5) {
        return 1.0f - this.sourceInterpolator.getInterpolation(r5);
    }
}
