package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface bu extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<bu> f19984a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19985b = null;

    static {
        DocumentFactory<bu> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctonoff04c2type");
        f19984a = r0;
        f19985b = r0.getType();
    }

    boolean isSetVal();

    org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.f xgetVal();
}
