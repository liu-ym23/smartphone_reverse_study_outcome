package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface ca extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<ca> f19513a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19514b = null;

    static {
        DocumentFactory<ca> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctfontname2dc3type");
        f19513a = r0;
        f19514b = r0.getType();
    }

    String getVal();

    void setVal(String r1);
}
