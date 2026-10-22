package org.apache.poi.poifs.crypt;

import com.bytedance.crypto.utils.CryptoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: loaded from: classes7.dex */
public class EncryptionInfo implements GenericRecord {
    private static final int[] FLAGS_MASKS = null;
    private static final String[] FLAGS_NAMES = null;
    public static final BitField flagAES = null;
    public static final BitField flagCryptoAPI = null;
    public static final BitField flagDocProps = null;
    public static final BitField flagExternal = null;
    private Decryptor decryptor;
    private final int encryptionFlags;
    private final EncryptionMode encryptionMode;
    private Encryptor encryptor;
    private EncryptionHeader header;
    private EncryptionVerifier verifier;
    private final int versionMajor;
    private final int versionMinor;

    static {
        flagCryptoAPI = BitFieldFactory.getInstance(4);
        flagDocProps = BitFieldFactory.getInstance(8);
        flagExternal = BitFieldFactory.getInstance(16);
        flagAES = BitFieldFactory.getInstance(32);
        FLAGS_MASKS = new int[]{4, 8, 16, 32};
        FLAGS_NAMES = new String[]{"CRYPTO_API", "DOC_PROPS", "EXTERNAL", CryptoConst.ALGORITHM_AES};
    }

    public EncryptionInfo(EncryptionMode r8) {
        this(r8, null, null, -1, -1, null);
    }

    public EncryptionInfo(EncryptionMode r9, CipherAlgorithm r10, HashAlgorithm r11, int r12, int r13, ChainingMode r14) {
        this.encryptionMode = r9;
        this.versionMajor = r9.versionMajor;
        this.versionMinor = r9.versionMinor;
        this.encryptionFlags = r9.encryptionFlags;
        getBuilder(r9).initialize(this, r10, r11, r12, r13, r14);
        return;
    L6:
        e = move-exception;
        throw new EncryptedDocumentException(e);
    }

    public EncryptionInfo(DirectoryNode r2) {
        this(r2.createDocumentInputStream("EncryptionInfo"), null);
    }

    public EncryptionInfo(LittleEndianInput r4, EncryptionMode r5) {
        LittleEndianInput r6 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r4, LittleEndianInput.class, "com.obric.memorydata.plugin");
        if (r5 != EncryptionMode.xor) goto L5;
        this.versionMajor = EncryptionMode.xor.versionMajor;
        int r0 = EncryptionMode.xor.versionMinor;
    L6:
        this.versionMinor = r0;
        if (this.versionMajor != EncryptionMode.xor.versionMajor) goto L13;
        if (this.versionMinor != EncryptionMode.xor.versionMinor) goto L13;
        EncryptionMode r7 = EncryptionMode.xor;
    L11:
        this.encryptionMode = r7;
        this.encryptionFlags = -1;
    L44:
        getBuilder(this.encryptionMode).initialize(this, r6);
        return;
    L39:
        e = move-exception;
        throw new IOException(e);
    L13:
        if (this.versionMajor == EncryptionMode.binaryRC4.versionMajor) goto L15;
    L17:
        int r1 = this.versionMajor;
        if (2 > r1) goto L32;
        if (r1 > 4) goto L32;
        if (this.versionMinor != 2) goto L32;
        int r2 = r6.readInt();
        this.encryptionFlags = r2;
        if (r5 != EncryptionMode.cryptoAPI) goto L26;
    L29:
        EncryptionMode r8 = EncryptionMode.cryptoAPI;
    L30:
        this.encryptionMode = r8;
        goto L44
    L26:
        if (flagAES.isSet(r2) == false) goto L29;
        r8 = EncryptionMode.standard;
    L32:
        if (r1 == EncryptionMode.agile.versionMajor) goto L34;
    L42:
        int r9 = r6.readInt();
        this.encryptionFlags = r9;
        throw new EncryptedDocumentException("Unknown encryption: version major: " + this.versionMajor + " / version minor: " + this.versionMinor + " / fCrypto: " + flagCryptoAPI.isSet(r9) + " / fExternal: " + flagExternal.isSet(r9) + " / fDocProps: " + flagDocProps.isSet(r9) + " / fAES: " + flagAES.isSet(r9));
    L34:
        if (this.versionMinor != EncryptionMode.agile.versionMinor) goto L42;
        this.encryptionMode = EncryptionMode.agile;
        this.encryptionFlags = r6.readInt();
        goto L44
    L15:
        if (this.versionMinor != EncryptionMode.binaryRC4.versionMinor) goto L17;
        r7 = EncryptionMode.binaryRC4;
        goto L11
    L5:
        this.versionMajor = r6.readUShort();
        r0 = r6.readUShort();
        goto L6
    }

    private static EncryptionInfoBuilder getBuilder(EncryptionMode r2) {
        return (EncryptionInfoBuilder) ZeusTransformUtils.preCheckCast(r2.builder.get(), EncryptionInfoBuilder.class, "com.obric.memorydata.plugin");
    }

    public Decryptor getDecryptor() {
        return this.decryptor;
    }

    public int getEncryptionFlags() {
        return this.encryptionFlags;
    }

    public EncryptionMode getEncryptionMode() {
        return this.encryptionMode;
    }

    public Encryptor getEncryptor() {
        return this.encryptor;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("encryptionMode", new $$Lambda$6uj55q80ICkDMPe6XzkWY0CWTBM(this));
        r0.put("versionMajor", new $$Lambda$zP6vGlrABV0ka3fhscictbGHV4(this));
        r0.put("versionMinor", new $$Lambda$94gJaOj7cfF2wILmAeH_wsFHrg(this));
        r0.put("encryptionFlags", GenericRecordUtil.getBitsAsString(new $$Lambda$rHIdV35_K2IBKwCKnnuLcig2I4A(this), FLAGS_MASKS, FLAGS_NAMES));
        r0.put("header", new $$Lambda$DSlCwbyQFcsutxTGAUrmvy7pCMc(this));
        r0.put("verifier", new $$Lambda$aSnL_dgAqDgz44Gl2trSE1NuvNE(this));
        r0.put("decryptor", new $$Lambda$xF4v0JJUDJYUNvOZXYZm4VEh3M(this));
        r0.put("encryptor", new $$Lambda$UBki9yi3HavVpwF4Xo8KI9VCp80(this));
        return Collections.unmodifiableMap(r0);
    }

    public EncryptionHeader getHeader() {
        return this.header;
    }

    public EncryptionVerifier getVerifier() {
        return this.verifier;
    }

    public int getVersionMajor() {
        return this.versionMajor;
    }

    public int getVersionMinor() {
        return this.versionMinor;
    }

    public void setDecryptor(Decryptor r1) {
        this.decryptor = r1;
    }

    public void setEncryptor(Encryptor r1) {
        this.encryptor = r1;
    }

    public void setHeader(EncryptionHeader r1) {
        this.header = r1;
    }

    public void setVerifier(EncryptionVerifier r1) {
        this.verifier = r1;
    }
}
