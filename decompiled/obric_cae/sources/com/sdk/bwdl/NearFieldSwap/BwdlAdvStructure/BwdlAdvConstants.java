package com.sdk.bwdl.NearFieldSwap.BwdlAdvStructure;

import com.sdk.bwdl.StateMachine.BWDLCommandBuilder;
import com.sdk.bwdl.StateMachine.BWDLDataStructure;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class BwdlAdvConstants {
    public static int BwdlAdVServiceDataLengh = 0;
    public static byte BwdlAdVServiceDataType = 0;
    public static byte BwdlAdvLongDevNameLengh = 0;
    public static byte BwdlAdvLongDevNameType = 0;
    public static byte BwdlAdvShortDevNameLengh = 0;
    public static byte BwdlAdvShortDevNameType = 0;
    public static byte BwdlAdvTxPowerLengh = 0;
    public static byte BwdlAdvTxPowerType = 0;
    public static byte BwdlAdvUUIDLengh = 0;
    public static byte BwdlAdvUUIDType = 0;
    public static String BwdlDefaultLocalName = null;
    public static byte BwdlDefaultTxPower = 0;
    public static short BwdlDefaultUuids = 0;
    public static byte BwdlFlagsLengh = 0;
    public static byte BwdlFlagsType = 0;
    public static int BwdlServiceCommonDataLen = 0;
    public static final int MANUFACTURER_ID = 43980;
    public static final int MAX_ADV_LENGTH = 240;
    public static final int MAX_SERVICE_ADV_LENGTH = 240;
    public static final UUID SERVICE_UUID = null;

    static {
        SERVICE_UUID = UUID.fromString("37841151-fb22-11ee-a244-fa163e6c466e");
        BwdlFlagsType = 1;
        BwdlFlagsLengh = 2;
        BwdlAdvShortDevNameType = 8;
        BwdlAdvShortDevNameLengh = BWDLDataStructure.DataLinkParamStructure.WIFI_P2P;
        BwdlAdvLongDevNameType = 9;
        BwdlAdvLongDevNameLengh = BWDLDataStructure.DataLinkParamStructure.WIFI_P2P;
        BwdlAdvTxPowerType = 10;
        BwdlAdvTxPowerLengh = 2;
        BwdlAdvUUIDType = 2;
        BwdlAdvUUIDLengh = 7;
        BwdlAdVServiceDataType = BWDLCommandBuilder.CHANNEL_CONFIG_RESP;
        BwdlAdVServiceDataLengh = 240;
        BwdlDefaultLocalName = "BWDL";
        BwdlDefaultTxPower = -2;
        BwdlDefaultUuids = 4660;
        BwdlServiceCommonDataLen = 9;
    }

    public BwdlAdvConstants() {
    }
}
