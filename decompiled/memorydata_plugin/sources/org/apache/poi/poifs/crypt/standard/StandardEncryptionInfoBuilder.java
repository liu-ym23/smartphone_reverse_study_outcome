package org.apache.poi.poifs.crypt.standard;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionInfoBuilder;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: loaded from: classes7.dex */
public class StandardEncryptionInfoBuilder implements EncryptionInfoBuilder {
    public StandardEncryptionInfoBuilder() {
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public void initialize(EncryptionInfo r7, CipherAlgorithm r8, HashAlgorithm r9, int r10, int r11, ChainingMode r12) {
        if (r8 != null) goto L5;
        r8 = CipherAlgorithm.aes128;
    L5:
        if (r8 != CipherAlgorithm.aes128) goto L7;
    L13:
        if (r9 != null) goto L16;
        r9 = HashAlgorithm.sha1;
    L16:
        if (r9 != HashAlgorithm.sha1) goto L41;
        if (r12 != null) goto L20;
        r12 = ChainingMode.ecb;
    L20:
        if (r12 != ChainingMode.ecb) goto L39;
        if (r10 != (-1)) goto L24;
        r10 = r8.defaultKeySize;
    L24:
        if (r11 != (-1)) goto L26;
        r11 = r8.blockSize;
    L26:
        int[] r6 = r8.allowedKeySize;
        int r0 = r6.length;
        int r2 = 0;
        boolean r3 = false;
    L27:
        if (r2 >= r0) goto L33;
        if (r6[r2] != r10) goto L31;
        boolean r4 = true;
    L32:
        r3 = r3 | r4;
        r2 = r2 + 1;
        goto L27
    L31:
        r4 = false;
        goto L32
    L33:
        if (r3 == false) goto L37;
        CipherAlgorithm r1 = r8;
        HashAlgorithm r5 = r9;
        int r13 = r10;
        int r14 = r11;
        ChainingMode r15 = r12;
        r7.setHeader(new StandardEncryptionHeader(r1, r5, r13, r14, r15));
        r7.setVerifier(new StandardEncryptionVerifier(r1, r5, r13, r14, r15));
        StandardDecryptor r16 = new StandardDecryptor();
        r16.setEncryptionInfo(r7);
        r7.setDecryptor(r16);
        StandardEncryptor r17 = new StandardEncryptor();
        r17.setEncryptionInfo(r7);
        r7.setEncryptor(r17);
        return;
    L37:
        throw new EncryptedDocumentException("KeySize " + r10 + " not allowed for Cipher " + r8);
    L39:
        throw new EncryptedDocumentException("Standard encryption only supports ECB chaining.");
    L41:
        throw new EncryptedDocumentException("Standard encryption only supports SHA-1.");
    L7:
        if (r8 == CipherAlgorithm.aes192) goto L13;
        if (r8 == CipherAlgorithm.aes256) goto L13;
        throw new EncryptedDocumentException("Standard encryption only supports AES128/192/256.");
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public void initialize(EncryptionInfo r2, LittleEndianInput r3) {
        LittleEndianInput r1 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin");
        r1.readInt();
        StandardEncryptionHeader r4 = new StandardEncryptionHeader(r1);
        r2.setHeader(r4);
        r2.setVerifier(new StandardEncryptionVerifier(r1, r4));
        if (r2.getVersionMinor() == 2) goto L5;
        return;
    L5:
        if (r2.getVersionMajor() != 3) goto L7;
    L8:
        Decryptor r5 = new StandardDecryptor();
        r5.setEncryptionInfo(r2);
        r2.setDecryptor(r5);
        return;
    L7:
        if (r2.getVersionMajor() == 4) goto L8;
    }
}
