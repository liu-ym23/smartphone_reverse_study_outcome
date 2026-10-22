package com.bytedance.crypto.cloudsync.network;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class NetworkRequest {
    private List<String> appList;
    private String certChain;
    private String challenge;
    private String publicKey;
    private String requestType;
    private String requestUrl;
    private String rootKeyName;

    public NetworkRequest() {
    }

    public List<String> getAppList() {
        return this.appList;
    }

    public String getCertChain() {
        return this.certChain;
    }

    public String getChallenge() {
        return this.challenge;
    }

    public String getPublicKey() {
        return this.publicKey;
    }

    public String getRequestType() {
        return this.requestType;
    }

    public String getRequestUrl() {
        return this.requestUrl;
    }

    public String getRootKeyName() {
        return this.rootKeyName;
    }

    public void setAppList(List<String> r10) {
        this.appList = r10;
    }

    public void setCertChain(String r10) {
        this.certChain = r10;
    }

    public void setChallenge(String r10) {
        this.challenge = r10;
    }

    public void setPublicKey(String r10) {
        this.publicKey = r10;
    }

    public void setRequestType(String r10) {
        this.requestType = r10;
    }

    public void setRequestUrl(String r10) {
        this.requestUrl = r10;
    }

    public void setRootKeyName(String r10) {
        this.rootKeyName = r10;
    }
}
