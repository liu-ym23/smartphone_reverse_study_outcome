package com.bytedance.android.live.core.gl.primitive;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/core/gl/primitive/RotationOrder;", "", "XYZ", "XZY", "YXZ", "YZX", "ZXY", "ZYX", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum RotationOrder extends Enum<RotationOrder> {
    public static final RotationOrder XYZ = null;
    public static final RotationOrder XZY = null;
    public static final RotationOrder YXZ = null;
    public static final RotationOrder YZX = null;
    public static final RotationOrder ZXY = null;
    public static final RotationOrder ZYX = null;
    public static final /* synthetic */ RotationOrder[] a = null;

    static {
        RotationOrder r1 = new RotationOrder("XYZ", 0);
        XYZ = r1;
        RotationOrder r2 = new RotationOrder("XZY", 1);
        XZY = r2;
        RotationOrder r3 = new RotationOrder("YXZ", 2);
        YXZ = r3;
        RotationOrder r4 = new RotationOrder("YZX", 3);
        YZX = r4;
        RotationOrder r5 = new RotationOrder("ZXY", 4);
        ZXY = r5;
        RotationOrder r6 = new RotationOrder("ZYX", 5);
        ZYX = r6;
        a = new RotationOrder[]{r1, r2, r3, r4, r5, r6};
    }

    public static RotationOrder valueOf(String r1) {
        return (RotationOrder) r27.a.a(RotationOrder.class, r1);
    }

    public static RotationOrder[] values() {
        return (RotationOrder[]) a.clone();
    }

    public RotationOrder(String r1, int r2) {
        super(r1, r2);
    }
}
