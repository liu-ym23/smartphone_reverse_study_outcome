package com.google.android.material.progressindicator;

import android.content.ContentResolver;
import android.provider.Settings;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class AnimatorDurationScaleProvider {
    private static float defaultSystemAnimatorDurationScale = 1.0f;

    public AnimatorDurationScaleProvider() {
    }

    @VisibleForTesting
    public static void setDefaultSystemAnimatorDurationScale(float r5) {
        defaultSystemAnimatorDurationScale = r5;
    }

    public float getSystemAnimatorDurationScale(@NonNull ContentResolver r5) {
        return Settings.Global.getFloat(r5, "animator_duration_scale", 1.0f);
    }
}
