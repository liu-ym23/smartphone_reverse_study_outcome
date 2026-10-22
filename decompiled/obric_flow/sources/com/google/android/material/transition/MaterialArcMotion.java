package com.google.android.material.transition;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.transition.PathMotion;

/* JADX INFO: loaded from: classes2.dex */
public final class MaterialArcMotion extends PathMotion {
    public MaterialArcMotion() {
    }

    private static PointF getControlPoint(float r5, float r10, float r11, float r12) {
        if (r10 <= r12) goto L7;
        return new PointF(r11, r10);
    L7:
        return new PointF(r5, r12);
    }

    @Override // androidx.transition.PathMotion
    @NonNull
    public Path getPath(float r5, float r10, float r11, float r12) {
        Path r13 = new Path();
        r13.moveTo(r5, r10);
        PointF r14 = getControlPoint(r5, r10, r11, r12);
        r13.quadTo(r14.x, r14.y, r11, r12);
        return r13;
    }
}
