package org.apache.poi.hslf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.OutputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public final class Environment extends PositionDependentRecordContainer {
    private static long _type = 1010;
    private byte[] _header;
    private FontCollection fontCollection;
    private TxMasterStyleAtom txmaster;

    static {
    }

    public Environment(byte[] r4, int r5, int r6) {
        int r0 = r5 + 8;
        this._header = Arrays.copyOfRange(r4, r5, r0);
        this._children = Record.findChildRecords(r4, r0, r6 - 8);
        Record[] r7 = this._children;
        int r8 = r7.length;
        int r9 = 0;
    L3:
        if (r9 >= r8) goto L12;
        Record r1 = r7[r9];
        if (ZeusTransformUtils.instanceOf(r1, FontCollection.class) == false) goto L8;
        this.fontCollection = (FontCollection) ZeusTransformUtils.preCheckCast(r1, FontCollection.class, "com.obric.memorydata.plugin");
    L10:
        r9 = r9 + 1;
        goto L3
    L8:
        if (ZeusTransformUtils.instanceOf(r1, TxMasterStyleAtom.class) == false) goto L10;
        this.txmaster = (TxMasterStyleAtom) ZeusTransformUtils.preCheckCast(r1, TxMasterStyleAtom.class, "com.obric.memorydata.plugin");
        goto L10
    L12:
        if (this.fontCollection == null) goto L15;
        return;
    L15:
        throw new IllegalStateException("Environment didn't contain a FontCollection record!");
    }

    public FontCollection getFontCollection() {
        return this.fontCollection;
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return _type;
    }

    public TxMasterStyleAtom getTxMasterStyleAtom() {
        return this.txmaster;
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r10) {
        byte[] r0 = this._header;
        writeOut(r0[0], r0[1], _type, this._children, r10);
    }
}
