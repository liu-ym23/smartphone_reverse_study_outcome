package com.microsoft.schemas.office.word;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: classes3.dex */
public final class STWrapSide$Enum extends StringEnumAbstractBase {
    static final int INT_BOTH = 1;
    static final int INT_LARGEST = 4;
    static final int INT_LEFT = 2;
    static final int INT_RIGHT = 3;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = null;

    static {
        table = new StringEnumAbstractBase.Table(new STWrapSide$Enum[]{new STWrapSide$Enum("both", 1), new STWrapSide$Enum("left", 2), new STWrapSide$Enum("right", 3), new STWrapSide$Enum("largest", 4)});
    }

    private STWrapSide$Enum(String r1, int r2) {
        super(r1, r2);
    }

    public static STWrapSide$Enum forInt(int r2) {
        return (STWrapSide$Enum) ZeusTransformUtils.preCheckCast(table.forInt(r2), STWrapSide$Enum.class, "com.obric.memorydata.plugin");
    }

    public static STWrapSide$Enum forString(String r2) {
        return (STWrapSide$Enum) ZeusTransformUtils.preCheckCast(table.forString(r2), STWrapSide$Enum.class, "com.obric.memorydata.plugin");
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
