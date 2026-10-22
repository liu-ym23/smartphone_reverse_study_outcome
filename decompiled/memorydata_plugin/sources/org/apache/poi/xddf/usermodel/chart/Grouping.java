package org.apache.poi.xddf.usermodel.chart;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.chart.STGrouping;

/* JADX INFO: loaded from: classes7.dex */
public final enum Grouping extends Enum<Grouping> {
    private static final /* synthetic */ Grouping[] $VALUES = null;
    public static final Grouping PERCENT_STACKED = null;
    public static final Grouping STACKED = null;
    public static final Grouping STANDARD = null;
    private static final HashMap<STGrouping.Enum, Grouping> reverse = null;
    final STGrouping.Enum underlying;

    static {
        int r3 = 0;
        Grouping r0 = new Grouping("STANDARD", 0, STGrouping.d);
        STANDARD = r0;
        Grouping r1 = new Grouping("STACKED", 1, STGrouping.e);
        STACKED = r1;
        Grouping r2 = new Grouping("PERCENT_STACKED", 2, STGrouping.c);
        PERCENT_STACKED = r2;
        $VALUES = new Grouping[]{r0, r1, r2};
        reverse = new HashMap();
        Grouping[] r4 = values();
        int r5 = r4.length;
    L3:
        if (r3 >= r5) goto L5;
        Grouping r6 = r4[r3];
        reverse.put(r6.underlying, r6);
        r3 = r3 + 1;
        goto L3
    }

    private Grouping(String r1, int r2, STGrouping.Enum r3) {
        super(r1, r2);
        this.underlying = r3;
    }

    public static Grouping valueOf(String r2) {
        return (Grouping) ZeusTransformUtils.preCheckCast(Enum.valueOf(Grouping.class, r2), Grouping.class, "com.obric.memorydata.plugin");
    }

    static Grouping valueOf(STGrouping.Enum r2) {
        return (Grouping) ZeusTransformUtils.preCheckCast(reverse.get(r2), Grouping.class, "com.obric.memorydata.plugin");
    }

    public static Grouping[] values() {
        return (Grouping[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Grouping[].class, "com.obric.memorydata.plugin");
    }
}
