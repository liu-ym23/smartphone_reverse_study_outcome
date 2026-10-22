package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Px;
import com.google.android.material.color.utilities.Contrast;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;

/* JADX INFO: loaded from: classes2.dex */
abstract class DrawingDelegate<S extends BaseProgressIndicatorSpec> {
    S spec;

    public static class ActiveIndicator {

        @ColorInt
        int color;

        @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN)
        float endFraction;

        @Px
        int gapSize;

        @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN)
        float startFraction;

        public ActiveIndicator() {
        }
    }

    public DrawingDelegate(S r5) {
        this.spec = r5;
    }

    public abstract void adjustCanvas(@NonNull Canvas r5, @NonNull Rect r10, @FloatRange(from = -1.0d, to = Contrast.RATIO_MIN) float r11, boolean r12, boolean r13);

    public abstract void drawStopIndicator(@NonNull Canvas r5, @NonNull Paint r10, @ColorInt int r11, @IntRange(from = 0, to = 255) int r12);

    public abstract void fillIndicator(@NonNull Canvas r5, @NonNull Paint r10, @NonNull ActiveIndicator r11, @IntRange(from = 0, to = 255) int r12);

    public abstract void fillTrack(@NonNull Canvas r5, @NonNull Paint r10, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r11, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r12, @ColorInt int r13, @IntRange(from = 0, to = 255) int r14, @Px int r15);

    public abstract int getPreferredHeight();

    public abstract int getPreferredWidth();

    public void validateSpecAndAdjustCanvas(@NonNull Canvas r5, @NonNull Rect r10, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r11, boolean r12, boolean r13) {
        this.spec.validateSpec();
        adjustCanvas(r5, r10, r11, r12, r13);
    }
}
