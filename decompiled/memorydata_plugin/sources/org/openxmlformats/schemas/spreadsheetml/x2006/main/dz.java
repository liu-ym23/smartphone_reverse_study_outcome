package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface dz extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<dz> f19617a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19618b = null;

    static {
        DocumentFactory<dz> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctrowdd39type");
        f19617a = r0;
        f19618b = r0.getType();
    }

    p addNewC();

    p getCArray(int r1);

    p[] getCArray();

    List<p> getCList();

    boolean getHidden();

    double getHt();

    long getR();

    boolean isSetHt();

    boolean isSetR();

    void removeC(int r1);

    void setCArray(int r1, p r2);

    void setR(long r1);
}
