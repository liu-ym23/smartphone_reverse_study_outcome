package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface cw extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<cw> f20034a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f20035b = null;

    static {
        DocumentFactory<cw> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctrow3b78type");
        f20034a = r0;
        f20035b = r0.getType();
    }

    ew addNewTc();

    ew[] getTcArray();

    List<ew> getTcList();
}
