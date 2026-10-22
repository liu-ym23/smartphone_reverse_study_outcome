package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface NamedGroup extends RealGroup {
    public static final DocumentFactory<NamedGroup> Factory = null;
    public static final SchemaType type = null;

    public interface All extends org.apache.xmlbeans.impl.xb.xsdschema.All {
    }

    static {
        DocumentFactory<NamedGroup> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "namedgroup878dtype");
        Factory = r0;
        type = r0.getType();
    }
}
