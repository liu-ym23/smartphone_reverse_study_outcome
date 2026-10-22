package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface RestrictionDocument extends XmlObject {
    public static final DocumentFactory<RestrictionDocument> Factory = null;
    public static final SchemaType type = null;

    public interface Restriction extends Annotated {
        public static final ElementFactory<Restriction> Factory = null;
        public static final SchemaType type = null;

        static {
            ElementFactory<Restriction> r0 = new ElementFactory(TypeSystemHolder.typeSystem, "restrictionad11elemtype");
            Factory = r0;
            type = r0.getType();
        }
    }

    static {
        DocumentFactory<RestrictionDocument> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "restriction0049doctype");
        Factory = r0;
        type = r0.getType();
    }
}
