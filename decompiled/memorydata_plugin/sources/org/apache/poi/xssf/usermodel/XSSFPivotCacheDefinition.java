package org.apache.poi.xssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import javax.xml.namespace.QName;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.dm;

/* JADX INFO: loaded from: classes7.dex */
public class XSSFPivotCacheDefinition extends POIXMLDocumentPart {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private dm ctPivotCacheDefinition;

    static {
    }

    public XSSFPivotCacheDefinition() {
        this.ctPivotCacheDefinition = (dm) ZeusTransformUtils.preCheckCast(dm.f19591a.newInstance(), dm.class, "com.obric.memorydata.plugin");
        createDefaultValues();
    }

    public XSSFPivotCacheDefinition(PackagePart r2) {
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

    private void createDefaultValues() {
        this.ctPivotCacheDefinition.setCreatedVersion(3);
        this.ctPivotCacheDefinition.setMinRefreshableVersion(3);
        this.ctPivotCacheDefinition.setRefreshedVersion(3);
        this.ctPivotCacheDefinition.setRefreshedBy("Apache POI");
        this.ctPivotCacheDefinition.setRefreshedDate(new Date().getTime());
        this.ctPivotCacheDefinition.setRefreshOnLoad(true);
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void commit() {
        OutputStream r0 = getPackagePart().getOutputStream();
        XmlOptions r1 = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);     // Catch: Throwable -> L7
        r1.setSaveSyntheticDocumentElement(new QName(dm.f19592b.getName().getNamespaceURI(), "pivotCacheDefinition"));     // Catch: Throwable -> L7
        this.ctPivotCacheDefinition.save(r0, r1);     // Catch: Throwable -> L7
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
        this.ctPivotCacheDefinition = (dm) ZeusTransformUtils.preCheckCast(dm.f19591a.parse(r3, r0), dm.class, "com.obric.memorydata.plugin");     // Catch: XmlException -> L4
        return;
    L4:
        e = move-exception;
        throw new IOException(e.getLocalizedMessage(), e);
    }
}
