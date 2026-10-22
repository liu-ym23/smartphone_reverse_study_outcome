package org.apache.poi.hslf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.OutputStream;
import java.util.Arrays;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public class ExObjList extends RecordContainer {
    private static final long _type = 0;
    private byte[] _header;
    private ExObjListAtom exObjListAtom;

    static {
        _type = RecordTypes.ExObjList.typeID;
    }

    public ExObjList() {
        this._header = new byte[8];
        this._children = new Record[1];
        byte[] r0 = this._header;
        r0[0] = 15;
        LittleEndian.putShort(r0, 2, (short) _type);
        this._children[0] = new ExObjListAtom();
        findInterestingChildren();
    }

    public ExObjList(byte[] r2, int r3, int r4) {
        int r0 = r3 + 8;
        this._header = Arrays.copyOfRange(r2, r3, r0);
        this._children = Record.findChildRecords(r2, r0, r4 - 8);
        findInterestingChildren();
    }

    private void findInterestingChildren() {
        if (ZeusTransformUtils.instanceOf(this._children[0], ExObjListAtom.class) == false) goto L7;
        this.exObjListAtom = (ExObjListAtom) ZeusTransformUtils.preCheckCast(this._children[0], ExObjListAtom.class, "com.obric.memorydata.plugin");
        return;
    L7:
        throw new IllegalStateException("First child record wasn't a ExObjListAtom, was of type " + this._children[0].getRecordType());
    }

    public ExHyperlink get(int r6) {
        Record[] r5 = this._children;
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        Record r2 = r5[r1];
        if (ZeusTransformUtils.instanceOf(r2, ExHyperlink.class) == false) goto L9;
        ExHyperlink r3 = (ExHyperlink) ZeusTransformUtils.preCheckCast(r2, ExHyperlink.class, "com.obric.memorydata.plugin");
        if (r3.getExHyperlinkAtom().getNumber() != r6) goto L9;
        return r3;
    L9:
        r1 = r1 + 1;
        goto L3
    L10:
        return null;
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return _type;
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r10) {
        byte[] r0 = this._header;
        writeOut(r0[0], r0[1], _type, this._children, r10);
    }
}
