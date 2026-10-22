package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface dy extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<dy> f19615a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19616b = null;

    static {
        DocumentFactory<dy> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctrgbcolor95dftype");
        f19615a = r0;
        f19616b = r0.getType();
    }

    byte[] getRgb();
}
