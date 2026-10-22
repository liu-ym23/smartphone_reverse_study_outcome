package org.apache.poi.xddf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.main.STPathShadeType;

/* JADX INFO: loaded from: classes7.dex */
public final enum PathShadeType extends Enum<PathShadeType> {
    private static final /* synthetic */ PathShadeType[] $VALUES = null;
    public static final PathShadeType CIRCLE = null;
    public static final PathShadeType RECTANGLE = null;
    public static final PathShadeType SHAPE = null;
    private static final HashMap<STPathShadeType.Enum, PathShadeType> reverse = null;
    final STPathShadeType.Enum underlying;

    static {
        int r3 = 0;
        PathShadeType r0 = new PathShadeType("CIRCLE", 0, STPathShadeType.d);
        CIRCLE = r0;
        PathShadeType r1 = new PathShadeType("RECTANGLE", 1, STPathShadeType.e);
        RECTANGLE = r1;
        PathShadeType r2 = new PathShadeType("SHAPE", 2, STPathShadeType.c);
        SHAPE = r2;
        $VALUES = new PathShadeType[]{r0, r1, r2};
        reverse = new HashMap();
        PathShadeType[] r4 = values();
        int r5 = r4.length;
    L3:
        if (r3 >= r5) goto L5;
        PathShadeType r6 = r4[r3];
        reverse.put(r6.underlying, r6);
        r3 = r3 + 1;
        goto L3
    }

    private PathShadeType(String r1, int r2, STPathShadeType.Enum r3) {
        super(r1, r2);
        this.underlying = r3;
    }

    public static PathShadeType valueOf(String r2) {
        return (PathShadeType) ZeusTransformUtils.preCheckCast(Enum.valueOf(PathShadeType.class, r2), PathShadeType.class, "com.obric.memorydata.plugin");
    }

    static PathShadeType valueOf(STPathShadeType.Enum r2) {
        return (PathShadeType) ZeusTransformUtils.preCheckCast(reverse.get(r2), PathShadeType.class, "com.obric.memorydata.plugin");
    }

    public static PathShadeType[] values() {
        return (PathShadeType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PathShadeType[].class, "com.obric.memorydata.plugin");
    }
}
