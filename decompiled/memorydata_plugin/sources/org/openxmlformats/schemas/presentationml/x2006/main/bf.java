package org.openxmlformats.schemas.presentationml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface bf extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<bf> f19263a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19264b = null;

    static {
        DocumentFactory<bf> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "notes4a02doctype");
        f19263a = r0;
        f19264b = r0.getType();
    }

    aa getNotes();
}
