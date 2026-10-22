package org.apache.poi.xddf.usermodel.chart;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.chart.STCrossBetween;

/* JADX INFO: loaded from: classes7.dex */
public final enum AxisCrossBetween extends Enum<AxisCrossBetween> {
    private static final /* synthetic */ AxisCrossBetween[] $VALUES = null;
    public static final AxisCrossBetween BETWEEN = null;
    public static final AxisCrossBetween MIDPOINT_CATEGORY = null;
    private static final HashMap<STCrossBetween.Enum, AxisCrossBetween> reverse = null;
    final STCrossBetween.Enum underlying;

    static {
        int r3 = 0;
        AxisCrossBetween r0 = new AxisCrossBetween("BETWEEN", 0, STCrossBetween.c);
        BETWEEN = r0;
        AxisCrossBetween r1 = new AxisCrossBetween("MIDPOINT_CATEGORY", 1, STCrossBetween.d);
        MIDPOINT_CATEGORY = r1;
        $VALUES = new AxisCrossBetween[]{r0, r1};
        reverse = new HashMap();
        AxisCrossBetween[] r2 = values();
        int r4 = r2.length;
    L3:
        if (r3 >= r4) goto L5;
        AxisCrossBetween r5 = r2[r3];
        reverse.put(r5.underlying, r5);
        r3 = r3 + 1;
        goto L3
    }

    private AxisCrossBetween(String r1, int r2, STCrossBetween.Enum r3) {
        super(r1, r2);
        this.underlying = r3;
    }

    public static AxisCrossBetween valueOf(String r2) {
        return (AxisCrossBetween) ZeusTransformUtils.preCheckCast(Enum.valueOf(AxisCrossBetween.class, r2), AxisCrossBetween.class, "com.obric.memorydata.plugin");
    }

    static AxisCrossBetween valueOf(STCrossBetween.Enum r2) {
        return (AxisCrossBetween) ZeusTransformUtils.preCheckCast(reverse.get(r2), AxisCrossBetween.class, "com.obric.memorydata.plugin");
    }

    public static AxisCrossBetween[] values() {
        return (AxisCrossBetween[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AxisCrossBetween[].class, "com.obric.memorydata.plugin");
    }
}
