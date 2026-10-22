package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import com.bytedance.bdlocation.client.LocationInfoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface STUnderline extends XmlString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STUnderline> f19888a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19889b = null;
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
        static final int INT_DASH = 7;
        static final int INT_DASHED_HEAVY = 8;
        static final int INT_DASH_DOT_DOT_HEAVY = 14;
        static final int INT_DASH_DOT_HEAVY = 12;
        static final int INT_DASH_LONG = 9;
        static final int INT_DASH_LONG_HEAVY = 10;
        static final int INT_DOTTED = 5;
        static final int INT_DOTTED_HEAVY = 6;
        static final int INT_DOT_DASH = 11;
        static final int INT_DOT_DOT_DASH = 13;
        static final int INT_DOUBLE = 3;
        static final int INT_NONE = 18;
        static final int INT_SINGLE = 1;
        static final int INT_THICK = 4;
        static final int INT_WAVE = 15;
        static final int INT_WAVY_DOUBLE = 17;
        static final int INT_WAVY_HEAVY = 16;
        static final int INT_WORDS = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum(LocationInfoConst.SINGLE, 1), new Enum("words", 2), new Enum("double", 3), new Enum("thick", 4), new Enum("dotted", 5), new Enum("dottedHeavy", 6), new Enum("dash", 7), new Enum("dashedHeavy", 8), new Enum("dashLong", 9), new Enum("dashLongHeavy", 10), new Enum("dotDash", 11), new Enum("dashDotHeavy", 12), new Enum("dotDotDash", 13), new Enum("dashDotDotHeavy", 14), new Enum("wave", 15), new Enum("wavyHeavy", 16), new Enum("wavyDouble", 17), new Enum("none", 18)});
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
        SimpleTypeFactory<STUnderline> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "stunderlinef416type");
        f19888a = r0;
        f19889b = r0.getType();
        c = Enum.forString(LocationInfoConst.SINGLE);
        d = Enum.forString("words");
        e = Enum.forString("double");
        f = Enum.forString("thick");
        g = Enum.forString("dotted");
        h = Enum.forString("dottedHeavy");
        i = Enum.forString("dash");
        j = Enum.forString("dashedHeavy");
        k = Enum.forString("dashLong");
        l = Enum.forString("dashLongHeavy");
        m = Enum.forString("dotDash");
        n = Enum.forString("dashDotHeavy");
        o = Enum.forString("dotDotDash");
        p = Enum.forString("dashDotDotHeavy");
        q = Enum.forString("wave");
        r = Enum.forString("wavyHeavy");
        s = Enum.forString("wavyDouble");
        t = Enum.forString("none");
    }
}
