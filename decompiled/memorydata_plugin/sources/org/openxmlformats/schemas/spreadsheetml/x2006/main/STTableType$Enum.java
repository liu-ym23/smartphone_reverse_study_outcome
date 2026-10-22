package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: classes8.dex */
public final class STTableType$Enum extends StringEnumAbstractBase {
    static final int INT_QUERY_TABLE = 3;
    static final int INT_WORKSHEET = 1;
    static final int INT_XML = 2;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = null;

    static {
        table = new StringEnumAbstractBase.Table(new STTableType$Enum[]{new STTableType$Enum("worksheet", 1), new STTableType$Enum("xml", 2), new STTableType$Enum("queryTable", 3)});
    }

    private STTableType$Enum(String r1, int r2) {
        super(r1, r2);
    }

    public static STTableType$Enum forInt(int r2) {
        return (STTableType$Enum) ZeusTransformUtils.preCheckCast(table.forInt(r2), STTableType$Enum.class, "com.obric.memorydata.plugin");
    }

    public static STTableType$Enum forString(String r2) {
        return (STTableType$Enum) ZeusTransformUtils.preCheckCast(table.forString(r2), STTableType$Enum.class, "com.obric.memorydata.plugin");
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
