package com.google.android.material.color;

import android.graphics.Bitmap;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import com.google.android.material.color.utilities.QuantizerCelebi;
import com.google.android.material.color.utilities.Score;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicColorsOptions {
    private static final DynamicColors.Precondition ALWAYS_ALLOW = null;
    private static final DynamicColors.OnAppliedCallback NO_OP_CALLBACK = null;

    @Nullable
    private Integer contentBasedSeedColor;

    @NonNull
    private final DynamicColors.OnAppliedCallback onAppliedCallback;

    @NonNull
    private final DynamicColors.Precondition precondition;

    @StyleRes
    private final int themeOverlay;

    public static class Builder {

        @Nullable
        private Bitmap contentBasedSourceBitmap;

        @Nullable
        private Integer contentBasedSourceColor;

        @NonNull
        private DynamicColors.OnAppliedCallback onAppliedCallback;

        @NonNull
        private DynamicColors.Precondition precondition;

        @StyleRes
        private int themeOverlay;

        public Builder() {
            this.precondition = DynamicColorsOptions.access$500();
            this.onAppliedCallback = DynamicColorsOptions.access$600();
        }

        public static /* synthetic */ int access$000(Builder r5) {
            return r5.themeOverlay;
        }

        public static /* synthetic */ DynamicColors.Precondition access$100(Builder r5) {
            return r5.precondition;
        }

        public static /* synthetic */ DynamicColors.OnAppliedCallback access$200(Builder r5) {
            return r5.onAppliedCallback;
        }

        public static /* synthetic */ Integer access$300(Builder r5) {
            return r5.contentBasedSourceColor;
        }

        public static /* synthetic */ Bitmap access$400(Builder r5) {
            return r5.contentBasedSourceBitmap;
        }

        @NonNull
        public DynamicColorsOptions build() {
            return new DynamicColorsOptions(this, null);
        }

        @NonNull
        public Builder setContentBasedSource(@NonNull Bitmap r5) {
            this.contentBasedSourceBitmap = r5;
            this.contentBasedSourceColor = null;
            return this;
        }

        @NonNull
        public Builder setOnAppliedCallback(@NonNull DynamicColors.OnAppliedCallback r5) {
            this.onAppliedCallback = r5;
            return this;
        }

        @NonNull
        public Builder setPrecondition(@NonNull DynamicColors.Precondition r5) {
            this.precondition = r5;
            return this;
        }

        @NonNull
        public Builder setThemeOverlay(@StyleRes int r5) {
            this.themeOverlay = r5;
            return this;
        }

        @NonNull
        public Builder setContentBasedSource(@ColorInt int r5) {
            this.contentBasedSourceBitmap = null;
            this.contentBasedSourceColor = Integer.valueOf(r5);
            return this;
        }
    }

    static {
        ALWAYS_ALLOW = new AnonymousClass1();
        NO_OP_CALLBACK = new AnonymousClass2();
    }

    public /* synthetic */ DynamicColorsOptions(Builder r5, AnonymousClass1 r10) {
        this(r5);
    }

    public static /* synthetic */ DynamicColors.Precondition access$500() {
        return ALWAYS_ALLOW;
    }

    public static /* synthetic */ DynamicColors.OnAppliedCallback access$600() {
        return NO_OP_CALLBACK;
    }

    private static int extractSeedColorFromImage(Bitmap r10) {
        int r11 = r10.getWidth();
        int r12 = r10.getHeight();
        int[] r13 = new int[r11 * r12];
        r10.getPixels(r13, 0, r11, 0, 0, r11, r12);
        return Score.score(QuantizerCelebi.quantize(r13, 128)).get(0).intValue();
    }

    @Nullable
    public Integer getContentBasedSeedColor() {
        return this.contentBasedSeedColor;
    }

    @NonNull
    public DynamicColors.OnAppliedCallback getOnAppliedCallback() {
        return this.onAppliedCallback;
    }

    @NonNull
    public DynamicColors.Precondition getPrecondition() {
        return this.precondition;
    }

    @StyleRes
    public int getThemeOverlay() {
        return this.themeOverlay;
    }

    private DynamicColorsOptions(Builder r5) {
        this.themeOverlay = Builder.access$000(r5);
        this.precondition = Builder.access$100(r5);
        this.onAppliedCallback = Builder.access$200(r5);
        if (Builder.access$300(r5) == null) goto L6;
        this.contentBasedSeedColor = Builder.access$300(r5);
        return;
    L6:
        if (Builder.access$400(r5) == null) goto L10;
        this.contentBasedSeedColor = Integer.valueOf(extractSeedColorFromImage(Builder.access$400(r5)));
        return;
    }
}
