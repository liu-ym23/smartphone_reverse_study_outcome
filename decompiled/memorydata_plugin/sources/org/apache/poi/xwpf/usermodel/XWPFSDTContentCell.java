package org.apache.poi.xwpf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.XmlCursor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.dg;

/* JADX INFO: loaded from: classes7.dex */
public class XWPFSDTContentCell implements ISDTContent {
    private String text;

    public XWPFSDTContentCell(dg r5, XWPFTableRow r6, IBody r7) {
        dg r8 = (dg) ZeusTransformUtils.wrapperContextForParams(r5, dg.class, "com.obric.memorydata.plugin");
        IBody r9 = (IBody) ZeusTransformUtils.wrapperContextForParams(r7, IBody.class, "com.obric.memorydata.plugin");
        this.text = "";
        if (r8 != null) goto L5;
        return;
    L5:
        StringBuilder r10 = new StringBuilder();
        XmlCursor r11 = r8.newCursor();
        int r12 = 1;
        int r1 = 0;
        int r2 = 0;
    L49:
    L40:
        th = move-exception;
        throw th;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        if (r11 != null) goto L53;
    L48:
        throw th;
    L53:
        r11.close();     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        th.addSuppressed(th);
        goto L48
    L7:
        if (r11.hasNextToken() == false) goto L36;
        if (r12 <= 0) goto L36;
        if (r11.toNextToken().isText() == false) goto L13;
        r10.append(r11.getTextValue());     // Catch: Throwable -> L40
    L31:
        if (r11.isStart() == true) goto L32;
        if (r11.isEnd() == false) goto L49;
        r12 = r12 - 1;     // Catch: Throwable -> L40
        goto L49
    L32:
        r12 = r12 + 1;     // Catch: Throwable -> L40
        goto L49
    L13:
        if (isStartToken(r11, "tr") == false) goto L16;
        r1 = 0;
        r2 = 0;
        goto L31
    L16:
        if (isStartToken(r11, "tc") == false) goto L22;
        int r3 = r1 + 1;     // Catch: Throwable -> L40
        if (r1 <= 0) goto L20;
        r10.append("\t");     // Catch: Throwable -> L40
    L20:
        r1 = r3;
        r2 = 0;
        goto L31
    L22:
        if (isStartToken(r11, "p") == false) goto L24;
    L27:
        if (r2 <= 0) goto L29;
        r10.append("\n");     // Catch: Throwable -> L40
    L29:
        r2 = r2 + 1;     // Catch: Throwable -> L40
        goto L31
    L24:
        if (isStartToken(r11, "tbl") == true) goto L27;
        if (isStartToken(r11, "sdt") == false) goto L31;
    L36:
        this.text = r10.toString();     // Catch: Throwable -> L40
        if (r11 == null) goto L64;
        r11.close();
        return;
    }

    private boolean isStartToken(XmlCursor r2, String r3) {
        XmlCursor r1 = (XmlCursor) ZeusTransformUtils.wrapperContextForParams(r2, XmlCursor.class, "com.obric.memorydata.plugin");
        if (r1.isStart() == true) goto L5;
        return false;
    L5:
        QName r4 = r1.getName();
        if (r4 != null) goto L8;
    L13:
        return false;
    L8:
        if (r4.getLocalPart() == null) goto L13;
        if (r4.getLocalPart().equals(r3) == false) goto L13;
        return true;
    }

    @Override // org.apache.poi.xwpf.usermodel.ISDTContent
    public String getText() {
        return this.text;
    }

    public String toString() {
        return getText();
    }
}
