package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface bh extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<bh> f18746a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18747b = null;

    static {
        DocumentFactory<bh> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctofficestylesheetce25type");
        f18746a = r0;
        f18747b = r0.getType();
    }

    e addNewThemeElements();

    e getThemeElements();
}
