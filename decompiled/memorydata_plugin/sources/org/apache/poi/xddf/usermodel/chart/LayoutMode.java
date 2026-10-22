package org.apache.poi.xddf.usermodel.chart;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.chart.STLayoutMode;

/* JADX INFO: loaded from: classes7.dex */
public final enum LayoutMode extends Enum<LayoutMode> {
    private static final /* synthetic */ LayoutMode[] $VALUES = null;
    public static final LayoutMode EDGE = null;
    public static final LayoutMode FACTOR = null;
    private static final HashMap<STLayoutMode.Enum, LayoutMode> reverse = null;
    final STLayoutMode.Enum underlying;

    static {
        int r3 = 0;
        LayoutMode r0 = new LayoutMode("EDGE", 0, STLayoutMode.c);
        EDGE = r0;
        LayoutMode r1 = new LayoutMode("FACTOR", 1, STLayoutMode.d);
        FACTOR = r1;
        $VALUES = new LayoutMode[]{r0, r1};
        reverse = new HashMap();
        LayoutMode[] r2 = values();
        int r4 = r2.length;
    L3:
        if (r3 >= r4) goto L5;
        LayoutMode r5 = r2[r3];
        reverse.put(r5.underlying, r5);
        r3 = r3 + 1;
        goto L3
    }

    private LayoutMode(String r1, int r2, STLayoutMode.Enum r3) {
        super(r1, r2);
        this.underlying = r3;
    }

    public static LayoutMode valueOf(String r2) {
        return (LayoutMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(LayoutMode.class, r2), LayoutMode.class, "com.obric.memorydata.plugin");
    }

    static LayoutMode valueOf(STLayoutMode.Enum r2) {
        return (LayoutMode) ZeusTransformUtils.preCheckCast(reverse.get(r2), LayoutMode.class, "com.obric.memorydata.plugin");
    }

    public static LayoutMode[] values() {
        return (LayoutMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), LayoutMode[].class, "com.obric.memorydata.plugin");
    }
}
