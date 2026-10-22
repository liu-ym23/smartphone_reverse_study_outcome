package org.apache.poi.xssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.xml.namespace.QName;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.dr;

/* JADX INFO: loaded from: classes7.dex */
public class XSSFPivotTable extends POIXMLDocumentPart {
    private XSSFPivotCache pivotCache;
    private XSSFPivotCacheDefinition pivotCacheDefinition;
    private XSSFPivotCacheRecords pivotCacheRecords;
    private dr pivotTableDefinition;

    public XSSFPivotTable() {
        this.pivotTableDefinition = (dr) ZeusTransformUtils.preCheckCast(dr.f19601a.newInstance(), dr.class, "com.obric.memorydata.plugin");
        this.pivotCache = new XSSFPivotCache();
        this.pivotCacheDefinition = new XSSFPivotCacheDefinition();
        this.pivotCacheRecords = new XSSFPivotCacheRecords();
    }

    public XSSFPivotTable(PackagePart r2) {
        super(r2);
        InputStream r3 = r2.getInputStream();
        readFrom(r3);     // Catch: Throwable -> L7
        if (r3 == null) goto L22;
        r3.close();
        return;
    L22:
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r3 != null) goto L20;
    L15:
        throw th;
    L20:
        r3.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void commit() {
        XmlOptions r0 = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        r0.setSaveSyntheticDocumentElement(new QName(dr.f19602b.getName().getNamespaceURI(), "pivotTableDefinition"));
        OutputStream r1 = getPackagePart().getOutputStream();
        this.pivotTableDefinition.save(r1, r0);     // Catch: Throwable -> L7
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
        if (r1 != null) goto L18;
    L15:
        throw th;
    L18:
        r1.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    }

    public void readFrom(InputStream r4) {
        XmlOptions r0 = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);     // Catch: XmlException -> L4
        r0.setLoadReplaceDocumentElement(null);     // Catch: XmlException -> L4
        this.pivotTableDefinition = (dr) ZeusTransformUtils.preCheckCast(dr.f19601a.parse(r4, r0), dr.class, "com.obric.memorydata.plugin");     // Catch: XmlException -> L4
        this.pivotCacheDefinition = null;     // Catch: XmlException -> L4
        return;
    L4:
        e = move-exception;
        throw new IOException(e.getLocalizedMessage());
    }
}
