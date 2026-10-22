package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface dw extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<dw> f19611a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19612b = null;

    static {
        DocumentFactory<dw> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctrelt6464type");
        f19611a = r0;
        f19612b = r0.getType();
    }

    dx getRPr();

    String getT();
}
