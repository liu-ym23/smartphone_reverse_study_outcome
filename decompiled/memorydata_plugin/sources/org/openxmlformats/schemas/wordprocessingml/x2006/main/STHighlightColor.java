package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface STHighlightColor extends XmlString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STHighlightColor> f19832a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19833b = null;
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
    public static final Enum n = null;
    public static final Enum o = null;
    public static final Enum p = null;
    public static final Enum q = null;
    public static final Enum r = null;
    public static final Enum s = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_BLACK = 1;
        static final int INT_BLUE = 2;
        static final int INT_CYAN = 3;
        static final int INT_DARK_BLUE = 9;
        static final int INT_DARK_CYAN = 10;
        static final int INT_DARK_GRAY = 15;
        static final int INT_DARK_GREEN = 11;
        static final int INT_DARK_MAGENTA = 12;
        static final int INT_DARK_RED = 13;
        static final int INT_DARK_YELLOW = 14;
        static final int INT_GREEN = 4;
        static final int INT_LIGHT_GRAY = 16;
        static final int INT_MAGENTA = 5;
        static final int INT_NONE = 17;
        static final int INT_RED = 6;
        static final int INT_WHITE = 8;
        static final int INT_YELLOW = 7;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("black", 1), new Enum("blue", 2), new Enum("cyan", 3), new Enum("green", 4), new Enum("magenta", 5), new Enum("red", 6), new Enum("yellow", 7), new Enum("white", 8), new Enum("darkBlue", 9), new Enum("darkCyan", 10), new Enum("darkGreen", 11), new Enum("darkMagenta", 12), new Enum("darkRed", 13), new Enum("darkYellow", 14), new Enum("darkGray", 15), new Enum("lightGray", 16), new Enum("none", 17)});
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
        SimpleTypeFactory<STHighlightColor> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "sthighlightcolora8e9type");
        f19832a = r0;
        f19833b = r0.getType();
        c = Enum.forString("black");
        d = Enum.forString("blue");
        e = Enum.forString("cyan");
        f = Enum.forString("green");
        g = Enum.forString("magenta");
        h = Enum.forString("red");
        i = Enum.forString("yellow");
        j = Enum.forString("white");
        k = Enum.forString("darkBlue");
        l = Enum.forString("darkCyan");
        m = Enum.forString("darkGreen");
        n = Enum.forString("darkMagenta");
        o = Enum.forString("darkRed");
        p = Enum.forString("darkYellow");
        q = Enum.forString("darkGray");
        r = Enum.forString("lightGray");
        s = Enum.forString("none");
    }
}
