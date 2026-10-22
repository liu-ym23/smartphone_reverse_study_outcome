package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: classes8.dex */
public final class STZoom$Enum extends StringEnumAbstractBase {
    static final int INT_BEST_FIT = 3;
    static final int INT_FULL_PAGE = 2;
    static final int INT_NONE = 1;
    static final int INT_TEXT_FIT = 4;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = null;

    static {
        table = new StringEnumAbstractBase.Table(new STZoom$Enum[]{new STZoom$Enum("none", 1), new STZoom$Enum("fullPage", 2), new STZoom$Enum("bestFit", 3), new STZoom$Enum("textFit", 4)});
    }

    private STZoom$Enum(String r1, int r2) {
        super(r1, r2);
    }

    public static STZoom$Enum forInt(int r2) {
        return (STZoom$Enum) ZeusTransformUtils.preCheckCast(table.forInt(r2), STZoom$Enum.class, "com.obric.memorydata.plugin");
    }

    public static STZoom$Enum forString(String r2) {
        return (STZoom$Enum) ZeusTransformUtils.preCheckCast(table.forString(r2), STZoom$Enum.class, "com.obric.memorydata.plugin");
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
