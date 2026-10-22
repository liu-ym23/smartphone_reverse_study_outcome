package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface gp extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<gp> f19751a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19752b = null;

    static {
        DocumentFactory<gp> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "singlexmlcells33bfdoctype");
        f19751a = r0;
        f19752b = r0.getType();
    }

    er getSingleXmlCells();

    void setSingleXmlCells(er r1);
}
