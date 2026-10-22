package org.apache.poi.xddf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.main.STLineCap;

/* JADX INFO: loaded from: classes7.dex */
public final enum LineCap extends Enum<LineCap> {
    private static final /* synthetic */ LineCap[] $VALUES = null;
    public static final LineCap FLAT = null;
    public static final LineCap ROUND = null;
    public static final LineCap SQUARE = null;
    private static final HashMap<STLineCap.Enum, LineCap> reverse = null;
    final STLineCap.Enum underlying;

    static {
        int r3 = 0;
        LineCap r0 = new LineCap("FLAT", 0, STLineCap.e);
        FLAT = r0;
        LineCap r1 = new LineCap("ROUND", 1, STLineCap.c);
        ROUND = r1;
        LineCap r2 = new LineCap("SQUARE", 2, STLineCap.d);
        SQUARE = r2;
        $VALUES = new LineCap[]{r0, r1, r2};
        reverse = new HashMap();
        LineCap[] r4 = values();
        int r5 = r4.length;
    L3:
        if (r3 >= r5) goto L5;
        LineCap r6 = r4[r3];
        reverse.put(r6.underlying, r6);
        r3 = r3 + 1;
        goto L3
    }

    private LineCap(String r1, int r2, STLineCap.Enum r3) {
        super(r1, r2);
        this.underlying = r3;
    }

    public static LineCap valueOf(String r2) {
        return (LineCap) ZeusTransformUtils.preCheckCast(Enum.valueOf(LineCap.class, r2), LineCap.class, "com.obric.memorydata.plugin");
    }

    static LineCap valueOf(STLineCap.Enum r2) {
        return (LineCap) ZeusTransformUtils.preCheckCast(reverse.get(r2), LineCap.class, "com.obric.memorydata.plugin");
    }

    public static LineCap[] values() {
        return (LineCap[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), LineCap[].class, "com.obric.memorydata.plugin");
    }
}
