package org.apache.poi.xddf.usermodel.chart;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.chart.STTickLblPos;

/* JADX INFO: loaded from: classes7.dex */
public final enum AxisTickLabelPosition extends Enum<AxisTickLabelPosition> {
    private static final /* synthetic */ AxisTickLabelPosition[] $VALUES = null;
    public static final AxisTickLabelPosition HIGH = null;
    public static final AxisTickLabelPosition LOW = null;
    public static final AxisTickLabelPosition NEXT_TO = null;
    public static final AxisTickLabelPosition NONE = null;
    private static final HashMap<STTickLblPos.Enum, AxisTickLabelPosition> reverse = null;
    final STTickLblPos.Enum underlying;

    static {
        int r3 = 0;
        AxisTickLabelPosition r0 = new AxisTickLabelPosition("HIGH", 0, STTickLblPos.c);
        HIGH = r0;
        AxisTickLabelPosition r1 = new AxisTickLabelPosition("LOW", 1, STTickLblPos.d);
        LOW = r1;
        AxisTickLabelPosition r2 = new AxisTickLabelPosition("NEXT_TO", 2, STTickLblPos.e);
        NEXT_TO = r2;
        AxisTickLabelPosition r4 = new AxisTickLabelPosition("NONE", 3, STTickLblPos.f);
        NONE = r4;
        $VALUES = new AxisTickLabelPosition[]{r0, r1, r2, r4};
        reverse = new HashMap();
        AxisTickLabelPosition[] r5 = values();
        int r6 = r5.length;
    L3:
        if (r3 >= r6) goto L5;
        AxisTickLabelPosition r7 = r5[r3];
        reverse.put(r7.underlying, r7);
        r3 = r3 + 1;
        goto L3
    }

    private AxisTickLabelPosition(String r1, int r2, STTickLblPos.Enum r3) {
        super(r1, r2);
        this.underlying = r3;
    }

    public static AxisTickLabelPosition valueOf(String r2) {
        return (AxisTickLabelPosition) ZeusTransformUtils.preCheckCast(Enum.valueOf(AxisTickLabelPosition.class, r2), AxisTickLabelPosition.class, "com.obric.memorydata.plugin");
    }

    static AxisTickLabelPosition valueOf(STTickLblPos.Enum r2) {
        return (AxisTickLabelPosition) ZeusTransformUtils.preCheckCast(reverse.get(r2), AxisTickLabelPosition.class, "com.obric.memorydata.plugin");
    }

    public static AxisTickLabelPosition[] values() {
        return (AxisTickLabelPosition[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AxisTickLabelPosition[].class, "com.obric.memorydata.plugin");
    }
}
