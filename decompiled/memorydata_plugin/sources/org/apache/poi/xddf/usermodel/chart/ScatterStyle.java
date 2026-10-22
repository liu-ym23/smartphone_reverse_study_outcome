package org.apache.poi.xddf.usermodel.chart;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.chart.STScatterStyle;

/* JADX INFO: loaded from: classes7.dex */
public final enum ScatterStyle extends Enum<ScatterStyle> {
    private static final /* synthetic */ ScatterStyle[] $VALUES = null;
    public static final ScatterStyle LINE = null;
    public static final ScatterStyle LINE_MARKER = null;
    public static final ScatterStyle MARKER = null;
    public static final ScatterStyle NONE = null;
    public static final ScatterStyle SMOOTH = null;
    public static final ScatterStyle SMOOTH_MARKER = null;
    private static final HashMap<STScatterStyle.Enum, ScatterStyle> reverse = null;
    final STScatterStyle.Enum underlying;

    static {
        int r3 = 0;
        ScatterStyle r0 = new ScatterStyle("LINE", 0, STScatterStyle.d);
        LINE = r0;
        ScatterStyle r1 = new ScatterStyle("LINE_MARKER", 1, STScatterStyle.e);
        LINE_MARKER = r1;
        ScatterStyle r2 = new ScatterStyle("MARKER", 2, STScatterStyle.f);
        MARKER = r2;
        ScatterStyle r4 = new ScatterStyle("NONE", 3, STScatterStyle.c);
        NONE = r4;
        ScatterStyle r6 = new ScatterStyle("SMOOTH", 4, STScatterStyle.g);
        SMOOTH = r6;
        ScatterStyle r8 = new ScatterStyle("SMOOTH_MARKER", 5, STScatterStyle.h);
        SMOOTH_MARKER = r8;
        $VALUES = new ScatterStyle[]{r0, r1, r2, r4, r6, r8};
        reverse = new HashMap();
        ScatterStyle[] r5 = values();
        int r7 = r5.length;
    L3:
        if (r3 >= r7) goto L5;
        ScatterStyle r9 = r5[r3];
        reverse.put(r9.underlying, r9);
        r3 = r3 + 1;
        goto L3
    }

    private ScatterStyle(String r1, int r2, STScatterStyle.Enum r3) {
        super(r1, r2);
        this.underlying = r3;
    }

    public static ScatterStyle valueOf(String r2) {
        return (ScatterStyle) ZeusTransformUtils.preCheckCast(Enum.valueOf(ScatterStyle.class, r2), ScatterStyle.class, "com.obric.memorydata.plugin");
    }

    static ScatterStyle valueOf(STScatterStyle.Enum r2) {
        return (ScatterStyle) ZeusTransformUtils.preCheckCast(reverse.get(r2), ScatterStyle.class, "com.obric.memorydata.plugin");
    }

    public static ScatterStyle[] values() {
        return (ScatterStyle[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ScatterStyle[].class, "com.obric.memorydata.plugin");
    }
}
