package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface ExplicitGroup extends Group {
    public static final DocumentFactory<ExplicitGroup> Factory = null;
    public static final SchemaType type = null;

    static {
        DocumentFactory<ExplicitGroup> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "explicitgroup4efatype");
        Factory = r0;
        type = r0.getType();
    }
}
