package org.etsi.uri.x01903.v13;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface w extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<w> f18225a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18226b = null;

    static {
        DocumentFactory<w> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "objectidentifiertype2f56type");
        f18225a = r0;
        f18226b = r0.getType();
    }

    r getIdentifier();
}
