package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface aa extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<aa> f19409a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19410b = null;

    static {
        DocumentFactory<aa> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctcola95ftype");
        f19409a = r0;
        f19410b = r0.getType();
    }

    boolean getBestFit();

    boolean getCollapsed();

    boolean getCustomWidth();

    boolean getHidden();

    long getMax();

    long getMin();

    short getOutlineLevel();

    boolean getPhonetic();

    long getStyle();

    double getWidth();

    boolean isSetBestFit();

    boolean isSetCollapsed();

    boolean isSetCustomWidth();

    boolean isSetHidden();

    boolean isSetOutlineLevel();

    boolean isSetPhonetic();

    boolean isSetStyle();

    boolean isSetWidth();

    void setBestFit(boolean r1);

    void setCollapsed(boolean r1);

    void setCustomWidth(boolean r1);

    void setHidden(boolean r1);

    void setMax(long r1);

    void setMin(long r1);

    void setOutlineLevel(short r1);

    void setPhonetic(boolean r1);

    void setStyle(long r1);

    void setWidth(double r1);
}
