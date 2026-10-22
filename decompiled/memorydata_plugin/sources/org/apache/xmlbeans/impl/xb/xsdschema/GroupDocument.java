package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: loaded from: classes7.dex */
public interface GroupDocument extends XmlObject {
    public static final DocumentFactory<GroupDocument> Factory = null;
    public static final SchemaType type = null;

    static {
        DocumentFactory<GroupDocument> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "group6eb6doctype");
        Factory = r0;
        type = r0.getType();
    }

    NamedGroup getGroup();
}
