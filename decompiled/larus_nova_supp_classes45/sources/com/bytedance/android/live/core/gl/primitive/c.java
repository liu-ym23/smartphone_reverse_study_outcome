package com.bytedance.android.live.core.gl.primitive;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final /* synthetic */ class c {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[Axis.values().length];
        a = r0;
        r0[Axis.X.ordinal()] = 1;
        r0[Axis.Y.ordinal()] = 2;
        r0[Axis.Z.ordinal()] = 3;
        int[] r1 = new int[RotationOrder.values().length];
        b = r1;
        r1[RotationOrder.XYZ.ordinal()] = 1;
        r1[RotationOrder.XZY.ordinal()] = 2;
        r1[RotationOrder.YXZ.ordinal()] = 3;
        r1[RotationOrder.YZX.ordinal()] = 4;
        r1[RotationOrder.ZXY.ordinal()] = 5;
        r1[RotationOrder.ZYX.ordinal()] = 6;
    }
}
