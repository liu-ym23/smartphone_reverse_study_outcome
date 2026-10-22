package org.openxmlformats.schemas.presentationml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface s extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<s> f19317a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19318b = null;

    static {
        DocumentFactory<s> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctgroupshape5b43type");
        f19317a = r0;
        f19318b = r0.getType();
    }

    org.openxmlformats.schemas.drawingml.x2006.main.an addNewGrpSpPr();

    t addNewNvGrpSpPr();

    org.openxmlformats.schemas.drawingml.x2006.main.an getGrpSpPr();

    List<ah> getSpList();
}
