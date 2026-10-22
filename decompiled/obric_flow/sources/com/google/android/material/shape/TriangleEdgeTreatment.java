package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public class TriangleEdgeTreatment extends EdgeTreatment {
    private final boolean inside;
    private final float size;

    public TriangleEdgeTreatment(float r5, boolean r10) {
        this.size = r5;
        this.inside = r10;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float r5, float r10, float r11, @NonNull ShapePath r12) {
        if (this.inside == false) goto L5;
        r12.lineTo(r10 - (this.size * r11), 0.0f);
        float r13 = this.size;
        r12.lineTo(r10, r13 * r11, (r13 * r11) + r10, 0.0f);
        r12.lineTo(r5, 0.0f);
        return;
    L5:
        float r14 = this.size;
        r12.lineTo(r10 - (r14 * r11), 0.0f, r10, (-r14) * r11);
        r12.lineTo((this.size * r11) + r10, 0.0f, r5, 0.0f);
    }
}
