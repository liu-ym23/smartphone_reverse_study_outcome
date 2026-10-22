package org.apache.poi.xssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.xml.namespace.QName;
import org.apache.commons.io.input.UnsynchronizedByteArrayInputStream;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.bb;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.cp;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.ft;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.z;

/* JADX INFO: loaded from: classes7.dex */
public class XSSFChartSheet extends XSSFSheet {
    private static final byte[] BLANK_WORKSHEET = null;
    protected z chartsheet;

    static {
        BLANK_WORKSHEET = blankWorksheet();
    }

    public XSSFChartSheet(PackagePart r1) {
        super(r1);
    }

    private static byte[] blankWorksheet() {
        UnsynchronizedByteArrayOutputStream r0 = new UnsynchronizedByteArrayOutputStream();
        new XSSFSheet().write(r0);     // Catch: IOException -> L6
        return r0.toByteArray();
    L6:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFSheet
    public bb getCTDrawing() {
        return this.chartsheet.getDrawing();
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFSheet
    public cp getCTLegacyDrawing() {
        return this.chartsheet.getLegacyDrawing();
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFSheet
    public void read(InputStream r3) {
        super.read(new UnsynchronizedByteArrayInputStream(BLANK_WORKSHEET));
        this.chartsheet = ((ft) ZeusTransformUtils.preCheckCast(ft.f19711a.parse(r3, POIXMLTypeLoader.DEFAULT_XML_OPTIONS), ft.class, "com.obric.memorydata.plugin")).getChartsheet();     // Catch: XmlException -> L5
        return;
    L5:
        e = move-exception;
        throw new POIXMLException(e);
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFSheet
    public void write(OutputStream r5) {
        XmlOptions r0 = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        r0.setSaveSyntheticDocumentElement(new QName(z.f19798b.getName().getNamespaceURI(), "chartsheet"));
        this.chartsheet.save(r5, r0);
    }
}
