package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: classes8.dex */
public final class STPTabAlignment$Enum extends StringEnumAbstractBase {
    static final int INT_CENTER = 2;
    static final int INT_LEFT = 1;
    static final int INT_RIGHT = 3;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = null;

    static {
        table = new StringEnumAbstractBase.Table(new STPTabAlignment$Enum[]{new STPTabAlignment$Enum("left", 1), new STPTabAlignment$Enum("center", 2), new STPTabAlignment$Enum("right", 3)});
    }

    private STPTabAlignment$Enum(String r1, int r2) {
        super(r1, r2);
    }

    public static STPTabAlignment$Enum forInt(int r2) {
        return (STPTabAlignment$Enum) ZeusTransformUtils.preCheckCast(table.forInt(r2), STPTabAlignment$Enum.class, "com.obric.memorydata.plugin");
    }

    public static STPTabAlignment$Enum forString(String r2) {
        return (STPTabAlignment$Enum) ZeusTransformUtils.preCheckCast(table.forString(r2), STPTabAlignment$Enum.class, "com.obric.memorydata.plugin");
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
