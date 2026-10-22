package org.openxmlformats.schemas.presentationml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface ai extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<ai> f19215a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19216b = null;

    static {
        DocumentFactory<ai> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctshapenonvisualb619type");
        f19215a = r0;
        f19216b = r0.getType();
    }

    org.openxmlformats.schemas.drawingml.x2006.main.bb getCNvSpPr();

    void setCNvPr(org.openxmlformats.schemas.drawingml.x2006.main.ba r1);

    void setCNvSpPr(org.openxmlformats.schemas.drawingml.x2006.main.bb r1);

    void setNvPr(a r1);
}
