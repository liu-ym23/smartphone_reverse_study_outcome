package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface eo extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<eo> f19649a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19650b = null;

    static {
        DocumentFactory<eo> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctsheetviewsb918type");
        f19649a = r0;
        f19650b = r0.getType();
    }

    en addNewSheetView();

    en[] getSheetViewArray();

    int sizeOfSheetViewArray();
}
