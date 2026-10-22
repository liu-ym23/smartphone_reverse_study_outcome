package org.openxmlformats.schemas.officeDocument.x2006.customProperties;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface c extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<c> f19084a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19085b = null;

    static {
        DocumentFactory<c> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "properties288cdoctype");
        f19084a = r0;
        f19085b = r0.getType();
    }

    a addNewProperties();
}
