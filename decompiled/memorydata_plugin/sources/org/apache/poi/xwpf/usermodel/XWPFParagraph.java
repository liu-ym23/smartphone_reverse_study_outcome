package org.apache.poi.xwpf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.aq;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.az;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.bv;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.bx;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.cq;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.db;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.dc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.dp;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.dx;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.dz;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.eb;

/* JADX INFO: loaded from: classes7.dex */
public class XWPFParagraph implements IBodyElement, IRunBody {
    protected XWPFDocument document;
    private final StringBuilder footnoteText;
    protected List<IRunElement> iruns;
    private final bv paragraph;
    protected IBody part;
    protected List<XWPFRun> runs;

    public XWPFParagraph(bv r6, IBody r7) {
        bv r8 = (bv) ZeusTransformUtils.wrapperContextForParams(r6, bv.class, "com.obric.memorydata.plugin");
        IBody r9 = (IBody) ZeusTransformUtils.wrapperContextForParams(r7, IBody.class, "com.obric.memorydata.plugin");
        this.footnoteText = new StringBuilder(64);
        this.paragraph = r8;
        this.part = r9;
        XWPFDocument r10 = r9.getXWPFDocument();
        this.document = r10;
        Objects.requireNonNull(r10);
        this.runs = new ArrayList();
        this.iruns = new ArrayList();
        buildRunsInOrderFromXml(r8);
        Iterator<XWPFRun> r11 = this.runs.iterator();
    L4:
        if (r11.hasNext() == false) goto L37;
        XmlCursor r12 = ((XWPFRun) ZeusTransformUtils.preCheckCast(r11.next(), XWPFRun.class, "com.obric.memorydata.plugin")).getCTR().newCursor();
        r12.selectPath("child::*");     // Catch: Throwable -> L28
    L8:
        if (r12.toNextSelection() == false) goto L26;
        XmlObject r0 = r12.getObject();     // Catch: Throwable -> L28
        if (ZeusTransformUtils.instanceOf(r0, aq.class) == false) goto L8;
        aq r1 = (aq) ZeusTransformUtils.preCheckCast(r0, aq.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        this.footnoteText.append(" [").append(r1.getId()).append(": ");     // Catch: Throwable -> L28
        if (r1.getDomNode().getLocalName().equals("footnoteReference") == false) goto L14;
        XWPFAbstractFootnoteEndnote r2 = this.document.getFootnoteByID(r1.getId().intValue());     // Catch: Throwable -> L28
    L15:
        if (r2 == null) goto L23;
        boolean r3 = true;
        Iterator<XWPFParagraph> r4 = r2.getParagraphs().iterator();     // Catch: Throwable -> L28
    L18:
        if (r4.hasNext() == false) goto L24;
        XWPFParagraph r5 = (XWPFParagraph) ZeusTransformUtils.preCheckCast(r4.next(), XWPFParagraph.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        if (r3 == true) goto L22;
        this.footnoteText.append("\n");     // Catch: Throwable -> L28
    L22:
        r3 = false;
        this.footnoteText.append(r5.getText());     // Catch: Throwable -> L28
    L24:
        this.footnoteText.append("] ");     // Catch: Throwable -> L28
        goto L8
    L23:
        this.footnoteText.append("!!! End note with ID \"").append(r1.getId()).append("\" not found in document.");     // Catch: Throwable -> L28
        goto L24
    L14:
        r2 = this.document.getEndnoteByID(r1.getId().intValue());     // Catch: Throwable -> L28
        goto L15
    L26:
        if (r12 == null) goto L4;
        r12.close();
    L28:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        if (r12 != null) goto L42;
    L36:
        throw th;
    L42:
        r12.close();     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        th.addSuppressed(th);
        goto L36
    }

    private void buildRunsInOrderFromXml(XmlObject r10) {
        XmlCursor r11 = ((XmlObject) ZeusTransformUtils.wrapperContextForParams(r10, XmlObject.class, "com.obric.memorydata.plugin")).newCursor();
        r11.selectPath("child::*");     // Catch: Throwable -> L42
    L4:
        if (r11.toNextSelection() == false) goto L39;
        XmlObject r0 = r11.getObject();     // Catch: Throwable -> L42
        if (ZeusTransformUtils.instanceOf(r0, cq.class) == false) goto L9;
        XWPFRun r2 = new XWPFRun((cq) ZeusTransformUtils.preCheckCast(r0, cq.class, "com.obric.memorydata.plugin"), this);     // Catch: Throwable -> L42
        this.runs.add(r2);     // Catch: Throwable -> L42
        this.iruns.add(r2);     // Catch: Throwable -> L42
    L9:
        int r3 = 0;
        if (ZeusTransformUtils.instanceOf(r0, az.class) == false) goto L15;
        az r4 = (az) ZeusTransformUtils.preCheckCast(r0, az.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L42
        cq[] r5 = r4.getRArray();     // Catch: Throwable -> L42
        int r6 = r5.length;     // Catch: Throwable -> L42
        int r7 = 0;
    L12:
        if (r7 >= r6) goto L15;
        XWPFHyperlinkRun r8 = new XWPFHyperlinkRun(r4, r5[r7], this);     // Catch: Throwable -> L42
        this.runs.add(r8);     // Catch: Throwable -> L42
        this.iruns.add(r8);     // Catch: Throwable -> L42
        r7 = r7 + 1;     // Catch: Throwable -> L42
    L15:
        if (ZeusTransformUtils.instanceOf(r0, dx.class) == false) goto L20;
        dx r9 = (dx) ZeusTransformUtils.preCheckCast(r0, dx.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L42
        cq[] r12 = r9.getRArray();     // Catch: Throwable -> L42
        int r13 = r12.length;     // Catch: Throwable -> L42
        int r14 = 0;
    L17:
        if (r14 >= r13) goto L20;
        XWPFFieldRun r15 = new XWPFFieldRun(r9, r12[r14], this);     // Catch: Throwable -> L42
        this.runs.add(r15);     // Catch: Throwable -> L42
        this.iruns.add(r15);     // Catch: Throwable -> L42
        r14 = r14 + 1;     // Catch: Throwable -> L42
    L20:
        if (ZeusTransformUtils.instanceOf(r0, dc.class) == false) goto L23;
        this.iruns.add(new XWPFSDT((dc) ZeusTransformUtils.preCheckCast(r0, dc.class, "com.obric.memorydata.plugin"), this.part));     // Catch: Throwable -> L42
    L23:
        if (ZeusTransformUtils.instanceOf(r0, dp.class) == false) goto L26;
        this.iruns.add(new XWPFSDT((dp) ZeusTransformUtils.preCheckCast(r0, dp.class, "com.obric.memorydata.plugin"), this.part));     // Catch: Throwable -> L42
    L26:
        if (ZeusTransformUtils.instanceOf(r0, db.class) == false) goto L31;
        cq[] r16 = ((db) ZeusTransformUtils.preCheckCast(r0, db.class, "com.obric.memorydata.plugin")).getRArray();     // Catch: Throwable -> L42
        int r17 = r16.length;     // Catch: Throwable -> L42
        int r18 = 0;
    L28:
        if (r18 >= r17) goto L31;
        XWPFRun r19 = new XWPFRun(r16[r18], this);     // Catch: Throwable -> L42
        this.runs.add(r19);     // Catch: Throwable -> L42
        this.iruns.add(r19);     // Catch: Throwable -> L42
        r18 = r18 + 1;     // Catch: Throwable -> L42
    L31:
        if (ZeusTransformUtils.instanceOf(r0, dz.class) == false) goto L34;
        buildRunsInOrderFromXml(r0);     // Catch: Throwable -> L42
    L34:
        if (ZeusTransformUtils.instanceOf(r0, db.class) == false) goto L4;
        db[] r1 = ((db) ZeusTransformUtils.preCheckCast(r0, db.class, "com.obric.memorydata.plugin")).getInsArray();     // Catch: Throwable -> L42
        int r20 = r1.length;     // Catch: Throwable -> L42
    L36:
        if (r3 >= r20) goto L4;
        buildRunsInOrderFromXml(r1[r3]);     // Catch: Throwable -> L42
        r3 = r3 + 1;
        goto L36
    L39:
        if (r11 == null) goto L65;
        r11.close();
        return;
    L65:
        return;
    L42:
        th = move-exception;
        throw th;     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        if (r11 != null) goto L51;
    L50:
        throw th;
    L51:
        r11.close();     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        th.addSuppressed(th);
        goto L50
    }

    public bx getCTPPr() {
        bx r0 = this.paragraph.getPPr();
        bv r1 = this.paragraph;
        if (r0 != null) goto L6;
        return r1.addNewPPr();
    L6:
        return r1.getPPr();
    }

    @Override // org.apache.poi.xwpf.usermodel.IRunBody
    public XWPFDocument getDocument() {
        return this.document;
    }

    @Override // org.apache.poi.xwpf.usermodel.IRunBody
    public POIXMLDocumentPart getPart() {
        IBody r0 = this.part;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getPart();
    }

    public List<XWPFRun> getRuns() {
        return Collections.unmodifiableList(this.runs);
    }

    public String getStyle() {
        bx r2 = getCTPPr();
        if (r2.isSetPStyle() == false) goto L5;
        eb r3 = r2.getPStyle();
    L6:
        if (r3 != null) goto L8;
        return null;
    L8:
        return r3.getVal();
    L5:
        r3 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, org.apache.poi.xwpf.usermodel.IRunElement] */
    /* JADX WARN: Type inference failed for: r2v5, types: [org.apache.poi.xwpf.usermodel.XWPFRun] */
    public String getText() {
        StringBuilder r0 = new StringBuilder(64);
        Iterator<IRunElement> r1 = this.iruns.iterator();
    L4:
        if (r1.hasNext() == false) goto L13;
        Object r2 = (IRunElement) ZeusTransformUtils.preCheckCast(r1.next(), IRunElement.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, XWPFRun.class) == true) goto L7;
        if (ZeusTransformUtils.instanceOf(r2, XWPFSDT.class) == false) goto L9;
        r0.append(((XWPFSDT) ZeusTransformUtils.preCheckCast(r2, XWPFSDT.class, "com.obric.memorydata.plugin")).getContent().getText());
    L9:
        r0.append(r2);
        goto L4
    L7:
        r2 = (XWPFRun) ZeusTransformUtils.preCheckCast(r2, XWPFRun.class, "com.obric.memorydata.plugin");
        if (r2.getCTR().getDelTextArray().length != 0) goto L4;
    L13:
        r0.append(this.footnoteText);
        return r0.toString();
    }
}
