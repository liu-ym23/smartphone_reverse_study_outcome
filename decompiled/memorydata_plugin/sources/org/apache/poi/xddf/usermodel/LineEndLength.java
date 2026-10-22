package org.apache.poi.xddf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.main.STLineEndLength;

/* JADX INFO: loaded from: classes7.dex */
public final enum LineEndLength extends Enum<LineEndLength> {
    private static final /* synthetic */ LineEndLength[] $VALUES = null;
    public static final LineEndLength LARGE = null;
    public static final LineEndLength MEDIUM = null;
    public static final LineEndLength SMALL = null;
    private static final HashMap<STLineEndLength.Enum, LineEndLength> reverse = null;
    final STLineEndLength.Enum underlying;

    static {
        int r3 = 0;
        LineEndLength r0 = new LineEndLength("LARGE", 0, STLineEndLength.e);
        LARGE = r0;
        LineEndLength r1 = new LineEndLength("MEDIUM", 1, STLineEndLength.d);
        MEDIUM = r1;
        LineEndLength r2 = new LineEndLength("SMALL", 2, STLineEndLength.c);
        SMALL = r2;
        $VALUES = new LineEndLength[]{r0, r1, r2};
        reverse = new HashMap();
        LineEndLength[] r4 = values();
        int r5 = r4.length;
    L3:
        if (r3 >= r5) goto L5;
        LineEndLength r6 = r4[r3];
        reverse.put(r6.underlying, r6);
        r3 = r3 + 1;
        goto L3
    }

    private LineEndLength(String r1, int r2, STLineEndLength.Enum r3) {
        super(r1, r2);
        this.underlying = r3;
    }

    public static LineEndLength valueOf(String r2) {
        return (LineEndLength) ZeusTransformUtils.preCheckCast(Enum.valueOf(LineEndLength.class, r2), LineEndLength.class, "com.obric.memorydata.plugin");
    }

    static LineEndLength valueOf(STLineEndLength.Enum r2) {
        return (LineEndLength) ZeusTransformUtils.preCheckCast(reverse.get(r2), LineEndLength.class, "com.obric.memorydata.plugin");
    }

    public static LineEndLength[] values() {
        return (LineEndLength[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), LineEndLength[].class, "com.obric.memorydata.plugin");
    }
}
