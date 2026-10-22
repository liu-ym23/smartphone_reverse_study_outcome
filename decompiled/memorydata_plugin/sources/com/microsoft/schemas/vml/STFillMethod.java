package com.microsoft.schemas.vml;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes3.dex */
public interface STFillMethod extends XmlString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STFillMethod> f5767a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f5768b = null;
    public static final Enum c = null;
    public static final Enum d = null;
    public static final Enum e = null;
    public static final Enum f = null;
    public static final Enum g = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_ANY = 4;
        static final int INT_LINEAR = 2;
        static final int INT_LINEAR_SIGMA = 5;
        static final int INT_NONE = 1;
        static final int INT_SIGMA = 3;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("none", 1), new Enum("linear", 2), new Enum("sigma", 3), new Enum("any", 4), new Enum("linear sigma", 5)});
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
        SimpleTypeFactory<STFillMethod> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "stfillmethoda592type");
        f5767a = r0;
        f5768b = r0.getType();
        c = Enum.forString("none");
        d = Enum.forString("linear");
        e = Enum.forString("sigma");
        f = Enum.forString("any");
        g = Enum.forString("linear sigma");
    }
}
