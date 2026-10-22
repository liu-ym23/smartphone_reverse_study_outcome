package org.apache.poi.xwpf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final enum TextAlignment extends Enum<TextAlignment> {
    private static final /* synthetic */ TextAlignment[] $VALUES = null;
    public static final TextAlignment AUTO = null;
    public static final TextAlignment BASELINE = null;
    public static final TextAlignment BOTTOM = null;
    public static final TextAlignment CENTER = null;
    public static final TextAlignment TOP = null;
    private static Map<Integer, TextAlignment> imap;
    private final int value;

    static {
        int r2 = 0;
        TextAlignment r0 = new TextAlignment("TOP", 0, 1);
        TOP = r0;
        TextAlignment r1 = new TextAlignment("CENTER", 1, 2);
        CENTER = r1;
        TextAlignment r4 = new TextAlignment("BASELINE", 2, 3);
        BASELINE = r4;
        TextAlignment r6 = new TextAlignment("BOTTOM", 3, 4);
        BOTTOM = r6;
        TextAlignment r8 = new TextAlignment("AUTO", 4, 5);
        AUTO = r8;
        $VALUES = new TextAlignment[]{r0, r1, r4, r6, r8};
        imap = new HashMap();
        TextAlignment[] r3 = values();
        int r5 = r3.length;
    L3:
        if (r2 >= r5) goto L5;
        TextAlignment r7 = r3[r2];
        imap.put(Integer.valueOf(r7.getValue()), r7);
        r2 = r2 + 1;
        goto L3
    }

    private TextAlignment(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static TextAlignment valueOf(int r3) {
        TextAlignment r0 = (TextAlignment) ZeusTransformUtils.preCheckCast(imap.get(Integer.valueOf(r3)), TextAlignment.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("Unknown text alignment: " + r3);
    }

    public static TextAlignment valueOf(String r2) {
        return (TextAlignment) ZeusTransformUtils.preCheckCast(Enum.valueOf(TextAlignment.class, r2), TextAlignment.class, "com.obric.memorydata.plugin");
    }

    public static TextAlignment[] values() {
        return (TextAlignment[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TextAlignment[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
