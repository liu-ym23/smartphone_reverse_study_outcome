package org.apache.commons.compress.archivers.zip;

/* JADX INFO: loaded from: classes6.dex */
public class X0015_CertificateIdForFile extends PKWareExtraHeader {
    private PKWareExtraHeader.HashAlgorithm hashAlg;
    private int rcount;

    public X0015_CertificateIdForFile() {
        super(new ZipShort(21));
    }

    @Override // org.apache.commons.compress.archivers.zip.PKWareExtraHeader, org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromCentralDirectoryData(byte[] r2, int r3, int r4) {
        assertMinimalLength(4, r4);
        super.parseFromCentralDirectoryData(r2, r3, r4);
        this.rcount = ZipShort.getValue(r2, r3);
        this.hashAlg = PKWareExtraHeader.HashAlgorithm.getAlgorithmByCode(ZipShort.getValue(r2, r3 + 2));
    }
}
