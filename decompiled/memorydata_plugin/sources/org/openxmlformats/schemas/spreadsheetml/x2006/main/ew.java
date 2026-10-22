package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface ew extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<ew> f19665a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19666b = null;

    static {
        DocumentFactory<ew> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "cttable736dtype");
        f19665a = r0;
        f19666b = r0.getType();
    }

    long getHeaderRowCount();

    String getName();

    String getRef();

    ey getTableColumns();

    fe getTableStyleInfo();

    long getTotalsRowCount();

    boolean isSetTableStyleInfo();

    void setName(String r1);

    void unsetName();
}
