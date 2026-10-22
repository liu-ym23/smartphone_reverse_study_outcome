package com.obric.cae.p001useraware;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.obric.cae.BWDL.BwdlDrop.provider.BwdlDropProvider;

/* JADX INFO: loaded from: classes2.dex */
public final class caeUserAwareEvent {
    private static Descriptors.FileDescriptor descriptor;
    static final Descriptors.Descriptor internal_static_com_obric_cae_useraware_CaeUserAwareServiceProtoData_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_useraware_CaeUserAwareServiceProtoData_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_com_obric_cae_useraware_CaeUserAwareServiceProto_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_useraware_CaeUserAwareServiceProto_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_com_obric_cae_useraware_HARStateRawData_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_useraware_HARStateRawData_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_com_obric_cae_useraware_HARUserAwareData_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_useraware_HARUserAwareData_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_com_obric_cae_useraware_UserAwarePrecisionData_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_useraware_UserAwarePrecisionData_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_com_obric_cae_useraware_WifiConnReportData_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_useraware_WifiConnReportData_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_com_obric_cae_useraware_WifiPnoStatsReportData_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_useraware_WifiPnoStatsReportData_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_com_obric_cae_useraware_WifiScanCountReportData_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_useraware_WifiScanCountReportData_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_com_obric_cae_useraware_WifiScanReportData_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_useraware_WifiScanReportData_fieldAccessorTable = null;

    static {
        descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019CaeUserAwareService.proto\u0012\u0017com.obric.cae.useraware\"w\n\u0018CaeUserAwareServiceProto\u0012[\n\u001ccaeUserAwareServiceProtoData\u0018\u0001 \u0003(\u000b25.com.obric.cae.useraware.CaeUserAwareServiceProtoData\"\u0097\u0004\n\u001cCaeUserAwareServiceProtoData\u0012C\n\u000eWifiScanReport\u0018\u0001 \u0003(\u000b2+.com.obric.cae.useraware.WifiScanReportData\u0012I\n\u0014WifiConnectionReport\u0018\u0002 \u0003(\u000b2+.com.obric.cae.useraware.WifiConnReportData\u0012K\n\u0012UserAwarePrecision\u0018\u0003 \u0003(\u000b2/.com.obric.cae.useraware.UserAwarePrecisionData\u0012M\n\u0013WifiScanCountReport\u0018\u0004 \u0003(\u000b20.com.obric.cae.useraware.WifiScanCountReportData\u0012?\n\fHARUserAware\u0018\u0005 \u0003(\u000b2).com.obric.cae.useraware.HARUserAwareData\u0012=\n\u000bHARStateRaw\u0018\u0006 \u0003(\u000b2(.com.obric.cae.useraware.HARStateRawData\u0012K\n\u0012WifiPnoStatsReport\u0018\u0007 \u0003(\u000b2/.com.obric.cae.useraware.WifiPnoStatsReportData\"w\n\u0012WifiScanReportData\u0012\r\n\u0005Bssid\u0018\u0001 \u0001(\t\u0012\f\n\u0004Ssid\u0018\u0002 \u0001(\t\u0012\f\n\u0004Rssi\u0018\u0003 \u0001(\u0011\u0012\u0011\n\tFrequency\u0018\u0004 \u0001(\u0011\u0012\u0011\n\tTimestamp\u0018\u0005 \u0001(\u0003\u0012\u0010\n\bAuthType\u0018\u0006 \u0001(\u0011\"w\n\u0012WifiConnReportData\u0012\r\n\u0005Bssid\u0018\u0001 \u0001(\t\u0012\f\n\u0004Ssid\u0018\u0002 \u0001(\t\u0012\f\n\u0004Rssi\u0018\u0003 \u0001(\u0011\u0012\u0011\n\tFrequency\u0018\u0004 \u0001(\u0011\u0012\u0011\n\tTimestamp\u0018\u0005 \u0001(\u0003\u0012\u0010\n\bAuthType\u0018\u0006 \u0001(\u0011\"g\n\u0016UserAwarePrecisionData\u0012\u0011\n\tTimeStamp\u0018\u0001 \u0001(\u0003\u0012\u0011\n\tStateCode\u0018\u0002 \u0001(\u0011\u0012\u0013\n\u000bStateChange\u0018\u0003 \u0001(\u0011\u0012\u0012\n\nUserChoice\u0018\u0004 \u0001(\u0011\"\u0083\u0001\n\u0017WifiScanCountReportData\u0012\u0011\n\tSceneType\u0018\u0001 \u0001(\u0011\u0012\u0011\n\tTimeStamp\u0018\u0002 \u0001(\u0003\u0012\u0010\n\bScanType\u0018\u0003 \u0001(\u0011\u0012\u0015\n\rDateScanCount\u0018\u0004 \u0001(\u0011\u0012\u0019\n\u0011DateScanDropCount\u0018\u0005 \u0001(\u0011\"\u0083\u0002\n\u0016WifiPnoStatsReportData\u0012\u0011\n\tTimeStamp\u0018\u0001 \u0001(\u0003\u0012\r\n\u0005Event\u0018\u0002 \u0001(\u0011\u0012\u0018\n\u0010StartWallClockMs\u0018\u0003 \u0001(\u0003\u0012\u0017\n\u000fStopWallClockMs\u0018\u0004 \u0001(\u0003\u0012\u0012\n\nDurationMs\u0018\u0005 \u0001(\u0003\u0012\u0010\n\bPeriodMs\u0018\u0006 \u0001(\u0011\u0012\u0017\n\u000fEstimatedRounds\u0018\u0007 \u0001(\u0011\u0012\u001c\n\u0014TotalDurationTodayMs\u0018\b \u0001(\u0003\u0012\u0019\n\u0011SessionCountToday\u0018\t \u0001(\u0011\u0012\u001c\n\u0014EstimatedRoundsToday\u0018\n \u0001(\u0011\"L\n\u0010HARUserAwareData\u0012\u0011\n\tTimeStamp\u0018\u0001 \u0001(\u0003\u0012\u0011\n\tStateCode\u0018\u0002 \u0001(\u0011\u0012\u0012\n\nUserChoice\u0018\u0003 \u0001(\u0011\"L\n\u000fHARStateRawData\u0012\u0011\n\tTimeStamp\u0018\u0001 \u0001(\u0003\u0012\u0011\n\tStateCode\u0018\u0002 \u0001(\u0011\u0012\u0013\n\u000bmodelNumber\u0018\u0003 \u0001(\u0011B\u0015B\u0011caeUserAwareEventP\u0001"}, new Descriptors.FileDescriptor[0]);
        Descriptors.Descriptor r8 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_obric_cae_useraware_CaeUserAwareServiceProto_descriptor = r8;
        internal_static_com_obric_cae_useraware_CaeUserAwareServiceProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r8, new String[]{"CaeUserAwareServiceProtoData"});
        Descriptors.Descriptor r10 = getDescriptor().getMessageTypes().get(1);
        internal_static_com_obric_cae_useraware_CaeUserAwareServiceProtoData_descriptor = r10;
        internal_static_com_obric_cae_useraware_CaeUserAwareServiceProtoData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r10, new String[]{"WifiScanReport", "WifiConnectionReport", "UserAwarePrecision", "WifiScanCountReport", "HARUserAware", "HARStateRaw", "WifiPnoStatsReport"});
        Descriptors.Descriptor r11 = getDescriptor().getMessageTypes().get(2);
        internal_static_com_obric_cae_useraware_WifiScanReportData_descriptor = r11;
        internal_static_com_obric_cae_useraware_WifiScanReportData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r11, new String[]{"Bssid", "Ssid", "Rssi", "Frequency", BwdlDropProvider.BwdlDropEntry.TIMESTAMP, "AuthType"});
        Descriptors.Descriptor r12 = getDescriptor().getMessageTypes().get(3);
        internal_static_com_obric_cae_useraware_WifiConnReportData_descriptor = r12;
        internal_static_com_obric_cae_useraware_WifiConnReportData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r12, new String[]{"Bssid", "Ssid", "Rssi", "Frequency", BwdlDropProvider.BwdlDropEntry.TIMESTAMP, "AuthType"});
        Descriptors.Descriptor r13 = getDescriptor().getMessageTypes().get(4);
        internal_static_com_obric_cae_useraware_UserAwarePrecisionData_descriptor = r13;
        internal_static_com_obric_cae_useraware_UserAwarePrecisionData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r13, new String[]{"TimeStamp", "StateCode", "StateChange", "UserChoice"});
        Descriptors.Descriptor r14 = getDescriptor().getMessageTypes().get(5);
        internal_static_com_obric_cae_useraware_WifiScanCountReportData_descriptor = r14;
        internal_static_com_obric_cae_useraware_WifiScanCountReportData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r14, new String[]{"SceneType", "TimeStamp", "ScanType", "DateScanCount", "DateScanDropCount"});
        Descriptors.Descriptor r15 = getDescriptor().getMessageTypes().get(6);
        internal_static_com_obric_cae_useraware_WifiPnoStatsReportData_descriptor = r15;
        internal_static_com_obric_cae_useraware_WifiPnoStatsReportData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r15, new String[]{"TimeStamp", "Event", "StartWallClockMs", "StopWallClockMs", "DurationMs", "PeriodMs", "EstimatedRounds", "TotalDurationTodayMs", "SessionCountToday", "EstimatedRoundsToday"});
        Descriptors.Descriptor r16 = getDescriptor().getMessageTypes().get(7);
        internal_static_com_obric_cae_useraware_HARUserAwareData_descriptor = r16;
        internal_static_com_obric_cae_useraware_HARUserAwareData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r16, new String[]{"TimeStamp", "StateCode", "UserChoice"});
        Descriptors.Descriptor r17 = getDescriptor().getMessageTypes().get(8);
        internal_static_com_obric_cae_useraware_HARStateRawData_descriptor = r17;
        internal_static_com_obric_cae_useraware_HARStateRawData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r17, new String[]{"TimeStamp", "StateCode", "ModelNumber"});
    }

    private caeUserAwareEvent() {
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
