package org.openxmlformats.schemas.drawingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface cr extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<cr> f18820a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18821b = null;

    static {
        DocumentFactory<cr> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "cttable5f3ftype");
        f18820a = r0;
        f18821b = r0.getType();
    }

    cv getTblGrid();

    List<cy> getTrList();

    int sizeOfTrArray();
}
