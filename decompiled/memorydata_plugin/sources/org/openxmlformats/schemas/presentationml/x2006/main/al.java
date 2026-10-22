package org.openxmlformats.schemas.presentationml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface al extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<al> f19221a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19222b = null;

    static {
        DocumentFactory<al> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctslideidlistentry427dtype");
        f19221a = r0;
        f19222b = r0.getType();
    }

    long getId();

    String getId2();
}
