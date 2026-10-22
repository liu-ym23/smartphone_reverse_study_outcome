package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface NoFixedFacet extends Facet {
    public static final DocumentFactory<NoFixedFacet> Factory = null;
    public static final SchemaType type = null;

    static {
        DocumentFactory<NoFixedFacet> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "nofixedfacet250ftype");
        Factory = r0;
        type = r0.getType();
    }
}
