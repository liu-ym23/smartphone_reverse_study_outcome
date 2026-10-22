package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface cd extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<cd> f18792a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18793b = null;

    static {
        DocumentFactory<cd> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctregulartextrun7e3dtype");
        f18792a = r0;
        f18793b = r0.getType();
    }

    String getT();

    void setRPr(dn r1);

    void setT(String r1);
}
