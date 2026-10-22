package org.apache.poi.hslf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.OutputStream;
import java.util.Arrays;
import org.apache.logging.log4j.util.v;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class ExVideoContainer extends RecordContainer {
    private byte[] _header;
    private ExMediaAtom mediaAtom;
    private CString pathAtom;

    public ExVideoContainer() {
        byte[] r0 = new byte[8];
        this._header = r0;
        r0[0] = 15;
        LittleEndian.putShort(r0, 2, (short) getRecordType());
        this._children = new Record[2];
        Record[] r1 = this._children;
        ExMediaAtom r2 = new ExMediaAtom();
        this.mediaAtom = r2;
        r1[0] = r2;
        Record[] r3 = this._children;
        CString r4 = new CString();
        this.pathAtom = r4;
        r3[1] = r4;
    }

    public ExVideoContainer(byte[] r2, int r3, int r4) {
        int r0 = r3 + 8;
        this._header = Arrays.copyOfRange(r2, r3, r0);
        this._children = Record.findChildRecords(r2, r0, r4 - 8);
        findInterestingChildren();
    }

    private void findInterestingChildren() {
        Record r0 = this._children[0];
        if (ZeusTransformUtils.instanceOf(r0, ExMediaAtom.class) == false) goto L5;
        this.mediaAtom = (ExMediaAtom) ZeusTransformUtils.preCheckCast(r0, ExMediaAtom.class, "com.obric.memorydata.plugin");
    L6:
        Record r1 = this._children[1];
        if (ZeusTransformUtils.instanceOf(r1, CString.class) == false) goto L9;
        this.pathAtom = (CString) ZeusTransformUtils.preCheckCast(r1, CString.class, "com.obric.memorydata.plugin");
        return;
    L9:
        LOG.atError().a("Second child record wasn't a CString, was of type {}", v.a(r1.getRecordType()));
        return;
    L5:
        LOG.atError().a("First child record wasn't a ExMediaAtom, was of type {}", v.a(r0.getRecordType()));
        goto L6
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return RecordTypes.ExVideoContainer.typeID;
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r10) {
        byte[] r0 = this._header;
        writeOut(r0[0], r0[1], getRecordType(), this._children, r10);
    }
}
