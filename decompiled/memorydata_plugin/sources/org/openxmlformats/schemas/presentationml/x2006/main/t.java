package org.openxmlformats.schemas.presentationml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface t extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<t> f19319a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19320b = null;

    static {
        DocumentFactory<t> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctgroupshapenonvisual3e44type");
        f19319a = r0;
        f19320b = r0.getType();
    }

    org.openxmlformats.schemas.drawingml.x2006.main.bd addNewCNvGrpSpPr();

    org.openxmlformats.schemas.drawingml.x2006.main.ba addNewCNvPr();

    a addNewNvPr();

    void setCNvGrpSpPr(org.openxmlformats.schemas.drawingml.x2006.main.bd r1);

    void setCNvPr(org.openxmlformats.schemas.drawingml.x2006.main.ba r1);

    void setNvPr(a r1);
}
