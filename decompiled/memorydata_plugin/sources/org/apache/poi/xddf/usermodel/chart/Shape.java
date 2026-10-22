package org.apache.poi.xddf.usermodel.chart;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.chart.STShape;

/* JADX INFO: loaded from: classes7.dex */
public final enum Shape extends Enum<Shape> {
    private static final /* synthetic */ Shape[] $VALUES = null;
    public static final Shape BOX = null;
    public static final Shape CONE = null;
    public static final Shape CONE_TO_MAX = null;
    public static final Shape CYLINDER = null;
    public static final Shape PYRAMID = null;
    public static final Shape PYRAMID_TO_MAX = null;
    private static final HashMap<STShape.Enum, Shape> reverse = null;
    final STShape.Enum underlying;

    static {
        int r3 = 0;
        Shape r0 = new Shape("BOX", 0, STShape.e);
        BOX = r0;
        Shape r1 = new Shape("CONE", 1, STShape.c);
        CONE = r1;
        Shape r2 = new Shape("CONE_TO_MAX", 2, STShape.d);
        CONE_TO_MAX = r2;
        Shape r4 = new Shape("CYLINDER", 3, STShape.f);
        CYLINDER = r4;
        Shape r6 = new Shape("PYRAMID", 4, STShape.g);
        PYRAMID = r6;
        Shape r8 = new Shape("PYRAMID_TO_MAX", 5, STShape.h);
        PYRAMID_TO_MAX = r8;
        $VALUES = new Shape[]{r0, r1, r2, r4, r6, r8};
        reverse = new HashMap();
        Shape[] r5 = values();
        int r7 = r5.length;
    L3:
        if (r3 >= r7) goto L5;
        Shape r9 = r5[r3];
        reverse.put(r9.underlying, r9);
        r3 = r3 + 1;
        goto L3
    }

    private Shape(String r1, int r2, STShape.Enum r3) {
        super(r1, r2);
        this.underlying = r3;
    }

    public static Shape valueOf(String r2) {
        return (Shape) ZeusTransformUtils.preCheckCast(Enum.valueOf(Shape.class, r2), Shape.class, "com.obric.memorydata.plugin");
    }

    static Shape valueOf(STShape.Enum r2) {
        return (Shape) ZeusTransformUtils.preCheckCast(reverse.get(r2), Shape.class, "com.obric.memorydata.plugin");
    }

    public static Shape[] values() {
        return (Shape[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Shape[].class, "com.obric.memorydata.plugin");
    }
}
