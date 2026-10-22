package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface TotalDigitsDocument extends XmlObject {
    public static final DocumentFactory<TotalDigitsDocument> Factory = null;
    public static final SchemaType type = null;

    public interface TotalDigits extends NumFacet {
        public static final ElementFactory<TotalDigits> Factory = null;
        public static final SchemaType type = null;

        static {
            ElementFactory<TotalDigits> r0 = new ElementFactory(TypeSystemHolder.typeSystem, "totaldigits2615elemtype");
            Factory = r0;
            type = r0.getType();
        }
    }

    static {
        DocumentFactory<TotalDigitsDocument> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "totaldigits4a8bdoctype");
        Factory = r0;
        type = r0.getType();
    }
}
