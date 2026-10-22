package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public class EdgeTreatment {
    public EdgeTreatment() {
    }

    public boolean forceIntersection() {
        return false;
    }

    @Deprecated
    public void getEdgePath(float r5, float r10, @NonNull ShapePath r11) {
        getEdgePath(r5, r5 / 2.0f, r10, r11);
    }

    public void getEdgePath(float r5, float r10, float r11, @NonNull ShapePath r12) {
        r12.lineTo(r5, 0.0f);
    }
}
