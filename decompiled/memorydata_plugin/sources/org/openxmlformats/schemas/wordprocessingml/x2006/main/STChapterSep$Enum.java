package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: classes8.dex */
public final class STChapterSep$Enum extends StringEnumAbstractBase {
    static final int INT_COLON = 3;
    static final int INT_EM_DASH = 4;
    static final int INT_EN_DASH = 5;
    static final int INT_HYPHEN = 1;
    static final int INT_PERIOD = 2;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = null;

    static {
        table = new StringEnumAbstractBase.Table(new STChapterSep$Enum[]{new STChapterSep$Enum("hyphen", 1), new STChapterSep$Enum(TypedValues.CycleType.S_WAVE_PERIOD, 2), new STChapterSep$Enum("colon", 3), new STChapterSep$Enum("emDash", 4), new STChapterSep$Enum("enDash", 5)});
    }

    private STChapterSep$Enum(String r1, int r2) {
        super(r1, r2);
    }

    public static STChapterSep$Enum forInt(int r2) {
        return (STChapterSep$Enum) ZeusTransformUtils.preCheckCast(table.forInt(r2), STChapterSep$Enum.class, "com.obric.memorydata.plugin");
    }

    public static STChapterSep$Enum forString(String r2) {
        return (STChapterSep$Enum) ZeusTransformUtils.preCheckCast(table.forString(r2), STChapterSep$Enum.class, "com.obric.memorydata.plugin");
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
