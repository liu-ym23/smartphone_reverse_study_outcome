package org.openxmlformats.schemas.drawingml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface STBlackWhiteMode extends XmlToken {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STBlackWhiteMode> f18606a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18607b = null;
    public static final Enum c = null;
    public static final Enum d = null;
    public static final Enum e = null;
    public static final Enum f = null;
    public static final Enum g = null;
    public static final Enum h = null;
    public static final Enum i = null;
    public static final Enum j = null;
    public static final Enum k = null;
    public static final Enum l = null;
    public static final Enum m = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_AUTO = 2;
        static final int INT_BLACK = 9;
        static final int INT_BLACK_GRAY = 7;
        static final int INT_BLACK_WHITE = 8;
        static final int INT_CLR = 1;
        static final int INT_GRAY = 3;
        static final int INT_GRAY_WHITE = 6;
        static final int INT_HIDDEN = 11;
        static final int INT_INV_GRAY = 5;
        static final int INT_LT_GRAY = 4;
        static final int INT_WHITE = 10;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("clr", 1), new Enum("auto", 2), new Enum("gray", 3), new Enum("ltGray", 4), new Enum("invGray", 5), new Enum("grayWhite", 6), new Enum("blackGray", 7), new Enum("blackWhite", 8), new Enum("black", 9), new Enum("white", 10), new Enum("hidden", 11)});
        }

        private Enum(String r1, int r2) {
            super(r1, r2);
        }

        public static Enum forInt(int r2) {
            return (Enum) ZeusTransformUtils.preCheckCast(table.forInt(r2), Enum.class, "com.obric.memorydata.plugin");
        }

        public static Enum forString(String r2) {
            return (Enum) ZeusTransformUtils.preCheckCast(table.forString(r2), Enum.class, "com.obric.memorydata.plugin");
        }

        private Object readResolve() {
            return forInt(intValue());
        }
    }

    static {
        SimpleTypeFactory<STBlackWhiteMode> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "stblackwhitemode0558type");
        f18606a = r0;
        f18607b = r0.getType();
        c = Enum.forString("clr");
        d = Enum.forString("auto");
        e = Enum.forString("gray");
        f = Enum.forString("ltGray");
        g = Enum.forString("invGray");
        h = Enum.forString("grayWhite");
        i = Enum.forString("blackGray");
        j = Enum.forString("blackWhite");
        k = Enum.forString("black");
        l = Enum.forString("white");
        m = Enum.forString("hidden");
    }
}
