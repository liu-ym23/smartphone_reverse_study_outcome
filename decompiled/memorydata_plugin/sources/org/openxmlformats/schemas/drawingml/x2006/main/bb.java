package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface bb extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<bb> f18734a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18735b = null;

    static {
        DocumentFactory<bb> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctnonvisualdrawingshapepropsf17btype");
        f18734a = r0;
        f18735b = r0.getType();
    }

    boolean isSetTxBox();

    void setTxBox(boolean r1);
}
