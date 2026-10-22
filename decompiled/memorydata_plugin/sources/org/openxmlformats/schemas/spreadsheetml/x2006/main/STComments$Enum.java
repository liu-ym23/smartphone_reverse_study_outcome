package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: classes8.dex */
public final class STComments$Enum extends StringEnumAbstractBase {
    static final int INT_COMM_INDICATOR = 2;
    static final int INT_COMM_IND_AND_COMMENT = 3;
    static final int INT_COMM_NONE = 1;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = null;

    static {
        table = new StringEnumAbstractBase.Table(new STComments$Enum[]{new STComments$Enum("commNone", 1), new STComments$Enum("commIndicator", 2), new STComments$Enum("commIndAndComment", 3)});
    }

    private STComments$Enum(String r1, int r2) {
        super(r1, r2);
    }

    public static STComments$Enum forInt(int r2) {
        return (STComments$Enum) ZeusTransformUtils.preCheckCast(table.forInt(r2), STComments$Enum.class, "com.obric.memorydata.plugin");
    }

    public static STComments$Enum forString(String r2) {
        return (STComments$Enum) ZeusTransformUtils.preCheckCast(table.forString(r2), STComments$Enum.class, "com.obric.memorydata.plugin");
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
