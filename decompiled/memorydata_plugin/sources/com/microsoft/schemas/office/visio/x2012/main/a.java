package com.microsoft.schemas.office.visio.x2012.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes3.dex */
public interface a extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<a> f5709a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f5710b = null;

    static {
        DocumentFactory<a> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "celltyped857type");
        f5709a = r0;
        f5710b = r0.getType();
    }

    String getN();

    String getV();
}
