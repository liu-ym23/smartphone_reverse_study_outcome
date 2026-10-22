package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.drawingml.x2006.main.df;

/* JADX INFO: loaded from: classes8.dex */
public interface n extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<n> f19046a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19047b = null;

    static {
        DocumentFactory<n> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctshapee40btype");
        f19046a = r0;
        f19047b = r0.getType();
    }

    df getTxBody();
}
