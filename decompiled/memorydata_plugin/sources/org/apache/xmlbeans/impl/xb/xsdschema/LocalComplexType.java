package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface LocalComplexType extends ComplexType {
    public static final DocumentFactory<LocalComplexType> Factory = null;
    public static final SchemaType type = null;

    static {
        DocumentFactory<LocalComplexType> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "localcomplextype6494type");
        Factory = r0;
        type = r0.getType();
    }
}
