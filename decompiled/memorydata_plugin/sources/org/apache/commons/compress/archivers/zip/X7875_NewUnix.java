package org.apache.commons.compress.archivers.zip;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.zip.ZipException;
import org.apache.commons.compress.utils.ByteUtils;

/* JADX INFO: loaded from: classes6.dex */
public class X7875_NewUnix implements Serializable, Cloneable, ZipExtraField {
    private static final ZipShort HEADER_ID = null;
    private static final BigInteger ONE_THOUSAND = null;
    private static final ZipShort ZERO = null;
    private static final long serialVersionUID = 1;
    private BigInteger gid;
    private BigInteger uid;
    private int version;

    static {
        HEADER_ID = new ZipShort(30837);
        ZERO = new ZipShort(0);
        ONE_THOUSAND = BigInteger.valueOf(1000);
    }

    public X7875_NewUnix() {
        this.version = 1;
        reset();
    }

    private void reset() {
        BigInteger r0 = ONE_THOUSAND;
        this.uid = r0;
        this.gid = r0;
    }

    static byte[] trimLeadingZeroesForceMinLength(byte[] r4) {
        if (r4 != null) goto L4;
        return r4;
    L4:
        int r0 = r4.length;
        int r1 = 0;
        int r2 = 0;
    L5:
        if (r1 >= r0) goto L10;
        if (r4[r1] != 0) goto L10;
        r2 = r2 + 1;
        r1 = r1 + 1;
    L10:
        int r3 = Math.max(1, r4.length - r2);
        byte[] r5 = new byte[r3];
        int r6 = r3 - (r4.length - r2);
        System.arraycopy(r4, r2, r5, r6, r3 - r6);
        return r5;
    }

    public Object clone() {
        return super.clone();
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, X7875_NewUnix.class) == false) goto L12;
        X7875_NewUnix r5 = (X7875_NewUnix) ZeusTransformUtils.preCheckCast(r4, X7875_NewUnix.class, "com.obric.memorydata.plugin");
        if (this.version == r5.version) goto L7;
        return false;
    L7:
        if (this.uid.equals(r5.uid) == true) goto L9;
        return false;
    L9:
        if (this.gid.equals(r5.gid) == false) goto L15;
        return true;
    L15:
        return false;
    L12:
        return false;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public byte[] getCentralDirectoryData() {
        return ByteUtils.EMPTY_BYTE_ARRAY;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getCentralDirectoryLength() {
        return ZERO;
    }

    public long getGID() {
        return ZipUtil.bigToLong(this.gid);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getHeaderId() {
        return HEADER_ID;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public byte[] getLocalFileDataData() {
        byte[] r0 = this.uid.toByteArray();
        byte[] r1 = this.gid.toByteArray();
        byte[] r2 = trimLeadingZeroesForceMinLength(r0);
        if (r2 == null) goto L5;
        int r3 = r2.length;
    L6:
        byte[] r4 = trimLeadingZeroesForceMinLength(r1);
        if (r4 == null) goto L9;
        int r5 = r4.length;
    L10:
        byte[] r6 = new byte[(r3 + 3) + r5];
        if (r2 == null) goto L13;
        ZipUtil.reverse(r2);
    L13:
        if (r4 == null) goto L15;
        ZipUtil.reverse(r4);
    L15:
        r6[0] = ZipUtil.unsignedIntToSignedByte(this.version);
        r6[1] = ZipUtil.unsignedIntToSignedByte(r3);
        if (r2 == null) goto L18;
        System.arraycopy(r2, 0, r6, 2, r3);
    L18:
        int r8 = 2 + r3;
        int r7 = r8 + 1;
        r6[r8] = ZipUtil.unsignedIntToSignedByte(r5);
        if (r4 == null) goto L21;
        System.arraycopy(r4, 0, r6, r7, r5);
    L21:
        return r6;
    L9:
        r5 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getLocalFileDataLength() {
        byte[] r0 = trimLeadingZeroesForceMinLength(this.uid.toByteArray());
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        byte[] r3 = trimLeadingZeroesForceMinLength(this.gid.toByteArray());
        if (r3 == null) goto L11;
        r1 = r3.length;
    L11:
        return new ZipShort((r2 + 3) + r1);
    L5:
        r2 = r0.length;
        goto L6
    }

    public long getUID() {
        return ZipUtil.bigToLong(this.uid);
    }

    public int hashCode() {
        int r0 = (this.version * (-1234567)) ^ Integer.rotateLeft(this.uid.hashCode(), 16);
        return this.gid.hashCode() ^ r0;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromCentralDirectoryData(byte[] r1, int r2, int r3) {
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromLocalFileData(byte[] r7, int r8, int r9) {
        reset();
        if (r9 < 3) goto L15;
        int r0 = r8 + 1;
        this.version = ZipUtil.signedByteToUnsignedInt(r7[r8]);
        int r10 = r0 + 1;
        int r1 = ZipUtil.signedByteToUnsignedInt(r7[r0]);
        int r2 = r1 + 3;
        if (r2 > r9) goto L13;
        int r3 = r1 + r10;
        this.uid = new BigInteger(1, ZipUtil.reverse(Arrays.copyOfRange(r7, r10, r3)));
        int r11 = r3 + 1;
        int r4 = ZipUtil.signedByteToUnsignedInt(r7[r3]);
        if ((r2 + r4) > r9) goto L11;
        this.gid = new BigInteger(1, ZipUtil.reverse(Arrays.copyOfRange(r7, r11, r4 + r11)));
        return;
    L11:
        throw new ZipException("X7875_NewUnix invalid: gidSize " + r4 + " doesn't fit into " + r9 + " bytes");
    L13:
        throw new ZipException("X7875_NewUnix invalid: uidSize " + r1 + " doesn't fit into " + r9 + " bytes");
    L15:
        throw new ZipException("X7875_NewUnix length is too short, only " + r9 + " bytes");
    }

    public void setGID(long r1) {
        this.gid = ZipUtil.longToBig(r1);
    }

    public void setUID(long r1) {
        this.uid = ZipUtil.longToBig(r1);
    }

    public String toString() {
        return "0x7875 Zip Extra Field: UID=" + this.uid + " GID=" + this.gid;
    }
}
