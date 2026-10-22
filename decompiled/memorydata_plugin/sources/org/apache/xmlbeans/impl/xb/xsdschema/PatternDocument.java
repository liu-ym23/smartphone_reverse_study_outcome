package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface PatternDocument extends XmlObject {
    public static final DocumentFactory<PatternDocument> Factory = null;
    public static final SchemaType type = null;

    public interface Pattern extends NoFixedFacet {
        public static final ElementFactory<Pattern> Factory = null;
        public static final SchemaType type = null;

        static {
            ElementFactory<Pattern> r0 = new ElementFactory(TypeSystemHolder.typeSystem, "pattern6809elemtype");
            Factory = r0;
            type = r0.getType();
        }
    }

    static {
        DocumentFactory<PatternDocument> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "pattern9585doctype");
        Factory = r0;
        type = r0.getType();
    }
}
