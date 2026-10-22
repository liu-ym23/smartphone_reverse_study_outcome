package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: classes8.dex */
public final class STShowDataAs$Enum extends StringEnumAbstractBase {
    static final int INT_DIFFERENCE = 2;
    static final int INT_INDEX = 9;
    static final int INT_NORMAL = 1;
    static final int INT_PERCENT = 3;
    static final int INT_PERCENT_DIFF = 4;
    static final int INT_PERCENT_OF_COL = 7;
    static final int INT_PERCENT_OF_ROW = 6;
    static final int INT_PERCENT_OF_TOTAL = 8;
    static final int INT_RUN_TOTAL = 5;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = null;

    static {
        table = new StringEnumAbstractBase.Table(new STShowDataAs$Enum[]{new STShowDataAs$Enum("normal", 1), new STShowDataAs$Enum("difference", 2), new STShowDataAs$Enum("percent", 3), new STShowDataAs$Enum("percentDiff", 4), new STShowDataAs$Enum("runTotal", 5), new STShowDataAs$Enum("percentOfRow", 6), new STShowDataAs$Enum("percentOfCol", 7), new STShowDataAs$Enum("percentOfTotal", 8), new STShowDataAs$Enum("index", 9)});
    }

    private STShowDataAs$Enum(String r1, int r2) {
        super(r1, r2);
    }

    public static STShowDataAs$Enum forInt(int r2) {
        return (STShowDataAs$Enum) ZeusTransformUtils.preCheckCast(table.forInt(r2), STShowDataAs$Enum.class, "com.obric.memorydata.plugin");
    }

    public static STShowDataAs$Enum forString(String r2) {
        return (STShowDataAs$Enum) ZeusTransformUtils.preCheckCast(table.forString(r2), STShowDataAs$Enum.class, "com.obric.memorydata.plugin");
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
