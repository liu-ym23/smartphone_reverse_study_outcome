package com.bytedance.crypto.modeldist;

/* JADX INFO: loaded from: classes.dex */
public class ModelInitResult {
    private String attestCertChain;
    private int errorCode;

    public ModelInitResult(int r10, String r11) {
        this.errorCode = r10;
        this.attestCertChain = r11;
    }

    public String getAttestCertChain() {
        return this.attestCertChain;
    }

    public int getErrorCode() {
        return this.errorCode;
    }
}
