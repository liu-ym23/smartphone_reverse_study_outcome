package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface d extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<d> f19565a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19566b = null;

    static {
        DocumentFactory<d> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctbookviewsb864type");
        f19565a = r0;
        f19566b = r0.getType();
    }

    c addNewWorkbookView();

    c getWorkbookViewArray(int r1);
}
