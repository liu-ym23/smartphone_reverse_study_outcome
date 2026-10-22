package org.checkerframework.framework.qual;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public final enum LiteralKind extends Enum<LiteralKind> {
    private static final /* synthetic */ LiteralKind[] $VALUES = null;
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

    private static /* synthetic */ LiteralKind[] $values() {
        return new LiteralKind[]{NULL, INT, LONG, FLOAT, DOUBLE, BOOLEAN, CHAR, STRING, ALL, PRIMITIVE};
    }

    static {
        NULL = new LiteralKind("NULL", 0);
        INT = new LiteralKind("INT", 1);
        LONG = new LiteralKind("LONG", 2);
        FLOAT = new LiteralKind("FLOAT", 3);
        DOUBLE = new LiteralKind("DOUBLE", 4);
        BOOLEAN = new LiteralKind("BOOLEAN", 5);
        CHAR = new LiteralKind("CHAR", 6);
        STRING = new LiteralKind("STRING", 7);
        ALL = new LiteralKind("ALL", 8);
        PRIMITIVE = new LiteralKind("PRIMITIVE", 9);
        $VALUES = $values();
    }

    private LiteralKind(String r1, int r2) {
        super(r1, r2);
    }

    public static List<LiteralKind> allLiteralKinds() {
        ArrayList r0 = new ArrayList(Arrays.asList(values()));
        r0.remove(ALL);
        r0.remove(PRIMITIVE);
        return r0;
    }

    public static List<LiteralKind> primitiveLiteralKinds() {
        return Arrays.asList(new LiteralKind[]{INT, LONG, FLOAT, DOUBLE, BOOLEAN, CHAR});
    }

    public static LiteralKind valueOf(String r2) {
        return (LiteralKind) ZeusTransformUtils.preCheckCast(Enum.valueOf(LiteralKind.class, r2), LiteralKind.class, "com.obric.memorydata.plugin");
    }

    public static LiteralKind[] values() {
        return (LiteralKind[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), LiteralKind[].class, "com.obric.memorydata.plugin");
    }
}
