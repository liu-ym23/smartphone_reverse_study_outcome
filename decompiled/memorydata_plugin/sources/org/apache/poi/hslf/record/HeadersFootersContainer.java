package org.apache.poi.hslf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.OutputStream;
import java.util.Arrays;
import org.apache.logging.log4j.util.v;

/* JADX INFO: loaded from: classes7.dex */
public final class HeadersFootersContainer extends RecordContainer {
    private byte[] _header;
    private CString csDate;
    private CString csFooter;
    private CString csHeader;
    private HeadersFootersAtom hdAtom;

    public HeadersFootersContainer(byte[] r2, int r3, int r4) {
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
        if (ZeusTransformUtils.instanceOf(r3, HeadersFootersAtom.class) == false) goto L8;
        this.hdAtom = (HeadersFootersAtom) ZeusTransformUtils.preCheckCast(r3, HeadersFootersAtom.class, "com.obric.memorydata.plugin");
    L20:
        r2 = r2 + 1;
        goto L3
    L8:
        if (ZeusTransformUtils.instanceOf(r3, CString.class) == false) goto L19;
        CString r4 = (CString) ZeusTransformUtils.preCheckCast(r3, CString.class, "com.obric.memorydata.plugin");
        int r5 = r4.getOptions() >> 4;
        if (r5 != 0) goto L12;
        this.csDate = r4;
        goto L20
    L12:
        if (r5 != 1) goto L14;
        this.csHeader = r4;
        goto L20
    L14:
        if (r5 == 2) goto L16;
        LOG.atWarn().a("Unexpected CString.Options in HeadersFootersContainer: {}", v.a(r5));
        goto L20
    L16:
        this.csFooter = r4;
        goto L20
    L19:
        LOG.atWarn().a("Unexpected record in HeadersFootersContainer: {}", r3);
        goto L20
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return RecordTypes.HeadersFooters.typeID;
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r10) {
        byte[] r0 = this._header;
        writeOut(r0[0], r0[1], getRecordType(), this._children, r10);
    }
}
