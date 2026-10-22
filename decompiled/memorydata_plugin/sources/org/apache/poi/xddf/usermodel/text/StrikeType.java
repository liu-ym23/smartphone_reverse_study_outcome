package org.apache.poi.xddf.usermodel.text;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextStrikeType;

/* JADX INFO: loaded from: classes7.dex */
public final enum StrikeType extends Enum<StrikeType> {
    private static final /* synthetic */ StrikeType[] $VALUES = null;
    public static final StrikeType DOUBLE_STRIKE = null;
    public static final StrikeType NO_STRIKE = null;
    public static final StrikeType SINGLE_STRIKE = null;
    private static final HashMap<STTextStrikeType.Enum, StrikeType> reverse = null;
    final STTextStrikeType.Enum underlying;

    static {
        int r3 = 0;
        StrikeType r0 = new StrikeType("DOUBLE_STRIKE", 0, STTextStrikeType.e);
        DOUBLE_STRIKE = r0;
        StrikeType r1 = new StrikeType("NO_STRIKE", 1, STTextStrikeType.c);
        NO_STRIKE = r1;
        StrikeType r2 = new StrikeType("SINGLE_STRIKE", 2, STTextStrikeType.d);
        SINGLE_STRIKE = r2;
        $VALUES = new StrikeType[]{r0, r1, r2};
        reverse = new HashMap();
        StrikeType[] r4 = values();
        int r5 = r4.length;
    L3:
        if (r3 >= r5) goto L5;
        StrikeType r6 = r4[r3];
        reverse.put(r6.underlying, r6);
        r3 = r3 + 1;
        goto L3
    }

    private StrikeType(String r1, int r2, STTextStrikeType.Enum r3) {
        super(r1, r2);
        this.underlying = r3;
    }

    public static StrikeType valueOf(String r2) {
        return (StrikeType) ZeusTransformUtils.preCheckCast(Enum.valueOf(StrikeType.class, r2), StrikeType.class, "com.obric.memorydata.plugin");
    }

    static StrikeType valueOf(STTextStrikeType.Enum r2) {
        return (StrikeType) ZeusTransformUtils.preCheckCast(reverse.get(r2), StrikeType.class, "com.obric.memorydata.plugin");
    }

    public static StrikeType[] values() {
        return (StrikeType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), StrikeType[].class, "com.obric.memorydata.plugin");
    }
}
