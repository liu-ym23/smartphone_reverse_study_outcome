package com.bytedance.crypto.cloudsync.network;

/* JADX INFO: loaded from: classes.dex */
public class SyncKeyData {
    private String appId;
    private int keyVersion;
    private String syncKeyCipher;

    public SyncKeyData(String r10, String r11, int r12) {
        this.appId = r10;
        this.syncKeyCipher = r11;
        this.keyVersion = r12;
    }

    public String getAppId() {
        return this.appId;
    }

    public int getKeyVersion() {
        return this.keyVersion;
    }

    public String getSyncKeyCipher() {
        return this.syncKeyCipher;
    }
}
