package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface fr extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<fr> f20170a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f20171b = null;

    static {
        DocumentFactory<fr> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "document2bd9doctype");
        f20170a = r0;
        f20171b = r0.getType();
    }

    z getDocument();
}
