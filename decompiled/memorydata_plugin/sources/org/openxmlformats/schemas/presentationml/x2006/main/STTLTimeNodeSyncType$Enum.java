package org.openxmlformats.schemas.presentationml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: classes8.dex */
public final class STTLTimeNodeSyncType$Enum extends StringEnumAbstractBase {
    static final int INT_CAN_SLIP = 1;
    static final int INT_LOCKED = 2;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = null;

    static {
        table = new StringEnumAbstractBase.Table(new STTLTimeNodeSyncType$Enum[]{new STTLTimeNodeSyncType$Enum("canSlip", 1), new STTLTimeNodeSyncType$Enum("locked", 2)});
    }

    private STTLTimeNodeSyncType$Enum(String r1, int r2) {
        super(r1, r2);
    }

    public static STTLTimeNodeSyncType$Enum forInt(int r2) {
        return (STTLTimeNodeSyncType$Enum) ZeusTransformUtils.preCheckCast(table.forInt(r2), STTLTimeNodeSyncType$Enum.class, "com.obric.memorydata.plugin");
    }

    public static STTLTimeNodeSyncType$Enum forString(String r2) {
        return (STTLTimeNodeSyncType$Enum) ZeusTransformUtils.preCheckCast(table.forString(r2), STTLTimeNodeSyncType$Enum.class, "com.obric.memorydata.plugin");
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
