package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface DocumentationDocument extends XmlObject {
    public static final DocumentFactory<DocumentationDocument> Factory = null;
    public static final SchemaType type = null;

    public interface Documentation extends XmlObject {
        public static final ElementFactory<Documentation> Factory = null;
        public static final SchemaType type = null;

        static {
            ElementFactory<Documentation> r0 = new ElementFactory(TypeSystemHolder.typeSystem, "documentationa475elemtype");
            Factory = r0;
            type = r0.getType();
        }
    }

    static {
        DocumentFactory<DocumentationDocument> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "documentation6cdbdoctype");
        Factory = r0;
        type = r0.getType();
    }
}
