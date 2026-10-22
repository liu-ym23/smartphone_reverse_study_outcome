package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface fw extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<fw> f20180a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f20181b = null;

    static {
        DocumentFactory<fw> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "numbering1c4ddoctype");
        f20180a = r0;
        f20181b = r0.getType();
    }

    bs getNumbering();
}
