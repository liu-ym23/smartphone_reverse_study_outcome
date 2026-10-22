package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface y extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<y> f19795a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19796b = null;

    static {
        DocumentFactory<y> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctcfvo7ca5type");
        f19795a = r0;
        f19796b = r0.getType();
    }

    STCfvoType.Enum getType();
}
