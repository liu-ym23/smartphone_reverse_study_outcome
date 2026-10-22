package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface AttributeGroupDocument extends XmlObject {
    public static final DocumentFactory<AttributeGroupDocument> Factory = null;
    public static final SchemaType type = null;

    static {
        DocumentFactory<AttributeGroupDocument> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "attributegroup4520doctype");
        Factory = r0;
        type = r0.getType();
    }

    NamedAttributeGroup getAttributeGroup();
}
