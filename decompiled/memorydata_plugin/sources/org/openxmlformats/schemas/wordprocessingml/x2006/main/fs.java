package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface fs extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<fs> f20172a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f20173b = null;

    static {
        DocumentFactory<fs> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "endnotes960edoctype");
        f20172a = r0;
        f20173b = r0.getType();
    }

    af getEndnotes();
}
