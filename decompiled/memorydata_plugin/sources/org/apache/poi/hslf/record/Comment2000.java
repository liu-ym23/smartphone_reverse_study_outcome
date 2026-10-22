package org.apache.poi.hslf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.OutputStream;
import java.util.Arrays;
import org.apache.logging.log4j.util.v;

/* JADX INFO: loaded from: classes7.dex */
public final class Comment2000 extends RecordContainer {
    private static final long _type = 0;
    private byte[] _header;
    private CString authorInitialsRecord;
    private CString authorRecord;
    private Comment2000Atom commentAtom;
    private CString commentRecord;

    static {
        _type = RecordTypes.Comment2000.typeID;
    }

    public Comment2000(byte[] r2, int r3, int r4) {
        int r0 = r3 + 8;
        this._header = Arrays.copyOfRange(r2, r3, r0);
        this._children = Record.findChildRecords(r2, r0, r4 - 8);
        findInterestingChildren();
    }

    private void findInterestingChildren() {
        Record[] r0 = this._children;
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L21;
        Record r3 = r0[r2];
        if (ZeusTransformUtils.instanceOf(r3, CString.class) == false) goto L17;
        CString r4 = (CString) ZeusTransformUtils.preCheckCast(r3, CString.class, "com.obric.memorydata.plugin");
        int r5 = r4.getOptions() >> 4;
        if (r5 != 0) goto L9;
        this.authorRecord = r4;
    L20:
        r2 = r2 + 1;
        goto L3
    L9:
        if (r5 != 1) goto L11;
        this.commentRecord = r4;
        goto L20
    L11:
        if (r5 != 2) goto L20;
        this.authorInitialsRecord = r4;
        goto L20
    L17:
        if (ZeusTransformUtils.instanceOf(r3, Comment2000Atom.class) == false) goto L19;
        this.commentAtom = (Comment2000Atom) ZeusTransformUtils.preCheckCast(r3, Comment2000Atom.class, "com.obric.memorydata.plugin");
        goto L20
    L19:
        LOG.atWarn().a("Unexpected record with type={} in Comment2000: {}", v.a(r3.getRecordType()), r3.getClass().getName());
        goto L20
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
