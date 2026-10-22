package com.microsoft.schemas.vml;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: classes3.dex */
public final class STImageAspect$Enum extends StringEnumAbstractBase {
    static final int INT_AT_LEAST = 3;
    static final int INT_AT_MOST = 2;
    static final int INT_IGNORE = 1;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = null;

    static {
        table = new StringEnumAbstractBase.Table(new STImageAspect$Enum[]{new STImageAspect$Enum("ignore", 1), new STImageAspect$Enum("atMost", 2), new STImageAspect$Enum("atLeast", 3)});
    }

    private STImageAspect$Enum(String r1, int r2) {
        super(r1, r2);
    }

    public static STImageAspect$Enum forInt(int r2) {
        return (STImageAspect$Enum) ZeusTransformUtils.preCheckCast(table.forInt(r2), STImageAspect$Enum.class, "com.obric.memorydata.plugin");
    }

    public static STImageAspect$Enum forString(String r2) {
        return (STImageAspect$Enum) ZeusTransformUtils.preCheckCast(table.forString(r2), STImageAspect$Enum.class, "com.obric.memorydata.plugin");
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
