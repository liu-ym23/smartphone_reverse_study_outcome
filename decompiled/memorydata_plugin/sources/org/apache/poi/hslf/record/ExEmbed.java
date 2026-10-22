package org.apache.poi.hslf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.OutputStream;
import java.util.Arrays;
import org.apache.logging.log4j.util.v;

/* JADX INFO: loaded from: classes7.dex */
public class ExEmbed extends RecordContainer {
    private final byte[] _header;
    private CString clipboardName;
    private RecordAtom embedAtom;
    private CString menuName;
    private ExOleObjAtom oleObjAtom;
    private CString progId;

    public ExEmbed(byte[] r2, int r3, int r4) {
        int r0 = r3 + 8;
        this._header = Arrays.copyOfRange(r2, r3, r0);
        this._children = Record.findChildRecords(r2, r0, r4 - 8);
        findInterestingChildren();
    }

    private void findInterestingChildren() {
        Record r0 = this._children[0];
        if (ZeusTransformUtils.instanceOf(r0, ExEmbedAtom.class) == false) goto L5;
        this.embedAtom = (ExEmbedAtom) ZeusTransformUtils.preCheckCast(r0, ExEmbedAtom.class, "com.obric.memorydata.plugin");
    L6:
        Record r1 = this._children[1];
        if (ZeusTransformUtils.instanceOf(r1, ExOleObjAtom.class) == false) goto L9;
        this.oleObjAtom = (ExOleObjAtom) ZeusTransformUtils.preCheckCast(r1, ExOleObjAtom.class, "com.obric.memorydata.plugin");
    L10:
        int r3 = 2;
    L12:
        if (r3 >= this._children.length) goto L25;
        if (ZeusTransformUtils.instanceOf(this._children[r3], CString.class) == false) goto L24;
        CString r4 = (CString) ZeusTransformUtils.preCheckCast(this._children[r3], CString.class, "com.obric.memorydata.plugin");
        int r5 = r4.getOptions() >> 4;
        if (r5 == 1) goto L23;
        if (r5 != 2) goto L19;
        this.progId = r4;
        goto L24
    L19:
        if (r5 != 3) goto L24;
        this.clipboardName = r4;
        goto L24
    L23:
        this.menuName = r4;
    L24:
        r3 = r3 + 1;
        goto L12
    L25:
        return;
    L9:
        LOG.atError().a("Second child record wasn't a ExOleObjAtom, was of type {}", v.a(r1.getRecordType()));
        goto L10
    L5:
        LOG.atError().a("First child record wasn't a ExEmbedAtom, was of type {}", v.a(r0.getRecordType()));
        goto L6
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return RecordTypes.ExEmbed.typeID;
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r10) {
        byte[] r0 = this._header;
        writeOut(r0[0], r0[1], getRecordType(), this._children, r10);
    }
}
