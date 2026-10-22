package org.apache.xmlbeans.impl.xb.xsdschema;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlNMTOKEN;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface Attribute extends Annotated {
    public static final DocumentFactory<Attribute> Factory = null;
    public static final SchemaType type = null;

    public interface Use extends XmlNMTOKEN {
        public static final ElementFactory<Use> Factory = null;
        public static final Enum OPTIONAL = null;
        public static final Enum PROHIBITED = null;
        public static final Enum REQUIRED = null;
        public static final SchemaType type = null;

        public static final class Enum extends StringEnumAbstractBase {
            static final int INT_OPTIONAL = 2;
            static final int INT_PROHIBITED = 1;
            static final int INT_REQUIRED = 3;
            private static final long serialVersionUID = 1;
            public static final StringEnumAbstractBase.Table table = null;

            static {
                table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("prohibited", 1), new Enum("optional", 2), new Enum("required", 3)});
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
            ElementFactory<Use> r0 = new ElementFactory(TypeSystemHolder.typeSystem, "usea41aattrtype");
            Factory = r0;
            type = r0.getType();
            PROHIBITED = Enum.forString("prohibited");
            OPTIONAL = Enum.forString("optional");
            REQUIRED = Enum.forString("required");
        }
    }

    static {
        DocumentFactory<Attribute> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "attribute83a9type");
        Factory = r0;
        type = r0.getType();
    }

    QName getType();
}
