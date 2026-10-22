package org.apache.poi.poifs.crypt;

import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: loaded from: classes7.dex */
public interface EncryptionInfoBuilder {
    void initialize(EncryptionInfo r1, CipherAlgorithm r2, HashAlgorithm r3, int r4, int r5, ChainingMode r6);

    void initialize(EncryptionInfo r1, LittleEndianInput r2);
}
