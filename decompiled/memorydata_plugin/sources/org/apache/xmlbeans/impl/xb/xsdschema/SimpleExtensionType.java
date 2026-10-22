package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface SimpleExtensionType extends ExtensionType {
    public static final DocumentFactory<SimpleExtensionType> Factory = null;
    public static final SchemaType type = null;

    static {
        DocumentFactory<SimpleExtensionType> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "simpleextensiontypee0detype");
        Factory = r0;
        type = r0.getType();
    }
}
