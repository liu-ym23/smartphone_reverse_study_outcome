package com.google.android.material.color;

import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes2.dex */
public final class HarmonizedColorAttributes {
    private static final int[] HARMONIZED_MATERIAL_ATTRIBUTES = null;
    private final int[] attributes;

    @StyleRes
    private final int themeOverlay;

    static {
        HARMONIZED_MATERIAL_ATTRIBUTES = new int[]{R.attr.colorError, R.attr.colorOnError, R.attr.colorErrorContainer, R.attr.colorOnErrorContainer};
    }

    private HarmonizedColorAttributes(@AttrRes @NonNull int[] r5, @StyleRes int r10) {
        if (r10 != 0) goto L5;
    L9:
        this.attributes = r5;
        this.themeOverlay = r10;
        return;
    L5:
        if (r5.length != 0) goto L9;
        throw new IllegalArgumentException("Theme overlay should be used with the accompanying int[] attributes.");
    }

    @NonNull
    public static HarmonizedColorAttributes create(@AttrRes @NonNull int[] r5) {
        return new HarmonizedColorAttributes(r5, 0);
    }

    @NonNull
    public static HarmonizedColorAttributes createMaterialDefaults() {
        return create(HARMONIZED_MATERIAL_ATTRIBUTES, R.style.ThemeOverlay_Material3_HarmonizedColors);
    }

    @NonNull
    public int[] getAttributes() {
        return this.attributes;
    }

    @StyleRes
    public int getThemeOverlay() {
        return this.themeOverlay;
    }

    @NonNull
    public static HarmonizedColorAttributes create(@AttrRes @NonNull int[] r5, @StyleRes int r10) {
        return new HarmonizedColorAttributes(r5, r10);
    }
}
