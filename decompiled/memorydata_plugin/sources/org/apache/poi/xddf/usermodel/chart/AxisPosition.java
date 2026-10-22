package org.apache.poi.xddf.usermodel.chart;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.chart.STAxPos;

/* JADX INFO: loaded from: classes7.dex */
public final enum AxisPosition extends Enum<AxisPosition> {
    private static final /* synthetic */ AxisPosition[] $VALUES = null;
    public static final AxisPosition BOTTOM = null;
    public static final AxisPosition LEFT = null;
    public static final AxisPosition RIGHT = null;
    public static final AxisPosition TOP = null;
    private static final HashMap<STAxPos.Enum, AxisPosition> reverse = null;
    final STAxPos.Enum underlying;

    static {
        int r3 = 0;
        AxisPosition r0 = new AxisPosition("BOTTOM", 0, STAxPos.c);
        BOTTOM = r0;
        AxisPosition r1 = new AxisPosition("LEFT", 1, STAxPos.d);
        LEFT = r1;
        AxisPosition r2 = new AxisPosition("RIGHT", 2, STAxPos.e);
        RIGHT = r2;
        AxisPosition r4 = new AxisPosition("TOP", 3, STAxPos.f);
        TOP = r4;
        $VALUES = new AxisPosition[]{r0, r1, r2, r4};
        reverse = new HashMap();
        AxisPosition[] r5 = values();
        int r6 = r5.length;
    L3:
        if (r3 >= r6) goto L5;
        AxisPosition r7 = r5[r3];
        reverse.put(r7.underlying, r7);
        r3 = r3 + 1;
        goto L3
    }

    private AxisPosition(String r1, int r2, STAxPos.Enum r3) {
        super(r1, r2);
        this.underlying = r3;
    }

    public static AxisPosition valueOf(String r2) {
        return (AxisPosition) ZeusTransformUtils.preCheckCast(Enum.valueOf(AxisPosition.class, r2), AxisPosition.class, "com.obric.memorydata.plugin");
    }

    static AxisPosition valueOf(STAxPos.Enum r2) {
        return (AxisPosition) ZeusTransformUtils.preCheckCast(reverse.get(r2), AxisPosition.class, "com.obric.memorydata.plugin");
    }

    public static AxisPosition[] values() {
        return (AxisPosition[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AxisPosition[].class, "com.obric.memorydata.plugin");
    }
}
