package com.google.android.material.elevation;

import android.content.Context;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

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
        SurfaceColors r0 = new SurfaceColors("SURFACE_0", 0, ZeusTransformUtils.mapRes(R.dimen.m3_sys_elevation_level0, "dimen", "m3_sys_elevation_level0"));
        SURFACE_0 = r0;
        SurfaceColors r1 = new SurfaceColors("SURFACE_1", 1, ZeusTransformUtils.mapRes(R.dimen.m3_sys_elevation_level1, "dimen", "m3_sys_elevation_level1"));
        SURFACE_1 = r1;
        SurfaceColors r3 = new SurfaceColors("SURFACE_2", 2, ZeusTransformUtils.mapRes(R.dimen.m3_sys_elevation_level2, "dimen", "m3_sys_elevation_level2"));
        SURFACE_2 = r3;
        SurfaceColors r5 = new SurfaceColors("SURFACE_3", 3, ZeusTransformUtils.mapRes(R.dimen.m3_sys_elevation_level3, "dimen", "m3_sys_elevation_level3"));
        SURFACE_3 = r5;
        SurfaceColors r7 = new SurfaceColors("SURFACE_4", 4, ZeusTransformUtils.mapRes(R.dimen.m3_sys_elevation_level4, "dimen", "m3_sys_elevation_level4"));
        SURFACE_4 = r7;
        SurfaceColors r9 = new SurfaceColors("SURFACE_5", 5, ZeusTransformUtils.mapRes(R.dimen.m3_sys_elevation_level5, "dimen", "m3_sys_elevation_level5"));
        SURFACE_5 = r9;
        $VALUES = new SurfaceColors[]{r0, r1, r3, r5, r7, r9};
    }

    private SurfaceColors(String r1, int r2, int r3) {
        super(r1, r2);
        this.elevationResId = r3;
    }

    public static int getColorForElevation(Context r4, float r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        return new a(r6).b(com.google.android.material.c.a.a(r6, ZeusTransformUtils.mapRes(R.attr.colorSurface, "attr", "colorSurface"), 0), r5);
    }

    public static SurfaceColors valueOf(String r2) {
        return (SurfaceColors) ZeusTransformUtils.preCheckCast(Enum.valueOf(SurfaceColors.class, r2), SurfaceColors.class, "com.obric.memorydata.plugin");
    }

    public static SurfaceColors[] values() {
        return (SurfaceColors[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SurfaceColors[].class, "com.obric.memorydata.plugin");
    }

    public int getColor(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        return getColorForElevation(r4, ZeusTransformUtils.getResources(r4, "com.obric.memorydata.plugin").getDimension(this.elevationResId));
    }
}
