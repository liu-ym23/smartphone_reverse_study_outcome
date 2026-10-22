package com.google.android.material.carousel;

import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.color.utilities.Contrast;

/* JADX INFO: loaded from: classes2.dex */
interface Maskable {
    @NonNull
    RectF getMaskRectF();

    @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN)
    @Deprecated
    float getMaskXPercentage();

    void setMaskRectF(@NonNull RectF r5);

    @Deprecated
    void setMaskXPercentage(@FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r5);

    void setOnMaskChangedListener(@Nullable OnMaskChangedListener r5);
}
