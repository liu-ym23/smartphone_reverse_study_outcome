package com.obric.cae.smartNetwork.netAccel;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.obric.cae.BWDL.BwdlDrop.provider.BwdlDropProvider;

/* JADX INFO: loaded from: classes2.dex */
public final class MultiNetAccelEvent {
    private static Descriptors.FileDescriptor descriptor;
    static final Descriptors.Descriptor internal_static_com_obric_cae_smartNetwork_netAccel_AccelCapability_CellularInfo_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_smartNetwork_netAccel_AccelCapability_CellularInfo_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_com_obric_cae_smartNetwork_netAccel_AccelCapability_WifiInfo_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_smartNetwork_netAccel_AccelCapability_WifiInfo_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_com_obric_cae_smartNetwork_netAccel_AccelCapability_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_smartNetwork_netAccel_AccelCapability_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_com_obric_cae_smartNetwork_netAccel_AccelUidCapability_AppInfo_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_smartNetwork_netAccel_AccelUidCapability_AppInfo_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_com_obric_cae_smartNetwork_netAccel_AccelUidCapability_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_smartNetwork_netAccel_AccelUidCapability_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_com_obric_cae_smartNetwork_netAccel_AppSocketStats_AppInfo_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_smartNetwork_netAccel_AppSocketStats_AppInfo_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_com_obric_cae_smartNetwork_netAccel_AppSocketStats_SocketStats_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_smartNetwork_netAccel_AppSocketStats_SocketStats_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_com_obric_cae_smartNetwork_netAccel_AppSocketStats_WifiStats_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_smartNetwork_netAccel_AppSocketStats_WifiStats_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_com_obric_cae_smartNetwork_netAccel_AppSocketStats_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_smartNetwork_netAccel_AppSocketStats_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_com_obric_cae_smartNetwork_netAccel_AutoDualWlanCapability_AppInfo_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_smartNetwork_netAccel_AutoDualWlanCapability_AppInfo_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_com_obric_cae_smartNetwork_netAccel_AutoDualWlanCapability_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_smartNetwork_netAccel_AutoDualWlanCapability_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_com_obric_cae_smartNetwork_netAccel_MultiNetAccelProtoData_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_smartNetwork_netAccel_MultiNetAccelProtoData_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_com_obric_cae_smartNetwork_netAccel_MultiNetAccelProto_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_smartNetwork_netAccel_MultiNetAccelProto_fieldAccessorTable = null;

    static {
        descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0013MultiNetAccel.proto\u0012#com.obric.cae.smartNetwork.netAccel\"m\n\u0012MultiNetAccelProto\u0012W\n\u0012multiNetAccelProto\u0018\u0001 \u0003(\u000b2;.com.obric.cae.smartNetwork.netAccel.MultiNetAccelProtoData\"æ\u0002\n\u0016MultiNetAccelProtoData\u0012M\n\u000faccelCapability\u0018\u0001 \u0001(\u000b24.com.obric.cae.smartNetwork.netAccel.AccelCapability\u0012S\n\u0012accelUidCapability\u0018\u0002 \u0001(\u000b27.com.obric.cae.smartNetwork.netAccel.AccelUidCapability\u0012[\n\u0016autoDualWlanCapability\u0018\u0003 \u0001(\u000b2;.com.obric.cae.smartNetwork.netAccel.AutoDualWlanCapability\u0012K\n\u000eappSocketStats\u0018\u0004 \u0001(\u000b23.com.obric.cae.smartNetwork.netAccel.AppSocketStats\"È\u0003\n\u000fAccelCapability\u0012\r\n\u0005state\u0018\u0001 \u0001(\u0005\u0012\u0011\n\ttimestamp\u0018\u0002 \u0001(\u0003\u0012O\n\bwifiInfo\u0018\u0003 \u0003(\u000b2=.com.obric.cae.smartNetwork.netAccel.AccelCapability.WifiInfo\u0012W\n\fcellularInfo\u0018\u0004 \u0003(\u000b2A.com.obric.cae.smartNetwork.netAccel.AccelCapability.CellularInfo\u001a\u008f\u0001\n\bWifiInfo\u0012\f\n\u0004ssid\u0018\u0001 \u0001(\t\u0012\r\n\u0005bssid\u0018\u0002 \u0001(\t\u0012\u0010\n\bstandard\u0018\u0003 \u0001(\u0005\u0012\f\n\u0004freq\u0018\u0004 \u0001(\u0005\u0012\f\n\u0004rssi\u0018\u0005 \u0001(\u0005\u0012\u0011\n\tlinkspeed\u0018\u0006 \u0001(\u0005\u0012\u0013\n\u000brxLinkspeed\u0018\u0007 \u0001(\u0005\u0012\u0010\n\binteface\u0018\b \u0001(\t\u001aW\n\fCellularInfo\u0012\r\n\u0005subid\u0018\u0001 \u0001(\u0005\u0012\f\n\u0004type\u0018\u0002 \u0001(\u0005\u0012\u000e\n\u0006cellId\u0018\u0003 \u0001(\u0003\u0012\f\n\u0004rsrp\u0018\u0004 \u0001(\u0005\u0012\f\n\u0004sinr\u0018\u0005 \u0001(\u0005\"µ\u0001\n\u0012AccelUidCapability\u0012\u0011\n\ttimestamp\u0018\u0002 \u0001(\u0003\u0012P\n\u0007appInfo\u0018\u0003 \u0003(\u000b2?.com.obric.cae.smartNetwork.netAccel.AccelUidCapability.AppInfo\u001a:\n\u0007AppInfo\u0012\r\n\u0005state\u0018\u0001 \u0001(\u0005\u0012\u000b\n\u0003uid\u0018\u0002 \u0001(\u0005\u0012\u0013\n\u000bpackageName\u0018\u0003 \u0001(\t\"Ì\u0001\n\u0016AutoDualWlanCapability\u0012\r\n\u0005state\u0018\u0001 \u0001(\u0005\u0012\u0011\n\ttimestamp\u0018\u0002 \u0001(\u0003\u0012T\n\u0007appInfo\u0018\u0003 \u0003(\u000b2C.com.obric.cae.smartNetwork.netAccel.AutoDualWlanCapability.AppInfo\u001a:\n\u0007AppInfo\u0012\r\n\u0005state\u0018\u0001 \u0001(\u0005\u0012\u000b\n\u0003uid\u0018\u0002 \u0001(\u0005\u0012\u0013\n\u000bpackageName\u0018\u0003 \u0001(\t\"á\u0004\n\u000eAppSocketStats\u0012\r\n\u0005state\u0018\u0001 \u0001(\u0005\u0012\u0016\n\u000estartTimestamp\u0018\u0002 \u0001(\u0003\u0012\u0014\n\fendTimestamp\u0018\u0003 \u0001(\u0003\u0012L\n\u0007appInfo\u0018\u0004 \u0001(\u000b2;.com.obric.cae.smartNetwork.netAccel.AppSocketStats.AppInfo\u0012T\n\u000bsocketStats\u0018\u0005 \u0003(\u000b2?.com.obric.cae.smartNetwork.netAccel.AppSocketStats.SocketStats\u0012P\n\twifiStats\u0018\u0006 \u0003(\u000b2=.com.obric.cae.smartNetwork.netAccel.AppSocketStats.WifiStats\u001a+\n\u0007AppInfo\u0012\u000b\n\u0003uid\u0018\u0001 \u0001(\u0005\u0012\u0013\n\u000bpackageName\u0018\u0002 \u0001(\t\u001a¦\u0001\n\u000bSocketStats\u0012\u0016\n\u000estartTimestamp\u0018\u0001 \u0001(\u0003\u0012\u0014\n\fendTimestamp\u0018\u0002 \u0001(\u0003\u0012\u0011\n\tinterface\u0018\u0003 \u0001(\t\u0012\r\n\u0005srcIp\u0018\u0004 \u0001(\t\u0012\u000f\n\u0007srcPort\u0018\u0005 \u0001(\u0005\u0012\r\n\u0005dstIp\u0018\u0006 \u0001(\t\u0012\u000f\n\u0007dstPort\u0018\u0007 \u0001(\u0005\u0012\u0016\n\u000etotalBytesRecv\u0018\b \u0001(\u0003\u001aF\n\tWifiStats\u0012\u0010\n\bwifiType\u0018\u0001 \u0001(\u0005\u0012\u0014\n\fl2Throughput\u0018\u0002 \u0001(\u0003\u0012\u0011\n\ttimestamp\u0018\u0003 \u0001(\u0003B\u0016B\u0012MultiNetAccelEventP\u0001"}, new Descriptors.FileDescriptor[0]);
        Descriptors.Descriptor r8 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_obric_cae_smartNetwork_netAccel_MultiNetAccelProto_descriptor = r8;
        internal_static_com_obric_cae_smartNetwork_netAccel_MultiNetAccelProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r8, new String[]{"MultiNetAccelProto"});
        Descriptors.Descriptor r10 = getDescriptor().getMessageTypes().get(1);
        internal_static_com_obric_cae_smartNetwork_netAccel_MultiNetAccelProtoData_descriptor = r10;
        internal_static_com_obric_cae_smartNetwork_netAccel_MultiNetAccelProtoData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r10, new String[]{"AccelCapability", "AccelUidCapability", "AutoDualWlanCapability", "AppSocketStats"});
        Descriptors.Descriptor r11 = getDescriptor().getMessageTypes().get(2);
        internal_static_com_obric_cae_smartNetwork_netAccel_AccelCapability_descriptor = r11;
        internal_static_com_obric_cae_smartNetwork_netAccel_AccelCapability_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r11, new String[]{"State", BwdlDropProvider.BwdlDropEntry.TIMESTAMP, "WifiInfo", "CellularInfo"});
        Descriptors.Descriptor r12 = r11.getNestedTypes().get(0);
        internal_static_com_obric_cae_smartNetwork_netAccel_AccelCapability_WifiInfo_descriptor = r12;
        internal_static_com_obric_cae_smartNetwork_netAccel_AccelCapability_WifiInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r12, new String[]{"Ssid", "Bssid", "Standard", "Freq", "Rssi", "Linkspeed", "RxLinkspeed", "Inteface"});
        Descriptors.Descriptor r13 = r11.getNestedTypes().get(1);
        internal_static_com_obric_cae_smartNetwork_netAccel_AccelCapability_CellularInfo_descriptor = r13;
        internal_static_com_obric_cae_smartNetwork_netAccel_AccelCapability_CellularInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r13, new String[]{"Subid", "Type", "CellId", "Rsrp", "Sinr"});
        Descriptors.Descriptor r14 = getDescriptor().getMessageTypes().get(3);
        internal_static_com_obric_cae_smartNetwork_netAccel_AccelUidCapability_descriptor = r14;
        internal_static_com_obric_cae_smartNetwork_netAccel_AccelUidCapability_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r14, new String[]{BwdlDropProvider.BwdlDropEntry.TIMESTAMP, "AppInfo"});
        Descriptors.Descriptor r15 = r14.getNestedTypes().get(0);
        internal_static_com_obric_cae_smartNetwork_netAccel_AccelUidCapability_AppInfo_descriptor = r15;
        internal_static_com_obric_cae_smartNetwork_netAccel_AccelUidCapability_AppInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r15, new String[]{"State", "Uid", "PackageName"});
        Descriptors.Descriptor r16 = getDescriptor().getMessageTypes().get(4);
        internal_static_com_obric_cae_smartNetwork_netAccel_AutoDualWlanCapability_descriptor = r16;
        internal_static_com_obric_cae_smartNetwork_netAccel_AutoDualWlanCapability_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r16, new String[]{"State", BwdlDropProvider.BwdlDropEntry.TIMESTAMP, "AppInfo"});
        Descriptors.Descriptor r17 = r16.getNestedTypes().get(0);
        internal_static_com_obric_cae_smartNetwork_netAccel_AutoDualWlanCapability_AppInfo_descriptor = r17;
        internal_static_com_obric_cae_smartNetwork_netAccel_AutoDualWlanCapability_AppInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r17, new String[]{"State", "Uid", "PackageName"});
        Descriptors.Descriptor r18 = getDescriptor().getMessageTypes().get(5);
        internal_static_com_obric_cae_smartNetwork_netAccel_AppSocketStats_descriptor = r18;
        internal_static_com_obric_cae_smartNetwork_netAccel_AppSocketStats_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r18, new String[]{"State", "StartTimestamp", "EndTimestamp", "AppInfo", "SocketStats", "WifiStats"});
        Descriptors.Descriptor r19 = r18.getNestedTypes().get(0);
        internal_static_com_obric_cae_smartNetwork_netAccel_AppSocketStats_AppInfo_descriptor = r19;
        internal_static_com_obric_cae_smartNetwork_netAccel_AppSocketStats_AppInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r19, new String[]{"Uid", "PackageName"});
        Descriptors.Descriptor r20 = r18.getNestedTypes().get(1);
        internal_static_com_obric_cae_smartNetwork_netAccel_AppSocketStats_SocketStats_descriptor = r20;
        internal_static_com_obric_cae_smartNetwork_netAccel_AppSocketStats_SocketStats_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r20, new String[]{"StartTimestamp", "EndTimestamp", "Interface", "SrcIp", "SrcPort", "DstIp", "DstPort", "TotalBytesRecv"});
        Descriptors.Descriptor r21 = r18.getNestedTypes().get(2);
        internal_static_com_obric_cae_smartNetwork_netAccel_AppSocketStats_WifiStats_descriptor = r21;
        internal_static_com_obric_cae_smartNetwork_netAccel_AppSocketStats_WifiStats_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r21, new String[]{"WifiType", "L2Throughput", BwdlDropProvider.BwdlDropEntry.TIMESTAMP});
    }

    private MultiNetAccelEvent() {
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
