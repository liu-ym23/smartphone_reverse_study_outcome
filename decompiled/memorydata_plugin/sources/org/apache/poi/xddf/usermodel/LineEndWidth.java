package org.apache.poi.xddf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.main.STLineEndWidth;

/* JADX INFO: loaded from: classes7.dex */
public final enum LineEndWidth extends Enum<LineEndWidth> {
    private static final /* synthetic */ LineEndWidth[] $VALUES = null;
    public static final LineEndWidth LARGE = null;
    public static final LineEndWidth MEDIUM = null;
    public static final LineEndWidth SMALL = null;
    private static final HashMap<STLineEndWidth.Enum, LineEndWidth> reverse = null;
    final STLineEndWidth.Enum underlying;

    static {
        int r3 = 0;
        LineEndWidth r0 = new LineEndWidth("LARGE", 0, STLineEndWidth.e);
        LARGE = r0;
        LineEndWidth r1 = new LineEndWidth("MEDIUM", 1, STLineEndWidth.d);
        MEDIUM = r1;
        LineEndWidth r2 = new LineEndWidth("SMALL", 2, STLineEndWidth.c);
        SMALL = r2;
        $VALUES = new LineEndWidth[]{r0, r1, r2};
        reverse = new HashMap();
        LineEndWidth[] r4 = values();
        int r5 = r4.length;
    L3:
        if (r3 >= r5) goto L5;
        LineEndWidth r6 = r4[r3];
        reverse.put(r6.underlying, r6);
        r3 = r3 + 1;
        goto L3
    }

    private LineEndWidth(String r1, int r2, STLineEndWidth.Enum r3) {
        super(r1, r2);
        this.underlying = r3;
    }

    public static LineEndWidth valueOf(String r2) {
        return (LineEndWidth) ZeusTransformUtils.preCheckCast(Enum.valueOf(LineEndWidth.class, r2), LineEndWidth.class, "com.obric.memorydata.plugin");
    }

    static LineEndWidth valueOf(STLineEndWidth.Enum r2) {
        return (LineEndWidth) ZeusTransformUtils.preCheckCast(reverse.get(r2), LineEndWidth.class, "com.obric.memorydata.plugin");
    }

    public static LineEndWidth[] values() {
        return (LineEndWidth[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), LineEndWidth[].class, "com.obric.memorydata.plugin");
    }
}
