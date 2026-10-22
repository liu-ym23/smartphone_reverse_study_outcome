package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface au extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<au> f19936a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19937b = null;

    static {
        DocumentFactory<au> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "cthdrftr26datype");
        f19936a = r0;
        f19937b = r0.getType();
    }

    bv addNewP();
}
