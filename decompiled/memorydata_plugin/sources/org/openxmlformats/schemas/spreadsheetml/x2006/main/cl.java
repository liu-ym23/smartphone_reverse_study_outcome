package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface cl extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<cl> f19535a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19536b = null;

    static {
        DocumentFactory<cl> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctindexedcolorsa0a0type");
        f19535a = r0;
        f19536b = r0.getType();
    }

    List<dy> getRgbColorList();
}
