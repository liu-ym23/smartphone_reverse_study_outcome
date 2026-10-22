package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface fj extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<fj> f19691a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19692b = null;

    static {
        DocumentFactory<fj> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctworkbook83c3type");
        f19691a = r0;
        f19692b = r0.getType();
    }

    d addNewBookViews();

    ep addNewSheets();

    fk addNewWorkbookPr();

    d getBookViews();

    az getDefinedNames();

    bm getExternalReferences();

    ep getSheets();

    fk getWorkbookPr();

    boolean isSetBookViews();

    boolean isSetDefinedNames();

    boolean isSetExternalReferences();

    void setDefinedNames(az r1);

    void unsetDefinedNames();
}
