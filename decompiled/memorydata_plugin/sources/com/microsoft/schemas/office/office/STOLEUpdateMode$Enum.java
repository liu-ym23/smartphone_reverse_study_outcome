package com.microsoft.schemas.office.office;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: classes3.dex */
public final class STOLEUpdateMode$Enum extends StringEnumAbstractBase {
    static final int INT_ALWAYS = 1;
    static final int INT_ON_CALL = 2;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = null;

    static {
        table = new StringEnumAbstractBase.Table(new STOLEUpdateMode$Enum[]{new STOLEUpdateMode$Enum("Always", 1), new STOLEUpdateMode$Enum("OnCall", 2)});
    }

    private STOLEUpdateMode$Enum(String r1, int r2) {
        super(r1, r2);
    }

    public static STOLEUpdateMode$Enum forInt(int r2) {
        return (STOLEUpdateMode$Enum) ZeusTransformUtils.preCheckCast(table.forInt(r2), STOLEUpdateMode$Enum.class, "com.obric.memorydata.plugin");
    }

    public static STOLEUpdateMode$Enum forString(String r2) {
        return (STOLEUpdateMode$Enum) ZeusTransformUtils.preCheckCast(table.forString(r2), STOLEUpdateMode$Enum.class, "com.obric.memorydata.plugin");
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
