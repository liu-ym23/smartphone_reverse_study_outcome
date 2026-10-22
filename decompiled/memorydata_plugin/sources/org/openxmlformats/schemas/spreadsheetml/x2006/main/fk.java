package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface fk extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<fk> f19693a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19694b = null;

    static {
        DocumentFactory<fk> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctworkbookpr03a5type");
        f19693a = r0;
        f19694b = r0.getType();
    }

    boolean getDate1904();

    void setDate1904(boolean r1);
}
