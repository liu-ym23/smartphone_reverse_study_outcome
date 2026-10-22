package com.microsoft.schemas.office.office;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: classes3.dex */
public final class STScreenSize$Enum extends StringEnumAbstractBase {
    static final int INT_X_1024_768 = 5;
    static final int INT_X_1152_862 = 6;
    static final int INT_X_544_376 = 1;
    static final int INT_X_640_480 = 2;
    static final int INT_X_720_512 = 3;
    static final int INT_X_800_600 = 4;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = null;

    static {
        table = new StringEnumAbstractBase.Table(new STScreenSize$Enum[]{new STScreenSize$Enum("544,376", 1), new STScreenSize$Enum("640,480", 2), new STScreenSize$Enum("720,512", 3), new STScreenSize$Enum("800,600", 4), new STScreenSize$Enum("1024,768", 5), new STScreenSize$Enum("1152,862", 6)});
    }

    private STScreenSize$Enum(String r1, int r2) {
        super(r1, r2);
    }

    public static STScreenSize$Enum forInt(int r2) {
        return (STScreenSize$Enum) ZeusTransformUtils.preCheckCast(table.forInt(r2), STScreenSize$Enum.class, "com.obric.memorydata.plugin");
    }

    public static STScreenSize$Enum forString(String r2) {
        return (STScreenSize$Enum) ZeusTransformUtils.preCheckCast(table.forString(r2), STScreenSize$Enum.class, "com.obric.memorydata.plugin");
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
