package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: classes8.dex */
public final class STSortBy$Enum extends StringEnumAbstractBase {
    static final int INT_CELL_COLOR = 2;
    static final int INT_FONT_COLOR = 3;
    static final int INT_ICON = 4;
    static final int INT_VALUE = 1;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = null;

    static {
        table = new StringEnumAbstractBase.Table(new STSortBy$Enum[]{new STSortBy$Enum(EventBody.KEY_VALUE, 1), new STSortBy$Enum("cellColor", 2), new STSortBy$Enum("fontColor", 3), new STSortBy$Enum("icon", 4)});
    }

    private STSortBy$Enum(String r1, int r2) {
        super(r1, r2);
    }

    public static STSortBy$Enum forInt(int r2) {
        return (STSortBy$Enum) ZeusTransformUtils.preCheckCast(table.forInt(r2), STSortBy$Enum.class, "com.obric.memorydata.plugin");
    }

    public static STSortBy$Enum forString(String r2) {
        return (STSortBy$Enum) ZeusTransformUtils.preCheckCast(table.forString(r2), STSortBy$Enum.class, "com.obric.memorydata.plugin");
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
