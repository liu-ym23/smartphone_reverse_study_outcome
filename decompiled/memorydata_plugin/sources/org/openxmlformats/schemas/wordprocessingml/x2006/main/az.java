package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface az extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<az> f19946a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19947b = null;

    static {
        DocumentFactory<az> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "cthyperlink38actype");
        f19946a = r0;
        f19947b = r0.getType();
    }

    cq[] getRArray();
}
