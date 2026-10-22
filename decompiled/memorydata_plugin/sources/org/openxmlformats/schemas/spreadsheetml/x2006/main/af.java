package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface af extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<af> f19419a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19420b = null;

    static {
        DocumentFactory<af> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctcols627ctype");
        f19419a = r0;
        f19420b = r0.getType();
    }

    aa addNewCol();

    aa[] getColArray();

    List<aa> getColList();

    aa insertNewCol(int r1);

    void setColArray(aa[] r1);

    int sizeOfColArray();
}
