package org.openxmlformats.schemas.drawingml.x2006.chart;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface bt extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<bt> f18476a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18477b = null;

    static {
        DocumentFactory<bt> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctplotarea106etype");
        f18476a = r0;
        f18477b = r0.getType();
    }

    ap addNewLayout();
}
