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
import org.openxmlformats.schemas.wordprocessingml.x2006.main.af;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.ap;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.fs;

/* JADX INFO: loaded from: classes7.dex */
public class XWPFEndnotes extends XWPFAbstractFootnotesEndnotes {
    protected af ctEndnotes;

    public XWPFEndnotes() {
    }

    public XWPFEndnotes(PackagePart r1) {
        super(r1);
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void commit() {
        XmlOptions r0 = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        r0.setSaveSyntheticDocumentElement(new QName(af.f19907b.getName().getNamespaceURI(), "endnotes"));
        OutputStream r1 = getPackagePart().getOutputStream();
        this.ctEndnotes.save(r1, r0);     // Catch: Throwable -> L7
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

    @Override // org.apache.poi.xwpf.usermodel.XWPFAbstractFootnotesEndnotes
    public /* bridge */ /* synthetic */ XWPFAbstractFootnoteEndnote getFootnoteById(int r1) {
        return getFootnoteById(r1);
    }

    @Override // org.apache.poi.xwpf.usermodel.XWPFAbstractFootnotesEndnotes
    public XWPFEndnote getFootnoteById(int r2) {
        return (XWPFEndnote) ZeusTransformUtils.preCheckCast(super.getFootnoteById(r2), XWPFEndnote.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void onDocumentRead() {
        InputStream r1 = getPackagePart().getInputStream();     // Catch: XmlException -> L21
        this.ctEndnotes = ((fs) ZeusTransformUtils.preCheckCast(fs.f20172a.parse(r1, POIXMLTypeLoader.DEFAULT_XML_OPTIONS), fs.class, "com.obric.memorydata.plugin")).getEndnotes();     // Catch: Throwable -> L12
        if (r1 == null) goto L7;
        r1.close();     // Catch: XmlException -> L21
    L7:
        Iterator<ap> r2 = this.ctEndnotes.getEndnoteList().iterator();
    L9:
        if (r2.hasNext() == false) goto L11;
        ap r3 = (ap) ZeusTransformUtils.preCheckCast(r2.next(), ap.class, "com.obric.memorydata.plugin");
        this.listFootnote.add(new XWPFEndnote(r3, this));
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
