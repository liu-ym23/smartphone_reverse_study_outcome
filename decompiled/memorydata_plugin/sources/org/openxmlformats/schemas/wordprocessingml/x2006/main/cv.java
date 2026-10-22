package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface cv extends XmlObject {
    public static final DocumentFactory<cv> c = null;
    public static final SchemaType d = null;

    static {
        DocumentFactory<cv> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctrel4519type");
        c = r0;
        d = r0.getType();
    }

    String getId();
}
