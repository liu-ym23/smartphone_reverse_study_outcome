package org.apache.poi.xddf.usermodel.chart;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.chart.STLegendPos;

/* JADX INFO: loaded from: classes7.dex */
public final enum LegendPosition extends Enum<LegendPosition> {
    private static final /* synthetic */ LegendPosition[] $VALUES = null;
    public static final LegendPosition BOTTOM = null;
    public static final LegendPosition LEFT = null;
    public static final LegendPosition RIGHT = null;
    public static final LegendPosition TOP = null;
    public static final LegendPosition TOP_RIGHT = null;
    private static final HashMap<STLegendPos.Enum, LegendPosition> reverse = null;
    final STLegendPos.Enum underlying;

    static {
        int r3 = 0;
        LegendPosition r0 = new LegendPosition("BOTTOM", 0, STLegendPos.c);
        BOTTOM = r0;
        LegendPosition r1 = new LegendPosition("LEFT", 1, STLegendPos.e);
        LEFT = r1;
        LegendPosition r2 = new LegendPosition("RIGHT", 2, STLegendPos.f);
        RIGHT = r2;
        LegendPosition r4 = new LegendPosition("TOP", 3, STLegendPos.g);
        TOP = r4;
        LegendPosition r6 = new LegendPosition("TOP_RIGHT", 4, STLegendPos.d);
        TOP_RIGHT = r6;
        $VALUES = new LegendPosition[]{r0, r1, r2, r4, r6};
        reverse = new HashMap();
        LegendPosition[] r5 = values();
        int r7 = r5.length;
    L3:
        if (r3 >= r7) goto L5;
        LegendPosition r8 = r5[r3];
        reverse.put(r8.underlying, r8);
        r3 = r3 + 1;
        goto L3
    }

    private LegendPosition(String r1, int r2, STLegendPos.Enum r3) {
        super(r1, r2);
        this.underlying = r3;
    }

    public static LegendPosition valueOf(String r2) {
        return (LegendPosition) ZeusTransformUtils.preCheckCast(Enum.valueOf(LegendPosition.class, r2), LegendPosition.class, "com.obric.memorydata.plugin");
    }

    static LegendPosition valueOf(STLegendPos.Enum r2) {
        return (LegendPosition) ZeusTransformUtils.preCheckCast(reverse.get(r2), LegendPosition.class, "com.obric.memorydata.plugin");
    }

    public static LegendPosition[] values() {
        return (LegendPosition[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), LegendPosition[].class, "com.obric.memorydata.plugin");
    }
}
