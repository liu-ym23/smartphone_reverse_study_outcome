package org.apache.poi.hslf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.OutputStream;
import java.util.Arrays;
import org.apache.logging.log4j.util.v;

/* JADX INFO: loaded from: classes7.dex */
public final class AnimationInfo extends RecordContainer {
    private byte[] _header;
    private AnimationInfoAtom animationAtom;

    public AnimationInfo(byte[] r2, int r3, int r4) {
        int r0 = r3 + 8;
        this._header = Arrays.copyOfRange(r2, r3, r0);
        this._children = Record.findChildRecords(r2, r0, r4 - 8);
        findInterestingChildren();
    }

    private void findInterestingChildren() {
        Record r0 = this._children[0];
        if (ZeusTransformUtils.instanceOf(r0, AnimationInfoAtom.class) == false) goto L5;
        this.animationAtom = (AnimationInfoAtom) ZeusTransformUtils.preCheckCast(r0, AnimationInfoAtom.class, "com.obric.memorydata.plugin");
        return;
    L5:
        LOG.atError().a("First child record wasn't a AnimationInfoAtom, was of type {}", v.a(r0.getRecordType()));
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return RecordTypes.AnimationInfo.typeID;
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r10) {
        byte[] r0 = this._header;
        writeOut(r0[0], r0[1], getRecordType(), this._children, r10);
    }
}
