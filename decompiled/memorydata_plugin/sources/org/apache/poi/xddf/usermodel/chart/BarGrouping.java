package org.apache.poi.xddf.usermodel.chart;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.chart.STBarGrouping;

/* JADX INFO: loaded from: classes7.dex */
public final enum BarGrouping extends Enum<BarGrouping> {
    private static final /* synthetic */ BarGrouping[] $VALUES = null;
    public static final BarGrouping CLUSTERED = null;
    public static final BarGrouping PERCENT_STACKED = null;
    public static final BarGrouping STACKED = null;
    public static final BarGrouping STANDARD = null;
    private static final HashMap<STBarGrouping.Enum, BarGrouping> reverse = null;
    final STBarGrouping.Enum underlying;

    static {
        int r3 = 0;
        BarGrouping r0 = new BarGrouping("STANDARD", 0, STBarGrouping.e);
        STANDARD = r0;
        BarGrouping r1 = new BarGrouping("CLUSTERED", 1, STBarGrouping.d);
        CLUSTERED = r1;
        BarGrouping r2 = new BarGrouping("STACKED", 2, STBarGrouping.f);
        STACKED = r2;
        BarGrouping r4 = new BarGrouping("PERCENT_STACKED", 3, STBarGrouping.c);
        PERCENT_STACKED = r4;
        $VALUES = new BarGrouping[]{r0, r1, r2, r4};
        reverse = new HashMap();
        BarGrouping[] r5 = values();
        int r6 = r5.length;
    L3:
        if (r3 >= r6) goto L5;
        BarGrouping r7 = r5[r3];
        reverse.put(r7.underlying, r7);
        r3 = r3 + 1;
        goto L3
    }

    private BarGrouping(String r1, int r2, STBarGrouping.Enum r3) {
        super(r1, r2);
        this.underlying = r3;
    }

    public static BarGrouping valueOf(String r2) {
        return (BarGrouping) ZeusTransformUtils.preCheckCast(Enum.valueOf(BarGrouping.class, r2), BarGrouping.class, "com.obric.memorydata.plugin");
    }

    static BarGrouping valueOf(STBarGrouping.Enum r2) {
        return (BarGrouping) ZeusTransformUtils.preCheckCast(reverse.get(r2), BarGrouping.class, "com.obric.memorydata.plugin");
    }

    public static BarGrouping[] values() {
        return (BarGrouping[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BarGrouping[].class, "com.obric.memorydata.plugin");
    }
}
