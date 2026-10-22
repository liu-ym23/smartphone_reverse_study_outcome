package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface r extends gf {
    public static final DocumentFactory<r> c = null;
    public static final SchemaType d = null;

    static {
        DocumentFactory<r> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctcellformula3583type");
        c = r0;
        d = r0.getType();
    }

    String getRef();

    long getSi();

    STCellFormulaType.Enum getT();

    boolean isSetRef();

    void setRef(String r1);
}
