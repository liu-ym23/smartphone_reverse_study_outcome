package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface gr extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<gr> f19755a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19756b = null;

    static {
        DocumentFactory<gr> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "stylesheet5d8bdoctype");
        f19755a = r0;
        f19756b = r0.getType();
    }

    ev addNewStyleSheet();

    ev getStyleSheet();
}
