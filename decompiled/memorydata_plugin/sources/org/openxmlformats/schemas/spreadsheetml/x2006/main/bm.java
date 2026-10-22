package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface bm extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<bm> f19483a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19484b = null;

    static {
        DocumentFactory<bm> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctexternalreferencesd77ctype");
        f19483a = r0;
        f19484b = r0.getType();
    }

    bl[] getExternalReferenceArray();
}
