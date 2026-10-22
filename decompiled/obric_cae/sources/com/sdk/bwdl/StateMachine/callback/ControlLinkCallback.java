package com.sdk.bwdl.StateMachine.callback;

import com.sdk.bwdl.BWDLDevice;
import com.sdk.bwdl.ControlLink;

/* JADX INFO: loaded from: classes2.dex */
public interface ControlLinkCallback {
    void onDataReceive(ControlLink r8, byte[] r10);

    void onEventComplete(ControlLink r8);

    void onEventConnectFail(BWDLDevice r8);

    void onEventConnected(BWDLDevice r8, ControlLink r10);

    void onEventDisconnected(ControlLink r8);

    void onEventFail(ControlLink r8);
}
