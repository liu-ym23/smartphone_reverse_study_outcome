package com.bytedance.bdinstall;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class BDInstallConfig {
    private int egdiRetryInterval;
    private boolean enableByPassFinger;
    private boolean enableDidGuard;
    private boolean enableGetEgdi;
    private boolean enableMediaID;
    private INetworkClientWrapper networkClientWrapper;
    private int timeoutForTicketGuard;

    public BDInstallConfig() {
        this.enableGetEgdi = false;
        this.enableMediaID = false;
        this.enableDidGuard = false;
        this.enableByPassFinger = false;
    }

    public int getEgdiRetryInterval() {
        int r0 = this.egdiRetryInterval;
        if (r0 <= 0) goto L5;
        return r0;
    L5:
        return 10000;
    }

    public INetworkClientWrapper getNetworkClientWrapper() {
        return this.networkClientWrapper;
    }

    public int getTimeoutForTicketGuard() {
        return this.timeoutForTicketGuard;
    }

    public boolean isEnableByPassFinger() {
        return this.enableByPassFinger;
    }

    public boolean isEnableDidGuard() {
        return this.enableDidGuard;
    }

    public boolean isEnableGetEgdi() {
        return this.enableGetEgdi;
    }

    public boolean isEnableMediaID() {
        return this.enableMediaID;
    }

    public void setEgdiRetryInterval(int r1) {
        this.egdiRetryInterval = r1;
    }

    public void setEnableByPassFinger(boolean r1) {
        this.enableByPassFinger = r1;
    }

    public void setEnableDidGuard(boolean r1) {
        this.enableDidGuard = r1;
    }

    public void setEnableGetEgdi(boolean r1) {
        this.enableGetEgdi = r1;
    }

    public void setEnableMediaID(boolean r1) {
        this.enableMediaID = r1;
    }

    public void setNetworkClientWrapper(INetworkClientWrapper r3) {
        this.networkClientWrapper = (INetworkClientWrapper) ZeusTransformUtils.wrapperContextForParams(r3, INetworkClientWrapper.class, "com.obric.memorydata.plugin");
    }

    public void setTimeoutForTicketGuard(int r1) {
        this.timeoutForTicketGuard = r1;
    }
}
