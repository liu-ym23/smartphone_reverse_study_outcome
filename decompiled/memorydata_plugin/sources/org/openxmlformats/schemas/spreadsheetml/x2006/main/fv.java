package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface fv extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<fv> f19715a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19716b = null;

    static {
        DocumentFactory<fv> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "externallinkb4c2doctype");
        f19715a = r0;
        f19716b = r0.getType();
    }

    bk getExternalLink();

    void setExternalLink(bk r1);
}
