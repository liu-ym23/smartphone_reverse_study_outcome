package org.apache.poi.xssf.usermodel;

import java.io.OutputStream;
import javax.xml.namespace.QName;
import org.apache.poi.ooxml.POIXMLFactory;
import org.apache.poi.ooxml.POIXMLRelation;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.xddf.usermodel.chart.XDDFChart;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.drawingml.x2006.chart.bn;
import org.openxmlformats.schemas.drawingml.x2006.chart.bu;
import org.openxmlformats.schemas.drawingml.x2006.chart.r;

/* JADX INFO: loaded from: classes7.dex */
public final class XSSFChart extends XDDFChart {
    private XSSFGraphicFrame frame;

    public XSSFChart() {
        createChart();
    }

    public XSSFChart(PackagePart r1) {
        super(r1);
    }

    private void createChart() {
        getCTPlotArea().addNewLayout();
        getCTChart().addNewPlotVisOnly().setVal(true);
        bu r5 = this.chartSpace.addNewPrintSettings();
        r5.addNewHeaderFooter();
        bn r0 = r5.addNewPageMargins();
        r0.setB(0.75d);
        r0.setL(0.7d);
        r0.setR(0.7d);
        r0.setT(0.75d);
        r0.setHeader(0.3d);
        r0.setFooter(0.3d);
        r5.addNewPageSetup();
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChart, org.apache.poi.ooxml.POIXMLDocumentPart
    public void commit() {
        XmlOptions r0 = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        r0.setSaveSyntheticDocumentElement(new QName(r.f18587b.getName().getNamespaceURI(), "chartSpace", "c"));
        OutputStream r1 = getPackagePart().getOutputStream();
        this.chartSpace.save(r1, r0);     // Catch: Throwable -> L7
        if (r1 == null) goto L22;
        r1.close();
        return;
    L22:
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r1 != null) goto L20;
    L15:
        throw th;
    L20:
        r1.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChart
    public POIXMLFactory getChartFactory() {
        return null;
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChart
    public POIXMLRelation getChartWorkbookRelation() {
        return null;
    }

    public void setGraphicFrame(XSSFGraphicFrame r1) {
        this.frame = r1;
    }
}
