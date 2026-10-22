package com.microsoft.schemas.office.drawing.x2008.diagram;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.drawingml.x2006.main.ba;
import org.openxmlformats.schemas.drawingml.x2006.main.bb;

/* JADX INFO: loaded from: classes3.dex */
public interface e extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<e> f5673a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f5674b = null;

    static {
        DocumentFactory<e> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctshapenonvisual6121type");
        f5673a = r0;
        f5674b = r0.getType();
    }

    ba getCNvPr();

    bb getCNvSpPr();
}
