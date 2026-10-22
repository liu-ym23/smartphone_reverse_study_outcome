package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface SchemaDocument extends XmlObject {
    public static final DocumentFactory<SchemaDocument> Factory = null;
    public static final SchemaType type = null;

    public interface Schema extends OpenAttrs {
        public static final ElementFactory<Schema> Factory = null;
        public static final SchemaType type = null;

        static {
            ElementFactory<Schema> r0 = new ElementFactory(TypeSystemHolder.typeSystem, "schemad77felemtype");
            Factory = r0;
            type = r0.getType();
        }
    }

    static {
        DocumentFactory<SchemaDocument> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "schema0782doctype");
        Factory = r0;
        type = r0.getType();
    }
}
