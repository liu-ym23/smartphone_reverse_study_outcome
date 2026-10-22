package org.apache.poi.xddf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.main.STLineEndType;

/* JADX INFO: loaded from: classes7.dex */
public final enum LineEndType extends Enum<LineEndType> {
    private static final /* synthetic */ LineEndType[] $VALUES = null;
    public static final LineEndType ARROW = null;
    public static final LineEndType DIAMOND = null;
    public static final LineEndType NONE = null;
    public static final LineEndType OVAL = null;
    public static final LineEndType STEALTH = null;
    public static final LineEndType TRIANGLE = null;
    private static final HashMap<STLineEndType.Enum, LineEndType> reverse = null;
    final STLineEndType.Enum underlying;

    static {
        int r3 = 0;
        LineEndType r0 = new LineEndType("ARROW", 0, STLineEndType.h);
        ARROW = r0;
        LineEndType r1 = new LineEndType("DIAMOND", 1, STLineEndType.f);
        DIAMOND = r1;
        LineEndType r2 = new LineEndType("NONE", 2, STLineEndType.c);
        NONE = r2;
        LineEndType r4 = new LineEndType("OVAL", 3, STLineEndType.g);
        OVAL = r4;
        LineEndType r6 = new LineEndType("STEALTH", 4, STLineEndType.e);
        STEALTH = r6;
        LineEndType r8 = new LineEndType("TRIANGLE", 5, STLineEndType.d);
        TRIANGLE = r8;
        $VALUES = new LineEndType[]{r0, r1, r2, r4, r6, r8};
        reverse = new HashMap();
        LineEndType[] r5 = values();
        int r7 = r5.length;
    L3:
        if (r3 >= r7) goto L5;
        LineEndType r9 = r5[r3];
        reverse.put(r9.underlying, r9);
        r3 = r3 + 1;
        goto L3
    }

    private LineEndType(String r1, int r2, STLineEndType.Enum r3) {
        super(r1, r2);
        this.underlying = r3;
    }

    public static LineEndType valueOf(String r2) {
        return (LineEndType) ZeusTransformUtils.preCheckCast(Enum.valueOf(LineEndType.class, r2), LineEndType.class, "com.obric.memorydata.plugin");
    }

    static LineEndType valueOf(STLineEndType.Enum r2) {
        return (LineEndType) ZeusTransformUtils.preCheckCast(reverse.get(r2), LineEndType.class, "com.obric.memorydata.plugin");
    }

    public static LineEndType[] values() {
        return (LineEndType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), LineEndType[].class, "com.obric.memorydata.plugin");
    }
}
