package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface dj extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<dj> f19585a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19586b = null;

    static {
        DocumentFactory<dj> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctphoneticpr898btype");
        f19585a = r0;
        f19586b = r0.getType();
    }

    STPhoneticType.Enum getType();
}
