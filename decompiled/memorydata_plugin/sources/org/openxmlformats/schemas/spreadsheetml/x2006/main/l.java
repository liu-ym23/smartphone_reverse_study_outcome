package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface l extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<l> f19771a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19772b = null;

    static {
        DocumentFactory<l> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctcachesource00dctype");
        f19771a = r0;
        f19772b = r0.getType();
    }

    STSourceType.Enum getType();
}
