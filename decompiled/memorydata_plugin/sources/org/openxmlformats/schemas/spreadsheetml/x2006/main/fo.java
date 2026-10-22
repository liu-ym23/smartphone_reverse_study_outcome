package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface fo extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<fo> f19701a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19702b = null;

    static {
        DocumentFactory<fo> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctxf97f7type");
        f19701a = r0;
        f19702b = r0.getType();
    }

    q getAlignment();

    long getFontId();

    long getNumFmtId();

    long getXfId();

    boolean isSetFontId();

    void setBorderId(long r1);

    void setFillId(long r1);

    void setFontId(long r1);

    void setNumFmtId(long r1);

    void setXfId(long r1);
}
