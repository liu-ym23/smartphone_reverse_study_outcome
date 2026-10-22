package com.sdk.bwdl.ExternalAPI;

import com.sdk.bwdl.BWDLDevice;
import com.sdk.bwdl.BWDLReceiver;
import com.sdk.bwdl.ControlLink;
import com.sdk.bwdl.DataLink;
import com.sdk.bwdl.NearFieldSwap.callback.BWDLAdvertisingSetCallback;
import com.sdk.bwdl.NearFieldSwap.callback.BWDLBleBroadcastReceiver;
import com.sdk.bwdl.NearFieldSwap.callback.BWDLDiscoveryCallback;
import com.sdk.bwdl.StateMachine.callback.ControlLinkCallback;
import com.sdk.bwdl.StateMachine.callback.DataLinkCallback;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BWDLCallback implements BWDLDiscoveryCallback, BWDLBleBroadcastReceiver, BWDLAdvertisingSetCallback, ControlLinkCallback, DataLinkCallback, BWDLReceiver.ISystemBroadcastListener {
    public BWDLCallback() {
    }

    @Override // com.sdk.bwdl.NearFieldSwap.callback.BWDLAdvertisingSetCallback
    public void onAdvConnected(int r8) {
    }

    @Override // com.sdk.bwdl.NearFieldSwap.callback.BWDLAdvertisingSetCallback
    public void onAdvConnectedFailed(int r8) {
    }

    @Override // com.sdk.bwdl.NearFieldSwap.callback.BWDLAdvertisingSetCallback
    public void onAdvStopped() {
    }

    @Override // com.sdk.bwdl.NearFieldSwap.callback.BWDLBleBroadcastReceiver
    public void onBroadcastReceiver(int r8, int r10) {
    }

    public void onBtStateChanged(int r8) {
    }

    public void onDataReceive(ControlLink r8, byte[] r10) {
    }

    @Override // com.sdk.bwdl.StateMachine.callback.DataLinkCallback
    public void onDataSent(BWDLConstant.LinkType r8, int r10) {
    }

    @Override // com.sdk.bwdl.NearFieldSwap.callback.BWDLDiscoveryCallback
    public void onDiscoveryConnected(int r8) {
    }

    @Override // com.sdk.bwdl.NearFieldSwap.callback.BWDLDiscoveryCallback
    public void onDiscoveryDataChanged(short r8, byte r10, BWDLDiscoveryData r11) {
    }

    @Override // com.sdk.bwdl.NearFieldSwap.callback.BWDLDiscoveryCallback
    public void onDiscoveryDevicesChanged(List<BWDLDiscoveryData> r8) {
    }

    public void onEventComplete(ControlLink r8) {
    }

    public void onEventConnectFail(BWDLDevice r8) {
    }

    public void onEventConnectFailWithReason(ControlLink r8, int r10) {
    }

    public void onEventConnected(BWDLDevice r8, ControlLink r10) {
    }

    public void onEventDisconnected(ControlLink r8) {
    }

    public void onEventFail(ControlLink r8) {
    }

    @Override // com.sdk.bwdl.BWDLReceiver.ISystemBroadcastListener
    public void onScreenOff() {
    }

    @Override // com.sdk.bwdl.BWDLReceiver.ISystemBroadcastListener
    public void onScreenOn() {
    }

    public void onWifiStateChanged(int r8) {
    }

    @Override // com.sdk.bwdl.StateMachine.callback.DataLinkCallback
    public void onDataReceive(BWDLConstant.LinkType r8, byte[] r10) {
    }

    public void onEventConnectFail(DataLink r8) {
    }

    public void onEventConnected(ControlLink r8, DataLink r10, BWDLDevice r11) {
    }

    public void onEventDisconnected(DataLink r8) {
    }
}
