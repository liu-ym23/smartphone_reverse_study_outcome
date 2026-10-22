package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface bn extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<bn> f19485a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19486b = null;

    static {
        DocumentFactory<bn> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctexternalrowa22etype");
        f19485a = r0;
        f19486b = r0.getType();
    }

    bh addNewCell();

    bh[] getCellArray();

    long getR();

    void setR(long r1);
}
