package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface RedefineDocument extends XmlObject {
    public static final DocumentFactory<RedefineDocument> Factory = null;
    public static final SchemaType type = null;

    public interface Redefine extends OpenAttrs {
        public static final ElementFactory<Redefine> Factory = null;
        public static final SchemaType type = null;

        static {
            ElementFactory<Redefine> r0 = new ElementFactory(TypeSystemHolder.typeSystem, "redefine9e9felemtype");
            Factory = r0;
            type = r0.getType();
        }
    }

    static {
        DocumentFactory<RedefineDocument> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "redefine3f55doctype");
        Factory = r0;
        type = r0.getType();
    }
}
