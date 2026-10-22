package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.drawingml.x2006.main.el;

/* JADX INFO: loaded from: classes8.dex */
public interface j extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<j> f19038a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19039b = null;

    static {
        DocumentFactory<j> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctmarkeree8etype");
        f19038a = r0;
        f19039b = r0.getType();
    }

    int getCol();

    int getRow();

    void setCol(int r1);

    void setColOff(Object r1);

    void setRow(int r1);

    void setRowOff(Object r1);

    el xgetColOff();

    el xgetRowOff();
}
