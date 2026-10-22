package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface STPatternType extends XmlString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STPatternType> f19379a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19380b = null;
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
    public static final Enum u = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_DARK_DOWN = 8;
        static final int INT_DARK_GRAY = 4;
        static final int INT_DARK_GRID = 10;
        static final int INT_DARK_HORIZONTAL = 6;
        static final int INT_DARK_TRELLIS = 11;
        static final int INT_DARK_UP = 9;
        static final int INT_DARK_VERTICAL = 7;
        static final int INT_GRAY_0625 = 19;
        static final int INT_GRAY_125 = 18;
        static final int INT_LIGHT_DOWN = 14;
        static final int INT_LIGHT_GRAY = 5;
        static final int INT_LIGHT_GRID = 16;
        static final int INT_LIGHT_HORIZONTAL = 12;
        static final int INT_LIGHT_TRELLIS = 17;
        static final int INT_LIGHT_UP = 15;
        static final int INT_LIGHT_VERTICAL = 13;
        static final int INT_MEDIUM_GRAY = 3;
        static final int INT_NONE = 1;
        static final int INT_SOLID = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("none", 1), new Enum("solid", 2), new Enum("mediumGray", 3), new Enum("darkGray", 4), new Enum("lightGray", 5), new Enum("darkHorizontal", 6), new Enum("darkVertical", 7), new Enum("darkDown", 8), new Enum("darkUp", 9), new Enum("darkGrid", 10), new Enum("darkTrellis", 11), new Enum("lightHorizontal", 12), new Enum("lightVertical", 13), new Enum("lightDown", 14), new Enum("lightUp", 15), new Enum("lightGrid", 16), new Enum("lightTrellis", 17), new Enum("gray125", 18), new Enum("gray0625", 19)});
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
        SimpleTypeFactory<STPatternType> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "stpatterntype7939type");
        f19379a = r0;
        f19380b = r0.getType();
        c = Enum.forString("none");
        d = Enum.forString("solid");
        e = Enum.forString("mediumGray");
        f = Enum.forString("darkGray");
        g = Enum.forString("lightGray");
        h = Enum.forString("darkHorizontal");
        i = Enum.forString("darkVertical");
        j = Enum.forString("darkDown");
        k = Enum.forString("darkUp");
        l = Enum.forString("darkGrid");
        m = Enum.forString("darkTrellis");
        n = Enum.forString("lightHorizontal");
        o = Enum.forString("lightVertical");
        p = Enum.forString("lightDown");
        q = Enum.forString("lightUp");
        r = Enum.forString("lightGrid");
        s = Enum.forString("lightTrellis");
        t = Enum.forString("gray125");
        u = Enum.forString("gray0625");
    }
}
