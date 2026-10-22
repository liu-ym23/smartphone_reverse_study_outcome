package org.openxmlformats.schemas.presentationml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface aa extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<aa> f19199a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19200b = null;

    static {
        DocumentFactory<aa> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctnotesslideab75type");
        f19199a = r0;
        f19200b = r0.getType();
    }

    h addNewCSld();
}
