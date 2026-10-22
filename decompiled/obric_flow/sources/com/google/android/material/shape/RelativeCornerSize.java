package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.color.utilities.Contrast;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class RelativeCornerSize implements CornerSize {
    private final float percent;

    public RelativeCornerSize(@FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r5) {
        this.percent = r5;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static RelativeCornerSize createFromCornerSize(@NonNull RectF r5, @NonNull CornerSize r10) {
        if ((r10 instanceof RelativeCornerSize) == false) goto L6;
        return (RelativeCornerSize) r10;
    L6:
        return new RelativeCornerSize(r10.getCornerSize(r5) / getMaxCornerSize(r5));
    }

    private static float getMaxCornerSize(@NonNull RectF r5) {
        return Math.min(r5.width(), r5.height());
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof RelativeCornerSize) == true) goto L9;
        return false;
    L9:
        if (this.percent != ((RelativeCornerSize) r5).percent) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // com.google.android.material.shape.CornerSize
    public float getCornerSize(@NonNull RectF r5) {
        return this.percent * getMaxCornerSize(r5);
    }

    @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN)
    public float getRelativePercent() {
        return this.percent;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.percent)});
    }
}
