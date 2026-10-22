package com.obric.cae.smartNetwork.multipath;

/* JADX INFO: loaded from: classes2.dex */
public class MPAConnQuality {
    public static final int CONN_TYPE_CELLULAR = 1;
    public static final int CONN_TYPE_UNKNOWN = -1;
    public static final int CONN_TYPE_WIFI = 0;
    public static final int RTT_CODE_TIMEOUT = -2;
    private String mAccelAddr;
    private int mClientRttTime;
    private int mClientRxLoss;
    private int mConnType;
    private int mServerRttTime;
    private int mServerRxLoss;

    public MPAConnQuality() {
        this.mConnType = -1;
    }

    public int getClientRttTime() {
        return this.mClientRttTime;
    }

    public int getClientRxLoss() {
        return this.mClientRxLoss;
    }

    public int getConnType() {
        return this.mConnType;
    }

    public int getServerRttTime() {
        return this.mServerRttTime;
    }

    public int getServerRxLoss() {
        return this.mServerRxLoss;
    }

    public String getaccelAddr() {
        return this.mAccelAddr;
    }

    public boolean isRttTimedout() {
        if (this.mClientRttTime != (-2)) goto L5;
    L8:
        return true;
    L5:
        if (this.mServerRttTime == (-2)) goto L8;
        return false;
    }

    public int maxRttTime() {
        return Math.max(this.mClientRttTime, this.mServerRttTime);
    }

    public void setAccelAddr(String r8) {
        this.mAccelAddr = r8;
    }

    public void setClientRttTime(int r8) {
        this.mClientRttTime = r8;
    }

    public void setClientRxLoss(int r8) {
        this.mClientRxLoss = r8;
    }

    public void setConnType(int r8) {
        this.mConnType = r8;
    }

    public void setServerRttTime(int r8) {
        this.mServerRttTime = r8;
    }

    public void setServerRxLoss(int r8) {
        this.mServerRxLoss = r8;
    }

    public String toString() {
        StringBuilder r8 = new StringBuilder("MPAConnQuality{mClientRttTime=");
        r8.append(this.mClientRttTime);
        r8.append(", mClientRxLoss=");
        r8.append(this.mClientRxLoss);
        r8.append(", mServerRttTime=");
        r8.append(this.mServerRttTime);
        r8.append(", mServerRxLoss=");
        r8.append(this.mServerRxLoss);
        r8.append(", mAccelAddr='");
        r8.append(this.mAccelAddr);
        r8.append("', mConnType=");
        return android.aimedia.a.f(r8, this.mConnType, '}');
    }
}
