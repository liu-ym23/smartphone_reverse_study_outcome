package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface ac extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<ac> f19413a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19414b = null;

    static {
        DocumentFactory<ac> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctcolord2c2type");
        f19413a = r0;
        f19414b = r0.getType();
    }

    boolean getAuto();

    long getIndexed();

    byte[] getRgb();

    long getTheme();

    double getTint();

    boolean isSetAuto();

    boolean isSetIndexed();

    boolean isSetRgb();

    boolean isSetTheme();

    boolean isSetTint();

    void setAuto(boolean r1);

    void setIndexed(long r1);

    void setRgb(byte[] r1);

    void setTheme(long r1);

    void setTint(double r1);
}
