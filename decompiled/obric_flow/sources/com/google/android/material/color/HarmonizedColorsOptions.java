package com.google.android.material.color;

import androidx.annotation.AttrRes;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes2.dex */
public class HarmonizedColorsOptions {

    @AttrRes
    private final int colorAttributeToHarmonizeWith;

    @Nullable
    private final HarmonizedColorAttributes colorAttributes;

    @NonNull
    @ColorRes
    private final int[] colorResourceIds;

    /* JADX INFO: renamed from: com.google.android.material.color.HarmonizedColorsOptions$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {

        @AttrRes
        private int colorAttributeToHarmonizeWith;

        @Nullable
        private HarmonizedColorAttributes colorAttributes;

        @NonNull
        @ColorRes
        private int[] colorResourceIds;

        public Builder() {
            this.colorResourceIds = new int[0];
            this.colorAttributeToHarmonizeWith = R.attr.colorPrimary;
        }

        public static /* synthetic */ int[] access$000(Builder r5) {
            return r5.colorResourceIds;
        }

        public static /* synthetic */ HarmonizedColorAttributes access$100(Builder r5) {
            return r5.colorAttributes;
        }

        public static /* synthetic */ int access$200(Builder r5) {
            return r5.colorAttributeToHarmonizeWith;
        }

        @NonNull
        public HarmonizedColorsOptions build() {
            return new HarmonizedColorsOptions(this, null);
        }

        @NonNull
        public Builder setColorAttributeToHarmonizeWith(@AttrRes int r5) {
            this.colorAttributeToHarmonizeWith = r5;
            return this;
        }

        @NonNull
        public Builder setColorAttributes(@Nullable HarmonizedColorAttributes r5) {
            this.colorAttributes = r5;
            return this;
        }

        @NonNull
        public Builder setColorResourceIds(@NonNull @ColorRes int[] r5) {
            this.colorResourceIds = r5;
            return this;
        }
    }

    public /* synthetic */ HarmonizedColorsOptions(Builder r5, AnonymousClass1 r10) {
        this(r5);
    }

    @NonNull
    public static HarmonizedColorsOptions createMaterialDefaults() {
        return new Builder().setColorAttributes(HarmonizedColorAttributes.createMaterialDefaults()).build();
    }

    @AttrRes
    public int getColorAttributeToHarmonizeWith() {
        return this.colorAttributeToHarmonizeWith;
    }

    @Nullable
    public HarmonizedColorAttributes getColorAttributes() {
        return this.colorAttributes;
    }

    @NonNull
    @ColorRes
    public int[] getColorResourceIds() {
        return this.colorResourceIds;
    }

    @StyleRes
    public int getThemeOverlayResourceId(@StyleRes int r5) {
        HarmonizedColorAttributes r10 = this.colorAttributes;
        if (r10 != null) goto L5;
        return r5;
    L5:
        if (r10.getThemeOverlay() != 0) goto L7;
        return r5;
    L7:
        return this.colorAttributes.getThemeOverlay();
    }

    private HarmonizedColorsOptions(Builder r5) {
        this.colorResourceIds = Builder.access$000(r5);
        this.colorAttributes = Builder.access$100(r5);
        this.colorAttributeToHarmonizeWith = Builder.access$200(r5);
    }
}
