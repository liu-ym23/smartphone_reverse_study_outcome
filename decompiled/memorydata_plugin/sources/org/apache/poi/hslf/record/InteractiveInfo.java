package org.apache.poi.hslf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.OutputStream;
import java.util.Arrays;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public class InteractiveInfo extends RecordContainer {
    private static final long _type = 0;
    private byte[] _header;
    private InteractiveInfoAtom infoAtom;

    static {
        _type = RecordTypes.InteractiveInfo.typeID;
    }

    public InteractiveInfo() {
        this._header = new byte[8];
        this._children = new Record[1];
        byte[] r0 = this._header;
        r0[0] = 15;
        LittleEndian.putShort(r0, 2, (short) _type);
        this.infoAtom = new InteractiveInfoAtom();
        this._children[0] = this.infoAtom;
    }

    public InteractiveInfo(byte[] r2, int r3, int r4) {
        int r0 = r3 + 8;
        this._header = Arrays.copyOfRange(r2, r3, r0);
        this._children = Record.findChildRecords(r2, r0, r4 - 8);
        findInterestingChildren();
    }

    private void findInterestingChildren() {
        if (this._children != null) goto L5;
    L11:
        LOG.atWarn().a("First child record wasn't a InteractiveInfoAtom - leaving this atom in an invalid state...");
        return;
    L5:
        if (this._children.length == 0) goto L11;
        if (ZeusTransformUtils.instanceOf(this._children[0], InteractiveInfoAtom.class) == false) goto L11;
        this.infoAtom = (InteractiveInfoAtom) ZeusTransformUtils.preCheckCast(this._children[0], InteractiveInfoAtom.class, "com.obric.memorydata.plugin");
    }

    public InteractiveInfoAtom getInteractiveInfoAtom() {
        return this.infoAtom;
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
