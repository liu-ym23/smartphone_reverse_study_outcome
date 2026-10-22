package org.apache.poi.hslf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.OutputStream;
import java.util.Arrays;
import org.apache.logging.log4j.util.v;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public class ExHyperlink extends RecordContainer {
    private static final long _type = 0;
    private byte[] _header;
    private ExHyperlinkAtom linkAtom;
    private CString linkDetailsA;
    private CString linkDetailsB;

    static {
        _type = RecordTypes.ExHyperlink.typeID;
    }

    public ExHyperlink() {
        this._header = new byte[8];
        this._children = new Record[3];
        byte[] r0 = this._header;
        r0[0] = 15;
        LittleEndian.putShort(r0, 2, (short) _type);
        CString r1 = new CString();
        CString r2 = new CString();
        r1.setOptions(0);
        r2.setOptions(16);
        this._children[0] = new ExHyperlinkAtom();
        this._children[1] = r1;
        this._children[2] = r2;
        findInterestingChildren();
    }

    public ExHyperlink(byte[] r2, int r3, int r4) {
        int r0 = r3 + 8;
        this._header = Arrays.copyOfRange(r2, r3, r0);
        this._children = Record.findChildRecords(r2, r0, r4 - 8);
        findInterestingChildren();
    }

    private void findInterestingChildren() {
        Record r0 = this._children[0];
        if (ZeusTransformUtils.instanceOf(r0, ExHyperlinkAtom.class) == false) goto L5;
        this.linkAtom = (ExHyperlinkAtom) ZeusTransformUtils.preCheckCast(r0, ExHyperlinkAtom.class, "com.obric.memorydata.plugin");
    L6:
        int r1 = 1;
    L8:
        if (r1 >= this._children.length) goto L17;
        Record r2 = this._children[r1];
        if (ZeusTransformUtils.instanceOf(r2, CString.class) == true) goto L12;
        LOG.atError().a("Record after ExHyperlinkAtom wasn't a CString, was of type {}", v.a(r2.getRecordType()));
    L16:
        r1 = r1 + 1;
        goto L8
    L12:
        if (this.linkDetailsA != null) goto L14;
        this.linkDetailsA = (CString) ZeusTransformUtils.preCheckCast(r2, CString.class, "com.obric.memorydata.plugin");
        goto L16
    L14:
        this.linkDetailsB = (CString) ZeusTransformUtils.preCheckCast(r2, CString.class, "com.obric.memorydata.plugin");
        goto L16
    L17:
        return;
    L5:
        LOG.atError().a("First child record wasn't a ExHyperlinkAtom, was of type {}", v.a(r0.getRecordType()));
        goto L6
    }

    public ExHyperlinkAtom getExHyperlinkAtom() {
        return this.linkAtom;
    }

    public String getLinkURL() {
        CString r0 = this.linkDetailsB;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getText();
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
