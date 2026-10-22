package com.microsoft.schemas.office.visio.x2012.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes3.dex */
public interface z extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<z> f5747a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f5748b = null;

    static {
        DocumentFactory<z> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "visiodocumenttypebfcatype");
        f5747a = r0;
        f5748b = r0.getType();
    }
}
