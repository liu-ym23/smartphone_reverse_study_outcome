package com.microsoft.schemas.office.office;

import com.microsoft.schemas.vml.STExt;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes3.dex */
public interface b extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<b> f5699a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f5700b = null;

    static {
        DocumentFactory<b> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctidmap63fatype");
        f5699a = r0;
        f5700b = r0.getType();
    }

    void setData(String r1);

    void setExt(STExt.Enum r1);
}
