package org.apache.poi.xddf.usermodel.text;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextAnchoringType;

/* JADX INFO: loaded from: classes7.dex */
public final enum AnchorType extends Enum<AnchorType> {
    private static final /* synthetic */ AnchorType[] $VALUES = null;
    public static final AnchorType BOTTOM = null;
    public static final AnchorType CENTER = null;
    public static final AnchorType DISTRIBUTED = null;
    public static final AnchorType JUSTIFIED = null;
    public static final AnchorType TOP = null;
    private static final HashMap<STTextAnchoringType.Enum, AnchorType> reverse = null;
    final STTextAnchoringType.Enum underlying;

    static {
        int r3 = 0;
        AnchorType r0 = new AnchorType("BOTTOM", 0, STTextAnchoringType.e);
        BOTTOM = r0;
        AnchorType r1 = new AnchorType("CENTER", 1, STTextAnchoringType.d);
        CENTER = r1;
        AnchorType r2 = new AnchorType("DISTRIBUTED", 2, STTextAnchoringType.g);
        DISTRIBUTED = r2;
        AnchorType r4 = new AnchorType("JUSTIFIED", 3, STTextAnchoringType.f);
        JUSTIFIED = r4;
        AnchorType r6 = new AnchorType("TOP", 4, STTextAnchoringType.c);
        TOP = r6;
        $VALUES = new AnchorType[]{r0, r1, r2, r4, r6};
        reverse = new HashMap();
        AnchorType[] r5 = values();
        int r7 = r5.length;
    L3:
        if (r3 >= r7) goto L5;
        AnchorType r8 = r5[r3];
        reverse.put(r8.underlying, r8);
        r3 = r3 + 1;
        goto L3
    }

    private AnchorType(String r1, int r2, STTextAnchoringType.Enum r3) {
        super(r1, r2);
        this.underlying = r3;
    }

    public static AnchorType valueOf(String r2) {
        return (AnchorType) ZeusTransformUtils.preCheckCast(Enum.valueOf(AnchorType.class, r2), AnchorType.class, "com.obric.memorydata.plugin");
    }

    static AnchorType valueOf(STTextAnchoringType.Enum r2) {
        return (AnchorType) ZeusTransformUtils.preCheckCast(reverse.get(r2), AnchorType.class, "com.obric.memorydata.plugin");
    }

    public static AnchorType[] values() {
        return (AnchorType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AnchorType[].class, "com.obric.memorydata.plugin");
    }
}
