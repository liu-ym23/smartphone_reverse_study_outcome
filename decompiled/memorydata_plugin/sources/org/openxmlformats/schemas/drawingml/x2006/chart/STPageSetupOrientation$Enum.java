package org.openxmlformats.schemas.drawingml.x2006.chart;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: classes7.dex */
public final class STPageSetupOrientation$Enum extends StringEnumAbstractBase {
    static final int INT_DEFAULT = 1;
    static final int INT_LANDSCAPE = 3;
    static final int INT_PORTRAIT = 2;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = null;

    static {
        table = new StringEnumAbstractBase.Table(new STPageSetupOrientation$Enum[]{new STPageSetupOrientation$Enum("default", 1), new STPageSetupOrientation$Enum("portrait", 2), new STPageSetupOrientation$Enum("landscape", 3)});
    }

    private STPageSetupOrientation$Enum(String r1, int r2) {
        super(r1, r2);
    }

    public static STPageSetupOrientation$Enum forInt(int r2) {
        return (STPageSetupOrientation$Enum) ZeusTransformUtils.preCheckCast(table.forInt(r2), STPageSetupOrientation$Enum.class, "com.obric.memorydata.plugin");
    }

    public static STPageSetupOrientation$Enum forString(String r2) {
        return (STPageSetupOrientation$Enum) ZeusTransformUtils.preCheckCast(table.forString(r2), STPageSetupOrientation$Enum.class, "com.obric.memorydata.plugin");
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
