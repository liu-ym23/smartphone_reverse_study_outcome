package org.openxmlformats.schemas.officeDocument.x2006.extendedProperties;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface e extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<e> f19098a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19099b = null;

    static {
        DocumentFactory<e> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "propertiesee84doctype");
        f19098a = r0;
        f19099b = r0.getType();
    }

    b addNewProperties();

    b getProperties();
}
