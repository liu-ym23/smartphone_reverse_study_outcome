package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Px;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.color.utilities.Contrast;
import com.google.android.material.math.MathUtils;

/* JADX INFO: loaded from: classes2.dex */
final class CircularDrawingDelegate extends DrawingDelegate<CircularProgressIndicatorSpec> {
    private static final float ROUND_CAP_RAMP_DOWN_THRESHHOLD = 0.01f;
    private float adjustedRadius;
    private float displayedCornerRadius;
    private float displayedTrackThickness;

    @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN)
    private float totalTrackLengthFraction;
    private boolean useStrokeCap;

    public CircularDrawingDelegate(@NonNull CircularProgressIndicatorSpec r5) {
        super(r5);
    }

    private void drawArc(@NonNull Canvas r15, @NonNull Paint r16, float r17, float r18, @ColorInt int r19, @Px int r20, @Px int r21) {
        if (r18 < r17) goto L5;
        float r5 = r18 - r17;
    L6:
        float r10 = r17 % 1.0f;
        if (this.totalTrackLengthFraction >= 1.0f) goto L12;
        float r11 = r10 + r5;
        if (r11 <= 1.0f) goto L12;
        drawArc(r15, r16, r10, 1.0f, r19, r20, 0);
        drawArc(r15, r16, 1.0f, r11, r19, 0, r21);
        return;
    L12:
        float r12 = (float) Math.toDegrees(this.displayedCornerRadius / this.adjustedRadius);
        if (r10 == 0.0f) goto L15;
    L17:
        float r13 = MathUtils.lerp(1.0f - this.totalTrackLengthFraction, 1.0f, r10);
        float r14 = MathUtils.lerp(0.0f, this.totalTrackLengthFraction, r5);
        float r22 = (float) Math.toDegrees(r20 / this.adjustedRadius);
        float r110 = ((r14 * 360.0f) - r22) - ((float) Math.toDegrees(r21 / this.adjustedRadius));
        float r111 = (r13 * 360.0f) + r22;
        if (r110 > 0.0f) goto L20;
        return;
    L20:
        r16.setAntiAlias(true);
        r16.setColor(r19);
        r16.setStrokeWidth(this.displayedTrackThickness);
        float r23 = r12 * 2.0f;
        if (r110 >= r23) goto L23;
        float r24 = r110 / r23;
        r16.setStyle(Paint.Style.FILL);
        drawRoundedBlock(r15, r16, (r12 * r24) + r111, this.displayedCornerRadius * 2.0f, this.displayedTrackThickness, r24);
        return;
    L23:
        float r25 = this.adjustedRadius;
        RectF r26 = new RectF(-r25, -r25, r25, r25);
        r16.setStyle(Paint.Style.STROKE);
        if (this.useStrokeCap == false) goto L26;
        Paint.Cap r27 = Paint.Cap.ROUND;
    L27:
        r16.setStrokeCap(r27);
        float r112 = r111 + r12;
        r15.drawArc(r26, r112, r110 - r23, false, r16);
        if (this.useStrokeCap == false) goto L30;
        return;
    L30:
        if (this.displayedCornerRadius <= 0.0f) goto L35;
        r16.setStyle(Paint.Style.FILL);
        drawRoundedBlock(r15, r16, r112, this.displayedCornerRadius * 2.0f, this.displayedTrackThickness);
        drawRoundedBlock(r15, r16, (r111 + r110) - r12, this.displayedCornerRadius * 2.0f, this.displayedTrackThickness);
        return;
    L35:
        return;
    L26:
        r27 = Paint.Cap.BUTT;
        goto L27
    L15:
        if (r5 < 0.99f) goto L17;
        r5 = r5 + ((((r12 * 2.0f) / 360.0f) * (r5 - 0.99f)) / ROUND_CAP_RAMP_DOWN_THRESHHOLD);
        goto L17
    L5:
        r5 = (r18 + 1.0f) - r17;
        goto L6
    }

    private void drawRoundedBlock(@NonNull Canvas r10, @NonNull Paint r11, float r12, float r13, float r14) {
        drawRoundedBlock(r10, r11, r12, r13, r14, 1.0f);
    }

    private int getSize() {
        S r5 = this.spec;
        int r10 = ((CircularProgressIndicatorSpec) r5).indicatorSize;
        return (((CircularProgressIndicatorSpec) r5).indicatorInset * 2) + r10;
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void adjustCanvas(@NonNull Canvas r10, @NonNull Rect r11, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r12, boolean r13, boolean r14) {
        float r5 = r11.width() / getPreferredWidth();
        float r15 = r11.height() / getPreferredHeight();
        S r16 = this.spec;
        float r17 = (((CircularProgressIndicatorSpec) r16).indicatorSize / 2.0f) + ((CircularProgressIndicatorSpec) r16).indicatorInset;
        r10.translate((r17 * r5) + r11.left, (r17 * r15) + r11.top);
        r10.rotate(-90.0f);
        r10.scale(r5, r15);
        if (((CircularProgressIndicatorSpec) this.spec).indicatorDirection == 0) goto L5;
        r10.scale(1.0f, -1.0f);
    L5:
        float r18 = -r17;
        r10.clipRect(r18, r18, r17, r17);
        S r19 = this.spec;
        if ((((CircularProgressIndicatorSpec) r19).trackThickness / 2) > ((CircularProgressIndicatorSpec) r19).trackCornerRadius) goto L8;
        boolean r20 = true;
    L9:
        this.useStrokeCap = r20;
        this.displayedTrackThickness = ((CircularProgressIndicatorSpec) r19).trackThickness * r12;
        this.displayedCornerRadius = Math.min(((CircularProgressIndicatorSpec) r19).trackThickness / 2, ((CircularProgressIndicatorSpec) r19).trackCornerRadius) * r12;
        S r21 = this.spec;
        float r22 = (((CircularProgressIndicatorSpec) r21).indicatorSize - ((CircularProgressIndicatorSpec) r21).trackThickness) / 2.0f;
        this.adjustedRadius = r22;
        if (r13 == true) goto L12;
        if (r14 == true) goto L12;
    L26:
        if (r14 == true) goto L28;
    L30:
        this.totalTrackLengthFraction = 1.0f;
        return;
    L28:
        if (((CircularProgressIndicatorSpec) r21).hideAnimationBehavior != 3) goto L30;
        this.totalTrackLengthFraction = r12;
        return;
    L12:
        if (r13 == true) goto L14;
    L15:
        if (r14 == true) goto L17;
    L19:
        if (r13 == true) goto L21;
    L22:
        if (r14 == false) goto L26;
        if (((CircularProgressIndicatorSpec) r21).hideAnimationBehavior != 2) goto L26;
    L25:
        this.adjustedRadius = r22 - (((1.0f - r12) * ((CircularProgressIndicatorSpec) r21).trackThickness) / 2.0f);
        goto L26
    L21:
        if (((CircularProgressIndicatorSpec) r21).showAnimationBehavior == 1) goto L25;
    L17:
        if (((CircularProgressIndicatorSpec) r21).hideAnimationBehavior != 1) goto L19;
    L18:
        this.adjustedRadius = (((1.0f - r12) * ((CircularProgressIndicatorSpec) r21).trackThickness) / 2.0f) + r22;
        goto L26
    L14:
        if (((CircularProgressIndicatorSpec) r21).showAnimationBehavior == 2) goto L18;
    L8:
        r20 = false;
        goto L9
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void drawStopIndicator(@NonNull Canvas r5, @NonNull Paint r10, @ColorInt int r11, @IntRange(from = 0, to = 255) int r12) {
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void fillIndicator(@NonNull Canvas r10, @NonNull Paint r11, @NonNull DrawingDelegate.ActiveIndicator r12, @IntRange(from = 0, to = 255) int r13) {
        int r14 = MaterialColors.compositeARGBWithAlpha(r12.color, r13);
        float r5 = r12.startFraction;
        float r15 = r12.endFraction;
        int r16 = r12.gapSize;
        drawArc(r10, r11, r5, r15, r14, r16, r16);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void fillTrack(@NonNull Canvas r10, @NonNull Paint r11, float r12, float r13, @ColorInt int r14, @IntRange(from = 0, to = 255) int r15, int r16) {
        drawArc(r10, r11, r12, r13, MaterialColors.compositeARGBWithAlpha(r14, r15), r16, r16);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredHeight() {
        return getSize();
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredWidth() {
        return getSize();
    }

    private void drawRoundedBlock(@NonNull Canvas r10, @NonNull Paint r11, float r12, float r13, float r14, float r15) {
        float r16 = (int) Math.min(r14, this.displayedTrackThickness);
        float r5 = r13 / 2.0f;
        float r17 = Math.min(r5, (this.displayedCornerRadius * r16) / this.displayedTrackThickness);
        RectF r18 = new RectF((-r16) / 2.0f, (-r13) / 2.0f, r16 / 2.0f, r5);
        r10.save();
        double r19 = r12;
        r10.translate((float) (Math.cos(Math.toRadians(r19)) * this.adjustedRadius), (float) (Math.sin(Math.toRadians(r19)) * this.adjustedRadius));
        r10.rotate(r12);
        r10.scale(r15, r15);
        r10.drawRoundRect(r18, r17, r17, r11);
        r10.restore();
    }
}
