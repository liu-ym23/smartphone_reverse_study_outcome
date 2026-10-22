package com.microsoft.schemas.office.office;

import com.microsoft.schemas.vml.STExt;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes3.dex */
public interface e extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<e> f5703a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f5704b = null;

    static {
        DocumentFactory<e> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctshapelayoutbda4type");
        f5703a = r0;
        f5704b = r0.getType();
    }

    b addNewIdmap();

    void setExt(STExt.Enum r1);
}
