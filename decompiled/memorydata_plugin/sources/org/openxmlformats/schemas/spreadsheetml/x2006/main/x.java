package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface x extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<x> f19793a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19794b = null;

    static {
        DocumentFactory<x> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctcfrule3548type");
        f19793a = r0;
        f19794b = r0.getType();
    }

    boolean getAboveAverage();

    boolean getBottom();

    long getDxfId();

    boolean getEqualAverage();

    String getFormulaArray(int r1);

    STConditionalFormattingOperator.Enum getOperator();

    boolean getPercent();

    int getPriority();

    long getRank();

    int getStdDev();

    boolean getStopIfTrue();

    String getText();

    STCfType.Enum getType();

    boolean isSetDxfId();

    void setDxfId(long r1);

    int sizeOfFormulaArray();
}
