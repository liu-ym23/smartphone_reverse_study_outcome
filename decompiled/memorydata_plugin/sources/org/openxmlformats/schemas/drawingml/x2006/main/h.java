package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface h extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<h> f18976a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18977b = null;

    static {
        DocumentFactory<h> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctcolorb114type");
        f18976a = r0;
        f18977b = r0.getType();
    }

    cf getSrgbClr();

    cq getSysClr();

    boolean isSetSrgbClr();

    boolean isSetSysClr();
}
