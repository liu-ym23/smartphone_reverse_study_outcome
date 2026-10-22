package com.aiassistant.security.keymanager;

import java.security.cert.Certificate;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class KeyManagerResult {
    private List<Certificate> certChainResult;
    private byte[] mOutData;
    private int mResultCode;

    public KeyManagerResult(int r1, byte[] r2) {
        this.mResultCode = -1000;
        throw new RuntimeException("Stub!!");
    }

    public KeyManagerResult(int r1, byte[] r2, boolean r3) {
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
