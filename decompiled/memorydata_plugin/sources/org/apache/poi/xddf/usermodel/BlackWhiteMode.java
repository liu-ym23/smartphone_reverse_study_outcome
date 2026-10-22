package org.apache.poi.xddf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.main.STBlackWhiteMode;

/* JADX INFO: loaded from: classes7.dex */
public final enum BlackWhiteMode extends Enum<BlackWhiteMode> {
    private static final /* synthetic */ BlackWhiteMode[] $VALUES = null;
    public static final BlackWhiteMode AUTO = null;
    public static final BlackWhiteMode BLACK = null;
    public static final BlackWhiteMode BLACK_GRAY = null;
    public static final BlackWhiteMode BLACK_WHITE = null;
    private static final HashMap<STBlackWhiteMode.Enum, BlackWhiteMode> reverse = null;
    final STBlackWhiteMode.Enum underlying;

    static {
        int r3 = 0;
        BlackWhiteMode r0 = new BlackWhiteMode("AUTO", 0, STBlackWhiteMode.d);
        AUTO = r0;
        BlackWhiteMode r1 = new BlackWhiteMode("BLACK", 1, STBlackWhiteMode.k);
        BLACK = r1;
        BlackWhiteMode r2 = new BlackWhiteMode("BLACK_GRAY", 2, STBlackWhiteMode.i);
        BLACK_GRAY = r2;
        BlackWhiteMode r4 = new BlackWhiteMode("BLACK_WHITE", 3, STBlackWhiteMode.j);
        BLACK_WHITE = r4;
        $VALUES = new BlackWhiteMode[]{r0, r1, r2, r4};
        reverse = new HashMap();
        BlackWhiteMode[] r5 = values();
        int r6 = r5.length;
    L3:
        if (r3 >= r6) goto L5;
        BlackWhiteMode r7 = r5[r3];
        reverse.put(r7.underlying, r7);
        r3 = r3 + 1;
        goto L3
    }

    private BlackWhiteMode(String r1, int r2, STBlackWhiteMode.Enum r3) {
        super(r1, r2);
        this.underlying = r3;
    }

    public static BlackWhiteMode valueOf(String r2) {
        return (BlackWhiteMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(BlackWhiteMode.class, r2), BlackWhiteMode.class, "com.obric.memorydata.plugin");
    }

    static BlackWhiteMode valueOf(STBlackWhiteMode.Enum r2) {
        return (BlackWhiteMode) ZeusTransformUtils.preCheckCast(reverse.get(r2), BlackWhiteMode.class, "com.obric.memorydata.plugin");
    }

    public static BlackWhiteMode[] values() {
        return (BlackWhiteMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BlackWhiteMode[].class, "com.obric.memorydata.plugin");
    }
}
