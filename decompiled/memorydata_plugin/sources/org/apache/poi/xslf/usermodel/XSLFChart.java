package org.apache.poi.xslf.usermodel;

import org.apache.poi.ooxml.POIXMLFactory;
import org.apache.poi.ooxml.POIXMLRelation;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.xddf.usermodel.chart.XDDFChart;

/* JADX INFO: loaded from: classes7.dex */
public final class XSLFChart extends XDDFChart {
    private static String CHART_URI = "http://schemas.openxmlformats.org/drawingml/2006/chart";

    static {
    }

    public XSLFChart() {
    }

    public XSLFChart(PackagePart r1) {
        super(r1);
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChart
    public POIXMLFactory getChartFactory() {
        return XSLFFactory.getInstance();
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChart
    public POIXMLRelation getChartWorkbookRelation() {
        return XSLFRelation.WORKBOOK;
    }
}
