package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface ft extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<ft> f20174a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f20175b = null;

    static {
        DocumentFactory<ft> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "footnotes8773doctype");
        f20174a = r0;
        f20175b = r0.getType();
    }

    an getFootnotes();
}
