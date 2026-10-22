package com.sdk.bwdl;

import com.sdk.bwdl.ExternalAPI.BWDLCallback;
import com.sdk.bwdl.ExternalAPI.BWDLConfigs;
import com.sdk.bwdl.StateMachine.ControlLinkSM;
import com.sdk.bwdl.StateMachine.DataLinkSM;
import com.sdk.bwdl.Utils.BWDLInnerConstant;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes2.dex */
public class ControlLinkProperty {
    private BWDLCallback mCbk;
    private BWDLConfigs mConfigs;
    private BWDLDevice mDataLinkLLInfo;
    private DataLinkSM mDataLinkSM;
    private BWDLDevice mDevice;
    private final ConcurrentMap<BWDLInnerConstant.ConnectivityType, byte[]> mDeviceCapabilitiesMap;
    private String mFeature;
    private ControlLink mInstance;
    private final Object mLock;
    private short mPeerCID;
    private ControlLinkSM mSm;
    private short mSourceCID;

    public ControlLinkProperty(BWDLConfigs r8, short r10, ControlLink r11) {
        this.mDeviceCapabilitiesMap = new ConcurrentHashMap();
        this.mLock = new Object();
        this.mConfigs = r8;
        this.mFeature = r8.getFeatureName();
        this.mCbk = r8.getCallback();
        this.mSourceCID = r10;
        this.mInstance = r11;
    }

    public BWDLCallback getBWDLCallback() {
        return this.mCbk;
    }

    public BWDLConfigs getBWDLConfigs() {
        Object r8 = this.mLock;
        monitor-enter(r8);
        BWDLConfigs r10 = this.mConfigs;     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public BWDLDevice getBWDLDevice() {
        Object r8 = this.mLock;
        monitor-enter(r8);
        BWDLDevice r10 = this.mDevice;     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public ControlLink getControlLink() {
        return this.mInstance;
    }

    public ControlLinkSM getControlLinkSM() {
        Object r8 = this.mLock;
        monitor-enter(r8);
        ControlLinkSM r10 = this.mSm;     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public BWDLDevice getDataLinkLLInfo() {
        Object r8 = this.mLock;
        monitor-enter(r8);
        BWDLDevice r10 = this.mDataLinkLLInfo;     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public DataLinkSM getDataLinkSM() {
        Object r8 = this.mLock;
        monitor-enter(r8);
        DataLinkSM r10 = this.mDataLinkSM;     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public byte[] getDeviceCapabilities(BWDLInnerConstant.ConnectivityType r8) {
        Object r10 = this.mLock;
        monitor-enter(r10);
        byte[] r11 = this.mDeviceCapabilitiesMap.get(r8);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public String getFeature() {
        return this.mFeature;
    }

    public short getPeerCID() {
        Object r8 = this.mLock;
        monitor-enter(r8);
        short r10 = this.mPeerCID;     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public short getSourceCID() {
        return this.mSourceCID;
    }

    public void setBWDLConfigs(BWDLConfigs r8) {
        Object r10 = this.mLock;
        monitor-enter(r10);
        this.mConfigs = r8;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setBWDLDevice(BWDLDevice r8) {
        Object r10 = this.mLock;
        monitor-enter(r10);
        this.mDevice = r8;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setControlLinkSM(ControlLinkSM r8) {
        Object r10 = this.mLock;
        monitor-enter(r10);
        this.mSm = r8;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setDataLinkLLInfo(BWDLDevice r8) {
        Object r10 = this.mLock;
        monitor-enter(r10);
        this.mDataLinkLLInfo = r8;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setDataLinkSM(DataLinkSM r8) {
        Object r10 = this.mLock;
        monitor-enter(r10);
        this.mDataLinkSM = r8;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setDeviceCapabilities(BWDLInnerConstant.ConnectivityType r8, byte[] r10) {
        Object r11 = this.mLock;
        monitor-enter(r11);
        this.mDeviceCapabilitiesMap.put(r8, r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setPeerCID(short r8) {
        Object r10 = this.mLock;
        monitor-enter(r10);
        this.mPeerCID = r8;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
