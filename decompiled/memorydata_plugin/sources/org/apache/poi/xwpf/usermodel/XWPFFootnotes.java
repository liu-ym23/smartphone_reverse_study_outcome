package org.apache.poi.xwpf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import javax.xml.namespace.QName;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.an;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.ap;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.ft;

/* JADX INFO: loaded from: classes7.dex */
public class XWPFFootnotes extends XWPFAbstractFootnotesEndnotes {
    protected an ctFootnotes;

    public XWPFFootnotes() {
    }

    public XWPFFootnotes(PackagePart r1) {
        super(r1);
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void commit() {
        XmlOptions r0 = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        r0.setSaveSyntheticDocumentElement(new QName(an.f19923b.getName().getNamespaceURI(), "footnotes"));
        OutputStream r1 = getPackagePart().getOutputStream();
        this.ctFootnotes.save(r1, r0);     // Catch: Throwable -> L7
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

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void onDocumentRead() {
        InputStream r1 = getPackagePart().getInputStream();     // Catch: XmlException -> L21
        this.ctFootnotes = ((ft) ZeusTransformUtils.preCheckCast(ft.f20174a.parse(r1, POIXMLTypeLoader.DEFAULT_XML_OPTIONS), ft.class, "com.obric.memorydata.plugin")).getFootnotes();     // Catch: Throwable -> L12
        if (r1 == null) goto L7;
        r1.close();     // Catch: XmlException -> L21
    L7:
        Iterator<ap> r2 = this.ctFootnotes.getFootnoteList().iterator();
    L9:
        if (r2.hasNext() == false) goto L11;
        ap r3 = (ap) ZeusTransformUtils.preCheckCast(r2.next(), ap.class, "com.obric.memorydata.plugin");
        this.listFootnote.add(new XWPFFootnote(r3, this));
        goto L9
    L11:
        return;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        if (r1 != null) goto L23;
    L20:
        throw th;     // Catch: XmlException -> L21
    L23:
        r1.close();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        th.addSuppressed(th);     // Catch: XmlException -> L21
    L22:
        throw new POIXMLException();
    }
}
