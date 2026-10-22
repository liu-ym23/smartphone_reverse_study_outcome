package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface bs extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<bs> f19980a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19981b = null;

    static {
        DocumentFactory<bs> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctnumberingfdf9type");
        f19980a = r0;
        f19981b = r0.getType();
    }

    a[] getAbstractNumArray();

    bn[] getNumArray();
}
