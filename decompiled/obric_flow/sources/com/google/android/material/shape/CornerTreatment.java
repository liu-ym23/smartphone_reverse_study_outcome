package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public class CornerTreatment {
    public CornerTreatment() {
    }

    @Deprecated
    public void getCornerPath(float r5, float r10, @NonNull ShapePath r11) {
    }

    public void getCornerPath(@NonNull ShapePath r5, float r10, float r11, float r12) {
        getCornerPath(r10, r11, r5);
    }

    public void getCornerPath(@NonNull ShapePath r5, float r10, float r11, @NonNull RectF r12, @NonNull CornerSize r13) {
        getCornerPath(r5, r10, r11, r13.getCornerSize(r12));
    }
}
