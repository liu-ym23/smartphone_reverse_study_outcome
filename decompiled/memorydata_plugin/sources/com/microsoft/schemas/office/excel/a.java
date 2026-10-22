package com.microsoft.schemas.office.excel;

import java.math.BigInteger;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes3.dex */
public interface a extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<a> f5679a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f5680b = null;

    static {
        DocumentFactory<a> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctclientdata433btype");
        f5679a = r0;
        f5680b = r0.getType();
    }

    BigInteger getColumnArray(int r1);

    STObjectType.Enum getObjectType();

    BigInteger getRowArray(int r1);

    void setColumnArray(int r1, BigInteger r2);

    void setRowArray(int r1, BigInteger r2);
}
