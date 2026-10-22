package com.microsoft.schemas.vml;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: classes3.dex */
public final class STStrokeArrowWidth$Enum extends StringEnumAbstractBase {
    static final int INT_MEDIUM = 2;
    static final int INT_NARROW = 1;
    static final int INT_WIDE = 3;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = null;

    static {
        table = new StringEnumAbstractBase.Table(new STStrokeArrowWidth$Enum[]{new STStrokeArrowWidth$Enum("narrow", 1), new STStrokeArrowWidth$Enum("medium", 2), new STStrokeArrowWidth$Enum("wide", 3)});
    }

    private STStrokeArrowWidth$Enum(String r1, int r2) {
        super(r1, r2);
    }

    public static STStrokeArrowWidth$Enum forInt(int r2) {
        return (STStrokeArrowWidth$Enum) ZeusTransformUtils.preCheckCast(table.forInt(r2), STStrokeArrowWidth$Enum.class, "com.obric.memorydata.plugin");
    }

    public static STStrokeArrowWidth$Enum forString(String r2) {
        return (STStrokeArrowWidth$Enum) ZeusTransformUtils.preCheckCast(table.forString(r2), STStrokeArrowWidth$Enum.class, "com.obric.memorydata.plugin");
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
