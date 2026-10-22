package com.microsoft.schemas.vml;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: classes3.dex */
public final class STStrokeEndCap$Enum extends StringEnumAbstractBase {
    static final int INT_FLAT = 1;
    static final int INT_ROUND = 3;
    static final int INT_SQUARE = 2;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = null;

    static {
        table = new StringEnumAbstractBase.Table(new STStrokeEndCap$Enum[]{new STStrokeEndCap$Enum("flat", 1), new STStrokeEndCap$Enum("square", 2), new STStrokeEndCap$Enum("round", 3)});
    }

    private STStrokeEndCap$Enum(String r1, int r2) {
        super(r1, r2);
    }

    public static STStrokeEndCap$Enum forInt(int r2) {
        return (STStrokeEndCap$Enum) ZeusTransformUtils.preCheckCast(table.forInt(r2), STStrokeEndCap$Enum.class, "com.obric.memorydata.plugin");
    }

    public static STStrokeEndCap$Enum forString(String r2) {
        return (STStrokeEndCap$Enum) ZeusTransformUtils.preCheckCast(table.forString(r2), STStrokeEndCap$Enum.class, "com.obric.memorydata.plugin");
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
