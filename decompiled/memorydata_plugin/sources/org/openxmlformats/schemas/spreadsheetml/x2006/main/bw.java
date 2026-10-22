package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface bw extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<bw> f19503a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19504b = null;

    static {
        DocumentFactory<bw> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctfill550ctype");
        f19503a = r0;
        f19504b = r0.getType();
    }

    di addNewPatternFill();

    di getPatternFill();
}
