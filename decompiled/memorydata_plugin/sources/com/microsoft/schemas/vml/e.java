package com.microsoft.schemas.vml;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes3.dex */
public interface e extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<e> f5783a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f5784b = null;

    static {
        DocumentFactory<e> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctgroup2b13type");
        f5783a = r0;
        f5784b = r0.getType();
    }

    p addNewShapetype();
}
