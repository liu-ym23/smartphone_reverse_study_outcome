package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface KeyrefDocument extends XmlObject {
    public static final DocumentFactory<KeyrefDocument> Factory = null;
    public static final SchemaType type = null;

    public interface Keyref extends Keybase {
        public static final ElementFactory<Keyref> Factory = null;
        public static final SchemaType type = null;

        static {
            ElementFactory<Keyref> r0 = new ElementFactory(TypeSystemHolder.typeSystem, "keyref7a1felemtype");
            Factory = r0;
            type = r0.getType();
        }
    }

    static {
        DocumentFactory<KeyrefDocument> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "keyref45afdoctype");
        Factory = r0;
        type = r0.getType();
    }
}
