package com.google.android.material.elevation;

import android.content.Context;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import q5.b;
import q5.d;
import w5.a;

/* JADX INFO: loaded from: classes.dex */
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
        SurfaceColors r10 = new SurfaceColors("SURFACE_0", 0, d.m3_sys_elevation_level0);
        SURFACE_0 = r10;
        SurfaceColors r11 = new SurfaceColors("SURFACE_1", 1, d.m3_sys_elevation_level1);
        SURFACE_1 = r11;
        SurfaceColors r12 = new SurfaceColors("SURFACE_2", 2, d.m3_sys_elevation_level2);
        SURFACE_2 = r12;
        SurfaceColors r13 = new SurfaceColors("SURFACE_3", 3, d.m3_sys_elevation_level3);
        SURFACE_3 = r13;
        SurfaceColors r14 = new SurfaceColors("SURFACE_4", 4, d.m3_sys_elevation_level4);
        SURFACE_4 = r14;
        SurfaceColors r15 = new SurfaceColors("SURFACE_5", 5, d.m3_sys_elevation_level5);
        SURFACE_5 = r15;
        $VALUES = new SurfaceColors[]{r10, r11, r12, r13, r14, r15};
    }

    private SurfaceColors(@DimenRes String r10, int r11, int r12) {
        super(r10, r11);
        this.elevationResId = r12;
    }

    @ColorInt
    public static int getColorForElevation(@NonNull Context r10, @Dimension float r11) {
        return new a(r10).b(t5.a.b(r10, b.colorSurface, 0), r11);
    }

    public static SurfaceColors valueOf(String r10) {
        return (SurfaceColors) Enum.valueOf(SurfaceColors.class, r10);
    }

    public static SurfaceColors[] values() {
        return (SurfaceColors[]) $VALUES.clone();
    }

    @ColorInt
    public int getColor(@NonNull Context r10) {
        return getColorForElevation(r10, r10.getResources().getDimension(this.elevationResId));
    }
}
