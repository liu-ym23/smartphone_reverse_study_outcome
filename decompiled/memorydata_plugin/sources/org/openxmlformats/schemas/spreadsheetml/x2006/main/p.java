package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface p extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<p> f19779a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19780b = null;

    static {
        DocumentFactory<p> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctcell842btype");
        f19779a = r0;
        f19780b = r0.getType();
    }

    r getF();

    eb getIs();

    String getR();

    long getS();

    STCellType.Enum getT();

    String getV();

    boolean isSetF();

    boolean isSetIs();

    boolean isSetS();

    boolean isSetT();

    boolean isSetV();

    void setF(r r1);

    void setR(String r1);

    void setS(long r1);

    void setT(STCellType.Enum r1);

    void setV(String r1);

    void unsetF();

    void unsetS();

    void unsetT();
}
