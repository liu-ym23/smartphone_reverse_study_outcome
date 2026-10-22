package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface NotationDocument extends XmlObject {
    public static final DocumentFactory<NotationDocument> Factory = null;
    public static final SchemaType type = null;

    public interface Notation extends Annotated {
        public static final ElementFactory<Notation> Factory = null;
        public static final SchemaType type = null;

        static {
            ElementFactory<Notation> r0 = new ElementFactory(TypeSystemHolder.typeSystem, "notation8b1felemtype");
            Factory = r0;
            type = r0.getType();
        }
    }

    static {
        DocumentFactory<NotationDocument> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "notation3381doctype");
        Factory = r0;
        type = r0.getType();
    }
}
