package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface dq extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<dq> f18872a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18873b = null;

    static {
        DocumentFactory<dq> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "cttextlinebreak932ftype");
        f18872a = r0;
        f18873b = r0.getType();
    }

    dn getRPr();
}
