package org.apache.poi.xwpf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.io.OutputStream;
import javax.xml.namespace.QName;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.bs;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.bv;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.dc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.eh;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.fv;

/* JADX INFO: loaded from: classes7.dex */
public class XWPFHeader extends XWPFHeaderFooter {
    public XWPFHeader() {
    }

    public XWPFHeader(POIXMLDocumentPart r1, PackagePart r2) {
        super(r1, r2);
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void commit() {
        XmlOptions r0 = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        r0.setSaveSyntheticDocumentElement(new QName(bs.f19981b.getName().getNamespaceURI(), "hdr"));
        OutputStream r1 = getPackagePart().getOutputStream();
        super._getHdrFtr().save(r1, r0);     // Catch: Throwable -> L7
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

    @Override // org.apache.poi.xwpf.usermodel.XWPFHeaderFooter, org.apache.poi.ooxml.POIXMLDocumentPart
    public void onDocumentRead() {
        super.onDocumentRead();
        InputStream r1 = getPackagePart().getInputStream();     // Catch: XmlException -> L41
        this.headerFooter = ((fv) ZeusTransformUtils.preCheckCast(fv.f20178a.parse(r1, POIXMLTypeLoader.DEFAULT_XML_OPTIONS), fv.class, "com.obric.memorydata.plugin")).getHdr();     // Catch: Throwable -> L32
        XmlCursor r2 = this.headerFooter.newCursor();     // Catch: Throwable -> L32
        r2.selectPath("./*");     // Catch: Throwable -> L23
    L6:
        if (r2.toNextSelection() == false) goto L18;
        XmlObject r3 = r2.getObject();     // Catch: Throwable -> L23
        if (ZeusTransformUtils.instanceOf(r3, bv.class) == false) goto L12;
        XWPFParagraph r4 = new XWPFParagraph((bv) ZeusTransformUtils.preCheckCast(r3, bv.class, "com.obric.memorydata.plugin"), this);     // Catch: Throwable -> L23
        this.paragraphs.add(r4);     // Catch: Throwable -> L23
        this.bodyElements.add(r4);     // Catch: Throwable -> L23
    L12:
        if (ZeusTransformUtils.instanceOf(r3, eh.class) == false) goto L15;
        XWPFTable r5 = new XWPFTable((eh) ZeusTransformUtils.preCheckCast(r3, eh.class, "com.obric.memorydata.plugin"), this);     // Catch: Throwable -> L23
        this.tables.add(r5);     // Catch: Throwable -> L23
        this.bodyElements.add(r5);     // Catch: Throwable -> L23
    L15:
        if (ZeusTransformUtils.instanceOf(r3, dc.class) == false) goto L6;
        XWPFSDT r6 = new XWPFSDT((dc) ZeusTransformUtils.preCheckCast(r3, dc.class, "com.obric.memorydata.plugin"), this);     // Catch: Throwable -> L23
        this.bodyElements.add(r6);     // Catch: Throwable -> L23
        goto L6
    L18:
        if (r2 == null) goto L20;
        r2.close();     // Catch: Throwable -> L32
    L20:
        if (r1 == null) goto L61;
        r1.close();     // Catch: XmlException -> L41
        return;
    L61:
        return;
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        if (r2 != null) goto L46;
    L31:
        throw th;     // Catch: Throwable -> L32
    L46:
        r2.close();     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        if (r1 != null) goto L44;
    L40:
        throw th;     // Catch: XmlException -> L41
    L44:
        r1.close();     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        th.addSuppressed(th);     // Catch: XmlException -> L41
    L41:
        e = move-exception;
        throw new POIXMLException(e);
    }
}
