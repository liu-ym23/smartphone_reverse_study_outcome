package com.microsoft.schemas.office.drawing.x2008.diagram;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.drawingml.x2006.main.ck;
import org.openxmlformats.schemas.drawingml.x2006.main.cl;
import org.openxmlformats.schemas.drawingml.x2006.main.df;
import org.openxmlformats.schemas.drawingml.x2006.main.ef;

/* JADX INFO: loaded from: classes3.dex */
public interface d extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<d> f5671a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f5672b = null;

    static {
        DocumentFactory<d> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctshape6416type");
        f5671a = r0;
        f5672b = r0.getType();
    }

    e getNvSpPr();

    ck getSpPr();

    cl getStyle();

    df getTxBody();

    ef getTxXfrm();
}
