package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface ew extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<ew> f20136a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f20137b = null;

    static {
        DocumentFactory<ew> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "cttc4019type");
        f20136a = r0;
        f20137b = r0.getType();
    }

    bv addNewP();

    List<bv> getPList();
}
