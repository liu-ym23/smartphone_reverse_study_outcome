package org.openxmlformats.schemas.presentationml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: classes8.dex */
public final class STTLTimeNodeMasterRelation$Enum extends StringEnumAbstractBase {
    static final int INT_LAST_CLICK = 2;
    static final int INT_NEXT_CLICK = 3;
    static final int INT_SAME_CLICK = 1;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = null;

    static {
        table = new StringEnumAbstractBase.Table(new STTLTimeNodeMasterRelation$Enum[]{new STTLTimeNodeMasterRelation$Enum("sameClick", 1), new STTLTimeNodeMasterRelation$Enum("lastClick", 2), new STTLTimeNodeMasterRelation$Enum("nextClick", 3)});
    }

    private STTLTimeNodeMasterRelation$Enum(String r1, int r2) {
        super(r1, r2);
    }

    public static STTLTimeNodeMasterRelation$Enum forInt(int r2) {
        return (STTLTimeNodeMasterRelation$Enum) ZeusTransformUtils.preCheckCast(table.forInt(r2), STTLTimeNodeMasterRelation$Enum.class, "com.obric.memorydata.plugin");
    }

    public static STTLTimeNodeMasterRelation$Enum forString(String r2) {
        return (STTLTimeNodeMasterRelation$Enum) ZeusTransformUtils.preCheckCast(table.forString(r2), STTLTimeNodeMasterRelation$Enum.class, "com.obric.memorydata.plugin");
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
