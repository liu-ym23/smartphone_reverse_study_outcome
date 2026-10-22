package org.openxmlformats.schemas.officeDocument.x2006.sharedTypes;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: classes8.dex */
public final class STConformanceClass$Enum extends StringEnumAbstractBase {
    static final int INT_STRICT = 1;
    static final int INT_TRANSITIONAL = 2;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = null;

    static {
        table = new StringEnumAbstractBase.Table(new STConformanceClass$Enum[]{new STConformanceClass$Enum("strict", 1), new STConformanceClass$Enum("transitional", 2)});
    }

    private STConformanceClass$Enum(String r1, int r2) {
        super(r1, r2);
    }

    public static STConformanceClass$Enum forInt(int r2) {
        return (STConformanceClass$Enum) ZeusTransformUtils.preCheckCast(table.forInt(r2), STConformanceClass$Enum.class, "com.obric.memorydata.plugin");
    }

    public static STConformanceClass$Enum forString(String r2) {
        return (STConformanceClass$Enum) ZeusTransformUtils.preCheckCast(table.forString(r2), STConformanceClass$Enum.class, "com.obric.memorydata.plugin");
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
