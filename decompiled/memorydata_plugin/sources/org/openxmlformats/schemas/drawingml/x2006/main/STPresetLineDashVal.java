package org.openxmlformats.schemas.drawingml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface STPresetLineDashVal extends XmlToken {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STPresetLineDashVal> f18635a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18636b = null;
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
        static final int INT_DASH = 3;
        static final int INT_DASH_DOT = 5;
        static final int INT_DOT = 2;
        static final int INT_LG_DASH = 4;
        static final int INT_LG_DASH_DOT = 6;
        static final int INT_LG_DASH_DOT_DOT = 7;
        static final int INT_SOLID = 1;
        static final int INT_SYS_DASH = 8;
        static final int INT_SYS_DASH_DOT = 10;
        static final int INT_SYS_DASH_DOT_DOT = 11;
        static final int INT_SYS_DOT = 9;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("solid", 1), new Enum("dot", 2), new Enum("dash", 3), new Enum("lgDash", 4), new Enum("dashDot", 5), new Enum("lgDashDot", 6), new Enum("lgDashDotDot", 7), new Enum("sysDash", 8), new Enum("sysDot", 9), new Enum("sysDashDot", 10), new Enum("sysDashDotDot", 11)});
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
        SimpleTypeFactory<STPresetLineDashVal> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "stpresetlinedashval159dtype");
        f18635a = r0;
        f18636b = r0.getType();
        c = Enum.forString("solid");
        d = Enum.forString("dot");
        e = Enum.forString("dash");
        f = Enum.forString("lgDash");
        g = Enum.forString("dashDot");
        h = Enum.forString("lgDashDot");
        i = Enum.forString("lgDashDotDot");
        j = Enum.forString("sysDash");
        k = Enum.forString("sysDot");
        l = Enum.forString("sysDashDot");
        m = Enum.forString("sysDashDotDot");
    }
}
