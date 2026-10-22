package com.microsoft.schemas.office.drawing.x2008.diagram;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes3.dex */
public interface b extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<b> f5667a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f5668b = null;

    static {
        DocumentFactory<b> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctgroupshape48cbtype");
        f5667a = r0;
        f5668b = r0.getType();
    }

    c getNvGrpSpPr();

    List<d> getSpList();
}
