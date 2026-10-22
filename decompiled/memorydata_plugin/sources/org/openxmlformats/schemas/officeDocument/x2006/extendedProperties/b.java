package org.openxmlformats.schemas.officeDocument.x2006.extendedProperties;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface b extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<b> f19092a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19093b = null;

    static {
        DocumentFactory<b> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctproperties3f10type");
        f19092a = r0;
        f19093b = r0.getType();
    }

    void setApplication(String r1);
}
