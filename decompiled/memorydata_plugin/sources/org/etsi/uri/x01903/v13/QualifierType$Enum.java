package org.etsi.uri.x01903.v13;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: classes7.dex */
public final class QualifierType$Enum extends StringEnumAbstractBase {
    static final int INT_OID_AS_URI = 1;
    static final int INT_OID_AS_URN = 2;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = null;

    static {
        table = new StringEnumAbstractBase.Table(new QualifierType$Enum[]{new QualifierType$Enum("OIDAsURI", 1), new QualifierType$Enum("OIDAsURN", 2)});
    }

    private QualifierType$Enum(String r1, int r2) {
        super(r1, r2);
    }

    public static QualifierType$Enum forInt(int r2) {
        return (QualifierType$Enum) ZeusTransformUtils.preCheckCast(table.forInt(r2), QualifierType$Enum.class, "com.obric.memorydata.plugin");
    }

    public static QualifierType$Enum forString(String r2) {
        return (QualifierType$Enum) ZeusTransformUtils.preCheckCast(table.forString(r2), QualifierType$Enum.class, "com.obric.memorydata.plugin");
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
