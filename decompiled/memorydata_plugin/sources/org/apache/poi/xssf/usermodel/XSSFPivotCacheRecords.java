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
import org.openxmlformats.schemas.spreadsheetml.x2006.main.dn;

/* JADX INFO: loaded from: classes7.dex */
public class XSSFPivotCacheRecords extends POIXMLDocumentPart {
    private dn ctPivotCacheRecords;

    public XSSFPivotCacheRecords() {
        this.ctPivotCacheRecords = (dn) ZeusTransformUtils.preCheckCast(dn.f19593a.newInstance(), dn.class, "com.obric.memorydata.plugin");
    }

    public XSSFPivotCacheRecords(PackagePart r2) {
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
        OutputStream r0 = getPackagePart().getOutputStream();
        XmlOptions r1 = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);     // Catch: Throwable -> L7
        r1.setSaveSyntheticDocumentElement(new QName(dn.f19594b.getName().getNamespaceURI(), "pivotCacheRecords"));     // Catch: Throwable -> L7
        this.ctPivotCacheRecords.save(r0, r1);     // Catch: Throwable -> L7
        if (r0 == null) goto L22;
        r0.close();
        return;
    L22:
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r0 != null) goto L18;
    L15:
        throw th;
    L18:
        r0.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    }

    public void readFrom(InputStream r3) {
        XmlOptions r0 = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);     // Catch: XmlException -> L4
        r0.setLoadReplaceDocumentElement(null);     // Catch: XmlException -> L4
        this.ctPivotCacheRecords = (dn) ZeusTransformUtils.preCheckCast(dn.f19593a.parse(r3, r0), dn.class, "com.obric.memorydata.plugin");     // Catch: XmlException -> L4
        return;
    L4:
        e = move-exception;
        throw new IOException(e.getLocalizedMessage());
    }
}
