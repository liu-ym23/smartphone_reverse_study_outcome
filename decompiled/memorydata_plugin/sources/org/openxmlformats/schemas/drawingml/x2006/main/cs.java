package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface cs extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<cs> f18822a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18823b = null;

    static {
        DocumentFactory<cs> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "cttablecell3ac1type");
        f18822a = r0;
        f18823b = r0.getType();
    }

    df getTxBody();

    void setTxBody(df r1);
}
