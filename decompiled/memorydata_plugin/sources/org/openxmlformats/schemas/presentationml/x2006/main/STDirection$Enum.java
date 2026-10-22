package org.openxmlformats.schemas.presentationml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: classes8.dex */
public final class STDirection$Enum extends StringEnumAbstractBase {
    static final int INT_HORZ = 1;
    static final int INT_VERT = 2;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = null;

    static {
        table = new StringEnumAbstractBase.Table(new STDirection$Enum[]{new STDirection$Enum("horz", 1), new STDirection$Enum("vert", 2)});
    }

    private STDirection$Enum(String r1, int r2) {
        super(r1, r2);
    }

    public static STDirection$Enum forInt(int r2) {
        return (STDirection$Enum) ZeusTransformUtils.preCheckCast(table.forInt(r2), STDirection$Enum.class, "com.obric.memorydata.plugin");
    }

    public static STDirection$Enum forString(String r2) {
        return (STDirection$Enum) ZeusTransformUtils.preCheckCast(table.forString(r2), STDirection$Enum.class, "com.obric.memorydata.plugin");
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
