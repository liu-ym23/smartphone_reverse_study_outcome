package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface gu extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<gu> f19761a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19762b = null;

    static {
        DocumentFactory<gu> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "worksheetf539doctype");
        f19761a = r0;
        f19762b = r0.getType();
    }

    fm getWorksheet();
}
