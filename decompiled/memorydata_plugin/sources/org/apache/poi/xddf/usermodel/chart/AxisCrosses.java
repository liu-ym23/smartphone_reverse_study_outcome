package org.apache.poi.xddf.usermodel.chart;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.chart.STCrosses;

/* JADX INFO: loaded from: classes7.dex */
public final enum AxisCrosses extends Enum<AxisCrosses> {
    private static final /* synthetic */ AxisCrosses[] $VALUES = null;
    public static final AxisCrosses AUTO_ZERO = null;
    public static final AxisCrosses MAX = null;
    public static final AxisCrosses MIN = null;
    private static final HashMap<STCrosses.Enum, AxisCrosses> reverse = null;
    final STCrosses.Enum underlying;

    static {
        int r3 = 0;
        AxisCrosses r0 = new AxisCrosses("AUTO_ZERO", 0, STCrosses.c);
        AUTO_ZERO = r0;
        AxisCrosses r1 = new AxisCrosses("MAX", 1, STCrosses.d);
        MAX = r1;
        AxisCrosses r2 = new AxisCrosses("MIN", 2, STCrosses.e);
        MIN = r2;
        $VALUES = new AxisCrosses[]{r0, r1, r2};
        reverse = new HashMap();
        AxisCrosses[] r4 = values();
        int r5 = r4.length;
    L3:
        if (r3 >= r5) goto L5;
        AxisCrosses r6 = r4[r3];
        reverse.put(r6.underlying, r6);
        r3 = r3 + 1;
        goto L3
    }

    private AxisCrosses(String r1, int r2, STCrosses.Enum r3) {
        super(r1, r2);
        this.underlying = r3;
    }

    public static AxisCrosses valueOf(String r2) {
        return (AxisCrosses) ZeusTransformUtils.preCheckCast(Enum.valueOf(AxisCrosses.class, r2), AxisCrosses.class, "com.obric.memorydata.plugin");
    }

    static AxisCrosses valueOf(STCrosses.Enum r2) {
        return (AxisCrosses) ZeusTransformUtils.preCheckCast(reverse.get(r2), AxisCrosses.class, "com.obric.memorydata.plugin");
    }

    public static AxisCrosses[] values() {
        return (AxisCrosses[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AxisCrosses[].class, "com.obric.memorydata.plugin");
    }
}
