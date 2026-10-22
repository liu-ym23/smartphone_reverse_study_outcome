package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface k extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<k> f18982a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18983b = null;

    static {
        DocumentFactory<k> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctcolorscheme0e99type");
        f18982a = r0;
        f18983b = r0.getType();
    }

    h getAccent1();

    h getAccent2();

    h getAccent3();

    h getAccent4();

    h getAccent5();

    h getAccent6();

    h getDk1();

    h getDk2();

    h getFolHlink();

    h getHlink();

    h getLt1();

    h getLt2();
}
