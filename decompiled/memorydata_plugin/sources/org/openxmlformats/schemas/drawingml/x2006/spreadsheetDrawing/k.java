package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.drawingml.x2006.main.bz;

/* JADX INFO: loaded from: classes8.dex */
public interface k extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<k> f19040a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19041b = null;

    static {
        DocumentFactory<k> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctonecellanchor0527type");
        f19040a = r0;
        f19041b = r0.getType();
    }

    bz getExt();

    j getFrom();
}
