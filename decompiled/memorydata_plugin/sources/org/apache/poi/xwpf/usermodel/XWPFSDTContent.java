package org.apache.poi.xwpf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.bv;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.cq;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.dc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.df;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.dh;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.dp;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.eh;

/* JADX INFO: loaded from: classes7.dex */
public class XWPFSDTContent implements ISDTContent {
    private final List<Object> bodyElements;

    public XWPFSDTContent(df r5, IBody r6, IRunBody r7) {
        df r8 = (df) ZeusTransformUtils.wrapperContextForParams(r5, df.class, "com.obric.memorydata.plugin");
        IBody r9 = (IBody) ZeusTransformUtils.wrapperContextForParams(r6, IBody.class, "com.obric.memorydata.plugin");
        IRunBody r10 = (IRunBody) ZeusTransformUtils.wrapperContextForParams(r7, IRunBody.class, "com.obric.memorydata.plugin");
        this.bodyElements = new ArrayList();
        if (r8 != null) goto L5;
        return;
    L5:
        XmlCursor r11 = r8.newCursor();
        r11.selectPath("./*");     // Catch: Throwable -> L26
    L7:
        if (r11.toNextSelection() == false) goto L23;
        XmlObject r0 = r11.getObject();     // Catch: Throwable -> L26
        if (ZeusTransformUtils.instanceOf(r0, bv.class) == true) goto L11;
        if (ZeusTransformUtils.instanceOf(r0, eh.class) == true) goto L15;
        if (ZeusTransformUtils.instanceOf(r0, dc.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r0, cq.class) == false) goto L7;
        Object r2 = new XWPFRun((cq) ZeusTransformUtils.preCheckCast(r0, cq.class, "com.obric.memorydata.plugin"), r10);     // Catch: Throwable -> L26
        List<Object> r1 = this.bodyElements;     // Catch: Throwable -> L26
    L12:
        r1.add(r2);     // Catch: Throwable -> L26
        goto L7
    L18:
        r2 = new XWPFSDT((dc) ZeusTransformUtils.preCheckCast(r0, dc.class, "com.obric.memorydata.plugin"), r9);     // Catch: Throwable -> L26
        r1 = this.bodyElements;     // Catch: Throwable -> L26
        goto L12
    L15:
        r2 = new XWPFTable((eh) ZeusTransformUtils.preCheckCast(r0, eh.class, "com.obric.memorydata.plugin"), r9);     // Catch: Throwable -> L26
        r1 = this.bodyElements;     // Catch: Throwable -> L26
        goto L12
    L11:
        r2 = new XWPFParagraph((bv) ZeusTransformUtils.preCheckCast(r0, bv.class, "com.obric.memorydata.plugin"), r9);     // Catch: Throwable -> L26
        r1 = this.bodyElements;     // Catch: Throwable -> L26
        goto L12
    L23:
        if (r11 == null) goto L49;
        r11.close();
        return;
    L49:
        return;
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        if (r11 != null) goto L39;
    L34:
        throw th;
    L39:
        r11.close();     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        th.addSuppressed(th);
        goto L34
    }

    public XWPFSDTContent(dh r5, IBody r6, IRunBody r7) {
        dh r8 = (dh) ZeusTransformUtils.wrapperContextForParams(r5, dh.class, "com.obric.memorydata.plugin");
        IBody r9 = (IBody) ZeusTransformUtils.wrapperContextForParams(r6, IBody.class, "com.obric.memorydata.plugin");
        IRunBody r10 = (IRunBody) ZeusTransformUtils.wrapperContextForParams(r7, IRunBody.class, "com.obric.memorydata.plugin");
        this.bodyElements = new ArrayList();
        if (r8 != null) goto L5;
        return;
    L5:
        XmlCursor r11 = r8.newCursor();
        r11.selectPath("./*");     // Catch: Throwable -> L20
    L7:
        if (r11.toNextSelection() == false) goto L17;
        XmlObject r0 = r11.getObject();     // Catch: Throwable -> L20
        if (ZeusTransformUtils.instanceOf(r0, cq.class) == true) goto L11;
        if (ZeusTransformUtils.instanceOf(r0, dp.class) == false) goto L7;
        Object r2 = new XWPFSDT((dp) ZeusTransformUtils.preCheckCast(r0, dp.class, "com.obric.memorydata.plugin"), r9);     // Catch: Throwable -> L20
        List<Object> r1 = this.bodyElements;     // Catch: Throwable -> L20
    L12:
        r1.add(r2);     // Catch: Throwable -> L20
        goto L7
    L11:
        r2 = new XWPFRun((cq) ZeusTransformUtils.preCheckCast(r0, cq.class, "com.obric.memorydata.plugin"), r10);     // Catch: Throwable -> L20
        r1 = this.bodyElements;     // Catch: Throwable -> L20
        goto L12
    L17:
        if (r11 == null) goto L41;
        r11.close();
        return;
    L41:
        return;
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        if (r11 != null) goto L33;
    L28:
        throw th;
    L33:
        r11.close();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        th.addSuppressed(th);
        goto L28
    }

    private void appendParagraph(XWPFParagraph r3, StringBuilder r4) {
        Iterator<XWPFRun> r2 = r3.getRuns().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r4.append((IRunElement) ZeusTransformUtils.preCheckCast(r2.next(), IRunElement.class, "com.obric.memorydata.plugin"));
        goto L4
    }

    private void appendTable(XWPFTable r5, StringBuilder r6) {
        Iterator<XWPFTableRow> r4 = r5.getRows().iterator();
    L4:
        if (r4.hasNext() == false) goto L20;
        List<ICell> r7 = ((XWPFTableRow) ZeusTransformUtils.preCheckCast(r4.next(), XWPFTableRow.class, "com.obric.memorydata.plugin")).getTableICells();
        int r0 = 0;
    L7:
        if (r0 >= r7.size()) goto L19;
        ICell r2 = (ICell) ZeusTransformUtils.preCheckCast(r7.get(r0), ICell.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, XWPFTableCell.class) == false) goto L13;
        String r3 = ((XWPFTableCell) ZeusTransformUtils.preCheckCast(r2, XWPFTableCell.class, "com.obric.memorydata.plugin")).getTextRecursively();
    L11:
        r6.append(r3);
    L16:
        if (r0 >= (r7.size() - 1)) goto L18;
        r6.append("\t");
    L18:
        r0 = r0 + 1;
        goto L7
    L13:
        if (ZeusTransformUtils.instanceOf(r2, XWPFSDTCell.class) == false) goto L16;
        r3 = ((XWPFSDTCell) ZeusTransformUtils.preCheckCast(r2, XWPFSDTCell.class, "com.obric.memorydata.plugin")).getContent().getText();
        goto L11
    L19:
        r6.append('\n');
        goto L4
    }

    @Override // org.apache.poi.xwpf.usermodel.ISDTContent
    public String getText() {
        StringBuilder r0 = new StringBuilder();
        int r2 = 0;
        boolean r3 = false;
    L4:
        if (r2 >= this.bodyElements.size()) goto L24;
        Object r4 = this.bodyElements.get(r2);
        if (ZeusTransformUtils.instanceOf(r4, XWPFParagraph.class) == false) goto L10;
        appendParagraph((XWPFParagraph) ZeusTransformUtils.preCheckCast(r4, XWPFParagraph.class, "com.obric.memorydata.plugin"), r0);
    L8:
        r3 = true;
    L18:
        if (r3 == false) goto L22;
        if (r2 >= (this.bodyElements.size() - 1)) goto L22;
        r0.append("\n");
    L22:
        r2 = r2 + 1;
        goto L4
    L10:
        if (ZeusTransformUtils.instanceOf(r4, XWPFTable.class) == false) goto L13;
        appendTable((XWPFTable) ZeusTransformUtils.preCheckCast(r4, XWPFTable.class, "com.obric.memorydata.plugin"), r0);
        goto L8
    L13:
        if (ZeusTransformUtils.instanceOf(r4, XWPFSDT.class) == false) goto L16;
        r0.append(((XWPFSDT) ZeusTransformUtils.preCheckCast(r4, XWPFSDT.class, "com.obric.memorydata.plugin")).getContent().getText());
        goto L8
    L16:
        if (ZeusTransformUtils.instanceOf(r4, XWPFRun.class) == false) goto L18;
        r0.append(r4);
        r3 = false;
        goto L18
    L24:
        return r0.toString();
    }

    public String toString() {
        return getText();
    }
}
