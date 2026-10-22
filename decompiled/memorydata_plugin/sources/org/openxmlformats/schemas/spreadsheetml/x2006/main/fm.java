package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface fm extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<fm> f19697a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19698b = null;

    static {
        DocumentFactory<fm> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctworksheet530dtype");
        f19697a = r0;
        f19698b = r0.getType();
    }

    af addNewCols();

    ej addNewDimension();

    ch addNewHyperlinks();

    cp addNewLegacyDrawing();

    de addNewPageMargins();

    ei addNewSheetData();

    ek addNewSheetFormatPr();

    eo addNewSheetViews();

    af getColsArray(int r1);

    af[] getColsArray();

    aj getConditionalFormattingArray(int r1);

    ej getDimension();

    bb getDrawing();

    ch getHyperlinks();

    cp getLegacyDrawing();

    cu getMergeCells();

    ei getSheetData();

    ek getSheetFormatPr();

    eo getSheetViews();

    boolean isSetDimension();

    boolean isSetHyperlinks();

    boolean isSetSheetViews();

    void removeCols(int r1);

    void setColsArray(int r1, af r2);

    void setColsArray(af[] r1);

    int sizeOfColsArray();

    int sizeOfConditionalFormattingArray();

    void unsetHyperlinks();
}
