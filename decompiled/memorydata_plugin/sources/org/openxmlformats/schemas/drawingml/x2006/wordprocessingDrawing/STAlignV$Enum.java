package org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing;

import com.obric.cae.userAware.utils.UserAwareUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: classes8.dex */
public final class STAlignV$Enum extends StringEnumAbstractBase {
    static final int INT_BOTTOM = 2;
    static final int INT_CENTER = 3;
    static final int INT_INSIDE = 4;
    static final int INT_OUTSIDE = 5;
    static final int INT_TOP = 1;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = null;

    static {
        table = new StringEnumAbstractBase.Table(new STAlignV$Enum[]{new STAlignV$Enum("top", 1), new STAlignV$Enum("bottom", 2), new STAlignV$Enum("center", 3), new STAlignV$Enum("inside", 4), new STAlignV$Enum(UserAwareUtil.STATE_OUTSIDE, 5)});
    }

    private STAlignV$Enum(String r1, int r2) {
        super(r1, r2);
    }

    public static STAlignV$Enum forInt(int r2) {
        return (STAlignV$Enum) ZeusTransformUtils.preCheckCast(table.forInt(r2), STAlignV$Enum.class, "com.obric.memorydata.plugin");
    }

    public static STAlignV$Enum forString(String r2) {
        return (STAlignV$Enum) ZeusTransformUtils.preCheckCast(table.forString(r2), STAlignV$Enum.class, "com.obric.memorydata.plugin");
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
