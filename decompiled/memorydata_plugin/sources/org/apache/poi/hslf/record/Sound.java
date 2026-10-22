package org.apache.poi.hslf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.OutputStream;
import java.util.Arrays;
import org.apache.logging.log4j.util.v;

/* JADX INFO: loaded from: classes7.dex */
public final class Sound extends RecordContainer {
    private SoundData _data;
    private byte[] _header;
    private CString _name;
    private CString _type;

    public Sound(byte[] r2, int r3, int r4) {
        int r0 = r3 + 8;
        this._header = Arrays.copyOfRange(r2, r3, r0);
        this._children = Record.findChildRecords(r2, r0, r4 - 8);
        findInterestingChildren();
    }

    private void findInterestingChildren() {
        Record r0 = this._children[0];
        if (ZeusTransformUtils.instanceOf(r0, CString.class) == false) goto L5;
        this._name = (CString) ZeusTransformUtils.preCheckCast(r0, CString.class, "com.obric.memorydata.plugin");
    L6:
        Record r1 = this._children[1];
        if (ZeusTransformUtils.instanceOf(r1, CString.class) == false) goto L9;
        this._type = (CString) ZeusTransformUtils.preCheckCast(r1, CString.class, "com.obric.memorydata.plugin");
    L10:
        int r2 = 2;
    L12:
        if (r2 >= this._children.length) goto L20;
        if (ZeusTransformUtils.instanceOf(this._children[r2], SoundData.class) == true) goto L15;
        r2 = r2 + 1;
        goto L12
    L15:
        this._data = (SoundData) ZeusTransformUtils.preCheckCast(this._children[r2], SoundData.class, "com.obric.memorydata.plugin");
        return;
    L20:
        return;
    L9:
        LOG.atError().a("Second child record wasn't a CString, was of type {}", v.a(r1.getRecordType()));
        goto L10
    L5:
        LOG.atError().a("First child record wasn't a CString, was of type {}", v.a(r0.getRecordType()));
        goto L6
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return RecordTypes.Sound.typeID;
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r10) {
        byte[] r0 = this._header;
        writeOut(r0[0], r0[1], getRecordType(), this._children, r10);
    }
}
