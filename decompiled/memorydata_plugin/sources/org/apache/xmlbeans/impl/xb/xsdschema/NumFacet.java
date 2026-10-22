package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface NumFacet extends Facet {
    public static final DocumentFactory<NumFacet> Factory = null;
    public static final SchemaType type = null;

    static {
        DocumentFactory<NumFacet> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "numfacet93a2type");
        Factory = r0;
        type = r0.getType();
    }
}
