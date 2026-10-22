package com.bytedance.crypto.cloudsync.network;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class NetworkResponse {
    private int code;
    private List<SyncKeyData> keyDataList;
    private String message;
    private String serverPubKey;

    public NetworkResponse(int r10, String r11, List<SyncKeyData> r12, String r13) {
        this.code = r10;
        this.message = r11;
        this.keyDataList = r12;
        this.serverPubKey = r13;
    }

    public int getCode() {
        return this.code;
    }

    public List<SyncKeyData> getKeyDataList() {
        return this.keyDataList;
    }

    public String getMessage() {
        return this.message;
    }

    public String getServerPubKey() {
        return this.serverPubKey;
    }
}
