package org.apache.poi.xddf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.main.STPenAlignment;

/* JADX INFO: loaded from: classes7.dex */
public final enum PenAlignment extends Enum<PenAlignment> {
    private static final /* synthetic */ PenAlignment[] $VALUES = null;
    public static final PenAlignment CENTER = null;
    public static final PenAlignment IN = null;
    private static final HashMap<STPenAlignment.Enum, PenAlignment> reverse = null;
    final STPenAlignment.Enum underlying;

    static {
        int r3 = 0;
        PenAlignment r0 = new PenAlignment("CENTER", 0, STPenAlignment.c);
        CENTER = r0;
        PenAlignment r1 = new PenAlignment("IN", 1, STPenAlignment.d);
        IN = r1;
        $VALUES = new PenAlignment[]{r0, r1};
        reverse = new HashMap();
        PenAlignment[] r2 = values();
        int r4 = r2.length;
    L3:
        if (r3 >= r4) goto L5;
        PenAlignment r5 = r2[r3];
        reverse.put(r5.underlying, r5);
        r3 = r3 + 1;
        goto L3
    }

    private PenAlignment(String r1, int r2, STPenAlignment.Enum r3) {
        super(r1, r2);
        this.underlying = r3;
    }

    public static PenAlignment valueOf(String r2) {
        return (PenAlignment) ZeusTransformUtils.preCheckCast(Enum.valueOf(PenAlignment.class, r2), PenAlignment.class, "com.obric.memorydata.plugin");
    }

    static PenAlignment valueOf(STPenAlignment.Enum r2) {
        return (PenAlignment) ZeusTransformUtils.preCheckCast(reverse.get(r2), PenAlignment.class, "com.obric.memorydata.plugin");
    }

    public static PenAlignment[] values() {
        return (PenAlignment[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PenAlignment[].class, "com.obric.memorydata.plugin");
    }
}
