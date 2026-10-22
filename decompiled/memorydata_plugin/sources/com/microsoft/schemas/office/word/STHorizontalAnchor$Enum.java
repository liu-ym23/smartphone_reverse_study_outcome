package com.microsoft.schemas.office.word;

import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: classes3.dex */
public final class STHorizontalAnchor$Enum extends StringEnumAbstractBase {
    static final int INT_CHAR = 4;
    static final int INT_MARGIN = 1;
    static final int INT_PAGE = 2;
    static final int INT_TEXT = 3;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = null;

    static {
        table = new StringEnumAbstractBase.Table(new STHorizontalAnchor$Enum[]{new STHorizontalAnchor$Enum("margin", 1), new STHorizontalAnchor$Enum("page", 2), new STHorizontalAnchor$Enum(IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, 3), new STHorizontalAnchor$Enum("char", 4)});
    }

    private STHorizontalAnchor$Enum(String r1, int r2) {
        super(r1, r2);
    }

    public static STHorizontalAnchor$Enum forInt(int r2) {
        return (STHorizontalAnchor$Enum) ZeusTransformUtils.preCheckCast(table.forInt(r2), STHorizontalAnchor$Enum.class, "com.obric.memorydata.plugin");
    }

    public static STHorizontalAnchor$Enum forString(String r2) {
        return (STHorizontalAnchor$Enum) ZeusTransformUtils.preCheckCast(table.forString(r2), STHorizontalAnchor$Enum.class, "com.obric.memorydata.plugin");
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
