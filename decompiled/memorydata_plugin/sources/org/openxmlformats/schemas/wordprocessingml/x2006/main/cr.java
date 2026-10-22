package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface cr extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<cr> f20026a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f20027b = null;

    static {
        DocumentFactory<cr> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctrpr097etype");
        f20026a = r0;
        f20027b = r0.getType();
    }

    bu getCapsArray(int r1);

    bu getSmallCapsArray(int r1);

    int sizeOfCapsArray();

    int sizeOfSmallCapsArray();
}
