package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface fw extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<fw> f19717a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19718b = null;

    static {
        DocumentFactory<fw> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "mapinfo5715doctype");
        f19717a = r0;
        f19718b = r0.getType();
    }

    cs getMapInfo();

    void setMapInfo(cs r1);
}
