package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface bz extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<bz> f19509a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19510b = null;

    static {
        DocumentFactory<bz> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctfontfamily685ctype");
        f19509a = r0;
        f19510b = r0.getType();
    }

    int getVal();

    void setVal(int r1);
}
