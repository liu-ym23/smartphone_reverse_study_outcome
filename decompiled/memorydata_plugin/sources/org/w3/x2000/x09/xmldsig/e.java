package org.w3.x2000.x09.xmldsig;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface e extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<e> f20303a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f20304b = null;

    static {
        DocumentFactory<e> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "referencetypef44ctype");
        f20303a = r0;
        f20304b = r0.getType();
    }

    String getType();
}
