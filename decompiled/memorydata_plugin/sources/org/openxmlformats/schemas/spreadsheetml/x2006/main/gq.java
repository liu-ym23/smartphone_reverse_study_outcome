package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface gq extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<gq> f19753a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19754b = null;

    static {
        DocumentFactory<gq> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "sstf81fdoctype");
        f19753a = r0;
        f19754b = r0.getType();
    }

    eu addNewSst();

    eu getSst();
}
