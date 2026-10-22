package com.ss.android.lark.conditional.access.network.easynetwork;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class EasyNetworkState implements Serializable {
    private EasyNetworkType easyNetworkType;
    private String networkId;

    public String toString() {
        return "EasyNetworkState{easyNetworkType=" + this.easyNetworkType.toString() + ", networkId='" + this.networkId + "'}";
    }

    public EasyNetworkType getEasyNetworkType() {
        return this.easyNetworkType;
    }

    public String getNetworkId() {
        return this.networkId;
    }

    public boolean sameAs(EasyNetworkState r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (r4.easyNetworkType == this.easyNetworkType) goto L8;
        return false;
    L8:
        if (r4.networkId != this.networkId) goto L12;
        return true;
    L12:
        return false;
    }

    public void setEasyNetworkType(EasyNetworkType r1) {
        this.easyNetworkType = r1;
    }

    public void setNetworkId(String r1) {
        this.networkId = r1;
    }

    public EasyNetworkState(EasyNetworkType r1, String r2) {
        this.easyNetworkType = r1;
        this.networkId = r2;
    }
}
