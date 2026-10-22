package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface STBorderStyle extends XmlString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STBorderStyle> f19335a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19336b = null;
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

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_DASHED = 4;
        static final int INT_DASH_DOT = 10;
        static final int INT_DASH_DOT_DOT = 12;
        static final int INT_DOTTED = 5;
        static final int INT_DOUBLE = 7;
        static final int INT_HAIR = 8;
        static final int INT_MEDIUM = 3;
        static final int INT_MEDIUM_DASHED = 9;
        static final int INT_MEDIUM_DASH_DOT = 11;
        static final int INT_MEDIUM_DASH_DOT_DOT = 13;
        static final int INT_NONE = 1;
        static final int INT_SLANT_DASH_DOT = 14;
        static final int INT_THICK = 6;
        static final int INT_THIN = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("none", 1), new Enum("thin", 2), new Enum("medium", 3), new Enum("dashed", 4), new Enum("dotted", 5), new Enum("thick", 6), new Enum("double", 7), new Enum("hair", 8), new Enum("mediumDashed", 9), new Enum("dashDot", 10), new Enum("mediumDashDot", 11), new Enum("dashDotDot", 12), new Enum("mediumDashDotDot", 13), new Enum("slantDashDot", 14)});
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
        SimpleTypeFactory<STBorderStyle> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "stborderstylec774type");
        f19335a = r0;
        f19336b = r0.getType();
        c = Enum.forString("none");
        d = Enum.forString("thin");
        e = Enum.forString("medium");
        f = Enum.forString("dashed");
        g = Enum.forString("dotted");
        h = Enum.forString("thick");
        i = Enum.forString("double");
        j = Enum.forString("hair");
        k = Enum.forString("mediumDashed");
        l = Enum.forString("dashDot");
        m = Enum.forString("mediumDashDot");
        n = Enum.forString("dashDotDot");
        o = Enum.forString("mediumDashDotDot");
        p = Enum.forString("slantDashDot");
    }
}
