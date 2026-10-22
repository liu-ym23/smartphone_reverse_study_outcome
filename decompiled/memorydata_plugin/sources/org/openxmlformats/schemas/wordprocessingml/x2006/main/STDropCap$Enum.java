package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: classes8.dex */
public final class STDropCap$Enum extends StringEnumAbstractBase {
    static final int INT_DROP = 2;
    static final int INT_MARGIN = 3;
    static final int INT_NONE = 1;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = null;

    static {
        table = new StringEnumAbstractBase.Table(new STDropCap$Enum[]{new STDropCap$Enum("none", 1), new STDropCap$Enum("drop", 2), new STDropCap$Enum("margin", 3)});
    }

    private STDropCap$Enum(String r1, int r2) {
        super(r1, r2);
    }

    public static STDropCap$Enum forInt(int r2) {
        return (STDropCap$Enum) ZeusTransformUtils.preCheckCast(table.forInt(r2), STDropCap$Enum.class, "com.obric.memorydata.plugin");
    }

    public static STDropCap$Enum forString(String r2) {
        return (STDropCap$Enum) ZeusTransformUtils.preCheckCast(table.forString(r2), STDropCap$Enum.class, "com.obric.memorydata.plugin");
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
