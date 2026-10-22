package org.w3.x2000.x09.xmldsig;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBase64Binary;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface h extends XmlBase64Binary {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<h> f20307a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f20308b = null;

    static {
        DocumentFactory<h> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "signaturevaluetype58cctype");
        f20307a = r0;
        f20308b = r0.getType();
    }
}
