package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface f extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<f> f18938a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18939b = null;

    static {
        DocumentFactory<f> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctblip034ctype");
        f18938a = r0;
        f18939b = r0.getType();
    }

    String getEmbed();
}
