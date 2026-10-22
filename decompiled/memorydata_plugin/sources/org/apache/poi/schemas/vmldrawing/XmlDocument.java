package org.apache.poi.schemas.vmldrawing;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface XmlDocument extends XmlObject {
    public static final DocumentFactory<XmlDocument> Factory = null;
    public static final SchemaType type = null;

    static {
        DocumentFactory<XmlDocument> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "xml2eb5doctype");
        Factory = r0;
        type = r0.getType();
    }

    CTXML addNewXml();

    CTXML getXml();
}
