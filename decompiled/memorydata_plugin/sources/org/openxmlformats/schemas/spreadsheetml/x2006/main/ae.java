package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface ae extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<ae> f19417a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19418b = null;

    static {
        DocumentFactory<ae> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctcolors6579type");
        f19417a = r0;
        f19418b = r0.getType();
    }

    cl getIndexedColors();

    boolean isSetIndexedColors();
}
