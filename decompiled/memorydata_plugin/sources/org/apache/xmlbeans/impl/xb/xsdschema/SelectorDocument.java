package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface SelectorDocument extends XmlObject {
    public static final DocumentFactory<SelectorDocument> Factory = null;
    public static final SchemaType type = null;

    public interface Selector extends Annotated {
        public static final ElementFactory<Selector> Factory = null;
        public static final SchemaType type = null;

        public interface Xpath extends XmlToken {
            public static final ElementFactory<Xpath> Factory = null;
            public static final SchemaType type = null;

            static {
                ElementFactory<Xpath> r0 = new ElementFactory(TypeSystemHolder.typeSystem, "xpath6f9aattrtype");
                Factory = r0;
                type = r0.getType();
            }
        }

        static {
            ElementFactory<Selector> r0 = new ElementFactory(TypeSystemHolder.typeSystem, "selector233felemtype");
            Factory = r0;
            type = r0.getType();
        }
    }

    static {
        DocumentFactory<SelectorDocument> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "selectorcb44doctype");
        Factory = r0;
        type = r0.getType();
    }
}
