package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface ImportDocument extends XmlObject {
    public static final DocumentFactory<ImportDocument> Factory = null;
    public static final SchemaType type = null;

    public interface Import extends Annotated {
        public static final ElementFactory<Import> Factory = null;
        public static final SchemaType type = null;

        static {
            ElementFactory<Import> r0 = new ElementFactory(TypeSystemHolder.typeSystem, "importe2ffelemtype");
            Factory = r0;
            type = r0.getType();
        }
    }

    static {
        DocumentFactory<ImportDocument> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "import99fedoctype");
        Factory = r0;
        type = r0.getType();
    }
}
