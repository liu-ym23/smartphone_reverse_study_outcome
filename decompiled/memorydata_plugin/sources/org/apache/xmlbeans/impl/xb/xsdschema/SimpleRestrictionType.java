package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface SimpleRestrictionType extends RestrictionType {
    public static final DocumentFactory<SimpleRestrictionType> Factory = null;
    public static final SchemaType type = null;

    static {
        DocumentFactory<SimpleRestrictionType> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "simplerestrictiontypeeab1type");
        Factory = r0;
        type = r0.getType();
    }
}
