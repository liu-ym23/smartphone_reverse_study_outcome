package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface dr extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<dr> f20078a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f20079b = null;

    static {
        DocumentFactory<dr> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctsectpr1123type");
        f20078a = r0;
        f20079b = r0.getType();
    }

    av getFooterReferenceArray(int r1);

    av getHeaderReferenceArray(int r1);

    ds getType();

    int sizeOfFooterReferenceArray();

    int sizeOfHeaderReferenceArray();
}
