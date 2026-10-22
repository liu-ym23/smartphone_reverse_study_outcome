package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface es extends XmlObject {
    public static final DocumentFactory<es> c = null;
    public static final SchemaType d = null;

    static {
        DocumentFactory<es> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "cttblprbaseeba1type");
        c = r0;
        d = r0.getType();
    }

    ei addNewTblBorders();

    ev addNewTblW();

    ev getTblW();
}
