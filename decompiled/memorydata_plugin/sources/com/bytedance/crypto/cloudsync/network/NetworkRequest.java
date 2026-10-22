package com.bytedance.crypto.cloudsync.network;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
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

    public void setAppList(List<String> r3) {
        this.appList = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public void setCertChain(String r1) {
        this.certChain = r1;
    }

    public void setChallenge(String r1) {
        this.challenge = r1;
    }

    public void setPublicKey(String r1) {
        this.publicKey = r1;
    }

    public void setRequestType(String r1) {
        this.requestType = r1;
    }

    public void setRequestUrl(String r1) {
        this.requestUrl = r1;
    }

    public void setRootKeyName(String r1) {
        this.rootKeyName = r1;
    }
}
