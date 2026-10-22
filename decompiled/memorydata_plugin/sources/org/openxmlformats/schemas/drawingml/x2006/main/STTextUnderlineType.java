package org.openxmlformats.schemas.drawingml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface STTextUnderlineType extends XmlToken {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STTextUnderlineType> f18666a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18667b = null;
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
    public static final Enum t = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_DASH = 8;
        static final int INT_DASH_HEAVY = 9;
        static final int INT_DASH_LONG = 10;
        static final int INT_DASH_LONG_HEAVY = 11;
        static final int INT_DBL = 4;
        static final int INT_DOTTED = 6;
        static final int INT_DOTTED_HEAVY = 7;
        static final int INT_DOT_DASH = 12;
        static final int INT_DOT_DASH_HEAVY = 13;
        static final int INT_DOT_DOT_DASH = 14;
        static final int INT_DOT_DOT_DASH_HEAVY = 15;
        static final int INT_HEAVY = 5;
        static final int INT_NONE = 1;
        static final int INT_SNG = 3;
        static final int INT_WAVY = 16;
        static final int INT_WAVY_DBL = 18;
        static final int INT_WAVY_HEAVY = 17;
        static final int INT_WORDS = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("none", 1), new Enum("words", 2), new Enum("sng", 3), new Enum("dbl", 4), new Enum("heavy", 5), new Enum("dotted", 6), new Enum("dottedHeavy", 7), new Enum("dash", 8), new Enum("dashHeavy", 9), new Enum("dashLong", 10), new Enum("dashLongHeavy", 11), new Enum("dotDash", 12), new Enum("dotDashHeavy", 13), new Enum("dotDotDash", 14), new Enum("dotDotDashHeavy", 15), new Enum("wavy", 16), new Enum("wavyHeavy", 17), new Enum("wavyDbl", 18)});
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
        SimpleTypeFactory<STTextUnderlineType> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "sttextunderlinetype469atype");
        f18666a = r0;
        f18667b = r0.getType();
        c = Enum.forString("none");
        d = Enum.forString("words");
        e = Enum.forString("sng");
        f = Enum.forString("dbl");
        g = Enum.forString("heavy");
        h = Enum.forString("dotted");
        i = Enum.forString("dottedHeavy");
        j = Enum.forString("dash");
        k = Enum.forString("dashHeavy");
        l = Enum.forString("dashLong");
        m = Enum.forString("dashLongHeavy");
        n = Enum.forString("dotDash");
        o = Enum.forString("dotDashHeavy");
        p = Enum.forString("dotDotDash");
        q = Enum.forString("dotDotDashHeavy");
        r = Enum.forString("wavy");
        s = Enum.forString("wavyHeavy");
        t = Enum.forString("wavyDbl");
    }
}
