package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface fu extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<fu> f20176a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f20177b = null;

    static {
        DocumentFactory<fu> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ftre182doctype");
        f20176a = r0;
        f20177b = r0.getType();
    }

    au getFtr();
}
