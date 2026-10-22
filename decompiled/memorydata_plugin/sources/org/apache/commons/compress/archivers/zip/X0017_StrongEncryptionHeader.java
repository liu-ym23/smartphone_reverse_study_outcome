package org.apache.commons.compress.archivers.zip;

import java.util.Arrays;
import java.util.zip.ZipException;

/* JADX INFO: loaded from: classes6.dex */
public class X0017_StrongEncryptionHeader extends PKWareExtraHeader {
    private PKWareExtraHeader.EncryptionAlgorithm algId;
    private int bitlen;
    private byte[] erdData;
    private int flags;
    private int format;
    private PKWareExtraHeader.HashAlgorithm hashAlg;
    private int hashSize;
    private byte[] ivData;
    private byte[] keyBlob;
    private long rcount;
    private byte[] recipientKeyHash;
    private byte[] vCRC32;
    private byte[] vData;

    public X0017_StrongEncryptionHeader() {
        super(new ZipShort(23));
    }

    private void assertDynamicLengthFits(String r3, int r4, int r5, int r6) {
        if ((r5 + r4) > r6) goto L6;
        return;
    L6:
        throw new ZipException("Invalid X0017_StrongEncryptionHeader: " + r3 + " " + r4 + " doesn't fit into " + r6 + " bytes of data at position " + r5);
    }

    public void parseCentralDirectoryFormat(byte[] r5, int r6, int r7) {
        assertMinimalLength(12, r7);
        this.format = ZipShort.getValue(r5, r6);
        this.algId = PKWareExtraHeader.EncryptionAlgorithm.getAlgorithmByCode(ZipShort.getValue(r5, r6 + 2));
        this.bitlen = ZipShort.getValue(r5, r6 + 4);
        this.flags = ZipShort.getValue(r5, r6 + 6);
        long r0 = ZipLong.getValue(r5, r6 + 8);
        this.rcount = r0;
        if (r0 <= 0) goto L6;
        assertMinimalLength(16, r7);
        this.hashAlg = PKWareExtraHeader.HashAlgorithm.getAlgorithmByCode(ZipShort.getValue(r5, r6 + 12));
        this.hashSize = ZipShort.getValue(r5, r6 + 14);
        return;
    }

    public void parseFileFormat(byte[] r13, int r14, int r15) {
        assertMinimalLength(4, r15);
        int r1 = ZipShort.getValue(r13, r14);
        assertDynamicLengthFits("ivSize", r1, 4, r15);
        int r2 = r14 + 4;
        assertMinimalLength(r2, r1);
        this.ivData = Arrays.copyOfRange(r13, r2, r1);
        int r3 = r1 + 16;
        assertMinimalLength(r3, r15);
        int r16 = r14 + r1;
        this.format = ZipShort.getValue(r13, r16 + 6);
        this.algId = PKWareExtraHeader.EncryptionAlgorithm.getAlgorithmByCode(ZipShort.getValue(r13, r16 + 8));
        this.bitlen = ZipShort.getValue(r13, r16 + 10);
        this.flags = ZipShort.getValue(r13, r16 + 12);
        int r4 = ZipShort.getValue(r13, r16 + 14);
        assertDynamicLengthFits("erdSize", r4, r3, r15);
        int r5 = r16 + 16;
        assertMinimalLength(r5, r4);
        this.erdData = Arrays.copyOfRange(r13, r5, r4);
        int r6 = (r1 + 20) + r4;
        assertMinimalLength(r6, r15);
        long r7 = ZipLong.getValue(r13, r5 + r4);
        this.rcount = r7;
        if (r7 != 0) goto L9;
        assertMinimalLength(r6 + 2, r15);
        int r8 = ZipShort.getValue(r13, (r16 + 20) + r4);
        assertDynamicLengthFits("vSize", r8, (r1 + 22) + r4, r15);
        if (r8 < 4) goto L8;
        int r17 = (r16 + 22) + r4;
        int r18 = r8 - 4;
        assertMinimalLength(r17, r18);
        this.vData = Arrays.copyOfRange(r13, r17, r18);
        int r19 = (r17 + r8) - 4;
        assertMinimalLength(r19, 4);
        this.vCRC32 = Arrays.copyOfRange(r13, r19, 4);
        return;
    L8:
        throw new ZipException("Invalid X0017_StrongEncryptionHeader: vSize " + r8 + " is too small to hold CRC");
    L9:
        assertMinimalLength(r6 + 6, r15);
        this.hashAlg = PKWareExtraHeader.HashAlgorithm.getAlgorithmByCode(ZipShort.getValue(r13, (r16 + 20) + r4));
        int r9 = (r16 + 22) + r4;
        this.hashSize = ZipShort.getValue(r13, r9);
        int r10 = (r16 + 24) + r4;
        int r11 = ZipShort.getValue(r13, r10);
        int r12 = this.hashSize;
        if (r11 < r12) goto L18;
        this.recipientKeyHash = new byte[r12];
        this.keyBlob = new byte[r11 - r12];
        assertDynamicLengthFits("resize", r11, (r1 + 24) + r4, r15);
        System.arraycopy(r13, r10, this.recipientKeyHash, 0, this.hashSize);
        int r20 = this.hashSize;
        System.arraycopy(r13, r10 + r20, this.keyBlob, 0, r11 - r20);
        assertMinimalLength((((r1 + 26) + r4) + r11) + 2, r15);
        int r110 = ZipShort.getValue(r13, ((r16 + 26) + r4) + r11);
        if (r110 < 4) goto L16;
        assertDynamicLengthFits("vSize", r110, ((r1 + 22) + r4) + r11, r15);
        int r111 = r110 - 4;
        byte[] r21 = new byte[r111];
        this.vData = r21;
        this.vCRC32 = new byte[4];
        int r22 = r9 + r11;
        System.arraycopy(r13, r22, r21, 0, r111);
        System.arraycopy(r13, (r22 + r110) - 4, this.vCRC32, 0, 4);
        return;
    L16:
        throw new ZipException("Invalid X0017_StrongEncryptionHeader: vSize " + r110 + " is too small to hold CRC");
    L18:
        throw new ZipException("Invalid X0017_StrongEncryptionHeader: resize " + r11 + " is too small to hold hashSize" + this.hashSize);
    }

    @Override // org.apache.commons.compress.archivers.zip.PKWareExtraHeader, org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromCentralDirectoryData(byte[] r1, int r2, int r3) {
        super.parseFromCentralDirectoryData(r1, r2, r3);
        parseCentralDirectoryFormat(r1, r2, r3);
    }

    @Override // org.apache.commons.compress.archivers.zip.PKWareExtraHeader, org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromLocalFileData(byte[] r1, int r2, int r3) {
        super.parseFromLocalFileData(r1, r2, r3);
        parseFileFormat(r1, r2, r3);
    }
}
