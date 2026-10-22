package com.microsoft.schemas.vml;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes3.dex */
public interface o extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<o> f5803a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f5804b = null;

    static {
        DocumentFactory<o> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctshape5cb5type");
        f5803a = r0;
        f5804b = r0.getType();
    }

    com.microsoft.schemas.office.excel.a getClientDataArray(int r1);

    List<com.microsoft.schemas.office.excel.a> getClientDataList();

    String getId();

    String getType();

    int sizeOfClientDataArray();
}
