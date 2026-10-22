package com.microsoft.schemas.office.word;

import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: classes3.dex */
public final class STVerticalAnchor$Enum extends StringEnumAbstractBase {
    static final int INT_LINE = 4;
    static final int INT_MARGIN = 1;
    static final int INT_PAGE = 2;
    static final int INT_TEXT = 3;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = null;

    static {
        table = new StringEnumAbstractBase.Table(new STVerticalAnchor$Enum[]{new STVerticalAnchor$Enum("margin", 1), new STVerticalAnchor$Enum("page", 2), new STVerticalAnchor$Enum(IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, 3), new STVerticalAnchor$Enum("line", 4)});
    }

    private STVerticalAnchor$Enum(String r1, int r2) {
        super(r1, r2);
    }

    public static STVerticalAnchor$Enum forInt(int r2) {
        return (STVerticalAnchor$Enum) ZeusTransformUtils.preCheckCast(table.forInt(r2), STVerticalAnchor$Enum.class, "com.obric.memorydata.plugin");
    }

    public static STVerticalAnchor$Enum forString(String r2) {
        return (STVerticalAnchor$Enum) ZeusTransformUtils.preCheckCast(table.forString(r2), STVerticalAnchor$Enum.class, "com.obric.memorydata.plugin");
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
