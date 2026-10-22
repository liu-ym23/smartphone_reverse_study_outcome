package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface cd extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<cd> f19519a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19520b = null;

    static {
        DocumentFactory<cd> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctfonts6623type");
        f19519a = r0;
        f19520b = r0.getType();
    }

    by[] getFontArray();

    void setCount(long r1);

    void setFontArray(by[] r1);
}
