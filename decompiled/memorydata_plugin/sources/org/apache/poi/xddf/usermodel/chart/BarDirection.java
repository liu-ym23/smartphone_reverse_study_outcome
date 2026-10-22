package org.apache.poi.xddf.usermodel.chart;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.chart.STBarDir;

/* JADX INFO: loaded from: classes7.dex */
public final enum BarDirection extends Enum<BarDirection> {
    private static final /* synthetic */ BarDirection[] $VALUES = null;
    public static final BarDirection BAR = null;
    public static final BarDirection COL = null;
    private static final HashMap<STBarDir.Enum, BarDirection> reverse = null;
    final STBarDir.Enum underlying;

    static {
        int r3 = 0;
        BarDirection r0 = new BarDirection("BAR", 0, STBarDir.c);
        BAR = r0;
        BarDirection r1 = new BarDirection("COL", 1, STBarDir.d);
        COL = r1;
        $VALUES = new BarDirection[]{r0, r1};
        reverse = new HashMap();
        BarDirection[] r2 = values();
        int r4 = r2.length;
    L3:
        if (r3 >= r4) goto L5;
        BarDirection r5 = r2[r3];
        reverse.put(r5.underlying, r5);
        r3 = r3 + 1;
        goto L3
    }

    private BarDirection(String r1, int r2, STBarDir.Enum r3) {
        super(r1, r2);
        this.underlying = r3;
    }

    public static BarDirection valueOf(String r2) {
        return (BarDirection) ZeusTransformUtils.preCheckCast(Enum.valueOf(BarDirection.class, r2), BarDirection.class, "com.obric.memorydata.plugin");
    }

    static BarDirection valueOf(STBarDir.Enum r2) {
        return (BarDirection) ZeusTransformUtils.preCheckCast(reverse.get(r2), BarDirection.class, "com.obric.memorydata.plugin");
    }

    public static BarDirection[] values() {
        return (BarDirection[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BarDirection[].class, "com.obric.memorydata.plugin");
    }
}
