package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface cq extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<cq> f18818a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18819b = null;

    static {
        DocumentFactory<cq> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctsystemcolor4525type");
        f18818a = r0;
        f18819b = r0.getType();
    }

    byte[] getLastClr();
}
