package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface bb extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<bb> f19461a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19462b = null;

    static {
        DocumentFactory<bb> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctdrawing44fdtype");
        f19461a = r0;
        f19462b = r0.getType();
    }

    String getId();
}
