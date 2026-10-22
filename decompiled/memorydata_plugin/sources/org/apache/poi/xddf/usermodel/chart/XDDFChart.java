package org.apache.poi.xddf.usermodel.chart;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.ooxml.POIXMLFactory;
import org.apache.poi.ooxml.POIXMLRelation;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.xddf.usermodel.text.TextContainer;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.drawingml.x2006.chart.ai;
import org.openxmlformats.schemas.drawingml.x2006.chart.bt;
import org.openxmlformats.schemas.drawingml.x2006.chart.cz;
import org.openxmlformats.schemas.drawingml.x2006.chart.p;
import org.openxmlformats.schemas.drawingml.x2006.chart.r;

/* JADX INFO: loaded from: classes7.dex */
public abstract class XDDFChart extends POIXMLDocumentPart implements TextContainer {
    protected List<Object> axes;
    private int chartIndex;
    protected final r chartSpace;
    private long seriesCount;
    private XSSFWorkbook workbook;

    public XDDFChart() {
        this.chartIndex = 0;
        this.axes = new ArrayList();
        this.seriesCount = 0;
        r r0 = (r) ZeusTransformUtils.preCheckCast(r.f18586a.newInstance(), r.class, "com.obric.memorydata.plugin");
        this.chartSpace = r0;
        r0.addNewChart().addNewPlotArea();
    }

    public XDDFChart(PackagePart r4) {
        super(r4);
        this.chartIndex = 0;
        this.axes = new ArrayList();
        this.seriesCount = 0;
        InputStream r5 = r4.getInputStream();
        this.chartSpace = ((cz) ZeusTransformUtils.preCheckCast(cz.f18542a.parse(r5, POIXMLTypeLoader.DEFAULT_XML_OPTIONS), cz.class, "com.obric.memorydata.plugin")).getChartSpace();     // Catch: Throwable -> L7
        if (r5 == null) goto L22;
        r5.close();
        return;
    L22:
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r5 != null) goto L20;
    L15:
        throw th;
    L20:
        r5.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    }

    private PackagePart createWorksheetPart(POIXMLRelation r2, POIXMLFactory r3) {
        PackageRelationship r4 = createRelationshipInChart(r2, r3, this.chartIndex);
        setExternalId(r4.getId());
        return getTargetPart(r4);
    }

    private PackagePart getWorksheetPart() {
        Iterator<POIXMLDocumentPart.RelationPart> r0 = getRelationParts().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        POIXMLDocumentPart.RelationPart r1 = (POIXMLDocumentPart.RelationPart) ZeusTransformUtils.preCheckCast(r0.next(), POIXMLDocumentPart.RelationPart.class, "com.obric.memorydata.plugin");
        if ("http://schemas.openxmlformats.org/officeDocument/2006/relationships/package".equals(r1.getRelationship().getRelationshipType()) == false) goto L4;
        return getTargetPart(r1.getRelationship());
    L9:
        return null;
    }

    private void setWorksheetPartCommitted() {
        Iterator<POIXMLDocumentPart.RelationPart> r3 = getRelationParts().iterator();
    L4:
        if (r3.hasNext() == false) goto L12;
        POIXMLDocumentPart.RelationPart r0 = (POIXMLDocumentPart.RelationPart) ZeusTransformUtils.preCheckCast(r3.next(), POIXMLDocumentPart.RelationPart.class, "com.obric.memorydata.plugin");
        if ("http://schemas.openxmlformats.org/officeDocument/2006/relationships/package".equals(r0.getRelationship().getRelationshipType()) == false) goto L4;
        r0.getDocumentPart().setCommitted(true);
        return;
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void commit() {
        XmlOptions r0 = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        r0.setSaveSyntheticDocumentElement(new QName(r.f18587b.getName().getNamespaceURI(), "chartSpace", "c"));
        XSSFWorkbook r1 = this.workbook;
        if (r1 != null) goto L25;
    L9:
        OutputStream r2 = getPackagePart().getOutputStream();
        this.chartSpace.save(r2, r0);     // Catch: Throwable -> L14
        if (r2 == null) goto L31;
        r2.close();
        return;
    L31:
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        if (r2 != null) goto L27;
    L22:
        throw th;
    L27:
        r2.close();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        th.addSuppressed(th);
        goto L22
    L25:
        saveWorkbook(r1);     // Catch: InvalidFormatException -> L6
    L6:
        e = move-exception;
        throw new POIXMLException(e);
    }

    public PackageRelationship createRelationshipInChart(POIXMLRelation r2, POIXMLFactory r3, int r4) {
        return addRelation(null, r2, createRelationship(r2, r3, r4, true).getDocumentPart()).getRelationship();
    }

    public p getCTChart() {
        return this.chartSpace.getChart();
    }

    public r getCTChartSpace() {
        return this.chartSpace;
    }

    public bt getCTPlotArea() {
        return getCTChart().getPlotArea();
    }

    public abstract POIXMLFactory getChartFactory();

    public abstract POIXMLRelation getChartWorkbookRelation();

    public void saveWorkbook(XSSFWorkbook r3) {
        PackagePart r0 = getWorksheetPart();
        if (r0 != null) goto L10;
        POIXMLRelation r1 = getChartWorkbookRelation();
        POIXMLFactory r2 = getChartFactory();
        if (r1 == null) goto L9;
        if (r2 == null) goto L9;
        r0 = createWorksheetPart(r1, r2);
    L9:
        throw new InvalidFormatException("unable to determine chart relations");
    L10:
        OutputStream r4 = r0.getOutputStream();
        setWorksheetPartCommitted();     // Catch: Throwable -> L15
        r3.write(r4);     // Catch: Throwable -> L15
        if (r4 == null) goto L30;
        r4.close();
        return;
    L30:
        return;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        if (r4 != null) goto L28;
    L23:
        throw th;
    L28:
        r4.close();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        th.addSuppressed(th);
        goto L23
    }

    public void setExternalId(String r2) {
        r r1 = getCTChartSpace();
        if (r1.isSetExternalData() == false) goto L5;
        ai r3 = r1.getExternalData();
    L6:
        r3.setId(r2);
        return;
    L5:
        r3 = r1.addNewExternalData();
        goto L6
    }

    public void setWorkbook(XSSFWorkbook r1) {
        this.workbook = r1;
    }
}
