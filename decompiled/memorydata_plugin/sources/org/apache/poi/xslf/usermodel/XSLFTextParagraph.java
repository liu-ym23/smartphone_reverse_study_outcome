package org.apache.poi.xslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.sl.usermodel.TextParagraph;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.Cdo;
import org.openxmlformats.schemas.drawingml.x2006.main.cd;
import org.openxmlformats.schemas.drawingml.x2006.main.dq;
import org.openxmlformats.schemas.drawingml.x2006.main.dv;

/* JADX INFO: loaded from: classes7.dex */
public class XSLFTextParagraph implements TextParagraph<XSLFShape, XSLFTextParagraph, XSLFTextRun> {
    private final dv _p;
    private final List<XSLFTextRun> _runs;
    private final XSLFTextShape _shape;

    XSLFTextParagraph(dv r5, XSLFTextShape r6) {
        dv r7 = (dv) ZeusTransformUtils.wrapperContextForParams(r5, dv.class, "com.obric.memorydata.plugin");
        this._p = r7;
        this._runs = new ArrayList();
        this._shape = r6;
        XmlCursor r8 = r7.newCursor();
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        if (r8 != null) goto L32;
    L27:
        throw th;
    L32:
        r8.close();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        th.addSuppressed(th);
        goto L27
    L4:
        if (r8.toFirstChild() == false) goto L16;
    L5:
        XmlObject r9 = r8.getObject();     // Catch: Throwable -> L19
        if (ZeusTransformUtils.instanceOf(r9, dq.class) == false) goto L10;
        List<XSLFTextRun> r0 = this._runs;     // Catch: Throwable -> L19
        XSLFTextRun r2 = new XSLFLineBreak((dq) ZeusTransformUtils.preCheckCast(r9, dq.class, "com.obric.memorydata.plugin"), this);     // Catch: Throwable -> L19
    L8:
        r0.add(r2);     // Catch: Throwable -> L19
    L15:
        if (r8.toNextSibling() == true) goto L5;
    L10:
        if (ZeusTransformUtils.instanceOf(r9, cd.class) == false) goto L12;
    L13:
        r0 = this._runs;     // Catch: Throwable -> L19
        r2 = new XSLFTextRun(r9, this);     // Catch: Throwable -> L19
        goto L8
    L12:
        if (ZeusTransformUtils.instanceOf(r9, Cdo.class) == false) goto L15;
    L16:
        if (r8 == null) goto L36;
        r8.close();
        return;
    }

    public String getText() {
        StringBuilder r0 = new StringBuilder();
        Iterator<XSLFTextRun> r4 = this._runs.iterator();
    L4:
        if (r4.hasNext() == false) goto L7;
        r0.append(((XSLFTextRun) ZeusTransformUtils.preCheckCast(r4.next(), XSLFTextRun.class, "com.obric.memorydata.plugin")).getRawText());
        goto L4
    L7:
        return r0.toString();
    }

    public List<XSLFTextRun> getTextRuns() {
        return Collections.unmodifiableList(this._runs);
    }

    @Override // java.lang.Iterable
    public Iterator<XSLFTextRun> iterator() {
        return getTextRuns().iterator();
    }

    public String toString() {
        return "[" + getClass() + "]" + getText();
    }
}
