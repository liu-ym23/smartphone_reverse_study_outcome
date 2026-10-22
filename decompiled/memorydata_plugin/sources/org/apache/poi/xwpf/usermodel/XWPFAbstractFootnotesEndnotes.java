package org.apache.poi.xwpf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.openxml4j.opc.PackagePart;

/* JADX INFO: loaded from: classes7.dex */
public abstract class XWPFAbstractFootnotesEndnotes extends POIXMLDocumentPart {
    protected XWPFDocument document;
    private FootnoteEndnoteIdManager idManager;
    protected List<XWPFAbstractFootnoteEndnote> listFootnote;

    public XWPFAbstractFootnotesEndnotes() {
        this.listFootnote = new ArrayList();
    }

    public XWPFAbstractFootnotesEndnotes(PackagePart r1) {
        super(r1);
        this.listFootnote = new ArrayList();
    }

    public XWPFAbstractFootnoteEndnote getFootnoteById(int r4) {
        Iterator<XWPFAbstractFootnoteEndnote> r3 = this.listFootnote.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        XWPFAbstractFootnoteEndnote r0 = (XWPFAbstractFootnoteEndnote) ZeusTransformUtils.preCheckCast(r3.next(), XWPFAbstractFootnoteEndnote.class, "com.obric.memorydata.plugin");
        if (r0.getCTFtnEdn().getId().intValue() != r4) goto L4;
        return r0;
    L8:
        return null;
    }

    public XWPFDocument getXWPFDocument() {
        XWPFDocument r0 = this.document;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return (XWPFDocument) ZeusTransformUtils.preCheckCast(getParent(), XWPFDocument.class, "com.obric.memorydata.plugin");
    }

    public void setIdManager(FootnoteEndnoteIdManager r1) {
        this.idManager = r1;
    }
}
