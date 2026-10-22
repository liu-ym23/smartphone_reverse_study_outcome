package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface bz extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<bz> f19992a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19993b = null;

    static {
        DocumentFactory<bz> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctpprdefaultf839type");
        f19992a = r0;
        f19993b = r0.getType();
    }

    ca getPPr();

    boolean isSetPPr();
}
