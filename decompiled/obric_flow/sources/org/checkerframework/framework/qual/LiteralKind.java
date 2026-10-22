package org.checkerframework.framework.qual;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final enum LiteralKind extends Enum<LiteralKind> {
    public static final LiteralKind ALL = null;
    public static final LiteralKind BOOLEAN = null;
    public static final LiteralKind CHAR = null;
    public static final LiteralKind DOUBLE = null;
    public static final LiteralKind FLOAT = null;
    public static final LiteralKind INT = null;
    public static final LiteralKind LONG = null;
    public static final LiteralKind NULL = null;
    public static final LiteralKind PRIMITIVE = null;
    public static final LiteralKind STRING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiteralKind[] f20986a = null;

    static {
        LiteralKind r5 = new LiteralKind("NULL", 0);
        NULL = r5;
        LiteralKind r10 = new LiteralKind("INT", 1);
        INT = r10;
        LiteralKind r11 = new LiteralKind("LONG", 2);
        LONG = r11;
        LiteralKind r12 = new LiteralKind("FLOAT", 3);
        FLOAT = r12;
        LiteralKind r13 = new LiteralKind("DOUBLE", 4);
        DOUBLE = r13;
        LiteralKind r14 = new LiteralKind("BOOLEAN", 5);
        BOOLEAN = r14;
        LiteralKind r15 = new LiteralKind("CHAR", 6);
        CHAR = r15;
        LiteralKind r16 = new LiteralKind("STRING", 7);
        STRING = r16;
        LiteralKind r17 = new LiteralKind("ALL", 8);
        ALL = r17;
        LiteralKind r18 = new LiteralKind("PRIMITIVE", 9);
        PRIMITIVE = r18;
        f20986a = new LiteralKind[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18};
    }

    public static List<LiteralKind> allLiteralKinds() {
        ArrayList r5 = new ArrayList(Arrays.asList(values()));
        r5.remove(ALL);
        r5.remove(PRIMITIVE);
        return r5;
    }

    public static List<LiteralKind> primitiveLiteralKinds() {
        return Arrays.asList(new LiteralKind[]{INT, LONG, FLOAT, DOUBLE, BOOLEAN, CHAR});
    }

    public static LiteralKind valueOf(String r5) {
        return (LiteralKind) Enum.valueOf(LiteralKind.class, r5);
    }

    public static LiteralKind[] values() {
        return (LiteralKind[]) f20986a.clone();
    }
}
