package com.google.android.material.elevation;

import android.content.Context;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;

/* JADX INFO: loaded from: classes2.dex */
public final enum SurfaceColors extends Enum<SurfaceColors> {
    private static final /* synthetic */ SurfaceColors[] $VALUES = null;
    public static final SurfaceColors SURFACE_0 = null;
    public static final SurfaceColors SURFACE_1 = null;
    public static final SurfaceColors SURFACE_2 = null;
    public static final SurfaceColors SURFACE_3 = null;
    public static final SurfaceColors SURFACE_4 = null;
    public static final SurfaceColors SURFACE_5 = null;
    private final int elevationResId;

    static {
        SurfaceColors r5 = new SurfaceColors("SURFACE_0", 0, R.dimen.m3_sys_elevation_level0);
        SURFACE_0 = r5;
        SurfaceColors r10 = new SurfaceColors("SURFACE_1", 1, R.dimen.m3_sys_elevation_level1);
        SURFACE_1 = r10;
        SurfaceColors r11 = new SurfaceColors("SURFACE_2", 2, R.dimen.m3_sys_elevation_level2);
        SURFACE_2 = r11;
        SurfaceColors r12 = new SurfaceColors("SURFACE_3", 3, R.dimen.m3_sys_elevation_level3);
        SURFACE_3 = r12;
        SurfaceColors r13 = new SurfaceColors("SURFACE_4", 4, R.dimen.m3_sys_elevation_level4);
        SURFACE_4 = r13;
        SurfaceColors r14 = new SurfaceColors("SURFACE_5", 5, R.dimen.m3_sys_elevation_level5);
        SURFACE_5 = r14;
        $VALUES = new SurfaceColors[]{r5, r10, r11, r12, r13, r14};
    }

    private SurfaceColors(@DimenRes String r5, int r10, int r11) {
        super(r5, r10);
        this.elevationResId = r11;
    }

    @ColorInt
    public static int getColorForElevation(@NonNull Context r5, @Dimension float r10) {
        return new ElevationOverlayProvider(r5).compositeOverlay(MaterialColors.getColor(r5, R.attr.colorSurface, 0), r10);
    }

    public static SurfaceColors valueOf(String r5) {
        return (SurfaceColors) Enum.valueOf(SurfaceColors.class, r5);
    }

    public static SurfaceColors[] values() {
        return (SurfaceColors[]) $VALUES.clone();
    }

    @ColorInt
    public int getColor(@NonNull Context r5) {
        return getColorForElevation(r5, r5.getResources().getDimension(this.elevationResId));
    }
}
