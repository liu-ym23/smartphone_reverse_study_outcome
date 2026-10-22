package com.obric.cae.userAware;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.obric.cae.BWDL.BwdlDrop.provider.BwdlDropProvider;

/* JADX INFO: loaded from: classes2.dex */
public final class CaeNearElevatorEvent {
    private static Descriptors.FileDescriptor descriptor;
    static final Descriptors.Descriptor internal_static_com_obric_cae_userAware_NearElevatorProto_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_userAware_NearElevatorProto_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_com_obric_cae_userAware_WifiScanDataPair_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_userAware_WifiScanDataPair_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_com_obric_cae_userAware_WifiScanData_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_userAware_WifiScanData_fieldAccessorTable = null;

    static {
        descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0012NearElevator.proto\u0012\u0017com.obric.cae.userAware\"¡\u0001\n\u0011NearElevatorProto\u0012\u0016\n\u000eis_in_elevator\u0018\u0001 \u0001(\b\u0012\u0013\n\u000belevator_id\u0018\u0002 \u0001(\u0005\u0012\u001b\n\u0013elevator_update_cnt\u0018\u0003 \u0001(\u0005\u0012B\n\u000fwifi_data_pairs\u0018\u0004 \u0003(\u000b2).com.obric.cae.userAware.WifiScanDataPair\"\u0096\u0001\n\u0010WifiScanDataPair\u0012A\n\u0012new_wifi_scan_data\u0018\u0001 \u0001(\u000b2%.com.obric.cae.userAware.WifiScanData\u0012?\n\u0010anchor_wifi_data\u0018\u0002 \u0001(\u000b2%.com.obric.cae.userAware.WifiScanData\"T\n\fWifiScanData\u0012\f\n\u0004rssi\u0018\u0001 \u0001(\u0005\u0012\f\n\u0004freq\u0018\u0002 \u0001(\u0005\u0012\u0015\n\rchannel_width\u0018\u0003 \u0001(\u0005\u0012\u0011\n\ttimestamp\u0018\u0004 \u0001(\u0003B\u0018B\u0014CaeNearElevatorEventP\u0001"}, new Descriptors.FileDescriptor[0]);
        Descriptors.Descriptor r8 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_obric_cae_userAware_NearElevatorProto_descriptor = r8;
        internal_static_com_obric_cae_userAware_NearElevatorProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r8, new String[]{"IsInElevator", "ElevatorId", "ElevatorUpdateCnt", "WifiDataPairs"});
        Descriptors.Descriptor r10 = getDescriptor().getMessageTypes().get(1);
        internal_static_com_obric_cae_userAware_WifiScanDataPair_descriptor = r10;
        internal_static_com_obric_cae_userAware_WifiScanDataPair_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r10, new String[]{"NewWifiScanData", "AnchorWifiData"});
        Descriptors.Descriptor r11 = getDescriptor().getMessageTypes().get(2);
        internal_static_com_obric_cae_userAware_WifiScanData_descriptor = r11;
        internal_static_com_obric_cae_userAware_WifiScanData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r11, new String[]{"Rssi", "Freq", "ChannelWidth", BwdlDropProvider.BwdlDropEntry.TIMESTAMP});
    }

    private CaeNearElevatorEvent() {
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static void registerAllExtensions(ExtensionRegistry r8) {
        registerAllExtensions(r8);
    }

    public static void registerAllExtensions(ExtensionRegistryLite r8) {
    }
}
