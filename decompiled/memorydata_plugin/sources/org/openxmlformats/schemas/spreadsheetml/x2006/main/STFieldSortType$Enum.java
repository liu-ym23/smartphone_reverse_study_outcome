package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: classes8.dex */
public final class STFieldSortType$Enum extends StringEnumAbstractBase {
    static final int INT_ASCENDING = 2;
    static final int INT_DESCENDING = 3;
    static final int INT_MANUAL = 1;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = null;

    static {
        table = new StringEnumAbstractBase.Table(new STFieldSortType$Enum[]{new STFieldSortType$Enum("manual", 1), new STFieldSortType$Enum("ascending", 2), new STFieldSortType$Enum("descending", 3)});
    }

    private STFieldSortType$Enum(String r1, int r2) {
        super(r1, r2);
    }

    public static STFieldSortType$Enum forInt(int r2) {
        return (STFieldSortType$Enum) ZeusTransformUtils.preCheckCast(table.forInt(r2), STFieldSortType$Enum.class, "com.obric.memorydata.plugin");
    }

    public static STFieldSortType$Enum forString(String r2) {
        return (STFieldSortType$Enum) ZeusTransformUtils.preCheckCast(table.forString(r2), STFieldSortType$Enum.class, "com.obric.memorydata.plugin");
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
