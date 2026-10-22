package org.apache.poi.hwmf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.awt.Shape;
import java.awt.geom.Area;
import java.util.function.BiFunction;

/* JADX INFO: loaded from: classes7.dex */
public final enum HwmfRegionMode extends Enum<HwmfRegionMode> {
    private static final /* synthetic */ HwmfRegionMode[] $VALUES = null;
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final HwmfRegionMode RGN_AND = null;
    public static final HwmfRegionMode RGN_COMPLEMENT = null;
    public static final HwmfRegionMode RGN_COPY = null;
    public static final HwmfRegionMode RGN_DIFF = null;
    public static final HwmfRegionMode RGN_OR = null;
    public static final HwmfRegionMode RGN_XOR = null;
    private final int flag;
    private final BiFunction<Shape, Shape, Shape> op;

    static {
        HwmfRegionMode r0 = new HwmfRegionMode("RGN_AND", 0, 1, $$Lambda$HwmfRegionMode$bvY9E3yMJgRd3v7yUEEUFfriAVQ.INSTANCE);
        RGN_AND = r0;
        HwmfRegionMode r1 = new HwmfRegionMode("RGN_OR", 1, 2, $$Lambda$HwmfRegionMode$lRb8i5iq7GkNpSN85wvPGQRqgT4.INSTANCE);
        RGN_OR = r1;
        HwmfRegionMode r2 = new HwmfRegionMode("RGN_XOR", 2, 3, $$Lambda$HwmfRegionMode$Sy4Sr5wvwUhPvUbKxKM8whTXPdo.INSTANCE);
        RGN_XOR = r2;
        HwmfRegionMode r5 = new HwmfRegionMode("RGN_DIFF", 3, 4, $$Lambda$HwmfRegionMode$FRzYpqCX9eUbJqw2rPfnrDFHJKc.INSTANCE);
        RGN_DIFF = r5;
        HwmfRegionMode r7 = new HwmfRegionMode("RGN_COPY", 4, 5, $$Lambda$HwmfRegionMode$zqqUXGHlDJk4bQgo0PtRPbvxOs.INSTANCE);
        RGN_COPY = r7;
        HwmfRegionMode r9 = new HwmfRegionMode("RGN_COMPLEMENT", 5, -1, $$Lambda$HwmfRegionMode$iiodq1efjKZxUNaHDD6pzyS57JQ.INSTANCE);
        RGN_COMPLEMENT = r9;
        $VALUES = new HwmfRegionMode[]{r0, r1, r2, r5, r7, r9};
    }

    private HwmfRegionMode(String r3, int r4, int r5, BiFunction r6) {
        BiFunction<Shape, Shape, Shape> r7 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r6, BiFunction.class, "com.obric.memorydata.plugin");
        super(r3, r4);
        this.flag = r5;
        this.op = r7;
    }

    private static Shape andOp(Shape r2, Shape r3) {
        Shape r4 = (Shape) ZeusTransformUtils.wrapperContextForParams(r2, Shape.class, "com.obric.memorydata.plugin");
        Shape r5 = (Shape) ZeusTransformUtils.wrapperContextForParams(r3, Shape.class, "com.obric.memorydata.plugin");
        if (r5.getBounds2D().isEmpty() == false) goto L5;
        return r4;
    L5:
        if (r4 != null) goto L7;
        return r5;
    L7:
        Area r0 = new Area(r4);
        r0.intersect(new Area(r5));
        if (r0.getBounds2D().isEmpty() == false) goto L11;
        return r5;
    L11:
        return r0;
    }

    private static Shape complementOp(Shape r2, Shape r3) {
        Shape r4 = (Shape) ZeusTransformUtils.wrapperContextForParams(r2, Shape.class, "com.obric.memorydata.plugin");
        Shape r5 = (Shape) ZeusTransformUtils.wrapperContextForParams(r3, Shape.class, "com.obric.memorydata.plugin");
        if (r5.getBounds2D().isEmpty() == false) goto L5;
        return r4;
    L5:
        if (r4 != null) goto L7;
        return r5;
    L7:
        Area r0 = new Area(r5);
        r0.subtract(new Area(r4));
        return r0;
    }

    private static Shape copyOp(Shape r2, Shape r3) {
        Shape r4 = (Shape) ZeusTransformUtils.wrapperContextForParams(r2, Shape.class, "com.obric.memorydata.plugin");
        Shape r5 = (Shape) ZeusTransformUtils.wrapperContextForParams(r3, Shape.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
    L6:
        return null;
    L5:
        if (r5.getBounds2D().isEmpty() == true) goto L6;
        return r5;
    }

    private static Shape diffOp(Shape r2, Shape r3) {
        Shape r4 = (Shape) ZeusTransformUtils.wrapperContextForParams(r2, Shape.class, "com.obric.memorydata.plugin");
        Shape r5 = (Shape) ZeusTransformUtils.wrapperContextForParams(r3, Shape.class, "com.obric.memorydata.plugin");
        if (r5.getBounds2D().isEmpty() == false) goto L5;
        return r4;
    L5:
        if (r4 != null) goto L7;
        return r5;
    L7:
        Area r0 = new Area(r4);
        r0.subtract(new Area(r5));
        return r0;
    }

    public static /* synthetic */ Shape lambda$FRzYpqCX9eUbJqw2rPfnrDFHJKc(Shape r0, Shape r1) {
        return diffOp(r0, r1);
    }

    public static /* synthetic */ Shape lambda$Sy4Sr5wvwUhPvUbKxKM8whTXPdo(Shape r0, Shape r1) {
        return xorOp(r0, r1);
    }

    public static /* synthetic */ Shape lambda$bvY9E3yMJgRd3v7yUEEUFfriAVQ(Shape r0, Shape r1) {
        return andOp(r0, r1);
    }

    public static /* synthetic */ Shape lambda$iiodq1efjKZxUNaHDD6pzyS57JQ(Shape r0, Shape r1) {
        return complementOp(r0, r1);
    }

    public static /* synthetic */ Shape lambda$lRb8i5iq7GkNpSN85wvPGQRqgT4(Shape r0, Shape r1) {
        return orOp(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$z-qqUXGHlDJk4bQgo0PtRPbvxOs, reason: not valid java name */
    public static /* synthetic */ Shape m3169lambda$zqqUXGHlDJk4bQgo0PtRPbvxOs(Shape r0, Shape r1) {
        return copyOp(r0, r1);
    }

    private static Shape orOp(Shape r2, Shape r3) {
        Shape r4 = (Shape) ZeusTransformUtils.wrapperContextForParams(r2, Shape.class, "com.obric.memorydata.plugin");
        Shape r5 = (Shape) ZeusTransformUtils.wrapperContextForParams(r3, Shape.class, "com.obric.memorydata.plugin");
        if (r5.getBounds2D().isEmpty() == false) goto L5;
        return r4;
    L5:
        if (r4 != null) goto L7;
        return r5;
    L7:
        Area r0 = new Area(r4);
        r0.add(new Area(r5));
        return r0;
    }

    public static HwmfRegionMode valueOf(int r5) {
        HwmfRegionMode[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        HwmfRegionMode r3 = r0[r2];
        if (r3.flag == r5) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L8:
        return null;
    }

    public static HwmfRegionMode valueOf(String r2) {
        return (HwmfRegionMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(HwmfRegionMode.class, r2), HwmfRegionMode.class, "com.obric.memorydata.plugin");
    }

    public static HwmfRegionMode[] values() {
        return (HwmfRegionMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HwmfRegionMode[].class, "com.obric.memorydata.plugin");
    }

    private static Shape xorOp(Shape r2, Shape r3) {
        Shape r4 = (Shape) ZeusTransformUtils.wrapperContextForParams(r2, Shape.class, "com.obric.memorydata.plugin");
        Shape r5 = (Shape) ZeusTransformUtils.wrapperContextForParams(r3, Shape.class, "com.obric.memorydata.plugin");
        if (r5.getBounds2D().isEmpty() == false) goto L5;
        return r4;
    L5:
        if (r4 != null) goto L7;
        return r5;
    L7:
        Area r0 = new Area(r4);
        r0.exclusiveOr(new Area(r5));
        return r0;
    }

    public Shape applyOp(Shape r3, Shape r4) {
        Shape r5 = (Shape) ZeusTransformUtils.wrapperContextForParams(r3, Shape.class, "com.obric.memorydata.plugin");
        Shape r6 = (Shape) ZeusTransformUtils.wrapperContextForParams(r4, Shape.class, "com.obric.memorydata.plugin");
        return (Shape) ZeusTransformUtils.preCheckCast(this.op.apply(r5, r6), Shape.class, "com.obric.memorydata.plugin");
    }

    public int getFlag() {
        return this.flag;
    }
}
