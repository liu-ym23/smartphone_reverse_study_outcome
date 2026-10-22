package org.checkerframework.framework.qual;

import com.bytedance.security.dbcipher.utils.CipherConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum TypeKind extends Enum<TypeKind> {
    private static final /* synthetic */ TypeKind[] $VALUES = null;
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

    private static /* synthetic */ TypeKind[] $values() {
        return new TypeKind[]{BOOLEAN, BYTE, SHORT, INT, LONG, CHAR, FLOAT, DOUBLE, VOID, NONE, NULL, ARRAY, DECLARED, ERROR, TYPEVAR, WILDCARD, PACKAGE, EXECUTABLE, OTHER, UNION, INTERSECTION};
    }

    static {
        BOOLEAN = new TypeKind("BOOLEAN", 0);
        BYTE = new TypeKind("BYTE", 1);
        SHORT = new TypeKind("SHORT", 2);
        INT = new TypeKind("INT", 3);
        LONG = new TypeKind("LONG", 4);
        CHAR = new TypeKind("CHAR", 5);
        FLOAT = new TypeKind("FLOAT", 6);
        DOUBLE = new TypeKind("DOUBLE", 7);
        VOID = new TypeKind("VOID", 8);
        NONE = new TypeKind("NONE", 9);
        NULL = new TypeKind("NULL", 10);
        ARRAY = new TypeKind("ARRAY", 11);
        DECLARED = new TypeKind("DECLARED", 12);
        ERROR = new TypeKind(CipherConst.LEVEL_ERROR, 13);
        TYPEVAR = new TypeKind("TYPEVAR", 14);
        WILDCARD = new TypeKind("WILDCARD", 15);
        PACKAGE = new TypeKind("PACKAGE", 16);
        EXECUTABLE = new TypeKind("EXECUTABLE", 17);
        OTHER = new TypeKind("OTHER", 18);
        UNION = new TypeKind("UNION", 19);
        INTERSECTION = new TypeKind("INTERSECTION", 20);
        $VALUES = $values();
    }

    private TypeKind(String r1, int r2) {
        super(r1, r2);
    }

    public static TypeKind valueOf(String r2) {
        return (TypeKind) ZeusTransformUtils.preCheckCast(Enum.valueOf(TypeKind.class, r2), TypeKind.class, "com.obric.memorydata.plugin");
    }

    public static TypeKind[] values() {
        return (TypeKind[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TypeKind[].class, "com.obric.memorydata.plugin");
    }
}
