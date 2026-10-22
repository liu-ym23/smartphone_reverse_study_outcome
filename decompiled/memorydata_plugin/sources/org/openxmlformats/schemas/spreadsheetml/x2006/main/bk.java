package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface bk extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<bk> f19479a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19480b = null;

    static {
        DocumentFactory<bk> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctexternallink966etype");
        f19479a = r0;
        f19480b = r0.getType();
    }

    bg addNewExternalBook();

    bg getExternalBook();
}
