package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.math.MathUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.color.utilities.Contrast;

/* JADX INFO: loaded from: classes2.dex */
final class LinearDrawingDelegate extends DrawingDelegate<LinearProgressIndicatorSpec> {
    private float displayedCornerRadius;
    private float displayedTrackThickness;

    @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN)
    private float totalTrackLengthFraction;
    private float trackLength;
    private boolean useStrokeCap;

    public LinearDrawingDelegate(@NonNull LinearProgressIndicatorSpec r5) {
        super(r5);
        this.trackLength = 300.0f;
    }

    private void drawLine(@NonNull Canvas r15, @NonNull Paint r16, float r17, float r18, @ColorInt int r19, @Px int r20, @Px int r21) {
        float r5 = MathUtils.clamp(r17, 0.0f, 1.0f);
        float r10 = MathUtils.clamp(r18, 0.0f, 1.0f);
        float r11 = com.google.android.material.math.MathUtils.lerp(1.0f - this.totalTrackLengthFraction, 1.0f, r5);
        float r12 = com.google.android.material.math.MathUtils.lerp(1.0f - this.totalTrackLengthFraction, 1.0f, r10);
        int r13 = (int) ((MathUtils.clamp(r11, 0.0f, 0.01f) * r20) / 0.01f);
        float r14 = 1.0f - MathUtils.clamp(r12, 0.99f, 1.0f);
        float r22 = this.trackLength;
        int r23 = (int) ((r11 * r22) + r13);
        int r24 = (int) ((r12 * r22) - ((int) ((r14 * r21) / 0.01f)));
        float r25 = (-r22) / 2.0f;
        if (r23 > r24) goto L22;
        float r26 = this.displayedCornerRadius;
        float r27 = r23 + r26;
        float r110 = r24 - r26;
        float r111 = r26 * 2.0f;
        r16.setColor(r19);
        r16.setAntiAlias(true);
        r16.setStrokeWidth(this.displayedTrackThickness);
        if (r27 < r110) goto L7;
        drawRoundedBlock(r15, r16, new PointF(r27 + r25, 0.0f), new PointF(r110 + r25, 0.0f), r111, this.displayedTrackThickness);
        return;
    L7:
        r16.setStyle(Paint.Style.STROKE);
        if (this.useStrokeCap == false) goto L10;
        Paint.Cap r28 = Paint.Cap.ROUND;
    L11:
        r16.setStrokeCap(r28);
        float r112 = r27 + r25;
        float r113 = r110 + r25;
        r15.drawLine(r112, 0.0f, r113, 0.0f, r16);
        if (this.useStrokeCap == false) goto L14;
        return;
    L14:
        if (this.displayedCornerRadius <= 0.0f) goto L25;
        r16.setStyle(Paint.Style.FILL);
        if (r27 <= 0.0f) goto L19;
        drawRoundedBlock(r15, r16, new PointF(r112, 0.0f), r111, this.displayedTrackThickness);
    L19:
        if (r110 >= this.trackLength) goto L26;
        drawRoundedBlock(r15, r16, new PointF(r113, 0.0f), r111, this.displayedTrackThickness);
        return;
    L26:
        return;
    L25:
        return;
    L10:
        r28 = Paint.Cap.BUTT;
        goto L11
    }

    private void drawRoundedBlock(@NonNull Canvas r10, @NonNull Paint r11, @NonNull PointF r12, float r13, float r14) {
        drawRoundedBlock(r10, r11, r12, null, r13, r14);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void adjustCanvas(@NonNull Canvas r10, @NonNull Rect r11, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r12, boolean r13, boolean r14) {
        this.trackLength = r11.width();
        float r5 = ((LinearProgressIndicatorSpec) this.spec).trackThickness;
        r10.translate((r11.width() / 2.0f) + r11.left, Math.max(0.0f, (r11.height() - r5) / 2.0f) + ((r11.height() / 2.0f) + r11.top));
        if (((LinearProgressIndicatorSpec) this.spec).drawHorizontallyInverse == false) goto L5;
        r10.scale(-1.0f, 1.0f);
    L5:
        float r15 = this.trackLength / 2.0f;
        float r16 = r5 / 2.0f;
        r10.clipRect(-r15, -r16, r15, r16);
        S r17 = this.spec;
        if ((((LinearProgressIndicatorSpec) r17).trackThickness / 2) != ((LinearProgressIndicatorSpec) r17).trackCornerRadius) goto L8;
        boolean r18 = true;
    L9:
        this.useStrokeCap = r18;
        this.displayedTrackThickness = ((LinearProgressIndicatorSpec) r17).trackThickness * r12;
        this.displayedCornerRadius = Math.min(((LinearProgressIndicatorSpec) r17).trackThickness / 2, ((LinearProgressIndicatorSpec) r17).trackCornerRadius) * r12;
        if (r13 == true) goto L12;
        if (r14 == true) goto L12;
    L24:
        if (r14 == true) goto L26;
    L28:
        this.totalTrackLengthFraction = 1.0f;
        return;
    L26:
        if (((LinearProgressIndicatorSpec) this.spec).hideAnimationBehavior != 3) goto L28;
        this.totalTrackLengthFraction = r12;
        return;
    L12:
        if (r13 == true) goto L14;
    L15:
        if (r14 == true) goto L17;
    L19:
        if (r13 == true) goto L23;
        if (r14 == false) goto L24;
        if (((LinearProgressIndicatorSpec) this.spec).hideAnimationBehavior == 3) goto L24;
    L23:
        r10.translate(0.0f, ((1.0f - r12) * ((LinearProgressIndicatorSpec) this.spec).trackThickness) / 2.0f);
        goto L24
    L17:
        if (((LinearProgressIndicatorSpec) this.spec).hideAnimationBehavior != 1) goto L19;
    L18:
        r10.scale(1.0f, -1.0f);
        goto L19
    L14:
        if (((LinearProgressIndicatorSpec) this.spec).showAnimationBehavior == 2) goto L18;
    L8:
        r18 = false;
        goto L9
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void drawStopIndicator(@NonNull Canvas r10, @NonNull Paint r11, @ColorInt int r12, @IntRange(from = 0, to = 255) int r13) {
        int r14 = MaterialColors.compositeARGBWithAlpha(r12, r13);
        if (((LinearProgressIndicatorSpec) this.spec).trackStopIndicatorSize <= 0) goto L7;
        if (r14 == 0) goto L8;
        r11.setStyle(Paint.Style.FILL);
        r11.setColor(r14);
        PointF r5 = new PointF((this.trackLength / 2.0f) - (this.displayedTrackThickness / 2.0f), 0.0f);
        S r15 = this.spec;
        drawRoundedBlock(r10, r11, r5, ((LinearProgressIndicatorSpec) r15).trackStopIndicatorSize, ((LinearProgressIndicatorSpec) r15).trackStopIndicatorSize);
        return;
    L8:
        return;
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void fillIndicator(@NonNull Canvas r10, @NonNull Paint r11, @NonNull DrawingDelegate.ActiveIndicator r12, int r13) {
        int r14 = MaterialColors.compositeARGBWithAlpha(r12.color, r13);
        float r5 = r12.startFraction;
        float r15 = r12.endFraction;
        int r16 = r12.gapSize;
        drawLine(r10, r11, r5, r15, r14, r16, r16);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void fillTrack(@NonNull Canvas r10, @NonNull Paint r11, float r12, float r13, int r14, int r15, @Px int r16) {
        drawLine(r10, r11, r12, r13, MaterialColors.compositeARGBWithAlpha(r14, r15), r16, r16);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredHeight() {
        return ((LinearProgressIndicatorSpec) this.spec).trackThickness;
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredWidth() {
        return -1;
    }

    private void drawRoundedBlock(@NonNull Canvas r5, @NonNull Paint r10, @NonNull PointF r11, @Nullable PointF r12, float r13, float r14) {
        float r15 = Math.min(r14, this.displayedTrackThickness);
        float r16 = r13 / 2.0f;
        float r17 = Math.min(r16, (this.displayedCornerRadius * r15) / this.displayedTrackThickness);
        RectF r18 = new RectF((-r13) / 2.0f, (-r15) / 2.0f, r16, r15 / 2.0f);
        r10.setStyle(Paint.Style.FILL);
        r5.save();
        if (r12 == null) goto L5;
        r5.translate(r12.x, r12.y);
        Path r19 = new Path();
        r19.addRoundRect(r18, r17, r17, Path.Direction.CCW);
        r5.clipPath(r19);
        r5.translate(-r12.x, -r12.y);
    L5:
        r5.translate(r11.x, r11.y);
        r5.drawRoundRect(r18, r17, r17, r10);
        r5.restore();
    }
}
