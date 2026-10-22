package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: classes8.dex */
public final class STPTabLeader$Enum extends StringEnumAbstractBase {
    static final int INT_DOT = 2;
    static final int INT_HYPHEN = 3;
    static final int INT_MIDDLE_DOT = 5;
    static final int INT_NONE = 1;
    static final int INT_UNDERSCORE = 4;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = null;

    static {
        table = new StringEnumAbstractBase.Table(new STPTabLeader$Enum[]{new STPTabLeader$Enum("none", 1), new STPTabLeader$Enum("dot", 2), new STPTabLeader$Enum("hyphen", 3), new STPTabLeader$Enum("underscore", 4), new STPTabLeader$Enum("middleDot", 5)});
    }

    private STPTabLeader$Enum(String r1, int r2) {
        super(r1, r2);
    }

    public static STPTabLeader$Enum forInt(int r2) {
        return (STPTabLeader$Enum) ZeusTransformUtils.preCheckCast(table.forInt(r2), STPTabLeader$Enum.class, "com.obric.memorydata.plugin");
    }

    public static STPTabLeader$Enum forString(String r2) {
        return (STPTabLeader$Enum) ZeusTransformUtils.preCheckCast(table.forString(r2), STPTabLeader$Enum.class, "com.obric.memorydata.plugin");
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
