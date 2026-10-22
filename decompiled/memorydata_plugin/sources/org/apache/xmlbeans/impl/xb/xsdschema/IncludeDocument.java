package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface IncludeDocument extends XmlObject {
    public static final DocumentFactory<IncludeDocument> Factory = null;
    public static final SchemaType type = null;

    public interface Include extends Annotated {
        public static final ElementFactory<Include> Factory = null;
        public static final SchemaType type = null;

        static {
            ElementFactory<Include> r0 = new ElementFactory(TypeSystemHolder.typeSystem, "include59d9elemtype");
            Factory = r0;
            type = r0.getType();
        }
    }

    static {
        DocumentFactory<IncludeDocument> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "includeaf6ddoctype");
        Factory = r0;
        type = r0.getType();
    }
}
