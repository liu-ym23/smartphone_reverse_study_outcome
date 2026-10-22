package org.apache.commons.compress.archivers.zip;

import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Date;

/* JADX INFO: loaded from: classes6.dex */
public class X000A_NTFS implements ZipExtraField {
    private static final ZipShort HEADER_ID = null;
    private static final ZipShort TIME_ATTR_SIZE = null;
    private static final ZipShort TIME_ATTR_TAG = null;
    private ZipEightByteInteger accessTime;
    private ZipEightByteInteger createTime;
    private ZipEightByteInteger modifyTime;

    static {
        HEADER_ID = new ZipShort(10);
        TIME_ATTR_TAG = new ZipShort(1);
        TIME_ATTR_SIZE = new ZipShort(24);
    }

    public X000A_NTFS() {
        this.modifyTime = ZipEightByteInteger.ZERO;
        this.accessTime = ZipEightByteInteger.ZERO;
        this.createTime = ZipEightByteInteger.ZERO;
    }

    private void readTimeAttr(byte[] r2, int r3, int r4) {
        if (r4 < 26) goto L8;
        ZipShort r5 = new ZipShort(r2, r3);
        if (TIME_ATTR_SIZE.equals(r5) == false) goto L9;
        int r6 = r3 + 2;
        this.modifyTime = new ZipEightByteInteger(r2, r6);
        int r7 = r6 + 8;
        this.accessTime = new ZipEightByteInteger(r2, r7);
        this.createTime = new ZipEightByteInteger(r2, r7 + 8);
        return;
    L9:
        return;
    }

    private void reset() {
        this.modifyTime = ZipEightByteInteger.ZERO;
        this.accessTime = ZipEightByteInteger.ZERO;
        this.createTime = ZipEightByteInteger.ZERO;
    }

    private static Date zipToDate(ZipEightByteInteger r4) {
        if (r4 != null) goto L4;
        return null;
    L4:
        if (ZipEightByteInteger.ZERO.equals(r4) == false) goto L7;
        return null;
    L7:
        return new Date((r4.getLongValue() - 116444736000000000L) / 10000);
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, X000A_NTFS.class) == false) goto L21;
        X000A_NTFS r5 = (X000A_NTFS) ZeusTransformUtils.preCheckCast(r4, X000A_NTFS.class, "com.obric.memorydata.plugin");
        ZipEightByteInteger r0 = this.modifyTime;
        ZipEightByteInteger r1 = r5.modifyTime;
        if (r0 == r1) goto L9;
        if (r0 != null) goto L8;
        return false;
    L8:
        if (r0.equals(r1) == true) goto L9;
        return false;
    L9:
        ZipEightByteInteger r2 = this.accessTime;
        ZipEightByteInteger r3 = r5.accessTime;
        if (r2 == r3) goto L14;
        if (r2 != null) goto L13;
        return false;
    L13:
        if (r2.equals(r3) == true) goto L14;
        return false;
    L14:
        ZipEightByteInteger r6 = this.createTime;
        ZipEightByteInteger r7 = r5.createTime;
        if (r6 == r7) goto L19;
        if (r6 != null) goto L18;
        return false;
    L18:
        if (r6.equals(r7) == true) goto L19;
        return false;
    L19:
        return true;
    L21:
        return false;
    }

    public Date getAccessJavaTime() {
        return zipToDate(this.accessTime);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public byte[] getCentralDirectoryData() {
        return getLocalFileDataData();
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getCentralDirectoryLength() {
        return getLocalFileDataLength();
    }

    public Date getCreateJavaTime() {
        return zipToDate(this.createTime);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getHeaderId() {
        return HEADER_ID;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public byte[] getLocalFileDataData() {
        byte[] r0 = new byte[getLocalFileDataLength().getValue()];
        System.arraycopy(TIME_ATTR_TAG.getBytes(), 0, r0, 4, 2);
        System.arraycopy(TIME_ATTR_SIZE.getBytes(), 0, r0, 6, 2);
        System.arraycopy(this.modifyTime.getBytes(), 0, r0, 8, 8);
        System.arraycopy(this.accessTime.getBytes(), 0, r0, 16, 8);
        System.arraycopy(this.createTime.getBytes(), 0, r0, 24, 8);
        return r0;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getLocalFileDataLength() {
        return new ZipShort(32);
    }

    public Date getModifyJavaTime() {
        return zipToDate(this.modifyTime);
    }

    public int hashCode() {
        ZipEightByteInteger r0 = this.modifyTime;
        int r1 = NetError.ERR_SSL_NO_RENEGOTIATION;
        if (r0 == null) goto L5;
        r1 = (-123) ^ r0.hashCode();
    L5:
        ZipEightByteInteger r2 = this.accessTime;
        if (r2 == null) goto L8;
        r1 = r1 ^ Integer.rotateLeft(r2.hashCode(), 11);
    L8:
        ZipEightByteInteger r3 = this.createTime;
        if (r3 != null) goto L11;
        return r1;
    L11:
        return r1 ^ Integer.rotateLeft(r3.hashCode(), 22);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromCentralDirectoryData(byte[] r1, int r2, int r3) {
        reset();
        parseFromLocalFileData(r1, r2, r3);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromLocalFileData(byte[] r3, int r4, int r5) {
        int r6 = r5 + r4;
        int r7 = r4 + 4;
    L4:
        if ((r7 + 4) > r6) goto L12;
        ZipShort r0 = new ZipShort(r3, r7);
        int r8 = r7 + 2;
        if (r0.equals(TIME_ATTR_TAG) == true) goto L7;
        r7 = r8 + (new ZipShort(r3, r8).getValue() + 2);
        goto L4
    L7:
        readTimeAttr(r3, r8, r6 - r8);
        return;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("0x000A Zip Extra Field:").append(" Modify:[").append(getModifyJavaTime()).append("] ").append(" Access:[").append(getAccessJavaTime()).append("] ").append(" Create:[").append(getCreateJavaTime()).append("] ");
        return r0.toString();
    }
}
