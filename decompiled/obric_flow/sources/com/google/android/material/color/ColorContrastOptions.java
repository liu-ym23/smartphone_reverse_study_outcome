package com.google.android.material.color;

import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;

/* JADX INFO: loaded from: classes2.dex */
public class ColorContrastOptions {

    @StyleRes
    private final int highContrastThemeOverlayResourceId;

    @StyleRes
    private final int mediumContrastThemeOverlayResourceId;

    /* JADX INFO: renamed from: com.google.android.material.color.ColorContrastOptions$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {

        @StyleRes
        private int highContrastThemeOverlayResourceId;

        @StyleRes
        private int mediumContrastThemeOverlayResourceId;

        public Builder() {
        }

        public static /* synthetic */ int access$000(Builder r5) {
            return r5.mediumContrastThemeOverlayResourceId;
        }

        public static /* synthetic */ int access$100(Builder r5) {
            return r5.highContrastThemeOverlayResourceId;
        }

        @NonNull
        public ColorContrastOptions build() {
            return new ColorContrastOptions(this, null);
        }

        @NonNull
        public Builder setHighContrastThemeOverlay(@StyleRes int r5) {
            this.highContrastThemeOverlayResourceId = r5;
            return this;
        }

        @NonNull
        public Builder setMediumContrastThemeOverlay(@StyleRes int r5) {
            this.mediumContrastThemeOverlayResourceId = r5;
            return this;
        }
    }

    public /* synthetic */ ColorContrastOptions(Builder r5, AnonymousClass1 r10) {
        this(r5);
    }

    @StyleRes
    public int getHighContrastThemeOverlay() {
        return this.highContrastThemeOverlayResourceId;
    }

    @StyleRes
    public int getMediumContrastThemeOverlay() {
        return this.mediumContrastThemeOverlayResourceId;
    }

    private ColorContrastOptions(Builder r5) {
        this.mediumContrastThemeOverlayResourceId = Builder.access$000(r5);
        this.highContrastThemeOverlayResourceId = Builder.access$100(r5);
    }
}
