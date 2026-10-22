package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface fu extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<fu> f19713a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19714b = null;

    static {
        DocumentFactory<fu> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "comments4c11doctype");
        f19713a = r0;
        f19714b = r0.getType();
    }

    ai getComments();

    void setComments(ai r1);
}
