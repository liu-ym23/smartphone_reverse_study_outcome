package org.apache.poi.xddf.usermodel.chart;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.chart.STTickMark;

/* JADX INFO: loaded from: classes7.dex */
public final enum AxisTickMark extends Enum<AxisTickMark> {
    private static final /* synthetic */ AxisTickMark[] $VALUES = null;
    public static final AxisTickMark CROSS = null;
    public static final AxisTickMark IN = null;
    public static final AxisTickMark NONE = null;
    public static final AxisTickMark OUT = null;
    private static final HashMap<STTickMark.Enum, AxisTickMark> reverse = null;
    final STTickMark.Enum underlying;

    static {
        int r3 = 0;
        AxisTickMark r0 = new AxisTickMark("CROSS", 0, STTickMark.c);
        CROSS = r0;
        AxisTickMark r1 = new AxisTickMark("IN", 1, STTickMark.d);
        IN = r1;
        AxisTickMark r2 = new AxisTickMark("NONE", 2, STTickMark.e);
        NONE = r2;
        AxisTickMark r4 = new AxisTickMark("OUT", 3, STTickMark.f);
        OUT = r4;
        $VALUES = new AxisTickMark[]{r0, r1, r2, r4};
        reverse = new HashMap();
        AxisTickMark[] r5 = values();
        int r6 = r5.length;
    L3:
        if (r3 >= r6) goto L5;
        AxisTickMark r7 = r5[r3];
        reverse.put(r7.underlying, r7);
        r3 = r3 + 1;
        goto L3
    }

    private AxisTickMark(String r1, int r2, STTickMark.Enum r3) {
        super(r1, r2);
        this.underlying = r3;
    }

    public static AxisTickMark valueOf(String r2) {
        return (AxisTickMark) ZeusTransformUtils.preCheckCast(Enum.valueOf(AxisTickMark.class, r2), AxisTickMark.class, "com.obric.memorydata.plugin");
    }

    static AxisTickMark valueOf(STTickMark.Enum r2) {
        return (AxisTickMark) ZeusTransformUtils.preCheckCast(reverse.get(r2), AxisTickMark.class, "com.obric.memorydata.plugin");
    }

    public static AxisTickMark[] values() {
        return (AxisTickMark[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AxisTickMark[].class, "com.obric.memorydata.plugin");
    }
}
