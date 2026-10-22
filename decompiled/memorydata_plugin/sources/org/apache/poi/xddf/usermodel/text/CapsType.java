package org.apache.poi.xddf.usermodel.text;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextCapsType;

/* JADX INFO: loaded from: classes7.dex */
public final enum CapsType extends Enum<CapsType> {
    private static final /* synthetic */ CapsType[] $VALUES = null;
    public static final CapsType ALL = null;
    public static final CapsType NONE = null;
    public static final CapsType SMALL = null;
    private static final HashMap<STTextCapsType.Enum, CapsType> reverse = null;
    final STTextCapsType.Enum underlying;

    static {
        int r3 = 0;
        CapsType r0 = new CapsType("ALL", 0, STTextCapsType.e);
        ALL = r0;
        CapsType r1 = new CapsType("NONE", 1, STTextCapsType.c);
        NONE = r1;
        CapsType r2 = new CapsType("SMALL", 2, STTextCapsType.d);
        SMALL = r2;
        $VALUES = new CapsType[]{r0, r1, r2};
        reverse = new HashMap();
        CapsType[] r4 = values();
        int r5 = r4.length;
    L3:
        if (r3 >= r5) goto L5;
        CapsType r6 = r4[r3];
        reverse.put(r6.underlying, r6);
        r3 = r3 + 1;
        goto L3
    }

    private CapsType(String r1, int r2, STTextCapsType.Enum r3) {
        super(r1, r2);
        this.underlying = r3;
    }

    public static CapsType valueOf(String r2) {
        return (CapsType) ZeusTransformUtils.preCheckCast(Enum.valueOf(CapsType.class, r2), CapsType.class, "com.obric.memorydata.plugin");
    }

    static CapsType valueOf(STTextCapsType.Enum r2) {
        return (CapsType) ZeusTransformUtils.preCheckCast(reverse.get(r2), CapsType.class, "com.obric.memorydata.plugin");
    }

    public static CapsType[] values() {
        return (CapsType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CapsType[].class, "com.obric.memorydata.plugin");
    }
}
