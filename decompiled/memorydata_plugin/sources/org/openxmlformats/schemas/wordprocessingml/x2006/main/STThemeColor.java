package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface STThemeColor extends XmlString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STThemeColor> f19886a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19887b = null;
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
        static final int INT_ACCENT_1 = 5;
        static final int INT_ACCENT_2 = 6;
        static final int INT_ACCENT_3 = 7;
        static final int INT_ACCENT_4 = 8;
        static final int INT_ACCENT_5 = 9;
        static final int INT_ACCENT_6 = 10;
        static final int INT_BACKGROUND_1 = 14;
        static final int INT_BACKGROUND_2 = 16;
        static final int INT_DARK_1 = 1;
        static final int INT_DARK_2 = 3;
        static final int INT_FOLLOWED_HYPERLINK = 12;
        static final int INT_HYPERLINK = 11;
        static final int INT_LIGHT_1 = 2;
        static final int INT_LIGHT_2 = 4;
        static final int INT_NONE = 13;
        static final int INT_TEXT_1 = 15;
        static final int INT_TEXT_2 = 17;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("dark1", 1), new Enum("light1", 2), new Enum("dark2", 3), new Enum("light2", 4), new Enum("accent1", 5), new Enum("accent2", 6), new Enum("accent3", 7), new Enum("accent4", 8), new Enum("accent5", 9), new Enum("accent6", 10), new Enum("hyperlink", 11), new Enum("followedHyperlink", 12), new Enum("none", 13), new Enum("background1", 14), new Enum("text1", 15), new Enum("background2", 16), new Enum("text2", 17)});
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
        SimpleTypeFactory<STThemeColor> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "stthemecolor063etype");
        f19886a = r0;
        f19887b = r0.getType();
        c = Enum.forString("dark1");
        d = Enum.forString("light1");
        e = Enum.forString("dark2");
        f = Enum.forString("light2");
        g = Enum.forString("accent1");
        h = Enum.forString("accent2");
        i = Enum.forString("accent3");
        j = Enum.forString("accent4");
        k = Enum.forString("accent5");
        l = Enum.forString("accent6");
        m = Enum.forString("hyperlink");
        n = Enum.forString("followedHyperlink");
        o = Enum.forString("none");
        p = Enum.forString("background1");
        q = Enum.forString("text1");
        r = Enum.forString("background2");
        s = Enum.forString("text2");
    }
}
