package com.obric.cae.smartNetwork.networkHandover;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkScore {
    public static final int NETWORK_POLICY_L2_QOE_GOOD = 3;
    public static final int NETWORK_POLICY_L4_QOE_GOOD = 4;
    public static final int NETWORK_POLICY_PRIMARY = 1;
    public static final int NETWORK_POLICY_VALID = 2;
    private int mNetId;
    private int mNetType;
    private int mPolicy;

    public NetworkScore() {
    }

    public static NetworkScore create() {
        return new NetworkScore();
    }

    public void addPolicy(int r8) {
        int r10 = 1 << r8;
        this.mPolicy = r10 | this.mPolicy;
    }

    public int getNetId() {
        return this.mNetId;
    }

    public int getNetType() {
        return this.mNetType;
    }

    public int getPolicy() {
        return this.mPolicy;
    }

    public boolean hasPolicy(int r8) {
        if ((this.mPolicy & (1 << r8)) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public void removePolicy(int r8) {
        int r10 = this.mPolicy;
        this.mPolicy = (~(1 << r8)) & r10;
    }

    public void setNetId(int r8) {
        this.mNetId = r8;
    }

    public void setNetType(int r8) {
        this.mNetType = r8;
    }

    public String toString() {
        return "NetworkScore { netId =" + this.mNetId + ", netType = " + this.mNetType + ", primary = " + hasPolicy(1) + ", valid = " + hasPolicy(2) + ", l2qoeGood = " + hasPolicy(3) + ", l4qoeGood = " + hasPolicy(4) + " }";
    }
}
