package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface ey extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<ey> f19669a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19670b = null;

    static {
        DocumentFactory<ey> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "cttablecolumnsebb8type");
        f19669a = r0;
        f19670b = r0.getType();
    }

    List<ex> getTableColumnList();
}
