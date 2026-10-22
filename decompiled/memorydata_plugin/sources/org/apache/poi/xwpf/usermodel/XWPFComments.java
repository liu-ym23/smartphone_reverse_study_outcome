package org.apache.poi.xwpf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.xml.namespace.QName;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.fq;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.p;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.q;

/* JADX INFO: loaded from: classes7.dex */
public class XWPFComments extends POIXMLDocumentPart {
    private final List<XWPFComment> comments;
    private q ctComments;
    XWPFDocument document;
    private final List<XWPFPictureData> pictures;

    public XWPFComments() {
        this.comments = new ArrayList();
        this.pictures = new ArrayList();
        this.ctComments = (q) ZeusTransformUtils.preCheckCast(q.f20234a.newInstance(), q.class, "com.obric.memorydata.plugin");
    }

    public XWPFComments(POIXMLDocumentPart r2, PackagePart r3) {
        super(r2, r3);
        this.comments = new ArrayList();
        this.pictures = new ArrayList();
        XWPFDocument r4 = (XWPFDocument) ZeusTransformUtils.preCheckCast(getParent(), XWPFDocument.class, "com.obric.memorydata.plugin");
        this.document = r4;
        Objects.requireNonNull(r4);
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void commit() {
        XmlOptions r0 = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        r0.setSaveSyntheticDocumentElement(new QName(q.f20235b.getName().getNamespaceURI(), "comments"));
        OutputStream r1 = getPackagePart().getOutputStream();
        this.ctComments.save(r1, r0);     // Catch: Throwable -> L7
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

    public XWPFDocument getXWPFDocument() {
        XWPFDocument r0 = this.document;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return (XWPFDocument) ZeusTransformUtils.preCheckCast(getParent(), XWPFDocument.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void onDocumentRead() {
        InputStream r1 = getPackagePart().getInputStream();     // Catch: XmlException -> L27
        q r2 = ((fq) ZeusTransformUtils.preCheckCast(fq.f20168a.parse(r1, POIXMLTypeLoader.DEFAULT_XML_OPTIONS), fq.class, "com.obric.memorydata.plugin")).getComments();     // Catch: Throwable -> L18
        this.ctComments = r2;     // Catch: Throwable -> L18
        Iterator<p> r3 = r2.getCommentList().iterator();     // Catch: Throwable -> L18
    L6:
        if (r3.hasNext() == false) goto L9;
        p r4 = (p) ZeusTransformUtils.preCheckCast(r3.next(), p.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        this.comments.add(new XWPFComment(r4, this));     // Catch: Throwable -> L18
    L9:
        if (r1 == null) goto L11;
        r1.close();     // Catch: XmlException -> L27
    L11:
        Iterator<POIXMLDocumentPart> r5 = getRelations().iterator();
    L13:
        if (r5.hasNext() == false) goto L17;
        POIXMLDocumentPart r6 = (POIXMLDocumentPart) ZeusTransformUtils.preCheckCast(r5.next(), POIXMLDocumentPart.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, XWPFPictureData.class) == false) goto L13;
        XWPFPictureData r7 = (XWPFPictureData) ZeusTransformUtils.preCheckCast(r6, XWPFPictureData.class, "com.obric.memorydata.plugin");
        this.pictures.add(r7);
        this.document.registerPackagePictureData(r7);
        goto L13
    L17:
        return;
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        if (r1 != null) goto L34;
    L26:
        throw th;     // Catch: XmlException -> L27
    L34:
        r1.close();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        th.addSuppressed(th);     // Catch: XmlException -> L27
    L27:
        e = move-exception;
        throw new POIXMLException("Unable to read comments", e);
    }
}
