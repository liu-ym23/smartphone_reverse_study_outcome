package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface ff extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<ff> f19683a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19684b = null;

    static {
        DocumentFactory<ff> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "cttablestyles872ftype");
        f19683a = r0;
        f19684b = r0.getType();
    }

    fc[] getTableStyleArray();
}
