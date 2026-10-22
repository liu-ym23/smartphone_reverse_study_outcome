package com.microsoft.schemas.office.drawing.x2008.diagram;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes3.dex */
public interface a extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<a> f5665a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f5666b = null;

    static {
        DocumentFactory<a> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctdrawingc4f9type");
        f5665a = r0;
        f5666b = r0.getType();
    }

    b getSpTree();
}
