package com.microsoft.schemas.vml;

import com.bytedance.bdlocation.client.LocationInfoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: classes3.dex */
public final class STStrokeLineStyle$Enum extends StringEnumAbstractBase {
    static final int INT_SINGLE = 1;
    static final int INT_THICK_BETWEEN_THIN = 5;
    static final int INT_THICK_THIN = 4;
    static final int INT_THIN_THICK = 3;
    static final int INT_THIN_THIN = 2;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = null;

    static {
        table = new StringEnumAbstractBase.Table(new STStrokeLineStyle$Enum[]{new STStrokeLineStyle$Enum(LocationInfoConst.SINGLE, 1), new STStrokeLineStyle$Enum("thinThin", 2), new STStrokeLineStyle$Enum("thinThick", 3), new STStrokeLineStyle$Enum("thickThin", 4), new STStrokeLineStyle$Enum("thickBetweenThin", 5)});
    }

    private STStrokeLineStyle$Enum(String r1, int r2) {
        super(r1, r2);
    }

    public static STStrokeLineStyle$Enum forInt(int r2) {
        return (STStrokeLineStyle$Enum) ZeusTransformUtils.preCheckCast(table.forInt(r2), STStrokeLineStyle$Enum.class, "com.obric.memorydata.plugin");
    }

    public static STStrokeLineStyle$Enum forString(String r2) {
        return (STStrokeLineStyle$Enum) ZeusTransformUtils.preCheckCast(table.forString(r2), STStrokeLineStyle$Enum.class, "com.obric.memorydata.plugin");
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
