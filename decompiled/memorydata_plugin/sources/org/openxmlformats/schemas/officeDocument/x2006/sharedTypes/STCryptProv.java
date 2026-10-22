package org.openxmlformats.schemas.officeDocument.x2006.sharedTypes;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface STCryptProv extends XmlString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STCryptProv> f19146a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19147b = null;
    public static final Enum c = null;
    public static final Enum d = null;
    public static final Enum e = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CUSTOM = 3;
        static final int INT_RSA_AES = 1;
        static final int INT_RSA_FULL = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("rsaAES", 1), new Enum("rsaFull", 2), new Enum("custom", 3)});
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
        SimpleTypeFactory<STCryptProv> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "stcryptprov36a7type");
        f19146a = r0;
        f19147b = r0.getType();
        c = Enum.forString("rsaAES");
        d = Enum.forString("rsaFull");
        e = Enum.forString("custom");
    }
}
