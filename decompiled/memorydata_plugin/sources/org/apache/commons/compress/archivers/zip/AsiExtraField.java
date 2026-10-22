package org.apache.commons.compress.archivers.zip;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

/* JADX INFO: loaded from: classes6.dex */
public class AsiExtraField implements Cloneable, ZipExtraField {
    private static final ZipShort HEADER_ID = null;
    private CRC32 crc;
    private boolean dirFlag;
    private int gid;
    private String link;
    private int mode;
    private int uid;

    static {
        HEADER_ID = new ZipShort(30062);
    }

    public AsiExtraField() {
        this.link = "";
        this.crc = new CRC32();
    }

    public Object clone() {
        AsiExtraField r2 = (AsiExtraField) ZeusTransformUtils.preCheckCast(super.clone(), AsiExtraField.class, "com.obric.memorydata.plugin");     // Catch: CloneNotSupportedException -> L4
        r2.crc = new CRC32();     // Catch: CloneNotSupportedException -> L4
        return r2;
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public byte[] getCentralDirectoryData() {
        return getLocalFileDataData();
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getCentralDirectoryLength() {
        return getLocalFileDataLength();
    }

    public int getGroupId() {
        return this.gid;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getHeaderId() {
        return HEADER_ID;
    }

    public String getLinkedFile() {
        return this.link;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public byte[] getLocalFileDataData() {
        int r0 = getLocalFileDataLength().getValue() - 4;
        byte[] r2 = new byte[r0];
        System.arraycopy(ZipShort.getBytes(getMode()), 0, r2, 0, 2);
        byte[] r3 = getLinkedFile().getBytes();
        System.arraycopy(ZipLong.getBytes(r3.length), 0, r2, 2, 4);
        System.arraycopy(ZipShort.getBytes(getUserId()), 0, r2, 6, 2);
        System.arraycopy(ZipShort.getBytes(getGroupId()), 0, r2, 8, 2);
        System.arraycopy(r3, 0, r2, 10, r3.length);
        this.crc.reset();
        this.crc.update(r2);
        long r5 = this.crc.getValue();
        byte[] r8 = new byte[r0 + 4];
        System.arraycopy(ZipLong.getBytes(r5), 0, r8, 0, 4);
        System.arraycopy(r2, 0, r8, 4, r0);
        return r8;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getLocalFileDataLength() {
        return new ZipShort(getLinkedFile().getBytes().length + 14);
    }

    public int getMode() {
        return this.mode;
    }

    public int getMode(int r2) {
        if (isLink() == false) goto L6;
        int r1 = 40960;
    L10:
        return r1 | (r2 & 4095);
    L6:
        if (isDirectory() == false) goto L8;
        r1 = 16384;
        goto L10
    L8:
        r1 = 32768;
        goto L10
    }

    public int getUserId() {
        return this.uid;
    }

    public boolean isDirectory() {
        if (this.dirFlag == true) goto L5;
    L7:
        return false;
    L5:
        if (isLink() == true) goto L7;
        return true;
    }

    public boolean isLink() {
        return !getLinkedFile().isEmpty();
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromCentralDirectoryData(byte[] r1, int r2, int r3) {
        parseFromLocalFileData(r1, r2, r3);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromLocalFileData(byte[] r6, int r7, int r8) {
        if (r8 < 14) goto L24;
        long r0 = ZipLong.getValue(r6, r7);
        int r9 = r8 - 4;
        byte[] r2 = new byte[r9];
        boolean r3 = false;
        System.arraycopy(r6, r7 + 4, r2, 0, r9);
        this.crc.reset();
        this.crc.update(r2);
        long r10 = this.crc.getValue();
        if (r0 != r10) goto L22;
        int r11 = ZipShort.getValue(r2, 0);
        int r12 = (int) ZipLong.getValue(r2, 2);
        if (r12 < 0) goto L20;
        if (r12 > (r9 - 10)) goto L20;
        this.uid = ZipShort.getValue(r2, 6);
        this.gid = ZipShort.getValue(r2, 8);
        if (r12 != 0) goto L13;
        String r13 = "";
    L14:
        this.link = r13;
        if ((r11 & 16384) == 0) goto L17;
        r3 = true;
    L17:
        setDirectory(r3);
        setMode(r11);
        return;
    L13:
        byte[] r14 = new byte[r12];
        System.arraycopy(r2, 10, r14, 0, r12);
        r13 = new String(r14);
    L20:
        throw new ZipException("Bad symbolic link name length " + r12 + " in ASI extra field");
    L22:
        throw new ZipException("Bad CRC checksum, expected " + Long.toHexString(r0) + " instead of " + Long.toHexString(r10));
    L24:
        throw new ZipException("The length is too short, only " + r8 + " bytes, expected at least 14");
    }

    public void setDirectory(boolean r1) {
        this.dirFlag = r1;
        this.mode = getMode(this.mode);
    }

    public void setMode(int r1) {
        this.mode = getMode(r1);
    }
}
