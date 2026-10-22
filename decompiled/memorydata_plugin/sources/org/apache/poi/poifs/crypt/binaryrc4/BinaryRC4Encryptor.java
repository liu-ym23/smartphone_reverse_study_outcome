package org.apache.poi.poifs.crypt.binaryrc4;

import org.apache.poi.poifs.crypt.Encryptor;

/* JADX INFO: loaded from: classes7.dex */
public class BinaryRC4Encryptor extends Encryptor {
    private int chunkSize;

    public BinaryRC4Encryptor() {
        this.chunkSize = 512;
    }
}
