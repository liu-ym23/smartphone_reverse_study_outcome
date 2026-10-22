package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface gt extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<gt> f19759a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19760b = null;

    static {
        DocumentFactory<gt> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "workbookec17doctype");
        f19759a = r0;
        f19760b = r0.getType();
    }

    fj getWorkbook();
}
