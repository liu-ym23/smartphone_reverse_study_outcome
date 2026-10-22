package com.sdk.bwdl.StateMachine.callback;

import com.sdk.bwdl.BWDLDevice;
import com.sdk.bwdl.ControlLink;
import com.sdk.bwdl.DataLink;
import com.sdk.bwdl.ExternalAPI.BWDLConstant;

/* JADX INFO: loaded from: classes2.dex */
public interface DataLinkCallback {
    void onDataReceive(BWDLConstant.LinkType r8, byte[] r10);

    void onDataSent(BWDLConstant.LinkType r8, int r10);

    void onEventConnectFail(DataLink r8);

    default void onEventConnectFailWithReason(ControlLink r8, int r10) {
    }

    void onEventConnected(ControlLink r8, DataLink r10, BWDLDevice r11);

    void onEventDisconnected(DataLink r8);
}
