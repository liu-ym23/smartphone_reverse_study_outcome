package org.apache.poi.xssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.xssf.model.ParagraphPropertyFetcher;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.Cdo;
import org.openxmlformats.schemas.drawingml.x2006.main.cd;
import org.openxmlformats.schemas.drawingml.x2006.main.dq;
import org.openxmlformats.schemas.drawingml.x2006.main.dv;
import org.openxmlformats.schemas.drawingml.x2006.main.dw;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.n;

/* JADX INFO: loaded from: classes7.dex */
public class XSSFTextParagraph implements Iterable<XSSFTextRun> {
    private final dv _p;
    private final List<XSSFTextRun> _runs;
    private final n _shape;

    XSSFTextParagraph(dv r6, n r7) {
        dv r8 = (dv) ZeusTransformUtils.wrapperContextForParams(r6, dv.class, "com.obric.memorydata.plugin");
        n r9 = (n) ZeusTransformUtils.wrapperContextForParams(r7, n.class, "com.obric.memorydata.plugin");
        this._p = r8;
        this._shape = r9;
        this._runs = new ArrayList();
        XmlObject[] r10 = r8.selectPath("*");
        int r11 = r10.length;
        int r0 = 0;
    L3:
        if (r0 >= r11) goto L15;
        XmlObject r2 = r10[r0];
        if (ZeusTransformUtils.instanceOf(r2, cd.class) == false) goto L8;
        cd r3 = (cd) ZeusTransformUtils.preCheckCast(r2, cd.class, "com.obric.memorydata.plugin");
        this._runs.add(new XSSFTextRun(r3, this));
    L14:
        r0 = r0 + 1;
        goto L3
    L8:
        if (ZeusTransformUtils.instanceOf(r2, dq.class) == false) goto L12;
        dq r4 = (dq) ZeusTransformUtils.preCheckCast(r2, dq.class, "com.obric.memorydata.plugin");
        cd r5 = (cd) ZeusTransformUtils.preCheckCast(cd.f18792a.newInstance(), cd.class, "com.obric.memorydata.plugin");
        r5.setRPr(r4.getRPr());
        r5.setT("\n");
        List<XSSFTextRun> r12 = this._runs;
        XSSFTextRun r13 = new XSSFTextRun(r5, this);
    L10:
        r12.add(r13);
        goto L14
    L12:
        if (ZeusTransformUtils.instanceOf(r2, Cdo.class) == false) goto L14;
        Cdo r14 = (Cdo) ZeusTransformUtils.preCheckCast(r2, Cdo.class, "com.obric.memorydata.plugin");
        cd r15 = (cd) ZeusTransformUtils.preCheckCast(cd.f18792a.newInstance(), cd.class, "com.obric.memorydata.plugin");
        r15.setRPr(r14.getRPr());
        r15.setT(r14.getT());
        r12 = this._runs;
        r13 = new XSSFTextRun(r15, this);
        goto L10
    }

    private boolean fetchParagraphProperty(ParagraphPropertyFetcher r2) {
        if (this._p.isSetPPr() == false) goto L5;
        boolean r0 = r2.fetch(this._p.getPPr());
    L6:
        if (r0 == false) goto L8;
        return r0;
    L8:
        return r2.fetch(this._shape);
    L5:
        r0 = false;
        goto L6
    }

    public ListAutoNumber getBulletAutoNumberScheme() {
        final int r1 = getLevel();
        ParagraphPropertyFetcher<ListAutoNumber> r0 = new AnonymousClass18(this, r1);
        fetchParagraphProperty(r0);
        if (r0.getValue() != null) goto L6;
        return ListAutoNumber.ARABIC_PLAIN;
    L6:
        return (ListAutoNumber) ZeusTransformUtils.preCheckCast(r0.getValue(), ListAutoNumber.class, "com.obric.memorydata.plugin");
    }

    public int getBulletAutoNumberStart() {
        final int r1 = getLevel();
        ParagraphPropertyFetcher<Integer> r0 = new AnonymousClass17(this, r1);
        fetchParagraphProperty(r0);
        if (r0.getValue() != null) goto L6;
        return 0;
    L6:
        return ((Integer) ZeusTransformUtils.preCheckCast(r0.getValue(), Integer.class, "com.obric.memorydata.plugin")).intValue();
    }

    public String getBulletCharacter() {
        final int r1 = getLevel();
        ParagraphPropertyFetcher<String> r0 = new AnonymousClass4(this, r1);
        fetchParagraphProperty(r0);
        return (String) ZeusTransformUtils.preCheckCast(r0.getValue(), String.class, "com.obric.memorydata.plugin");
    }

    public int getLevel() {
        dw r0 = this._p.getPPr();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getLvl();
    }

    public String getText() {
        StringBuilder r0 = new StringBuilder();
        Iterator<XSSFTextRun> r4 = this._runs.iterator();
    L4:
        if (r4.hasNext() == false) goto L7;
        r0.append(((XSSFTextRun) ZeusTransformUtils.preCheckCast(r4.next(), XSSFTextRun.class, "com.obric.memorydata.plugin")).getText());
        goto L4
    L7:
        return r0.toString();
    }

    public boolean isBullet() {
        final int r1 = getLevel();
        ParagraphPropertyFetcher<Boolean> r0 = new AnonymousClass15(this, r1);
        fetchParagraphProperty(r0);
        if (r0.getValue() != null) goto L6;
        return false;
    L6:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r0.getValue(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    public boolean isBulletAutoNumber() {
        final int r1 = getLevel();
        ParagraphPropertyFetcher<Boolean> r0 = new AnonymousClass16(this, r1);
        fetchParagraphProperty(r0);
        if (r0.getValue() != null) goto L6;
        return false;
    L6:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r0.getValue(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    @Override // java.lang.Iterable
    public Iterator<XSSFTextRun> iterator() {
        return this._runs.iterator();
    }

    public String toString() {
        return "[" + getClass() + "]" + getText();
    }
}
