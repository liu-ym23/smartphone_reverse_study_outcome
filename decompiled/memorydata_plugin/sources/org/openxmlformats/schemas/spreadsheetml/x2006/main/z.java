package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface z extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<z> f19797a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19798b = null;

    static {
        DocumentFactory<z> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctchartsheetf68atype");
        f19797a = r0;
        f19798b = r0.getType();
    }

    bb getDrawing();

    cp getLegacyDrawing();
}
