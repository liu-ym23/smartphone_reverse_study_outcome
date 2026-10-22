package org.apache.poi.xddf.usermodel.text;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextUnderlineType;

/* JADX INFO: loaded from: classes7.dex */
public final enum UnderlineType extends Enum<UnderlineType> {
    private static final /* synthetic */ UnderlineType[] $VALUES = null;
    public static final UnderlineType DASH = null;
    public static final UnderlineType DASH_HEAVY = null;
    public static final UnderlineType DASH_LONG = null;
    public static final UnderlineType DASH_LONG_HEAVY = null;
    public static final UnderlineType DOTTED = null;
    public static final UnderlineType DOTTED_HEAVY = null;
    public static final UnderlineType DOT_DASH = null;
    public static final UnderlineType DOT_DASH_HEAVY = null;
    public static final UnderlineType DOT_DOT_DASH = null;
    public static final UnderlineType DOT_DOT_DASH_HEAVY = null;
    public static final UnderlineType DOUBLE = null;
    public static final UnderlineType HEAVY = null;
    public static final UnderlineType NONE = null;
    public static final UnderlineType SINGLE = null;
    public static final UnderlineType WAVY = null;
    public static final UnderlineType WAVY_DOUBLE = null;
    public static final UnderlineType WAVY_HEAVY = null;
    public static final UnderlineType WORDS = null;
    private static final HashMap<STTextUnderlineType.Enum, UnderlineType> reverse = null;
    final STTextUnderlineType.Enum underlying;

    static {
        UnderlineType r0 = new UnderlineType("DASH", 0, STTextUnderlineType.j);
        DASH = r0;
        UnderlineType r1 = new UnderlineType("DASH_HEAVY", 1, STTextUnderlineType.k);
        DASH_HEAVY = r1;
        UnderlineType r2 = new UnderlineType("DASH_LONG", 2, STTextUnderlineType.l);
        DASH_LONG = r2;
        UnderlineType r4 = new UnderlineType("DASH_LONG_HEAVY", 3, STTextUnderlineType.m);
        DASH_LONG_HEAVY = r4;
        UnderlineType r6 = new UnderlineType("DOUBLE", 4, STTextUnderlineType.f);
        DOUBLE = r6;
        UnderlineType r8 = new UnderlineType("DOT_DASH", 5, STTextUnderlineType.n);
        DOT_DASH = r8;
        UnderlineType r10 = new UnderlineType("DOT_DASH_HEAVY", 6, STTextUnderlineType.o);
        DOT_DASH_HEAVY = r10;
        UnderlineType r12 = new UnderlineType("DOT_DOT_DASH", 7, STTextUnderlineType.p);
        DOT_DOT_DASH = r12;
        UnderlineType r14 = new UnderlineType("DOT_DOT_DASH_HEAVY", 8, STTextUnderlineType.q);
        DOT_DOT_DASH_HEAVY = r14;
        UnderlineType r13 = new UnderlineType("DOTTED", 9, STTextUnderlineType.h);
        DOTTED = r13;
        UnderlineType r11 = new UnderlineType("DOTTED_HEAVY", 10, STTextUnderlineType.i);
        DOTTED_HEAVY = r11;
        UnderlineType r9 = new UnderlineType("HEAVY", 11, STTextUnderlineType.g);
        HEAVY = r9;
        UnderlineType r7 = new UnderlineType("NONE", 12, STTextUnderlineType.c);
        NONE = r7;
        UnderlineType r5 = new UnderlineType("SINGLE", 13, STTextUnderlineType.e);
        SINGLE = r5;
        UnderlineType r3 = new UnderlineType("WAVY", 14, STTextUnderlineType.r);
        WAVY = r3;
        UnderlineType r15 = new UnderlineType("WAVY_DOUBLE", 15, STTextUnderlineType.t);
        WAVY_DOUBLE = r15;
        UnderlineType r16 = new UnderlineType("WAVY_HEAVY", 16, STTextUnderlineType.s);
        WAVY_HEAVY = r16;
        UnderlineType r17 = new UnderlineType("WORDS", 17, STTextUnderlineType.d);
        WORDS = r17;
        $VALUES = new UnderlineType[]{r0, r1, r2, r4, r6, r8, r10, r12, r14, r13, r11, r9, r7, r5, r3, r15, r16, r17};
        reverse = new HashMap();
        UnderlineType[] r18 = values();
        int r19 = r18.length;
        int r20 = 0;
    L3:
        if (r20 >= r19) goto L5;
        UnderlineType r21 = r18[r20];
        reverse.put(r21.underlying, r21);
        r20 = r20 + 1;
        goto L3
    }

    private UnderlineType(String r1, int r2, STTextUnderlineType.Enum r3) {
        super(r1, r2);
        this.underlying = r3;
    }

    public static UnderlineType valueOf(String r2) {
        return (UnderlineType) ZeusTransformUtils.preCheckCast(Enum.valueOf(UnderlineType.class, r2), UnderlineType.class, "com.obric.memorydata.plugin");
    }

    static UnderlineType valueOf(STTextUnderlineType.Enum r2) {
        return (UnderlineType) ZeusTransformUtils.preCheckCast(reverse.get(r2), UnderlineType.class, "com.obric.memorydata.plugin");
    }

    public static UnderlineType[] values() {
        return (UnderlineType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), UnderlineType[].class, "com.obric.memorydata.plugin");
    }
}
