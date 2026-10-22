package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ClampedCornerSize implements CornerSize {
    private final float target;

    public ClampedCornerSize(float r5) {
        this.target = r5;
    }

    @NonNull
    public static ClampedCornerSize createFromCornerSize(@NonNull AbsoluteCornerSize r5) {
        return new ClampedCornerSize(r5.getCornerSize());
    }

    private static float getMaxCornerSize(@NonNull RectF r5) {
        return Math.min(r5.width() / 2.0f, r5.height() / 2.0f);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ClampedCornerSize) == true) goto L9;
        return false;
    L9:
        if (this.target != ((ClampedCornerSize) r5).target) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // com.google.android.material.shape.CornerSize
    public float getCornerSize(@NonNull RectF r5) {
        return Math.min(this.target, getMaxCornerSize(r5));
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.target)});
    }
}
