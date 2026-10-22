package com.microsoft.schemas.vml;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: classes3.dex */
public final class STStrokeArrowLength$Enum extends StringEnumAbstractBase {
    static final int INT_LONG = 3;
    static final int INT_MEDIUM = 2;
    static final int INT_SHORT = 1;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = null;

    static {
        table = new StringEnumAbstractBase.Table(new STStrokeArrowLength$Enum[]{new STStrokeArrowLength$Enum("short", 1), new STStrokeArrowLength$Enum("medium", 2), new STStrokeArrowLength$Enum("long", 3)});
    }

    private STStrokeArrowLength$Enum(String r1, int r2) {
        super(r1, r2);
    }

    public static STStrokeArrowLength$Enum forInt(int r2) {
        return (STStrokeArrowLength$Enum) ZeusTransformUtils.preCheckCast(table.forInt(r2), STStrokeArrowLength$Enum.class, "com.obric.memorydata.plugin");
    }

    public static STStrokeArrowLength$Enum forString(String r2) {
        return (STStrokeArrowLength$Enum) ZeusTransformUtils.preCheckCast(table.forString(r2), STStrokeArrowLength$Enum.class, "com.obric.memorydata.plugin");
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
