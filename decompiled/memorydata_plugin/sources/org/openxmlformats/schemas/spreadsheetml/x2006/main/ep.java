package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface ep extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<ep> f19651a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19652b = null;

    static {
        DocumentFactory<ep> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctsheets49fdtype");
        f19651a = r0;
        f19652b = r0.getType();
    }

    ef addNewSheet();

    ef[] getSheetArray();
}
