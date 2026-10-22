package com.microsoft.schemas.office.office;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes3.dex */
public interface g extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<g> f5707a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f5708b = null;

    static {
        DocumentFactory<g> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "shapelayoutebb0doctype");
        f5707a = r0;
        f5708b = r0.getType();
    }

    e addNewShapelayout();
}
