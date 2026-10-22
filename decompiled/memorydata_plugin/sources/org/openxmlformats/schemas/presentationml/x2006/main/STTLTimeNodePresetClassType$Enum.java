package org.openxmlformats.schemas.presentationml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: classes8.dex */
public final class STTLTimeNodePresetClassType$Enum extends StringEnumAbstractBase {
    static final int INT_EMPH = 3;
    static final int INT_ENTR = 1;
    static final int INT_EXIT = 2;
    static final int INT_MEDIACALL = 6;
    static final int INT_PATH = 4;
    static final int INT_VERB = 5;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = null;

    static {
        table = new StringEnumAbstractBase.Table(new STTLTimeNodePresetClassType$Enum[]{new STTLTimeNodePresetClassType$Enum("entr", 1), new STTLTimeNodePresetClassType$Enum("exit", 2), new STTLTimeNodePresetClassType$Enum("emph", 3), new STTLTimeNodePresetClassType$Enum("path", 4), new STTLTimeNodePresetClassType$Enum("verb", 5), new STTLTimeNodePresetClassType$Enum("mediacall", 6)});
    }

    private STTLTimeNodePresetClassType$Enum(String r1, int r2) {
        super(r1, r2);
    }

    public static STTLTimeNodePresetClassType$Enum forInt(int r2) {
        return (STTLTimeNodePresetClassType$Enum) ZeusTransformUtils.preCheckCast(table.forInt(r2), STTLTimeNodePresetClassType$Enum.class, "com.obric.memorydata.plugin");
    }

    public static STTLTimeNodePresetClassType$Enum forString(String r2) {
        return (STTLTimeNodePresetClassType$Enum) ZeusTransformUtils.preCheckCast(table.forString(r2), STTLTimeNodePresetClassType$Enum.class, "com.obric.memorydata.plugin");
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
