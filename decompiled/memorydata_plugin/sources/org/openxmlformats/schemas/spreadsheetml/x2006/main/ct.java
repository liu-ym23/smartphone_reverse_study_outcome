package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface ct extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<ct> f19551a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19552b = null;

    static {
        DocumentFactory<ct> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctmergecelle8d9type");
        f19551a = r0;
        f19552b = r0.getType();
    }

    String getRef();
}
