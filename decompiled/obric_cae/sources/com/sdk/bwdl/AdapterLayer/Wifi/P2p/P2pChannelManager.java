package com.sdk.bwdl.AdapterLayer.Wifi.P2p;

import com.sdk.bwdl.Utils.BWDLLog;

/* JADX INFO: loaded from: classes2.dex */
public class P2pChannelManager {
    private static final int BAND_24_GHZ_END_FREQ_MHZ = 2484;
    private static final int BAND_24_GHZ_START_FREQ_MHZ = 2412;
    private static final int BAND_5_GHZ_END_FREQ_MHZ = 5885;
    private static final int BAND_5_GHZ_START_FREQ_MHZ = 5160;
    private static final int BAND_DFS_END_FREQ_MHZ = 5700;
    private static final int BAND_DFS_START_FREQ_MHZ = 5260;
    private static final int DEFAULT_P2P_24G_FREQUENCY = 2437;
    private static final int DEFAULT_P2P_5G_FREQUENCY = 5200;
    private static final int P2P_NEGOTIATION_TYPE_BOTH_WIFI_CONNECTED = 3;
    private static final int P2P_NEGOTIATION_TYPE_LOCAL_WIFI_CONNECTED = 1;
    private static final int P2P_NEGOTIATION_TYPE_NONE_WIFI_CONNECTED = 0;
    private static final int P2P_NEGOTIATION_TYPE_PEER_WIFI_CONNECTED = 2;
    private static final String TAG = "P2pChannelManager";

    public P2pChannelManager() {
    }

    private static int getP2pNegotiationType(WifiCapabilities r8, WifiCapabilities r10) {
        boolean r11 = r8.isConnected;
        if (r11 == true) goto L5;
    L8:
        if (r11 == false) goto L12;
        return 1;
    L12:
        if (r10.isConnected == false) goto L15;
        return 2;
    L15:
        return 0;
    L5:
        if (r10.isConnected == false) goto L8;
        return 3;
    }

    private static boolean is24GHz(int r8) {
        if (r8 >= 2412) goto L5;
    L7:
        return false;
    L5:
        if (r8 > 2484) goto L7;
        return true;
    }

    public static boolean is5GHz(int r8) {
        if (r8 >= 5160) goto L5;
    L7:
        return false;
    L5:
        if (r8 > 5885) goto L7;
        return true;
    }

    public static boolean isDfsFreq(int r8) {
        if (r8 >= BAND_DFS_START_FREQ_MHZ) goto L5;
    L7:
        return false;
    L5:
        if (r8 > BAND_DFS_END_FREQ_MHZ) goto L7;
        return true;
    }

    public static int negotiateP2pBand(WifiCapabilities r8, WifiCapabilities r10) {
        if (r8 == null) goto L17;
        if (r10 == null) goto L17;
        BWDLLog.d(TAG, "localDeviceWifiCapabilities:" + r8.toString() + "\npeerDeviceWifiCapabilities:" + r10.toString());
        if (r8.isEnabled == false) goto L17;
        if (r10.isEnabled == false) goto L17;
        if (r8.isSupported5GHz == false) goto L17;
        if (r10.isSupported5GHz == false) goto L17;
        return 2;
    L17:
        return 1;
    }

    public static int negotiateP2pFrequency(WifiCapabilities r8, WifiCapabilities r10) {
        if (r8 == null) goto L60;
        if (r10 == null) goto L60;
        BWDLLog.d(TAG, "localDeviceWifiCapabilities:" + r8.toString() + "\npeerDeviceWifiCapabilities:" + r10.toString());
        if (r8.isEnabled == false) goto L60;
        if (r10.isEnabled == false) goto L60;
        int r11 = getP2pNegotiationType(r8, r10);
        if (r11 == 0) goto L56;
        if (r11 == 1) goto L21;
        if (r11 == 2) goto L21;
        if (r11 == 3) goto L21;
        return DEFAULT_P2P_24G_FREQUENCY;
    L21:
        if (r8.isSupported5GHz == false) goto L45;
        if (r10.isSupported5GHz == false) goto L45;
        if (is5GHz(r8.frequency) == true) goto L31;
        if (is5GHz(r10.frequency) == true) goto L31;
        return DEFAULT_P2P_5G_FREQUENCY;
    L31:
        if (is5GHz(r8.frequency) == false) goto L33;
        int r12 = r8.frequency;
    L35:
        if (isDfsFreq(r12) == true) goto L37;
        return r12;
    L37:
        if (is5GHz(r10.frequency) == true) goto L39;
    L42:
        return DEFAULT_P2P_5G_FREQUENCY;
    L39:
        if (isDfsFreq(r10.frequency) == true) goto L42;
        return r10.frequency;
    L33:
        r12 = r10.frequency;
    L45:
        if (is24GHz(r8.frequency) == true) goto L51;
        if (is24GHz(r10.frequency) == true) goto L51;
        return DEFAULT_P2P_24G_FREQUENCY;
    L51:
        if (is24GHz(r8.frequency) == false) goto L54;
        return r8.frequency;
    L54:
        return r10.frequency;
    L56:
        if (r8.isSupported5GHz == false) goto L60;
        if (r10.isSupported5GHz == false) goto L60;
        return DEFAULT_P2P_5G_FREQUENCY;
    L60:
        return DEFAULT_P2P_24G_FREQUENCY;
    }
}
