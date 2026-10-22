package org.apache.poi.xddf.usermodel.chart;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.chart.STLblAlgn;

/* JADX INFO: loaded from: classes7.dex */
public final enum AxisLabelAlignment extends Enum<AxisLabelAlignment> {
    private static final /* synthetic */ AxisLabelAlignment[] $VALUES = null;
    public static final AxisLabelAlignment CENTER = null;
    public static final AxisLabelAlignment LEFT = null;
    public static final AxisLabelAlignment RIGHT = null;
    private static final HashMap<STLblAlgn.Enum, AxisLabelAlignment> reverse = null;
    final STLblAlgn.Enum underlying;

    static {
        int r3 = 0;
        AxisLabelAlignment r0 = new AxisLabelAlignment("CENTER", 0, STLblAlgn.c);
        CENTER = r0;
        AxisLabelAlignment r1 = new AxisLabelAlignment("LEFT", 1, STLblAlgn.d);
        LEFT = r1;
        AxisLabelAlignment r2 = new AxisLabelAlignment("RIGHT", 2, STLblAlgn.e);
        RIGHT = r2;
        $VALUES = new AxisLabelAlignment[]{r0, r1, r2};
        reverse = new HashMap();
        AxisLabelAlignment[] r4 = values();
        int r5 = r4.length;
    L3:
        if (r3 >= r5) goto L5;
        AxisLabelAlignment r6 = r4[r3];
        reverse.put(r6.underlying, r6);
        r3 = r3 + 1;
        goto L3
    }

    private AxisLabelAlignment(String r1, int r2, STLblAlgn.Enum r3) {
        super(r1, r2);
        this.underlying = r3;
    }

    public static AxisLabelAlignment valueOf(String r2) {
        return (AxisLabelAlignment) ZeusTransformUtils.preCheckCast(Enum.valueOf(AxisLabelAlignment.class, r2), AxisLabelAlignment.class, "com.obric.memorydata.plugin");
    }

    static AxisLabelAlignment valueOf(STLblAlgn.Enum r2) {
        return (AxisLabelAlignment) ZeusTransformUtils.preCheckCast(reverse.get(r2), AxisLabelAlignment.class, "com.obric.memorydata.plugin");
    }

    public static AxisLabelAlignment[] values() {
        return (AxisLabelAlignment[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AxisLabelAlignment[].class, "com.obric.memorydata.plugin");
    }
}
