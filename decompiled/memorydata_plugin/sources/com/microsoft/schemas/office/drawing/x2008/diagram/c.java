package com.microsoft.schemas.office.drawing.x2008.diagram;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.drawingml.x2006.main.ba;
import org.openxmlformats.schemas.drawingml.x2006.main.bd;

/* JADX INFO: loaded from: classes3.dex */
public interface c extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<c> f5669a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f5670b = null;

    static {
        DocumentFactory<c> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctgroupshapenonvisualf80ctype");
        f5669a = r0;
        f5670b = r0.getType();
    }

    bd getCNvGrpSpPr();

    ba getCNvPr();
}
