package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface m extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<m> f19773a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19774b = null;

    static {
        DocumentFactory<m> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctcalccellb960type");
        f19773a = r0;
        f19774b = r0.getType();
    }

    int getI();

    String getR();

    boolean isSetI();

    void setI(int r1);
}
