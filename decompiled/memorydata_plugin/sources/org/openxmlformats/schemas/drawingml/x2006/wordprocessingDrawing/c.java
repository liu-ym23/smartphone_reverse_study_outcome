package org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.drawingml.x2006.main.ba;

/* JADX INFO: loaded from: classes8.dex */
public interface c extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<c> f19066a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19067b = null;

    static {
        DocumentFactory<c> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctinline5726type");
        f19066a = r0;
        f19067b = r0.getType();
    }

    ba getDocPr();
}
