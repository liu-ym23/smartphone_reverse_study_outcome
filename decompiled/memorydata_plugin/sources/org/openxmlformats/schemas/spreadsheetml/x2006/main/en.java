package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface en extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<en> f19647a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19648b = null;

    static {
        DocumentFactory<en> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctsheetview0f43type");
        f19647a = r0;
        f19648b = r0.getType();
    }

    void setTabSelected(boolean r1);

    void setWorkbookViewId(long r1);
}
