package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface l extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<l> f19042a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19043b = null;

    static {
        DocumentFactory<l> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctpicturee028type");
        f19042a = r0;
        f19043b = r0.getType();
    }

    org.openxmlformats.schemas.drawingml.x2006.main.g getBlipFill();
}
