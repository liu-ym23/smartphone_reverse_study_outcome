package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface TopLevelElement extends Element {
    public static final DocumentFactory<TopLevelElement> Factory = null;
    public static final SchemaType type = null;

    static {
        DocumentFactory<TopLevelElement> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "toplevelelement98d8type");
        Factory = r0;
        type = r0.getType();
    }
}
