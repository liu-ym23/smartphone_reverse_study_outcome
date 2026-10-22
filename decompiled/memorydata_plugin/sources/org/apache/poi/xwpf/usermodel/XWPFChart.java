package org.apache.poi.xwpf.usermodel;

import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.ooxml.POIXMLFactory;
import org.apache.poi.ooxml.POIXMLRelation;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xddf.usermodel.chart.XDDFChart;

/* JADX INFO: loaded from: classes7.dex */
public class XWPFChart extends XDDFChart {
    private Long checksum;

    public XWPFChart() {
    }

    public XWPFChart(PackagePart r1) {
        super(r1);
    }

    public boolean equals(Object r1) {
        if (r1 != this) goto L4;
        return true;
    L4:
        return false;
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChart
    public POIXMLFactory getChartFactory() {
        return XWPFFactory.getInstance();
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChart
    public POIXMLRelation getChartWorkbookRelation() {
        return XWPFRelation.WORKBOOK;
    }

    public Long getChecksum() {
        if (this.checksum != null) goto L22;
        InputStream r0 = getPackagePart().getInputStream();     // Catch: IOException -> L18
        this.checksum = Long.valueOf(IOUtils.calculateChecksum(r0));     // Catch: Throwable -> L9
        if (r0 == null) goto L22;
        r0.close();     // Catch: IOException -> L18
        goto L22
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        if (r0 != null) goto L24;
    L17:
        throw th;     // Catch: IOException -> L18
    L24:
        r0.close();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L18
    L18:
        e = move-exception;
        throw new POIXMLException(e);
    L22:
        return this.checksum;
    }

    public int hashCode() {
        return getChecksum().hashCode();
    }
}
