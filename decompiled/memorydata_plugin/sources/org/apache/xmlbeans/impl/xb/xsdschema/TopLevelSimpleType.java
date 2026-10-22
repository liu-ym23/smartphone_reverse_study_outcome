package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface TopLevelSimpleType extends SimpleType {
    public static final DocumentFactory<TopLevelSimpleType> Factory = null;
    public static final SchemaType type = null;

    static {
        DocumentFactory<TopLevelSimpleType> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "toplevelsimpletypec958type");
        Factory = r0;
        type = r0.getType();
    }
}
