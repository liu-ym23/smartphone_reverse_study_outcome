package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface f extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<f> f19671a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19672b = null;

    static {
        DocumentFactory<f> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctborderf935type");
        f19671a = r0;
        f19672b = r0.getType();
    }

    g addNewBottom();

    g addNewDiagonal();

    g addNewHorizontal();

    g addNewLeft();

    g addNewRight();

    g addNewTop();

    g addNewVertical();

    g getBottom();

    g getDiagonal();

    boolean getDiagonalDown();

    boolean getDiagonalUp();

    g getHorizontal();

    g getLeft();

    boolean getOutline();

    g getRight();

    g getTop();

    g getVertical();

    boolean isSetDiagonalDown();

    boolean isSetDiagonalUp();

    boolean isSetOutline();
}
