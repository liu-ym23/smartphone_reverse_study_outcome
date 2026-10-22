package org.openxmlformats.schemas.presentationml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface bg extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<bg> f19265a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19266b = null;

    static {
        DocumentFactory<bg> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "notesmaster8840doctype");
        f19265a = r0;
        f19266b = r0.getType();
    }

    x getNotesMaster();
}
