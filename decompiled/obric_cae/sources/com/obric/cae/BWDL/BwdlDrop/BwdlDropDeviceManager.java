package com.obric.cae.BWDL.BwdlDrop;

import com.obric.cae.log.CaeLog;
import com.sdk.bwdl.BWDLDevice;
import com.sdk.bwdl.ControlLink;
import com.sdk.bwdl.DataLink;

/* JADX INFO: loaded from: classes.dex */
public class BwdlDropDeviceManager {
    private static final String TAG = "BwdlDropDeviceManager";
    private BwdlDropSession mBwdlDropSession;
    private ControlLink mControlLink;
    private BWDLDevice mControlLinkDevice;
    private DataLink mDataLink;
    private BWDLDevice mDataLinkDevice;
    private int mDeviceId;

    public BwdlDropDeviceManager(int r8) {
        this.mDeviceId = r8;
    }

    public void cleanDataLinkInfo() {
        this.mDataLink = null;
        this.mDataLinkDevice = null;
    }

    public BwdlDropSession getBwdlDropSession() {
        return this.mBwdlDropSession;
    }

    public ControlLink getControlLink() {
        return this.mControlLink;
    }

    public BWDLDevice getControlLinkDevice() {
        return this.mControlLinkDevice;
    }

    public DataLink getDataLink() {
        return this.mDataLink;
    }

    public BWDLDevice getDataLinkDevice() {
        return this.mDataLinkDevice;
    }

    public int getDeviceId() {
        return this.mDeviceId;
    }

    public void setBwdlDropSession(BwdlDropSession r8) {
        CaeLog.d(TAG, "setBwdlDropSession:" + r8);
        this.mBwdlDropSession = r8;
        r8.setBwdlDropDeviceManager(this);
    }

    public void setControlLinkInfo(ControlLink r8, BWDLDevice r10) {
        this.mControlLink = r8;
        this.mControlLinkDevice = r10;
    }

    public void setDataLinkInfo(DataLink r8, BWDLDevice r10) {
        this.mDataLink = r8;
        this.mDataLinkDevice = r10;
    }
}
