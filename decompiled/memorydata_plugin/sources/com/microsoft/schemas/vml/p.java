package com.microsoft.schemas.vml;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes3.dex */
public interface p extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<p> f5805a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f5806b = null;

    static {
        DocumentFactory<p> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctshapetype5c6ftype");
        f5805a = r0;
        f5806b = r0.getType();
    }

    k addNewPath();

    q addNewStroke();

    String getId();

    void setCoordsize(String r1);

    void setId(String r1);

    void setPath2(String r1);

    void setSpt(float r1);
}
