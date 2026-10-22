package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface ab extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<ab> f19898a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19899b = null;

    static {
        DocumentFactory<ab> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctdrawing8d34type");
        f19898a = r0;
        f19899b = r0.getType();
    }

    org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.a[] getAnchorArray();

    org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.c[] getInlineArray();
}
