package org.apache.xmlbeans.impl.xb.xmlconfig;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;
import org.apache.xmlbeans.metadata.system.sXMLCONFIG.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface Qnametargetenum extends XmlToken {
    public static final Enum ACCESSOR_ATTRIBUTE = null;
    public static final Enum ACCESSOR_ELEMENT = null;
    public static final Enum DOCUMENT_TYPE = null;
    public static final SimpleTypeFactory<Qnametargetenum> Factory = null;
    public static final Enum TYPE = null;
    public static final SchemaType type = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_ACCESSOR_ATTRIBUTE = 4;
        static final int INT_ACCESSOR_ELEMENT = 3;
        static final int INT_DOCUMENT_TYPE = 2;
        static final int INT_TYPE = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("type", 1), new Enum("document-type", 2), new Enum("accessor-element", 3), new Enum("accessor-attribute", 4)});
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
        SimpleTypeFactory<Qnametargetenum> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "qnametargetenum9f8ftype");
        Factory = r0;
        type = r0.getType();
        TYPE = Enum.forString("type");
        DOCUMENT_TYPE = Enum.forString("document-type");
        ACCESSOR_ELEMENT = Enum.forString("accessor-element");
        ACCESSOR_ATTRIBUTE = Enum.forString("accessor-attribute");
    }
}
