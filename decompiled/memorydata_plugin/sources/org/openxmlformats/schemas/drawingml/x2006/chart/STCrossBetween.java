package org.openxmlformats.schemas.drawingml.x2006.chart;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface STCrossBetween extends XmlString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STCrossBetween> f18340a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18341b = null;
    public static final Enum c = null;
    public static final Enum d = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_BETWEEN = 1;
        static final int INT_MID_CAT = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("between", 1), new Enum("midCat", 2)});
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
        SimpleTypeFactory<STCrossBetween> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "stcrossbetweenf504type");
        f18340a = r0;
        f18341b = r0.getType();
        c = Enum.forString("between");
        d = Enum.forString("midCat");
    }
}
