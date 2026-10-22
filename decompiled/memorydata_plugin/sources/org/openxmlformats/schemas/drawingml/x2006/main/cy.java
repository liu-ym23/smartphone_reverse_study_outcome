package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface cy extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<cy> f18834a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18835b = null;

    static {
        DocumentFactory<cy> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "cttablerow4ac7type");
        f18834a = r0;
        f18835b = r0.getType();
    }

    cs[] getTcArray();
}
