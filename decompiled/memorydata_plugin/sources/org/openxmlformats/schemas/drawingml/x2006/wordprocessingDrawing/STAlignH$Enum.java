package org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing;

import com.obric.cae.userAware.utils.UserAwareUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: classes8.dex */
public final class STAlignH$Enum extends StringEnumAbstractBase {
    static final int INT_CENTER = 3;
    static final int INT_INSIDE = 4;
    static final int INT_LEFT = 1;
    static final int INT_OUTSIDE = 5;
    static final int INT_RIGHT = 2;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = null;

    static {
        table = new StringEnumAbstractBase.Table(new STAlignH$Enum[]{new STAlignH$Enum("left", 1), new STAlignH$Enum("right", 2), new STAlignH$Enum("center", 3), new STAlignH$Enum("inside", 4), new STAlignH$Enum(UserAwareUtil.STATE_OUTSIDE, 5)});
    }

    private STAlignH$Enum(String r1, int r2) {
        super(r1, r2);
    }

    public static STAlignH$Enum forInt(int r2) {
        return (STAlignH$Enum) ZeusTransformUtils.preCheckCast(table.forInt(r2), STAlignH$Enum.class, "com.obric.memorydata.plugin");
    }

    public static STAlignH$Enum forString(String r2) {
        return (STAlignH$Enum) ZeusTransformUtils.preCheckCast(table.forString(r2), STAlignH$Enum.class, "com.obric.memorydata.plugin");
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
