package org.openxmlformats.schemas.drawingml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: classes7.dex */
public final class STPresetMaterialType$Enum extends StringEnumAbstractBase {
    static final int INT_CLEAR = 13;
    static final int INT_DK_EDGE = 11;
    static final int INT_FLAT = 14;
    static final int INT_LEGACY_MATTE = 1;
    static final int INT_LEGACY_METAL = 3;
    static final int INT_LEGACY_PLASTIC = 2;
    static final int INT_LEGACY_WIREFRAME = 4;
    static final int INT_MATTE = 5;
    static final int INT_METAL = 7;
    static final int INT_PLASTIC = 6;
    static final int INT_POWDER = 10;
    static final int INT_SOFTMETAL = 15;
    static final int INT_SOFT_EDGE = 12;
    static final int INT_TRANSLUCENT_POWDER = 9;
    static final int INT_WARM_MATTE = 8;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = null;

    static {
        table = new StringEnumAbstractBase.Table(new STPresetMaterialType$Enum[]{new STPresetMaterialType$Enum("legacyMatte", 1), new STPresetMaterialType$Enum("legacyPlastic", 2), new STPresetMaterialType$Enum("legacyMetal", 3), new STPresetMaterialType$Enum("legacyWireframe", 4), new STPresetMaterialType$Enum("matte", 5), new STPresetMaterialType$Enum("plastic", 6), new STPresetMaterialType$Enum("metal", 7), new STPresetMaterialType$Enum("warmMatte", 8), new STPresetMaterialType$Enum("translucentPowder", 9), new STPresetMaterialType$Enum("powder", 10), new STPresetMaterialType$Enum("dkEdge", 11), new STPresetMaterialType$Enum("softEdge", 12), new STPresetMaterialType$Enum("clear", 13), new STPresetMaterialType$Enum("flat", 14), new STPresetMaterialType$Enum("softmetal", 15)});
    }

    private STPresetMaterialType$Enum(String r1, int r2) {
        super(r1, r2);
    }

    public static STPresetMaterialType$Enum forInt(int r2) {
        return (STPresetMaterialType$Enum) ZeusTransformUtils.preCheckCast(table.forInt(r2), STPresetMaterialType$Enum.class, "com.obric.memorydata.plugin");
    }

    public static STPresetMaterialType$Enum forString(String r2) {
        return (STPresetMaterialType$Enum) ZeusTransformUtils.preCheckCast(table.forString(r2), STPresetMaterialType$Enum.class, "com.obric.memorydata.plugin");
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
