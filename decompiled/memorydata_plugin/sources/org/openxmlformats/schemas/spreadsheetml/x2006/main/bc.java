package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface bc extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<bc> f19463a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19464b = null;

    static {
        DocumentFactory<bc> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctdxfa3b1type");
        f19463a = r0;
        f19464b = r0.getType();
    }

    f getBorder();

    bw getFill();

    by getFont();

    cv getNumFmt();

    boolean isSetBorder();

    boolean isSetFill();

    boolean isSetFont();

    boolean isSetNumFmt();
}
