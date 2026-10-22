package org.apache.commons.compress.archivers.zip;

import com.bytedance.crypto.utils.CryptoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipException;

/* JADX INFO: loaded from: classes6.dex */
public abstract class PKWareExtraHeader implements ZipExtraField {
    private byte[] centralData;
    private final ZipShort headerId;
    private byte[] localData;

    public static final enum EncryptionAlgorithm extends Enum<EncryptionAlgorithm> {
        private static final /* synthetic */ EncryptionAlgorithm[] $VALUES = null;
        public static final EncryptionAlgorithm AES128 = null;
        public static final EncryptionAlgorithm AES192 = null;
        public static final EncryptionAlgorithm AES256 = null;
        public static final EncryptionAlgorithm DES = null;
        public static final EncryptionAlgorithm RC2 = null;
        public static final EncryptionAlgorithm RC2pre52 = null;
        public static final EncryptionAlgorithm RC4 = null;
        public static final EncryptionAlgorithm TripleDES168 = null;
        public static final EncryptionAlgorithm TripleDES192 = null;
        public static final EncryptionAlgorithm UNKNOWN = null;
        private static final Map<Integer, EncryptionAlgorithm> codeToEnum = null;
        private final int code;

        static {
            int r2 = 0;
            EncryptionAlgorithm r0 = new EncryptionAlgorithm("DES", 0, 26113);
            DES = r0;
            EncryptionAlgorithm r1 = new EncryptionAlgorithm("RC2pre52", 1, 26114);
            RC2pre52 = r1;
            EncryptionAlgorithm r3 = new EncryptionAlgorithm("TripleDES168", 2, 26115);
            TripleDES168 = r3;
            EncryptionAlgorithm r5 = new EncryptionAlgorithm("TripleDES192", 3, 26121);
            TripleDES192 = r5;
            EncryptionAlgorithm r7 = new EncryptionAlgorithm("AES128", 4, 26126);
            AES128 = r7;
            EncryptionAlgorithm r9 = new EncryptionAlgorithm("AES192", 5, 26127);
            AES192 = r9;
            EncryptionAlgorithm r11 = new EncryptionAlgorithm("AES256", 6, 26128);
            AES256 = r11;
            EncryptionAlgorithm r13 = new EncryptionAlgorithm("RC2", 7, 26370);
            RC2 = r13;
            EncryptionAlgorithm r12 = new EncryptionAlgorithm("RC4", 8, 26625);
            RC4 = r12;
            EncryptionAlgorithm r10 = new EncryptionAlgorithm("UNKNOWN", 9, 65535);
            UNKNOWN = r10;
            $VALUES = new EncryptionAlgorithm[]{r0, r1, r3, r5, r7, r9, r11, r13, r12, r10};
            HashMap r4 = new HashMap();
            EncryptionAlgorithm[] r6 = values();
            int r8 = r6.length;
        L3:
            if (r2 >= r8) goto L5;
            EncryptionAlgorithm r14 = r6[r2];
            r4.put(Integer.valueOf(r14.getCode()), r14);
            r2 = r2 + 1;
            goto L3
        L5:
            codeToEnum = Collections.unmodifiableMap(r4);
        }

        private EncryptionAlgorithm(String r1, int r2, int r3) {
            super(r1, r2);
            this.code = r3;
        }

        public static EncryptionAlgorithm getAlgorithmByCode(int r2) {
            return (EncryptionAlgorithm) ZeusTransformUtils.preCheckCast(codeToEnum.get(Integer.valueOf(r2)), EncryptionAlgorithm.class, "com.obric.memorydata.plugin");
        }

        public static EncryptionAlgorithm valueOf(String r2) {
            return (EncryptionAlgorithm) ZeusTransformUtils.preCheckCast(Enum.valueOf(EncryptionAlgorithm.class, r2), EncryptionAlgorithm.class, "com.obric.memorydata.plugin");
        }

        public static EncryptionAlgorithm[] values() {
            return (EncryptionAlgorithm[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EncryptionAlgorithm[].class, "com.obric.memorydata.plugin");
        }

        public int getCode() {
            return this.code;
        }
    }

    public static final enum HashAlgorithm extends Enum<HashAlgorithm> {
        private static final /* synthetic */ HashAlgorithm[] $VALUES = null;
        public static final HashAlgorithm CRC32 = null;
        public static final HashAlgorithm MD5 = null;
        public static final HashAlgorithm NONE = null;
        public static final HashAlgorithm RIPEND160 = null;
        public static final HashAlgorithm SHA1 = null;
        public static final HashAlgorithm SHA256 = null;
        public static final HashAlgorithm SHA384 = null;
        public static final HashAlgorithm SHA512 = null;
        private static final Map<Integer, HashAlgorithm> codeToEnum = null;
        private final int code;

        static {
            int r2 = 0;
            HashAlgorithm r0 = new HashAlgorithm("NONE", 0, 0);
            NONE = r0;
            HashAlgorithm r1 = new HashAlgorithm("CRC32", 1, 1);
            CRC32 = r1;
            HashAlgorithm r3 = new HashAlgorithm(CryptoConst.ALGORITHM_MD5, 2, 32771);
            MD5 = r3;
            HashAlgorithm r5 = new HashAlgorithm("SHA1", 3, 32772);
            SHA1 = r5;
            HashAlgorithm r7 = new HashAlgorithm("RIPEND160", 4, 32775);
            RIPEND160 = r7;
            HashAlgorithm r9 = new HashAlgorithm("SHA256", 5, 32780);
            SHA256 = r9;
            HashAlgorithm r11 = new HashAlgorithm("SHA384", 6, 32781);
            SHA384 = r11;
            HashAlgorithm r13 = new HashAlgorithm("SHA512", 7, 32782);
            SHA512 = r13;
            $VALUES = new HashAlgorithm[]{r0, r1, r3, r5, r7, r9, r11, r13};
            HashMap r4 = new HashMap();
            HashAlgorithm[] r6 = values();
            int r8 = r6.length;
        L3:
            if (r2 >= r8) goto L5;
            HashAlgorithm r10 = r6[r2];
            r4.put(Integer.valueOf(r10.getCode()), r10);
            r2 = r2 + 1;
            goto L3
        L5:
            codeToEnum = Collections.unmodifiableMap(r4);
        }

        private HashAlgorithm(String r1, int r2, int r3) {
            super(r1, r2);
            this.code = r3;
        }

        public static HashAlgorithm getAlgorithmByCode(int r2) {
            return (HashAlgorithm) ZeusTransformUtils.preCheckCast(codeToEnum.get(Integer.valueOf(r2)), HashAlgorithm.class, "com.obric.memorydata.plugin");
        }

        public static HashAlgorithm valueOf(String r2) {
            return (HashAlgorithm) ZeusTransformUtils.preCheckCast(Enum.valueOf(HashAlgorithm.class, r2), HashAlgorithm.class, "com.obric.memorydata.plugin");
        }

        public static HashAlgorithm[] values() {
            return (HashAlgorithm[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HashAlgorithm[].class, "com.obric.memorydata.plugin");
        }

        public int getCode() {
            return this.code;
        }
    }

    public PKWareExtraHeader(ZipShort r1) {
        this.headerId = r1;
    }

    public final void assertMinimalLength(int r3, int r4) {
        if (r4 < r3) goto L5;
        return;
    L5:
        throw new ZipException(getClass().getName() + " is too short, only " + r4 + " bytes, expected at least " + r3);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public byte[] getCentralDirectoryData() {
        byte[] r0 = this.centralData;
        if (r0 == null) goto L7;
        return ZipUtil.copy(r0);
    L7:
        return getLocalFileDataData();
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getCentralDirectoryLength() {
        if (this.centralData == null) goto L7;
        return new ZipShort(this.centralData.length);
    L7:
        return getLocalFileDataLength();
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getHeaderId() {
        return this.headerId;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public byte[] getLocalFileDataData() {
        return ZipUtil.copy(this.localData);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getLocalFileDataLength() {
        byte[] r1 = this.localData;
        if (r1 == null) goto L5;
        int r2 = r1.length;
    L7:
        return new ZipShort(r2);
    L5:
        r2 = 0;
        goto L7
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromCentralDirectoryData(byte[] r1, int r2, int r3) {
        byte[] r4 = Arrays.copyOfRange(r1, r2, r3 + r2);
        setCentralDirectoryData(r4);
        if (this.localData != null) goto L6;
        setLocalFileDataData(r4);
        return;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromLocalFileData(byte[] r1, int r2, int r3) {
        setLocalFileDataData(Arrays.copyOfRange(r1, r2, r3 + r2));
    }

    public void setCentralDirectoryData(byte[] r1) {
        this.centralData = ZipUtil.copy(r1);
    }

    public void setLocalFileDataData(byte[] r1) {
        this.localData = ZipUtil.copy(r1);
    }
}
