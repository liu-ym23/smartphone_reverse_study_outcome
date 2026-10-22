package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface bl extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<bl> f19481a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19482b = null;

    static {
        DocumentFactory<bl> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctexternalreference945ftype");
        f19481a = r0;
        f19482b = r0.getType();
    }

    String getId();
}
