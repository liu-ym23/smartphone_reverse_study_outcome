package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: classes8.dex */
public final class STSortMethod$Enum extends StringEnumAbstractBase {
    static final int INT_NONE = 3;
    static final int INT_PIN_YIN = 2;
    static final int INT_STROKE = 1;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = null;

    static {
        table = new StringEnumAbstractBase.Table(new STSortMethod$Enum[]{new STSortMethod$Enum("stroke", 1), new STSortMethod$Enum("pinYin", 2), new STSortMethod$Enum("none", 3)});
    }

    private STSortMethod$Enum(String r1, int r2) {
        super(r1, r2);
    }

    public static STSortMethod$Enum forInt(int r2) {
        return (STSortMethod$Enum) ZeusTransformUtils.preCheckCast(table.forInt(r2), STSortMethod$Enum.class, "com.obric.memorydata.plugin");
    }

    public static STSortMethod$Enum forString(String r2) {
        return (STSortMethod$Enum) ZeusTransformUtils.preCheckCast(table.forString(r2), STSortMethod$Enum.class, "com.obric.memorydata.plugin");
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
