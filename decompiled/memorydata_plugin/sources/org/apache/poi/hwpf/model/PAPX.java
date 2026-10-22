package org.apache.poi.hwpf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.hwpf.sprm.SprmBuffer;
import org.apache.poi.hwpf.sprm.SprmOperation;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class PAPX extends BytePropertyNode<PAPX> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private ParagraphHeight _phe;

    static {
    }

    public PAPX(int r1, int r2, SprmBuffer r3) {
        super(r1, r2, r3);
        this._phe = new ParagraphHeight();
    }

    public PAPX(int r3, int r4, byte[] r5, ParagraphHeight r6, byte[] r7) {
        super(r3, r4, new SprmBuffer(r5, 2));
        this._phe = r6;
        SprmBuffer r8 = findHuge(new SprmBuffer(r5, 2), r7);
        if (r8 == null) goto L6;
        this._buf = r8;
        return;
    }

    private SprmBuffer findHuge(SprmBuffer r6, byte[] r7) {
        byte[] r5 = r6.toByteArray();
        if (r5.length != 8) goto L17;
        if (r7 == null) goto L19;
        SprmOperation r8 = new SprmOperation(r5, 2);
        if (r8.getOperation() == 69) goto L10;
        if (r8.getOperation() == 70) goto L10;
        return null;
    L10:
        if (r8.getSizeCode() != 3) goto L21;
        int r9 = r8.getOperand();
        if ((r9 + 1) >= r7.length) goto L22;
        short r1 = LittleEndian.getShort(r7, r9);
        if ((r9 + r1) >= r7.length) goto L23;
        byte[] r2 = new byte[r1 + 2];
        r2[0] = r5[0];
        r2[1] = r5[1];
        System.arraycopy(r7, r9 + 2, r2, 2, r1);
        return new SprmBuffer(r2, 2);
    L23:
        return null;
    L22:
        return null;
    L21:
        return null;
    L19:
        return null;
    L17:
        return null;
    }

    @Override // org.apache.poi.hwpf.model.PropertyNode
    public boolean equals(Object r3) {
        if (super.equals(r3) == true) goto L5;
        return false;
    L5:
        return this._phe.equals(((PAPX) ZeusTransformUtils.preCheckCast(r3, PAPX.class, "com.obric.memorydata.plugin"))._phe);
    }

    public byte[] getGrpprl() {
        if (this._buf != null) goto L7;
        return new byte[0];
    L7:
        return ((SprmBuffer) ZeusTransformUtils.preCheckCast(this._buf, SprmBuffer.class, "com.obric.memorydata.plugin")).toByteArray();
    }

    public short getIstd() {
        if (this._buf != null) goto L5;
        return 0;
    L5:
        byte[] r3 = getGrpprl();
        if (r3.length != 0) goto L9;
        return 0;
    L9:
        if (r3.length != 1) goto L13;
        return LittleEndian.getUByte(r3, 0);
    L13:
        return LittleEndian.getShort(r3);
    }

    public SprmBuffer getSprmBuf() {
        return (SprmBuffer) ZeusTransformUtils.preCheckCast(this._buf, SprmBuffer.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.poi.hwpf.model.PropertyNode
    public int hashCode() {
        return 42;
    }

    public String toString() {
        return "PAPX from " + getStart() + " to " + getEnd() + " (in bytes " + getStartBytes() + " to " + getEndBytes() + ")";
    }
}
