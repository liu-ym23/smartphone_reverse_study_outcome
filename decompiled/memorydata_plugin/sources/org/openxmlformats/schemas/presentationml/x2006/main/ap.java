package org.openxmlformats.schemas.presentationml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface ap extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<ap> f19229a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19230b = null;

    static {
        DocumentFactory<ap> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctslidemasteridlistentryae7ftype");
        f19229a = r0;
        f19230b = r0.getType();
    }

    String getId2();
}
