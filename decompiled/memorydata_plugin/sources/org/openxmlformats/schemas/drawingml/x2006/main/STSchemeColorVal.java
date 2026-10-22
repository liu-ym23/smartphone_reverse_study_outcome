package org.openxmlformats.schemas.drawingml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface STSchemeColorVal extends XmlToken {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STSchemeColorVal> f18642a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18643b = null;
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
        static final int INT_BG_1 = 1;
        static final int INT_BG_2 = 3;
        static final int INT_DK_1 = 14;
        static final int INT_DK_2 = 16;
        static final int INT_FOL_HLINK = 12;
        static final int INT_HLINK = 11;
        static final int INT_LT_1 = 15;
        static final int INT_LT_2 = 17;
        static final int INT_PH_CLR = 13;
        static final int INT_TX_1 = 2;
        static final int INT_TX_2 = 4;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("bg1", 1), new Enum("tx1", 2), new Enum("bg2", 3), new Enum("tx2", 4), new Enum("accent1", 5), new Enum("accent2", 6), new Enum("accent3", 7), new Enum("accent4", 8), new Enum("accent5", 9), new Enum("accent6", 10), new Enum("hlink", 11), new Enum("folHlink", 12), new Enum("phClr", 13), new Enum("dk1", 14), new Enum("lt1", 15), new Enum("dk2", 16), new Enum("lt2", 17)});
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
        SimpleTypeFactory<STSchemeColorVal> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "stschemecolorval722etype");
        f18642a = r0;
        f18643b = r0.getType();
        c = Enum.forString("bg1");
        d = Enum.forString("tx1");
        e = Enum.forString("bg2");
        f = Enum.forString("tx2");
        g = Enum.forString("accent1");
        h = Enum.forString("accent2");
        i = Enum.forString("accent3");
        j = Enum.forString("accent4");
        k = Enum.forString("accent5");
        l = Enum.forString("accent6");
        m = Enum.forString("hlink");
        n = Enum.forString("folHlink");
        o = Enum.forString("phClr");
        p = Enum.forString("dk1");
        q = Enum.forString("lt1");
        r = Enum.forString("dk2");
        s = Enum.forString("lt2");
    }
}
