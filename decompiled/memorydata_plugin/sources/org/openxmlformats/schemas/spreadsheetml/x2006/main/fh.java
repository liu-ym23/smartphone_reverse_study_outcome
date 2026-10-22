package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STVerticalAlignRun;

/* JADX INFO: loaded from: classes8.dex */
public interface fh extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<fh> f19687a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19688b = null;

    static {
        DocumentFactory<fh> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctverticalalignfontproperty89f2type");
        f19687a = r0;
        f19688b = r0.getType();
    }

    STVerticalAlignRun.Enum getVal();

    void setVal(STVerticalAlignRun.Enum r1);
}
