package org.apache.commons.compress.archivers.zip;

import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.zip.ZipException;

/* JADX INFO: loaded from: classes6.dex */
public class X5455_ExtendedTimestamp implements Serializable, Cloneable, ZipExtraField {
    public static final byte ACCESS_TIME_BIT = 2;
    public static final byte CREATE_TIME_BIT = 4;
    private static final ZipShort HEADER_ID = null;
    public static final byte MODIFY_TIME_BIT = 1;
    private static final long serialVersionUID = 1;
    private ZipLong accessTime;
    private boolean bit0_modifyTimePresent;
    private boolean bit1_accessTimePresent;
    private boolean bit2_createTimePresent;
    private ZipLong createTime;
    private byte flags;
    private ZipLong modifyTime;

    static {
        HEADER_ID = new ZipShort(21589);
    }

    public X5455_ExtendedTimestamp() {
    }

    private static ZipLong dateToZipLong(Date r4) {
        if (r4 != null) goto L6;
        return null;
    L6:
        return unixTimeToZipLong(r4.getTime() / 1000);
    }

    private void reset() {
        setFlags((byte) 0);
        this.modifyTime = null;
        this.accessTime = null;
        this.createTime = null;
    }

    private static ZipLong unixTimeToZipLong(long r3) {
        if (r3 < (-2147483648L)) goto L9;
        if (r3 > 2147483647L) goto L9;
        return new ZipLong(r3);
    L9:
        throw new IllegalArgumentException("X5455 timestamps must fit in a signed 32 bit integer: " + r3);
    }

    private static Date zipLongToDate(ZipLong r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        return new Date(((long) r5.getIntValue()) * 1000);
    }

    public Object clone() {
        return super.clone();
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, X5455_ExtendedTimestamp.class) == false) goto L23;
        X5455_ExtendedTimestamp r5 = (X5455_ExtendedTimestamp) ZeusTransformUtils.preCheckCast(r4, X5455_ExtendedTimestamp.class, "com.obric.memorydata.plugin");
        if ((this.flags & 7) != (r5.flags & 7)) goto L24;
        ZipLong r0 = this.modifyTime;
        ZipLong r1 = r5.modifyTime;
        if (r0 == r1) goto L11;
        if (r0 != null) goto L10;
        return false;
    L10:
        if (r0.equals(r1) == true) goto L11;
        return false;
    L11:
        ZipLong r2 = this.accessTime;
        ZipLong r3 = r5.accessTime;
        if (r2 == r3) goto L16;
        if (r2 != null) goto L15;
        return false;
    L15:
        if (r2.equals(r3) == true) goto L16;
        return false;
    L16:
        ZipLong r6 = this.createTime;
        ZipLong r7 = r5.createTime;
        if (r6 == r7) goto L21;
        if (r6 != null) goto L20;
        return false;
    L20:
        if (r6.equals(r7) == true) goto L21;
        return false;
    L21:
        return true;
    L24:
        return false;
    L23:
        return false;
    }

    public Date getAccessJavaTime() {
        return zipLongToDate(this.accessTime);
    }

    public ZipLong getAccessTime() {
        return this.accessTime;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public byte[] getCentralDirectoryData() {
        return Arrays.copyOf(getLocalFileDataData(), getCentralDirectoryLength().getValue());
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getCentralDirectoryLength() {
        if (this.bit0_modifyTimePresent == false) goto L5;
        int r1 = 4;
    L7:
        return new ZipShort(r1 + 1);
    L5:
        r1 = 0;
        goto L7
    }

    public Date getCreateJavaTime() {
        return zipLongToDate(this.createTime);
    }

    public ZipLong getCreateTime() {
        return this.createTime;
    }

    public byte getFlags() {
        return this.flags;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getHeaderId() {
        return HEADER_ID;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public byte[] getLocalFileDataData() {
        byte[] r0 = new byte[getLocalFileDataLength().getValue()];
        r0[0] = 0;
        int r3 = 1;
        if (this.bit0_modifyTimePresent == false) goto L6;
        r0[0] = (byte) (r0[0] | 1);
        System.arraycopy(this.modifyTime.getBytes(), 0, r0, 1, 4);
        r3 = 5;
    L6:
        if (this.bit1_accessTimePresent == false) goto L11;
        ZipLong r2 = this.accessTime;
        if (r2 == null) goto L11;
        r0[0] = (byte) (r0[0] | 2);
        System.arraycopy(r2.getBytes(), 0, r0, r3, 4);
        r3 = r3 + 4;
    L11:
        if (this.bit2_createTimePresent == false) goto L15;
        ZipLong r6 = this.createTime;
        if (r6 == null) goto L15;
        r0[0] = (byte) (r0[0] | 4);
        System.arraycopy(r6.getBytes(), 0, r0, r3, 4);
    L15:
        return r0;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getLocalFileDataLength() {
        int r2 = 4;
        if (this.bit0_modifyTimePresent == false) goto L5;
        int r1 = 4;
    L6:
        int r3 = r1 + 1;
        if (this.bit1_accessTimePresent == true) goto L9;
    L11:
        int r4 = 0;
    L12:
        int r5 = r3 + r4;
        if (this.bit2_createTimePresent == true) goto L15;
    L17:
        r2 = 0;
    L19:
        return new ZipShort(r5 + r2);
    L15:
        if (this.createTime == null) goto L17;
    L9:
        if (this.accessTime == null) goto L11;
        r4 = 4;
        goto L12
    L5:
        r1 = 0;
        goto L6
    }

    public Date getModifyJavaTime() {
        return zipLongToDate(this.modifyTime);
    }

    public ZipLong getModifyTime() {
        return this.modifyTime;
    }

    public int hashCode() {
        int r0 = (this.flags & 7) * NetError.ERR_SSL_NO_RENEGOTIATION;
        ZipLong r1 = this.modifyTime;
        if (r1 == null) goto L5;
        r0 = r0 ^ r1.hashCode();
    L5:
        ZipLong r2 = this.accessTime;
        if (r2 == null) goto L8;
        r0 = r0 ^ Integer.rotateLeft(r2.hashCode(), 11);
    L8:
        ZipLong r3 = this.createTime;
        if (r3 != null) goto L11;
        return r0;
    L11:
        return r0 ^ Integer.rotateLeft(r3.hashCode(), 22);
    }

    public boolean isBit0_modifyTimePresent() {
        return this.bit0_modifyTimePresent;
    }

    public boolean isBit1_accessTimePresent() {
        return this.bit1_accessTimePresent;
    }

    public boolean isBit2_createTimePresent() {
        return this.bit2_createTimePresent;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromCentralDirectoryData(byte[] r1, int r2, int r3) {
        reset();
        parseFromLocalFileData(r1, r2, r3);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromLocalFileData(byte[] r4, int r5, int r6) {
        reset();
        if (r6 < 1) goto L24;
        int r7 = r6 + r5;
        int r0 = r5 + 1;
        setFlags(r4[r5]);
        if (this.bit0_modifyTimePresent == false) goto L9;
        int r8 = r0 + 4;
        if (r8 > r7) goto L9;
        this.modifyTime = new ZipLong(r4, r0);
        r0 = r8;
    L11:
        if (this.bit1_accessTimePresent == false) goto L15;
        int r9 = r0 + 4;
        if (r9 > r7) goto L15;
        this.accessTime = new ZipLong(r4, r0);
        r0 = r9;
    L17:
        if (this.bit2_createTimePresent == true) goto L19;
    L21:
        this.bit2_createTimePresent = false;
        return;
    L19:
        if ((r0 + 4) > r7) goto L21;
        this.createTime = new ZipLong(r4, r0);
        return;
    L15:
        this.bit1_accessTimePresent = false;
    L9:
        this.bit0_modifyTimePresent = false;
        goto L11
    L24:
        throw new ZipException("X5455_ExtendedTimestamp too short, only " + r6 + " bytes");
    }

    public void setAccessJavaTime(Date r1) {
        setAccessTime(dateToZipLong(r1));
    }

    public void setAccessTime(ZipLong r2) {
        if (r2 == null) goto L4;
        boolean r0 = true;
    L5:
        this.bit1_accessTimePresent = r0;
        byte r1 = this.flags;
        if (r2 == null) goto L8;
        int r3 = r1 | 2;
    L9:
        this.flags = (byte) r3;
        this.accessTime = r2;
        return;
    L8:
        r3 = r1 & (-3);
        goto L9
    L4:
        r0 = false;
        goto L5
    }

    public void setCreateJavaTime(Date r1) {
        setCreateTime(dateToZipLong(r1));
    }

    public void setCreateTime(ZipLong r2) {
        if (r2 == null) goto L4;
        boolean r0 = true;
    L5:
        this.bit2_createTimePresent = r0;
        byte r1 = this.flags;
        if (r2 == null) goto L8;
        int r3 = r1 | 4;
    L9:
        this.flags = (byte) r3;
        this.createTime = r2;
        return;
    L8:
        r3 = r1 & (-5);
        goto L9
    L4:
        r0 = false;
        goto L5
    }

    public void setFlags(byte r5) {
        this.flags = r5;
        boolean r1 = false;
        if ((r5 & 1) != 1) goto L5;
        boolean r0 = true;
    L6:
        this.bit0_modifyTimePresent = r0;
        if ((r5 & 2) != 2) goto L9;
        boolean r2 = true;
    L10:
        this.bit1_accessTimePresent = r2;
        if ((r5 & 4) != 4) goto L13;
        r1 = true;
    L13:
        this.bit2_createTimePresent = r1;
        return;
    L9:
        r2 = false;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    public void setModifyJavaTime(Date r1) {
        setModifyTime(dateToZipLong(r1));
    }

    public void setModifyTime(ZipLong r3) {
        if (r3 == null) goto L5;
        boolean r1 = true;
    L6:
        this.bit0_modifyTimePresent = r1;
        if (r3 == null) goto L9;
        int r0 = 1 | this.flags;
    L10:
        this.flags = (byte) r0;
        this.modifyTime = r3;
        return;
    L9:
        r0 = this.flags & (-2);
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("0x5455 Zip Extra Field: Flags=");
        r0.append(Integer.toBinaryString(ZipUtil.unsignedIntToSignedByte(this.flags))).append(" ");
        if (this.bit0_modifyTimePresent == false) goto L8;
        if (this.modifyTime == null) goto L8;
        Date r1 = getModifyJavaTime();
        r0.append(" Modify:[").append(r1).append("] ");
    L8:
        if (this.bit1_accessTimePresent == false) goto L13;
        if (this.accessTime == null) goto L13;
        Date r2 = getAccessJavaTime();
        r0.append(" Access:[").append(r2).append("] ");
    L13:
        if (this.bit2_createTimePresent == false) goto L18;
        if (this.createTime == null) goto L18;
        Date r4 = getCreateJavaTime();
        r0.append(" Create:[").append(r4).append("] ");
    L18:
        return r0.toString();
    }
}
