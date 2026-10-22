package org.apache.poi.hslf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public final class MainMaster extends SheetContainer {
    private static long _type = 1016;
    private ColorSchemeAtom _colorScheme;
    private byte[] _header;
    private ColorSchemeAtom[] clrscheme;
    private PPDrawing ppDrawing;
    private SlideAtom slideAtom;
    private TxMasterStyleAtom[] txmasters;

    static {
    }

    public MainMaster(byte[] r7, int r8, int r9) {
        int r0 = r8 + 8;
        this._header = Arrays.copyOfRange(r7, r8, r0);
        this._children = Record.findChildRecords(r7, r0, r9 - 8);
        ArrayList r10 = new ArrayList();
        ArrayList r11 = new ArrayList();
        Record[] r12 = this._children;
        int r1 = r12.length;
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L23;
        Record r4 = r12[r2];
        if (ZeusTransformUtils.instanceOf(r4, SlideAtom.class) == false) goto L9;
        this.slideAtom = (SlideAtom) ZeusTransformUtils.preCheckCast(r4, SlideAtom.class, "com.obric.memorydata.plugin");
    L18:
        if (this.ppDrawing == null) goto L22;
        if (ZeusTransformUtils.instanceOf(r4, ColorSchemeAtom.class) == false) goto L22;
        this._colorScheme = (ColorSchemeAtom) ZeusTransformUtils.preCheckCast(r4, ColorSchemeAtom.class, "com.obric.memorydata.plugin");
    L22:
        r2 = r2 + 1;
        goto L4
    L9:
        if (ZeusTransformUtils.instanceOf(r4, PPDrawing.class) == false) goto L12;
        this.ppDrawing = (PPDrawing) ZeusTransformUtils.preCheckCast(r4, PPDrawing.class, "com.obric.memorydata.plugin");
        goto L18
    L12:
        if (ZeusTransformUtils.instanceOf(r4, TxMasterStyleAtom.class) == false) goto L15;
        r10.add((TxMasterStyleAtom) ZeusTransformUtils.preCheckCast(r4, TxMasterStyleAtom.class, "com.obric.memorydata.plugin"));
        goto L18
    L15:
        if (ZeusTransformUtils.instanceOf(r4, ColorSchemeAtom.class) == false) goto L18;
        r11.add((ColorSchemeAtom) ZeusTransformUtils.preCheckCast(r4, ColorSchemeAtom.class, "com.obric.memorydata.plugin"));
        goto L18
    L23:
        this.txmasters = (TxMasterStyleAtom[]) ZeusTransformUtils.preCheckCast(r10.toArray(new TxMasterStyleAtom[0]), TxMasterStyleAtom[].class, "com.obric.memorydata.plugin");
        this.clrscheme = (ColorSchemeAtom[]) ZeusTransformUtils.preCheckCast(r11.toArray(new ColorSchemeAtom[0]), ColorSchemeAtom[].class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.poi.hslf.record.SheetContainer
    public PPDrawing getPPDrawing() {
        return this.ppDrawing;
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return _type;
    }

    public TxMasterStyleAtom[] getTxMasterStyleAtoms() {
        return this.txmasters;
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r10) {
        byte[] r0 = this._header;
        writeOut(r0[0], r0[1], _type, this._children, r10);
    }
}
