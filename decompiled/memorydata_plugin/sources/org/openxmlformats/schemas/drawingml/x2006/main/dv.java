package org.openxmlformats.schemas.drawingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface dv extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<dv> f18882a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18883b = null;

    static {
        DocumentFactory<dv> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "cttextparagraphcaf2type");
        f18882a = r0;
        f18883b = r0.getType();
    }

    dw getPPr();

    List<cd> getRList();

    boolean isSetPPr();
}
