package com.microsoft.schemas.office.excel;

import com.tom_roush.pdfbox.pdmodel.a.d.e;
import com.tom_roush.pdfbox.pdmodel.a.d.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes3.dex */
public interface STObjectType extends XmlString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STObjectType> f5677a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f5678b = null;
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
        static final int INT_BUTTON = 1;
        static final int INT_CHECKBOX = 2;
        static final int INT_DIALOG = 3;
        static final int INT_DROP = 4;
        static final int INT_EDIT = 5;
        static final int INT_GROUP = 18;
        static final int INT_G_BOX = 6;
        static final int INT_LABEL = 7;
        static final int INT_LINE_A = 8;
        static final int INT_LIST = 9;
        static final int INT_MOVIE = 10;
        static final int INT_NOTE = 11;
        static final int INT_PICT = 12;
        static final int INT_RADIO = 13;
        static final int INT_RECT = 19;
        static final int INT_RECT_A = 14;
        static final int INT_SCROLL = 15;
        static final int INT_SHAPE = 17;
        static final int INT_SPIN = 16;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("Button", 1), new Enum("Checkbox", 2), new Enum("Dialog", 3), new Enum("Drop", 4), new Enum("Edit", 5), new Enum("GBox", 6), new Enum("Label", 7), new Enum("LineA", 8), new Enum(e.f16168a, 9), new Enum("Movie", 10), new Enum(i.H, 11), new Enum("Pict", 12), new Enum("Radio", 13), new Enum("RectA", 14), new Enum("Scroll", 15), new Enum("Spin", 16), new Enum("Shape", 17), new Enum("Group", 18), new Enum("Rect", 19)});
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
        SimpleTypeFactory<STObjectType> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "stobjecttype97a7type");
        f5677a = r0;
        f5678b = r0.getType();
        c = Enum.forString("Button");
        d = Enum.forString("Checkbox");
        e = Enum.forString("Dialog");
        f = Enum.forString("Drop");
        g = Enum.forString("Edit");
        h = Enum.forString("GBox");
        i = Enum.forString("Label");
        j = Enum.forString("LineA");
        k = Enum.forString(e.f16168a);
        l = Enum.forString("Movie");
        m = Enum.forString(i.H);
        n = Enum.forString("Pict");
        o = Enum.forString("Radio");
        p = Enum.forString("RectA");
        q = Enum.forString("Scroll");
        r = Enum.forString("Spin");
        s = Enum.forString("Shape");
        t = Enum.forString("Group");
        u = Enum.forString("Rect");
    }
}
