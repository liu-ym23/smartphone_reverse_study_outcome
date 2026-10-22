package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface fv extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<fv> f18970a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18971b = null;

    static {
        DocumentFactory<fv> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "tblstylelst4997doctype");
        f18970a = r0;
        f18971b = r0.getType();
    }

    db getTblStyleLst();
}
