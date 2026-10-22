package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface cr extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<cr> f19547a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19548b = null;

    static {
        DocumentFactory<cr> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctmap023btype");
        f19547a = r0;
        f19548b = r0.getType();
    }

    long getID();
}
