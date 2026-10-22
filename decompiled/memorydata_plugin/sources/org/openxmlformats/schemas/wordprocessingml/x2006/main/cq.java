package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface cq extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<cq> f20024a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f20025b = null;

    static {
        DocumentFactory<cq> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctr8120type");
        f20024a = r0;
        f20025b = r0.getType();
    }

    cr addNewRPr();

    fc[] getDelTextArray();

    ab[] getDrawingArray();

    cn[] getPictArray();

    cr getRPr();

    boolean isSetRPr();
}
