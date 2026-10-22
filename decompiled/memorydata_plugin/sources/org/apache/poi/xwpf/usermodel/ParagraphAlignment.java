package org.apache.poi.xwpf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final enum ParagraphAlignment extends Enum<ParagraphAlignment> {
    private static final /* synthetic */ ParagraphAlignment[] $VALUES = null;
    public static final ParagraphAlignment BOTH = null;
    public static final ParagraphAlignment CENTER = null;
    public static final ParagraphAlignment DISTRIBUTE = null;
    public static final ParagraphAlignment END = null;
    public static final ParagraphAlignment HIGH_KASHIDA = null;
    public static final ParagraphAlignment LEFT = null;
    public static final ParagraphAlignment LOW_KASHIDA = null;
    public static final ParagraphAlignment MEDIUM_KASHIDA = null;
    public static final ParagraphAlignment NUM_TAB = null;
    public static final ParagraphAlignment RIGHT = null;
    public static final ParagraphAlignment START = null;
    public static final ParagraphAlignment THAI_DISTRIBUTE = null;
    private static final Map<Integer, ParagraphAlignment> imap = null;
    private final int value;

    static {
        int r2 = 0;
        ParagraphAlignment r0 = new ParagraphAlignment("START", 0, 1);
        START = r0;
        ParagraphAlignment r1 = new ParagraphAlignment("CENTER", 1, 2);
        CENTER = r1;
        ParagraphAlignment r4 = new ParagraphAlignment("END", 2, 3);
        END = r4;
        ParagraphAlignment r6 = new ParagraphAlignment("BOTH", 3, 4);
        BOTH = r6;
        ParagraphAlignment r8 = new ParagraphAlignment("MEDIUM_KASHIDA", 4, 5);
        MEDIUM_KASHIDA = r8;
        ParagraphAlignment r10 = new ParagraphAlignment("DISTRIBUTE", 5, 6);
        DISTRIBUTE = r10;
        ParagraphAlignment r12 = new ParagraphAlignment("NUM_TAB", 6, 7);
        NUM_TAB = r12;
        ParagraphAlignment r14 = new ParagraphAlignment("HIGH_KASHIDA", 7, 8);
        HIGH_KASHIDA = r14;
        ParagraphAlignment r13 = new ParagraphAlignment("LOW_KASHIDA", 8, 9);
        LOW_KASHIDA = r13;
        ParagraphAlignment r15 = new ParagraphAlignment("THAI_DISTRIBUTE", 9, 10);
        THAI_DISTRIBUTE = r15;
        ParagraphAlignment r11 = new ParagraphAlignment("LEFT", 10, 11);
        LEFT = r11;
        ParagraphAlignment r9 = new ParagraphAlignment("RIGHT", 11, 12);
        RIGHT = r9;
        $VALUES = new ParagraphAlignment[]{r0, r1, r4, r6, r8, r10, r12, r14, r13, r15, r11, r9};
        imap = new HashMap();
        ParagraphAlignment[] r3 = values();
        int r5 = r3.length;
    L3:
        if (r2 >= r5) goto L5;
        ParagraphAlignment r7 = r3[r2];
        imap.put(Integer.valueOf(r7.getValue()), r7);
        r2 = r2 + 1;
        goto L3
    }

    private ParagraphAlignment(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static ParagraphAlignment valueOf(int r3) {
        ParagraphAlignment r0 = (ParagraphAlignment) ZeusTransformUtils.preCheckCast(imap.get(Integer.valueOf(r3)), ParagraphAlignment.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("Unknown paragraph alignment: " + r3);
    }

    public static ParagraphAlignment valueOf(String r2) {
        return (ParagraphAlignment) ZeusTransformUtils.preCheckCast(Enum.valueOf(ParagraphAlignment.class, r2), ParagraphAlignment.class, "com.obric.memorydata.plugin");
    }

    public static ParagraphAlignment[] values() {
        return (ParagraphAlignment[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ParagraphAlignment[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
