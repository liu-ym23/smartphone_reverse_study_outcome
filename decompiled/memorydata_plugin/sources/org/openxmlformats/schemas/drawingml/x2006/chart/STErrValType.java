package org.openxmlformats.schemas.drawingml.x2006.chart;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface STErrValType extends XmlString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STErrValType> f18352a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18353b = null;
    public static final Enum c = null;
    public static final Enum d = null;
    public static final Enum e = null;
    public static final Enum f = null;
    public static final Enum g = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CUST = 1;
        static final int INT_FIXED_VAL = 2;
        static final int INT_PERCENTAGE = 3;
        static final int INT_STD_DEV = 4;
        static final int INT_STD_ERR = 5;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("cust", 1), new Enum("fixedVal", 2), new Enum("percentage", 3), new Enum("stdDev", 4), new Enum("stdErr", 5)});
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
        SimpleTypeFactory<STErrValType> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "sterrvaltype96d6type");
        f18352a = r0;
        f18353b = r0.getType();
        c = Enum.forString("cust");
        d = Enum.forString("fixedVal");
        e = Enum.forString("percentage");
        f = Enum.forString("stdDev");
        g = Enum.forString("stdErr");
    }
}
