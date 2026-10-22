package org.openxmlformats.schemas.drawingml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: classes7.dex */
public final class STEffectContainerType$Enum extends StringEnumAbstractBase {
    static final int INT_SIB = 1;
    static final int INT_TREE = 2;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = null;

    static {
        table = new StringEnumAbstractBase.Table(new STEffectContainerType$Enum[]{new STEffectContainerType$Enum("sib", 1), new STEffectContainerType$Enum("tree", 2)});
    }

    private STEffectContainerType$Enum(String r1, int r2) {
        super(r1, r2);
    }

    public static STEffectContainerType$Enum forInt(int r2) {
        return (STEffectContainerType$Enum) ZeusTransformUtils.preCheckCast(table.forInt(r2), STEffectContainerType$Enum.class, "com.obric.memorydata.plugin");
    }

    public static STEffectContainerType$Enum forString(String r2) {
        return (STEffectContainerType$Enum) ZeusTransformUtils.preCheckCast(table.forString(r2), STEffectContainerType$Enum.class, "com.obric.memorydata.plugin");
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
