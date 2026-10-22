package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface AnyDocument extends XmlObject {
    public static final DocumentFactory<AnyDocument> Factory = null;
    public static final SchemaType type = null;

    public interface Any extends Wildcard {
        public static final ElementFactory<Any> Factory = null;
        public static final SchemaType type = null;

        static {
            ElementFactory<Any> r0 = new ElementFactory(TypeSystemHolder.typeSystem, "anye9d1elemtype");
            Factory = r0;
            type = r0.getType();
        }
    }

    static {
        DocumentFactory<AnyDocument> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "anye729doctype");
        Factory = r0;
        type = r0.getType();
    }
}
