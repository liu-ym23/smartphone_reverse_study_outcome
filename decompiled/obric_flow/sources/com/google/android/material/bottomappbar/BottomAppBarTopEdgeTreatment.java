package com.google.android.material.bottomappbar;

import ai.j0;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.ShapePath;

/* JADX INFO: loaded from: classes2.dex */
public class BottomAppBarTopEdgeTreatment extends EdgeTreatment implements Cloneable {
    private static final int ANGLE_LEFT = 180;
    private static final int ANGLE_UP = 270;
    private static final int ARC_HALF = 180;
    private static final int ARC_QUARTER = 90;
    private static final float ROUNDED_CORNER_FAB_OFFSET = 1.75f;
    private float cradleVerticalOffset;
    private float fabCornerSize;
    private float fabDiameter;
    private float fabMargin;
    private float horizontalOffset;
    private float roundedCornerRadius;

    public BottomAppBarTopEdgeTreatment(float r5, float r10, float r11) {
        this.fabCornerSize = -1.0f;
        this.fabMargin = r5;
        this.roundedCornerRadius = r10;
        setCradleVerticalOffset(r11);
        this.horizontalOffset = 0.0f;
    }

    public float getCradleVerticalOffset() {
        return this.cradleVerticalOffset;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float r24, float r25, float r26, @NonNull ShapePath r27) {
        float r5 = this.fabDiameter;
        if (r5 != 0.0f) goto L6;
        r27.lineTo(r24, 0.0f);
        return;
    L6:
        float r12 = ((this.fabMargin * 2.0f) + r5) / 2.0f;
        float r13 = r26 * this.roundedCornerRadius;
        float r14 = r25 + this.horizontalOffset;
        float r10 = j0.b(1.0f, r26, r12, this.cradleVerticalOffset * r26);
        if ((r10 / r12) < 1.0f) goto L10;
        r27.lineTo(r24, 0.0f);
        return;
    L10:
        float r11 = this.fabCornerSize;
        float r15 = r11 * r26;
        if (r11 != (-1.0f)) goto L13;
    L17:
        boolean r16 = true;
    L16:
        boolean r17 = r16;
        if (r17 == true) goto L20;
        float r18 = ROUNDED_CORNER_FAB_OFFSET;
        float r19 = 0.0f;
    L21:
        float r20 = r12 + r13;
        float r21 = r19 + r13;
        float r22 = (float) Math.sqrt((r20 * r20) - (r21 * r21));
        float r23 = r14 - r22;
        float r110 = r14 + r22;
        float r28 = (float) Math.toDegrees(Math.atan(r22 / r21));
        float r111 = (90.0f - r28) + r18;
        r27.lineTo(r23, 0.0f);
        float r29 = r13 * 2.0f;
        r27.addArc(r23 - r13, 0.0f, r23 + r13, r29, 270.0f, r28);
        if (r17 == false) goto L24;
        r27.addArc(r14 - r12, (-r12) - r19, r14 + r12, r12 - r19, 180.0f - r111, (r111 * 2.0f) - 180.0f);
    L25:
        r27.addArc(r110 - r13, 0.0f, r110 + r13, r29, 270.0f - r28, r28);
        r27.lineTo(r24, 0.0f);
        return;
    L24:
        float r30 = this.fabMargin;
        float r112 = r15 * 2.0f;
        float r31 = r14 - r12;
        r27.addArc(r31, -(r15 + r30), r31 + (r30 + r112), r30 + r15, 180.0f - r111, ((r111 * 2.0f) - 180.0f) / 2.0f);
        float r32 = r14 + r12;
        float r33 = this.fabMargin;
        r27.lineTo(r32 - ((r33 / 2.0f) + r15), r33 + r15);
        float r34 = this.fabMargin;
        r27.addArc(r32 - (r112 + r34), -(r15 + r34), r32, r34 + r15, 90.0f, r111 - 90.0f);
        goto L25
    L20:
        r19 = r10;
        r18 = 0.0f;
        goto L21
    L13:
        if (Math.abs((r11 * 2.0f) - r5) < 0.1f) goto L17;
        r16 = false;
        goto L16
    }

    public float getFabCornerRadius() {
        return this.fabCornerSize;
    }

    public float getFabCradleMargin() {
        return this.fabMargin;
    }

    public float getFabCradleRoundedCornerRadius() {
        return this.roundedCornerRadius;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getFabDiameter() {
        return this.fabDiameter;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getHorizontalOffset() {
        return this.horizontalOffset;
    }

    public void setCradleVerticalOffset(@FloatRange(from = 0.0d) float r5) {
        if (r5 < 0.0f) goto L7;
        this.cradleVerticalOffset = r5;
        return;
    L7:
        throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
    }

    public void setFabCornerSize(float r5) {
        this.fabCornerSize = r5;
    }

    public void setFabCradleMargin(float r5) {
        this.fabMargin = r5;
    }

    public void setFabCradleRoundedCornerRadius(float r5) {
        this.roundedCornerRadius = r5;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setFabDiameter(float r5) {
        this.fabDiameter = r5;
    }

    public void setHorizontalOffset(float r5) {
        this.horizontalOffset = r5;
    }
}
