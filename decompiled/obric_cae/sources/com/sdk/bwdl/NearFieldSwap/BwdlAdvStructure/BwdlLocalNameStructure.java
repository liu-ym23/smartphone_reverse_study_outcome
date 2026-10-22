package com.sdk.bwdl.NearFieldSwap.BwdlAdvStructure;

/* JADX INFO: loaded from: classes2.dex */
public class BwdlLocalNameStructure {
    private static final int MAX_LENGTH = 14;
    private String mLocalName;

    public BwdlLocalNameStructure() {
        this.mLocalName = BwdlAdvConstants.BwdlDefaultLocalName;
    }

    public byte[] getBytesData() {
        return this.mLocalName.getBytes();
    }

    public String getLocalName() {
        return this.mLocalName;
    }

    public void setLocalName(String r8) {
        if (r8.isEmpty() == false) goto L5;
        return;
    L5:
        if (r8.length() >= 14) goto L9;
        this.mLocalName = r8;
        return;
    }
}
