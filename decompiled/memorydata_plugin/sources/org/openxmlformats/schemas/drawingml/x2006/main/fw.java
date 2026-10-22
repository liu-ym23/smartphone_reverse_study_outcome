package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface fw extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<fw> f18972a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18973b = null;

    static {
        DocumentFactory<fw> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "themefd26doctype");
        f18972a = r0;
        f18973b = r0.getType();
    }

    bh addNewTheme();

    bh getTheme();
}
