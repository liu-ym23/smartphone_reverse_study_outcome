package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface z extends aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<z> f20252a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f20253b = null;

    static {
        DocumentFactory<z> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctdocument64adtype");
        f20252a = r0;
        f20253b = r0.getType();
    }

    f addNewBody();

    f getBody();
}
