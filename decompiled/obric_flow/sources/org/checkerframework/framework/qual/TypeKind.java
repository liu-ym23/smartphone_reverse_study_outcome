package org.checkerframework.framework.qual;

/* JADX INFO: loaded from: classes3.dex */
public final enum TypeKind extends Enum<TypeKind> {
    public static final TypeKind ARRAY = null;
    public static final TypeKind BOOLEAN = null;
    public static final TypeKind BYTE = null;
    public static final TypeKind CHAR = null;
    public static final TypeKind DECLARED = null;
    public static final TypeKind DOUBLE = null;
    public static final TypeKind ERROR = null;
    public static final TypeKind EXECUTABLE = null;
    public static final TypeKind FLOAT = null;
    public static final TypeKind INT = null;
    public static final TypeKind INTERSECTION = null;
    public static final TypeKind LONG = null;
    public static final TypeKind NONE = null;
    public static final TypeKind NULL = null;
    public static final TypeKind OTHER = null;
    public static final TypeKind PACKAGE = null;
    public static final TypeKind SHORT = null;
    public static final TypeKind TYPEVAR = null;
    public static final TypeKind UNION = null;
    public static final TypeKind VOID = null;
    public static final TypeKind WILDCARD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TypeKind[] f20987a = null;

    static {
        TypeKind r5 = new TypeKind("BOOLEAN", 0);
        BOOLEAN = r5;
        TypeKind r10 = new TypeKind("BYTE", 1);
        BYTE = r10;
        TypeKind r11 = new TypeKind("SHORT", 2);
        SHORT = r11;
        TypeKind r12 = new TypeKind("INT", 3);
        INT = r12;
        TypeKind r13 = new TypeKind("LONG", 4);
        LONG = r13;
        TypeKind r14 = new TypeKind("CHAR", 5);
        CHAR = r14;
        TypeKind r15 = new TypeKind("FLOAT", 6);
        FLOAT = r15;
        TypeKind r16 = new TypeKind("DOUBLE", 7);
        DOUBLE = r16;
        TypeKind r17 = new TypeKind("VOID", 8);
        VOID = r17;
        TypeKind r18 = new TypeKind("NONE", 9);
        NONE = r18;
        TypeKind r19 = new TypeKind("NULL", 10);
        NULL = r19;
        TypeKind r110 = new TypeKind("ARRAY", 11);
        ARRAY = r110;
        TypeKind r111 = new TypeKind("DECLARED", 12);
        DECLARED = r111;
        TypeKind r112 = new TypeKind("ERROR", 13);
        ERROR = r112;
        TypeKind r113 = new TypeKind("TYPEVAR", 14);
        TYPEVAR = r113;
        TypeKind r114 = new TypeKind("WILDCARD", 15);
        WILDCARD = r114;
        TypeKind r115 = new TypeKind("PACKAGE", 16);
        PACKAGE = r115;
        TypeKind r116 = new TypeKind("EXECUTABLE", 17);
        EXECUTABLE = r116;
        TypeKind r117 = new TypeKind("OTHER", 18);
        OTHER = r117;
        TypeKind r118 = new TypeKind("UNION", 19);
        UNION = r118;
        TypeKind r119 = new TypeKind("INTERSECTION", 20);
        INTERSECTION = r119;
        f20987a = new TypeKind[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119};
    }

    public static TypeKind valueOf(String r5) {
        return (TypeKind) Enum.valueOf(TypeKind.class, r5);
    }

    public static TypeKind[] values() {
        return (TypeKind[]) f20987a.clone();
    }
}
