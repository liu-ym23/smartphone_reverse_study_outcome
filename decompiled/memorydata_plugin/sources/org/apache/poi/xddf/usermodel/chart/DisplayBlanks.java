package org.apache.poi.xddf.usermodel.chart;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.chart.STDispBlanksAs;

/* JADX INFO: loaded from: classes7.dex */
public final enum DisplayBlanks extends Enum<DisplayBlanks> {
    private static final /* synthetic */ DisplayBlanks[] $VALUES = null;
    public static final DisplayBlanks GAP = null;
    public static final DisplayBlanks SPAN = null;
    public static final DisplayBlanks ZERO = null;
    private static final HashMap<STDispBlanksAs.Enum, DisplayBlanks> reverse = null;
    final STDispBlanksAs.Enum underlying;

    static {
        int r3 = 0;
        DisplayBlanks r0 = new DisplayBlanks("GAP", 0, STDispBlanksAs.d);
        GAP = r0;
        DisplayBlanks r1 = new DisplayBlanks("SPAN", 1, STDispBlanksAs.c);
        SPAN = r1;
        DisplayBlanks r2 = new DisplayBlanks("ZERO", 2, STDispBlanksAs.e);
        ZERO = r2;
        $VALUES = new DisplayBlanks[]{r0, r1, r2};
        reverse = new HashMap();
        DisplayBlanks[] r4 = values();
        int r5 = r4.length;
    L3:
        if (r3 >= r5) goto L5;
        DisplayBlanks r6 = r4[r3];
        reverse.put(r6.underlying, r6);
        r3 = r3 + 1;
        goto L3
    }

    private DisplayBlanks(String r1, int r2, STDispBlanksAs.Enum r3) {
        super(r1, r2);
        this.underlying = r3;
    }

    public static DisplayBlanks valueOf(String r2) {
        return (DisplayBlanks) ZeusTransformUtils.preCheckCast(Enum.valueOf(DisplayBlanks.class, r2), DisplayBlanks.class, "com.obric.memorydata.plugin");
    }

    static DisplayBlanks valueOf(STDispBlanksAs.Enum r2) {
        return (DisplayBlanks) ZeusTransformUtils.preCheckCast(reverse.get(r2), DisplayBlanks.class, "com.obric.memorydata.plugin");
    }

    public static DisplayBlanks[] values() {
        return (DisplayBlanks[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DisplayBlanks[].class, "com.obric.memorydata.plugin");
    }
}
