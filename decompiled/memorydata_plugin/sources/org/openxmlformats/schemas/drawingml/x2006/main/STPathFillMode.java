package org.openxmlformats.schemas.drawingml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface STPathFillMode extends XmlToken {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STPathFillMode> f18626a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18627b = null;
    public static final Enum c = null;
    public static final Enum d = null;
    public static final Enum e = null;
    public static final Enum f = null;
    public static final Enum g = null;
    public static final Enum h = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_DARKEN = 5;
        static final int INT_DARKEN_LESS = 6;
        static final int INT_LIGHTEN = 3;
        static final int INT_LIGHTEN_LESS = 4;
        static final int INT_NONE = 1;
        static final int INT_NORM = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("none", 1), new Enum("norm", 2), new Enum("lighten", 3), new Enum("lightenLess", 4), new Enum("darken", 5), new Enum("darkenLess", 6)});
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
        SimpleTypeFactory<STPathFillMode> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "stpathfillmode3cf6type");
        f18626a = r0;
        f18627b = r0.getType();
        c = Enum.forString("none");
        d = Enum.forString("norm");
        e = Enum.forString("lighten");
        f = Enum.forString("lightenLess");
        g = Enum.forString("darken");
        h = Enum.forString("darkenLess");
    }
}
