package com.sdk.bwdl.StateMachine;

import android.content.Context;
import com.sdk.bwdl.AdapterLayer.Wifi.P2p.P2pAdapter;
import com.sdk.bwdl.AdapterLayer.Wifi.P2p.P2pUtil;
import com.sdk.bwdl.AdapterLayer.Wifi.P2p.WifiCapabilities;
import com.sdk.bwdl.ControlLinkProperty;
import com.sdk.bwdl.Utils.BWDLLog;

/* JADX INFO: loaded from: classes2.dex */
public class BWDLDeviceCapabilities {
    private static final String TAG = "BWDLDeviceCapabilities";
    private BWDLCommandBuilder mBWDLCommandBuilder;
    private Context mContext;
    private ControlLinkProperty mControlLinkProperty;
    private ControlLinkSM mControlLinkSM;
    private P2pAdapter mP2pAdapter;

    public BWDLDeviceCapabilities(Context r8, ControlLinkProperty r10) {
        this.mControlLinkProperty = r10;
        this.mControlLinkSM = r10.getControlLinkSM();
        this.mContext = r8;
        this.mBWDLCommandBuilder = new BWDLCommandBuilder();
        this.mP2pAdapter = P2pAdapter.getInstance(this.mContext, this.mControlLinkProperty.getBWDLConfigs().getP2pBand());
    }

    private byte[] obtainWifiCapabilities() {
        BWDLLog.d(TAG, "obtainWifiCapabilities");
        WifiCapabilities r8 = (WifiCapabilities) this.mP2pAdapter.getCapabilities();
        return BWDLCommandBuilder.buildDataLinkExchangeInfoCmd(this.mControlLinkProperty.getPeerCID(), P2pUtil.convertCapabilitiesToByteArray(r8));
    }

    public void exchangeDeviceCapabilities() {
        byte[] r8 = obtainWifiCapabilities();
        this.mControlLinkSM.getControlLinkHandler().sendMessageWithParam(5, 0, 0, r8);
    }
}
