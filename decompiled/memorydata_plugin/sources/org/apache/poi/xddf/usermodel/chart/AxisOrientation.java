package org.apache.poi.xddf.usermodel.chart;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.chart.STOrientation;

/* JADX INFO: loaded from: classes7.dex */
public final enum AxisOrientation extends Enum<AxisOrientation> {
    private static final /* synthetic */ AxisOrientation[] $VALUES = null;
    public static final AxisOrientation MAX_MIN = null;
    public static final AxisOrientation MIN_MAX = null;
    private static final HashMap<STOrientation.Enum, AxisOrientation> reverse = null;
    final STOrientation.Enum underlying;

    static {
        int r3 = 0;
        AxisOrientation r0 = new AxisOrientation("MIN_MAX", 0, STOrientation.d);
        MIN_MAX = r0;
        AxisOrientation r1 = new AxisOrientation("MAX_MIN", 1, STOrientation.c);
        MAX_MIN = r1;
        $VALUES = new AxisOrientation[]{r0, r1};
        reverse = new HashMap();
        AxisOrientation[] r2 = values();
        int r4 = r2.length;
    L3:
        if (r3 >= r4) goto L5;
        AxisOrientation r5 = r2[r3];
        reverse.put(r5.underlying, r5);
        r3 = r3 + 1;
        goto L3
    }

    private AxisOrientation(String r1, int r2, STOrientation.Enum r3) {
        super(r1, r2);
        this.underlying = r3;
    }

    public static AxisOrientation valueOf(String r2) {
        return (AxisOrientation) ZeusTransformUtils.preCheckCast(Enum.valueOf(AxisOrientation.class, r2), AxisOrientation.class, "com.obric.memorydata.plugin");
    }

    static AxisOrientation valueOf(STOrientation.Enum r2) {
        return (AxisOrientation) ZeusTransformUtils.preCheckCast(reverse.get(r2), AxisOrientation.class, "com.obric.memorydata.plugin");
    }

    public static AxisOrientation[] values() {
        return (AxisOrientation[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AxisOrientation[].class, "com.obric.memorydata.plugin");
    }
}
