package org.apache.poi.xddf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.main.STCompoundLine;

/* JADX INFO: loaded from: classes7.dex */
public final enum CompoundLine extends Enum<CompoundLine> {
    private static final /* synthetic */ CompoundLine[] $VALUES = null;
    public static final CompoundLine DOUBLE = null;
    public static final CompoundLine SINGLE = null;
    public static final CompoundLine THICK_THIN = null;
    public static final CompoundLine THIN_THICK = null;
    public static final CompoundLine TRIPLE = null;
    private static final HashMap<STCompoundLine.Enum, CompoundLine> reverse = null;
    final STCompoundLine.Enum underlying;

    static {
        int r3 = 0;
        CompoundLine r0 = new CompoundLine("DOUBLE", 0, STCompoundLine.d);
        DOUBLE = r0;
        CompoundLine r1 = new CompoundLine("SINGLE", 1, STCompoundLine.c);
        SINGLE = r1;
        CompoundLine r2 = new CompoundLine("THICK_THIN", 2, STCompoundLine.e);
        THICK_THIN = r2;
        CompoundLine r4 = new CompoundLine("THIN_THICK", 3, STCompoundLine.f);
        THIN_THICK = r4;
        CompoundLine r6 = new CompoundLine("TRIPLE", 4, STCompoundLine.g);
        TRIPLE = r6;
        $VALUES = new CompoundLine[]{r0, r1, r2, r4, r6};
        reverse = new HashMap();
        CompoundLine[] r5 = values();
        int r7 = r5.length;
    L3:
        if (r3 >= r7) goto L5;
        CompoundLine r8 = r5[r3];
        reverse.put(r8.underlying, r8);
        r3 = r3 + 1;
        goto L3
    }

    private CompoundLine(String r1, int r2, STCompoundLine.Enum r3) {
        super(r1, r2);
        this.underlying = r3;
    }

    public static CompoundLine valueOf(String r2) {
        return (CompoundLine) ZeusTransformUtils.preCheckCast(Enum.valueOf(CompoundLine.class, r2), CompoundLine.class, "com.obric.memorydata.plugin");
    }

    static CompoundLine valueOf(STCompoundLine.Enum r2) {
        return (CompoundLine) ZeusTransformUtils.preCheckCast(reverse.get(r2), CompoundLine.class, "com.obric.memorydata.plugin");
    }

    public static CompoundLine[] values() {
        return (CompoundLine[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CompoundLine[].class, "com.obric.memorydata.plugin");
    }
}
