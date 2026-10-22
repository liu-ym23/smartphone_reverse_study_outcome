package org.apache.poi.poifs.crypt.cryptoapi;

import org.apache.poi.poifs.crypt.Encryptor;

/* JADX INFO: loaded from: classes7.dex */
public class CryptoAPIEncryptor extends Encryptor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private int chunkSize;

    static {
    }

    CryptoAPIEncryptor() {
        this.chunkSize = 512;
    }
}
