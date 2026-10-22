package org.apache.poi.xwpf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final enum UnderlinePatterns extends Enum<UnderlinePatterns> {
    private static final /* synthetic */ UnderlinePatterns[] $VALUES = null;
    public static final UnderlinePatterns DASH = null;
    public static final UnderlinePatterns DASHED_HEAVY = null;
    public static final UnderlinePatterns DASH_DOT_DOT_HEAVY = null;
    public static final UnderlinePatterns DASH_DOT_HEAVY = null;
    public static final UnderlinePatterns DASH_LONG = null;
    public static final UnderlinePatterns DASH_LONG_HEAVY = null;
    public static final UnderlinePatterns DOTTED = null;
    public static final UnderlinePatterns DOTTED_HEAVY = null;
    public static final UnderlinePatterns DOT_DASH = null;
    public static final UnderlinePatterns DOT_DOT_DASH = null;
    public static final UnderlinePatterns DOUBLE = null;
    public static final UnderlinePatterns NONE = null;
    public static final UnderlinePatterns SINGLE = null;
    public static final UnderlinePatterns THICK = null;
    public static final UnderlinePatterns WAVE = null;
    public static final UnderlinePatterns WAVY_DOUBLE = null;
    public static final UnderlinePatterns WAVY_HEAVY = null;
    public static final UnderlinePatterns WORDS = null;
    private static Map<Integer, UnderlinePatterns> imap;
    private final int value;

    static {
        UnderlinePatterns r0 = new UnderlinePatterns("SINGLE", 0, 1);
        SINGLE = r0;
        UnderlinePatterns r1 = new UnderlinePatterns("WORDS", 1, 2);
        WORDS = r1;
        UnderlinePatterns r4 = new UnderlinePatterns("DOUBLE", 2, 3);
        DOUBLE = r4;
        UnderlinePatterns r6 = new UnderlinePatterns("THICK", 3, 4);
        THICK = r6;
        UnderlinePatterns r8 = new UnderlinePatterns("DOTTED", 4, 5);
        DOTTED = r8;
        UnderlinePatterns r10 = new UnderlinePatterns("DOTTED_HEAVY", 5, 6);
        DOTTED_HEAVY = r10;
        UnderlinePatterns r12 = new UnderlinePatterns("DASH", 6, 7);
        DASH = r12;
        UnderlinePatterns r14 = new UnderlinePatterns("DASHED_HEAVY", 7, 8);
        DASHED_HEAVY = r14;
        UnderlinePatterns r13 = new UnderlinePatterns("DASH_LONG", 8, 9);
        DASH_LONG = r13;
        UnderlinePatterns r15 = new UnderlinePatterns("DASH_LONG_HEAVY", 9, 10);
        DASH_LONG_HEAVY = r15;
        UnderlinePatterns r11 = new UnderlinePatterns("DOT_DASH", 10, 11);
        DOT_DASH = r11;
        UnderlinePatterns r9 = new UnderlinePatterns("DASH_DOT_HEAVY", 11, 12);
        DASH_DOT_HEAVY = r9;
        UnderlinePatterns r7 = new UnderlinePatterns("DOT_DOT_DASH", 12, 13);
        DOT_DOT_DASH = r7;
        UnderlinePatterns r5 = new UnderlinePatterns("DASH_DOT_DOT_HEAVY", 13, 14);
        DASH_DOT_DOT_HEAVY = r5;
        UnderlinePatterns r3 = new UnderlinePatterns("WAVE", 14, 15);
        WAVE = r3;
        UnderlinePatterns r2 = new UnderlinePatterns("WAVY_HEAVY", 15, 16);
        WAVY_HEAVY = r2;
        UnderlinePatterns r16 = new UnderlinePatterns("WAVY_DOUBLE", 16, 17);
        WAVY_DOUBLE = r16;
        UnderlinePatterns r17 = new UnderlinePatterns("NONE", 17, 18);
        NONE = r17;
        $VALUES = new UnderlinePatterns[]{r0, r1, r4, r6, r8, r10, r12, r14, r13, r15, r11, r9, r7, r5, r3, r2, r16, r17};
        imap = new HashMap();
        UnderlinePatterns[] r18 = values();
        int r19 = r18.length;
        int r20 = 0;
    L3:
        if (r20 >= r19) goto L5;
        UnderlinePatterns r21 = r18[r20];
        imap.put(Integer.valueOf(r21.getValue()), r21);
        r20 = r20 + 1;
        goto L3
    }

    private UnderlinePatterns(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static UnderlinePatterns valueOf(int r3) {
        UnderlinePatterns r0 = (UnderlinePatterns) ZeusTransformUtils.preCheckCast(imap.get(Integer.valueOf(r3)), UnderlinePatterns.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("Unknown underline pattern: " + r3);
    }

    public static UnderlinePatterns valueOf(String r2) {
        return (UnderlinePatterns) ZeusTransformUtils.preCheckCast(Enum.valueOf(UnderlinePatterns.class, r2), UnderlinePatterns.class, "com.obric.memorydata.plugin");
    }

    public static UnderlinePatterns[] values() {
        return (UnderlinePatterns[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), UnderlinePatterns[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
