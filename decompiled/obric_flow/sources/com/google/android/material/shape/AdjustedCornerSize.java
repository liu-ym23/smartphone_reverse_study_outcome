package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class AdjustedCornerSize implements CornerSize {
    private final float adjustment;
    private final CornerSize other;

    public AdjustedCornerSize(float r5, @NonNull CornerSize r10) {
    L4:
        if ((r10 instanceof AdjustedCornerSize) == false) goto L6;
        r10 = ((AdjustedCornerSize) r10).other;
        r5 = r5 + ((AdjustedCornerSize) r10).adjustment;
        goto L4
    L6:
        this.other = r10;
        this.adjustment = r5;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AdjustedCornerSize) == true) goto L8;
        return false;
    L8:
        AdjustedCornerSize r10 = (AdjustedCornerSize) r5;
        if (this.other.equals(r10.other) == false) goto L14;
        if (this.adjustment != r10.adjustment) goto L14;
        return true;
    L14:
        return false;
    }

    @Override // com.google.android.material.shape.CornerSize
    public float getCornerSize(@NonNull RectF r5) {
        return Math.max(0.0f, this.other.getCornerSize(r5) + this.adjustment);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.other, Float.valueOf(this.adjustment)});
    }
}
