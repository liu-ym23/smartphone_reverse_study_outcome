package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.drawingml.x2006.main.aj;

/* JADX INFO: loaded from: classes8.dex */
public interface f extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<f> f19030a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19031b = null;

    static {
        DocumentFactory<f> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctgraphicalobjectframe536ftype");
        f19030a = r0;
        f19031b = r0.getType();
    }

    aj getGraphic();
}
