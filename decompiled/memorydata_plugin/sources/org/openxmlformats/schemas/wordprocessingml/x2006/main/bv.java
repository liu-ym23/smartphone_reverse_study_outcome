package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface bv extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<bv> f19986a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19987b = null;

    static {
        DocumentFactory<bv> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctpa1e2type");
        f19986a = r0;
        f19987b = r0.getType();
    }

    bx addNewPPr();

    bx getPPr();
}
