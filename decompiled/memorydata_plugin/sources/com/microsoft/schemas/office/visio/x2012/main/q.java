package com.microsoft.schemas.office.visio.x2012.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes3.dex */
public interface q extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<q> f5733a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f5734b = null;

    static {
        DocumentFactory<q> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "sectiontype30a6type");
        f5733a = r0;
        f5734b = r0.getType();
    }

    a[] getCellArray();

    String getN();

    p getRowArray(int r1);

    p[] getRowArray();
}
