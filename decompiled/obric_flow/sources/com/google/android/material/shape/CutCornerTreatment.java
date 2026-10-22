package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public class CutCornerTreatment extends CornerTreatment {
    float size;

    public CutCornerTreatment() {
        this.size = -1.0f;
    }

    @Override // com.google.android.material.shape.CornerTreatment
    public void getCornerPath(@NonNull ShapePath r5, float r10, float r11, float r12) {
        r5.reset(0.0f, r12 * r11, 180.0f, 180.0f - r10);
        double r13 = r12;
        double r14 = r11;
        r5.lineTo((float) ((Math.sin(Math.toRadians(r10)) * r13) * r14), (float) ((Math.sin(Math.toRadians(90.0f - r10)) * r13) * r14));
    }

    @Deprecated
    public CutCornerTreatment(float r5) {
        this.size = r5;
    }
}
