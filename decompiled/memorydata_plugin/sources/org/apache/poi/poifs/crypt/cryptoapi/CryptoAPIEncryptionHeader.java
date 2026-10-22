package org.apache.poi.poifs.crypt.cryptoapi;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.CipherProvider;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.poifs.crypt.standard.StandardEncryptionHeader;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: loaded from: classes7.dex */
public class CryptoAPIEncryptionHeader extends StandardEncryptionHeader {
    public CryptoAPIEncryptionHeader(CipherAlgorithm r1, HashAlgorithm r2, int r3, int r4, ChainingMode r5) {
        super(r1, r2, r3, r4, r5);
    }

    public CryptoAPIEncryptionHeader(LittleEndianInput r3) {
        super((LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionHeader
    public void setKeySize(int r6) {
        int[] r0 = getCipherAlgorithm().allowedKeySize;
        int r1 = r0.length;
        boolean r2 = false;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L8;
        if (r0[r3] == r6) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        r2 = true;
    L8:
        if (r2 == false) goto L16;
        super.setKeySize(r6);
        if (r6 <= 40) goto L12;
        String r7 = "Microsoft Enhanced Cryptographic Provider v1.0";
    L13:
        setCspName(r7);
        return;
    L12:
        r7 = CipherProvider.rc4.cipherProviderName;
        goto L13
    L16:
        throw new EncryptedDocumentException("invalid keysize " + r6 + " for cipher algorithm " + getCipherAlgorithm());
    }
}
