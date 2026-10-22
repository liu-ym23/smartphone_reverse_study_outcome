package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface LocalElement extends Element {
    public static final DocumentFactory<LocalElement> Factory = null;
    public static final SchemaType type = null;

    static {
        DocumentFactory<LocalElement> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "localelement2ce2type");
        Factory = r0;
        type = r0.getType();
    }
}
