package org.apache.poi.xddf.usermodel.chart;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.chart.STLayoutTarget;

/* JADX INFO: loaded from: classes7.dex */
public final enum LayoutTarget extends Enum<LayoutTarget> {
    private static final /* synthetic */ LayoutTarget[] $VALUES = null;
    public static final LayoutTarget INNER = null;
    public static final LayoutTarget OUTER = null;
    private static final HashMap<STLayoutTarget.Enum, LayoutTarget> reverse = null;
    final STLayoutTarget.Enum underlying;

    static {
        int r3 = 0;
        LayoutTarget r0 = new LayoutTarget("INNER", 0, STLayoutTarget.c);
        INNER = r0;
        LayoutTarget r1 = new LayoutTarget("OUTER", 1, STLayoutTarget.d);
        OUTER = r1;
        $VALUES = new LayoutTarget[]{r0, r1};
        reverse = new HashMap();
        LayoutTarget[] r2 = values();
        int r4 = r2.length;
    L3:
        if (r3 >= r4) goto L5;
        LayoutTarget r5 = r2[r3];
        reverse.put(r5.underlying, r5);
        r3 = r3 + 1;
        goto L3
    }

    private LayoutTarget(String r1, int r2, STLayoutTarget.Enum r3) {
        super(r1, r2);
        this.underlying = r3;
    }

    public static LayoutTarget valueOf(String r2) {
        return (LayoutTarget) ZeusTransformUtils.preCheckCast(Enum.valueOf(LayoutTarget.class, r2), LayoutTarget.class, "com.obric.memorydata.plugin");
    }

    static LayoutTarget valueOf(STLayoutTarget.Enum r2) {
        return (LayoutTarget) ZeusTransformUtils.preCheckCast(reverse.get(r2), LayoutTarget.class, "com.obric.memorydata.plugin");
    }

    public static LayoutTarget[] values() {
        return (LayoutTarget[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), LayoutTarget[].class, "com.obric.memorydata.plugin");
    }
}
