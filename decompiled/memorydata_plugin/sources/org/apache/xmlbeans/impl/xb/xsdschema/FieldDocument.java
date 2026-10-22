package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface FieldDocument extends XmlObject {
    public static final DocumentFactory<FieldDocument> Factory = null;
    public static final SchemaType type = null;

    public interface Field extends Annotated {
        public static final ElementFactory<Field> Factory = null;
        public static final SchemaType type = null;

        public interface Xpath extends XmlToken {
            public static final ElementFactory<Xpath> Factory = null;
            public static final SchemaType type = null;

            static {
                ElementFactory<Xpath> r0 = new ElementFactory(TypeSystemHolder.typeSystem, "xpath7f90attrtype");
                Factory = r0;
                type = r0.getType();
            }
        }

        static {
            ElementFactory<Field> r0 = new ElementFactory(TypeSystemHolder.typeSystem, "field12f5elemtype");
            Factory = r0;
            type = r0.getType();
        }
    }

    static {
        DocumentFactory<FieldDocument> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "field3f9bdoctype");
        Factory = r0;
        type = r0.getType();
    }
}
