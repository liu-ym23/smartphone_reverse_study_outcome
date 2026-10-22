package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface br extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<br> f19493a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19494b = null;

    static {
        DocumentFactory<br> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctexternalsheetnames7eddtype");
        f19493a = r0;
        f19494b = r0.getType();
    }

    bq addNewSheetName();

    bq getSheetNameArray(int r1);

    int sizeOfSheetNameArray();
}
