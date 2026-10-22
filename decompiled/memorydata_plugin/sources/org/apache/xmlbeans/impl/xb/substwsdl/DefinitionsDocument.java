package org.apache.xmlbeans.impl.xb.substwsdl;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLTOOLS.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface DefinitionsDocument extends XmlObject {
    public static final DocumentFactory<DefinitionsDocument> Factory = null;
    public static final SchemaType type = null;

    public interface Definitions extends XmlObject {
        public static final ElementFactory<Definitions> Factory = null;
        public static final SchemaType type = null;

        static {
            ElementFactory<Definitions> r0 = new ElementFactory(TypeSystemHolder.typeSystem, "definitions05ddelemtype");
            Factory = r0;
            type = r0.getType();
        }
    }

    static {
        DocumentFactory<DefinitionsDocument> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "definitionsc7f1doctype");
        Factory = r0;
        type = r0.getType();
    }
}
