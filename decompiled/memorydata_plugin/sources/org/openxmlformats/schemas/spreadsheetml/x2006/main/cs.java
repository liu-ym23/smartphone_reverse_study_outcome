package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface cs extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<cs> f19549a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19550b = null;

    static {
        DocumentFactory<cs> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctmapinfo1a09type");
        f19549a = r0;
        f19550b = r0.getType();
    }

    cr[] getMapArray();
}
