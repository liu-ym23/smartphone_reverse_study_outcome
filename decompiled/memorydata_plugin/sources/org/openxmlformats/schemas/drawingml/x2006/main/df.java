package org.openxmlformats.schemas.drawingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface df extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<df> f18850a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18851b = null;

    static {
        DocumentFactory<df> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "cttextbodya3catype");
        f18850a = r0;
        f18851b = r0.getType();
    }

    dv getPArray(int r1);

    dv[] getPArray();

    List<dv> getPList();

    int sizeOfPArray();
}
