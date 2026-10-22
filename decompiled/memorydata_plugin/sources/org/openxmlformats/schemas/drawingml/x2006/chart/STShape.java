package org.openxmlformats.schemas.drawingml.x2006.chart;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface STShape extends XmlString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STShape> f18374a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18375b = null;
    public static final Enum c = null;
    public static final Enum d = null;
    public static final Enum e = null;
    public static final Enum f = null;
    public static final Enum g = null;
    public static final Enum h = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_BOX = 3;
        static final int INT_CONE = 1;
        static final int INT_CONE_TO_MAX = 2;
        static final int INT_CYLINDER = 4;
        static final int INT_PYRAMID = 5;
        static final int INT_PYRAMID_TO_MAX = 6;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("cone", 1), new Enum("coneToMax", 2), new Enum("box", 3), new Enum("cylinder", 4), new Enum("pyramid", 5), new Enum("pyramidToMax", 6)});
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
        SimpleTypeFactory<STShape> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "stshapecdf5type");
        f18374a = r0;
        f18375b = r0.getType();
        c = Enum.forString("cone");
        d = Enum.forString("coneToMax");
        e = Enum.forString("box");
        f = Enum.forString("cylinder");
        g = Enum.forString("pyramid");
        h = Enum.forString("pyramidToMax");
    }
}
