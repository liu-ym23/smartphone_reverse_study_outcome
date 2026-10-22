package org.apache.poi.hslf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.OutputStream;
import java.util.Arrays;
import org.apache.logging.log4j.util.v;

/* JADX INFO: loaded from: classes7.dex */
public final class Document extends PositionDependentRecordContainer {
    private static long _type = 1000;
    private byte[] _header;
    private DocumentAtom documentAtom;
    private Environment environment;
    private ExObjList exObjList;
    private PPDrawingGroup ppDrawing;
    private SlideListWithText[] slwts;

    static {
    }

    Document(byte[] r5, int r6, int r7) {
        int r0 = r6 + 8;
        this._header = Arrays.copyOfRange(r5, r6, r0);
        this._children = Record.findChildRecords(r5, r0, r7 - 8);
        int r8 = 0;
        if (ZeusTransformUtils.instanceOf(this._children[0], DocumentAtom.class) == false) goto L34;
        this.documentAtom = (DocumentAtom) ZeusTransformUtils.preCheckCast(this._children[0], DocumentAtom.class, "com.obric.memorydata.plugin");
        int r9 = 1;
        int r10 = 1;
        int r1 = 0;
    L6:
        if (r10 >= this._children.length) goto L20;
        if (ZeusTransformUtils.instanceOf(this._children[r10], SlideListWithText.class) == false) goto L11;
        r1 = r1 + 1;
    L11:
        if (ZeusTransformUtils.instanceOf(this._children[r10], Environment.class) == false) goto L14;
        this.environment = (Environment) ZeusTransformUtils.preCheckCast(this._children[r10], Environment.class, "com.obric.memorydata.plugin");
    L14:
        if (ZeusTransformUtils.instanceOf(this._children[r10], PPDrawingGroup.class) == false) goto L17;
        this.ppDrawing = (PPDrawingGroup) ZeusTransformUtils.preCheckCast(this._children[r10], PPDrawingGroup.class, "com.obric.memorydata.plugin");
    L17:
        if (ZeusTransformUtils.instanceOf(this._children[r10], ExObjList.class) == false) goto L19;
        this.exObjList = (ExObjList) ZeusTransformUtils.preCheckCast(this._children[r10], ExObjList.class, "com.obric.memorydata.plugin");
    L19:
        r10 = r10 + 1;
        goto L6
    L20:
        if (r1 != 0) goto L23;
        LOG.atWarn().a("No SlideListWithText's found - there should normally be at least one!");
    L23:
        if (r1 <= 3) goto L25;
        LOG.atWarn().a("Found {} SlideListWithTexts - normally there should only be three!", v.a(r1));
    L25:
        this.slwts = new SlideListWithText[r1];
    L27:
        if (r9 >= this._children.length) goto L32;
        if (ZeusTransformUtils.instanceOf(this._children[r9], SlideListWithText.class) == false) goto L31;
        this.slwts[r8] = (SlideListWithText) ZeusTransformUtils.preCheckCast(this._children[r9], SlideListWithText.class, "com.obric.memorydata.plugin");
        r8 = r8 + 1;
    L31:
        r9 = r9 + 1;
        goto L27
    L32:
        return;
    L34:
        throw new IllegalStateException("The first child of a Document must be a DocumentAtom");
    }

    public DocumentAtom getDocumentAtom() {
        return this.documentAtom;
    }

    public Environment getEnvironment() {
        return this.environment;
    }

    public ExObjList getExObjList(boolean r2) {
        if (this.exObjList != null) goto L7;
        if (r2 == false) goto L7;
        ExObjList r3 = new ExObjList();
        this.exObjList = r3;
        addChildAfter(r3, getDocumentAtom());
    L7:
        return this.exObjList;
    }

    public SlideListWithText getMasterSlideListWithText() {
        SlideListWithText[] r5 = this.slwts;
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        SlideListWithText r2 = r5[r1];
        if (r2.getInstance() == 1) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r2;
    L8:
        return null;
    }

    public SlideListWithText getNotesSlideListWithText() {
        SlideListWithText[] r5 = this.slwts;
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        SlideListWithText r2 = r5[r1];
        if (r2.getInstance() == 2) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r2;
    L8:
        return null;
    }

    public PPDrawingGroup getPPDrawingGroup() {
        return this.ppDrawing;
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return _type;
    }

    public SlideListWithText getSlideSlideListWithText() {
        SlideListWithText[] r4 = this.slwts;
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        SlideListWithText r2 = r4[r1];
        if (r2.getInstance() == 0) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r2;
    L8:
        return null;
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r10) {
        byte[] r0 = this._header;
        writeOut(r0[0], r0[1], _type, this._children, r10);
    }
}
