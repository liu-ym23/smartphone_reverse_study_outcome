package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface p extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<p> f19050a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19051b = null;

    static {
        DocumentFactory<p> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "cttwocellanchor1e8dtype");
        f19050a = r0;
        f19051b = r0.getType();
    }

    j getFrom();

    j getTo();
}
