package org.openxmlformats.schemas.drawingml.x2006.chart;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface STBarGrouping extends XmlString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STBarGrouping> f18338a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18339b = null;
    public static final Enum c = null;
    public static final Enum d = null;
    public static final Enum e = null;
    public static final Enum f = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CLUSTERED = 2;
        static final int INT_PERCENT_STACKED = 1;
        static final int INT_STACKED = 4;
        static final int INT_STANDARD = 3;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("percentStacked", 1), new Enum("clustered", 2), new Enum("standard", 3), new Enum("stacked", 4)});
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
        SimpleTypeFactory<STBarGrouping> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "stbargrouping8400type");
        f18338a = r0;
        f18339b = r0.getType();
        c = Enum.forString("percentStacked");
        d = Enum.forString("clustered");
        e = Enum.forString("standard");
        f = Enum.forString("stacked");
    }
}
