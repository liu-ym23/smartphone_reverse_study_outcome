package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: classes8.dex */
public final class STPhoneticAlignment$Enum extends StringEnumAbstractBase {
    static final int INT_CENTER = 3;
    static final int INT_DISTRIBUTED = 4;
    static final int INT_LEFT = 2;
    static final int INT_NO_CONTROL = 1;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = null;

    static {
        table = new StringEnumAbstractBase.Table(new STPhoneticAlignment$Enum[]{new STPhoneticAlignment$Enum("noControl", 1), new STPhoneticAlignment$Enum("left", 2), new STPhoneticAlignment$Enum("center", 3), new STPhoneticAlignment$Enum("distributed", 4)});
    }

    private STPhoneticAlignment$Enum(String r1, int r2) {
        super(r1, r2);
    }

    public static STPhoneticAlignment$Enum forInt(int r2) {
        return (STPhoneticAlignment$Enum) ZeusTransformUtils.preCheckCast(table.forInt(r2), STPhoneticAlignment$Enum.class, "com.obric.memorydata.plugin");
    }

    public static STPhoneticAlignment$Enum forString(String r2) {
        return (STPhoneticAlignment$Enum) ZeusTransformUtils.preCheckCast(table.forString(r2), STPhoneticAlignment$Enum.class, "com.obric.memorydata.plugin");
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
