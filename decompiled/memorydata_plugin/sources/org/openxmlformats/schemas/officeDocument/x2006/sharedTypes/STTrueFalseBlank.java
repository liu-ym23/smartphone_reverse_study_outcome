package org.openxmlformats.schemas.officeDocument.x2006.sharedTypes;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface STTrueFalseBlank extends XmlString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STTrueFalseBlank> f19152a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19153b = null;
    public static final Enum c = null;
    public static final Enum d = null;
    public static final Enum e = null;
    public static final Enum f = null;
    public static final Enum g = null;
    public static final Enum h = null;
    public static final Enum i = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_F = 2;
        static final int INT_FALSE = 4;
        static final int INT_FALSE_2 = 7;
        static final int INT_T = 1;
        static final int INT_TRUE = 3;
        static final int INT_TRUE_2 = 6;
        static final int INT_X = 5;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("t", 1), new Enum(com.bytedance.apm.util.f.f1488a, 2), new Enum("true", 3), new Enum("false", 4), new Enum("", 5), new Enum("True", 6), new Enum("False", 7)});
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
        SimpleTypeFactory<STTrueFalseBlank> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "sttruefalseblank5459type");
        f19152a = r0;
        f19153b = r0.getType();
        c = Enum.forString("t");
        d = Enum.forString(com.bytedance.apm.util.f.f1488a);
        e = Enum.forString("true");
        f = Enum.forString("false");
        g = Enum.forString("");
        h = Enum.forString("True");
        i = Enum.forString("False");
    }
}
