package org.apache.xmlbeans.impl.xb.xsdschema;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlNMTOKEN;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface WhiteSpaceDocument extends XmlObject {
    public static final DocumentFactory<WhiteSpaceDocument> Factory = null;
    public static final SchemaType type = null;

    public interface WhiteSpace extends Facet {
        public static final ElementFactory<WhiteSpace> Factory = null;
        public static final SchemaType type = null;

        public interface Value extends XmlNMTOKEN {
            public static final Enum COLLAPSE = null;
            public static final ElementFactory<Value> Factory = null;
            public static final Enum PRESERVE = null;
            public static final Enum REPLACE = null;
            public static final SchemaType type = null;

            public static final class Enum extends StringEnumAbstractBase {
                static final int INT_COLLAPSE = 3;
                static final int INT_PRESERVE = 1;
                static final int INT_REPLACE = 2;
                private static final long serialVersionUID = 1;
                public static final StringEnumAbstractBase.Table table = null;

                static {
                    table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("preserve", 1), new Enum("replace", 2), new Enum("collapse", 3)});
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
                ElementFactory<Value> r0 = new ElementFactory(TypeSystemHolder.typeSystem, "value8186attrtype");
                Factory = r0;
                type = r0.getType();
                PRESERVE = Enum.forString("preserve");
                REPLACE = Enum.forString("replace");
                COLLAPSE = Enum.forString("collapse");
            }
        }

        static {
            ElementFactory<WhiteSpace> r0 = new ElementFactory(TypeSystemHolder.typeSystem, "whitespace97ffelemtype");
            Factory = r0;
            type = r0.getType();
        }
    }

    static {
        DocumentFactory<WhiteSpaceDocument> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "whitespaced2c6doctype");
        Factory = r0;
        type = r0.getType();
    }
}
