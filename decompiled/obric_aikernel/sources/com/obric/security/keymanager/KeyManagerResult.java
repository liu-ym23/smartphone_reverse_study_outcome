package com.obric.security.keymanager;

import java.security.cert.Certificate;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class KeyManagerResult {
    private List<Certificate> certChainResult;
    private byte[] mOutData;
    private int mResultCode;

    public KeyManagerResult(int r10, byte[] r11) {
        this.mResultCode = -1000;
        throw new RuntimeException("Stub!!");
    }

    public KeyManagerResult(int r10, byte[] r11, boolean r12) {
        this.mResultCode = -1000;
        throw new RuntimeException("Stub!!");
    }

    public List<Certificate> getCertChain() {
        throw new RuntimeException("Stub!!");
    }

    public byte[] getOutData() {
        throw new RuntimeException("Stub!!");
    }

    public int getResultCode() {
        throw new RuntimeException("Stub!!");
    }
}
