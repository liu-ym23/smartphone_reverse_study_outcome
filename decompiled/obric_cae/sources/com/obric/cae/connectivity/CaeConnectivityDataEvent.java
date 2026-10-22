package com.obric.cae.connectivity;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.obric.cae.BWDL.BwdlDrop.provider.BwdlDropProvider;
import com.obric.cae.location.database.StarLocationDbManager;

/* JADX INFO: loaded from: classes.dex */
public final class CaeConnectivityDataEvent {
    private static Descriptors.FileDescriptor descriptor;
    static final Descriptors.Descriptor internal_static_com_obric_cae_connectivity_BleScanResultDataReport_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_connectivity_BleScanResultDataReport_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_com_obric_cae_connectivity_CaeConnectivityDataProto_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_connectivity_CaeConnectivityDataProto_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_com_obric_cae_connectivity_CaeConnectivityProtoData_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_connectivity_CaeConnectivityProtoData_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_com_obric_cae_connectivity_CellularCellRecordReport_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_connectivity_CellularCellRecordReport_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_com_obric_cae_connectivity_GpsLocationSummaryReport_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_connectivity_GpsLocationSummaryReport_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_com_obric_cae_connectivity_GpsMeasurementReport_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_connectivity_GpsMeasurementReport_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_com_obric_cae_connectivity_WifiScanDataReport_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_connectivity_WifiScanDataReport_fieldAccessorTable = null;

    static {
        descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019CaeConnectivityData.proto\u0012\u001acom.obric.cae.connectivity\"n\n\u0018CaeConnectivityDataProto\u0012R\n\u0014caeConnectivityProto\u0018\u0001 \u0003(\u000b24.com.obric.cae.connectivity.CaeConnectivityProtoData\"ß\u0003\n\u0018CaeConnectivityProtoData\u0012\u0013\n\u000bdevice_time\u0018\u0001 \u0001(\u0004\u0012\f\n\u0004name\u0018\u0002 \u0001(\t\u0012J\n\u0012wifiScanDataReport\u0018\u0003 \u0003(\u000b2..com.obric.cae.connectivity.WifiScanDataReport\u0012T\n\u0017bleScanResultDataReport\u0018\u0004 \u0003(\u000b23.com.obric.cae.connectivity.BleScanResultDataReport\u0012V\n\u0018gpsLocationSummaryReport\u0018\u0005 \u0001(\u000b24.com.obric.cae.connectivity.GpsLocationSummaryReport\u0012N\n\u0014gpsMeasurementReport\u0018\u0006 \u0003(\u000b20.com.obric.cae.connectivity.GpsMeasurementReport\u0012V\n\u0018cellularCellRecordReport\u0018\u0007 \u0003(\u000b24.com.obric.cae.connectivity.CellularCellRecordReport\"ì\u0001\n\u0012WifiScanDataReport\u0012\f\n\u0004ssid\u0018\u0001 \u0001(\t\u0012\r\n\u0005bssid\u0018\u0002 \u0001(\t\u0012\r\n\u0005level\u0018\u0003 \u0001(\u0005\u0012\u0011\n\tfrequency\u0018\u0004 \u0001(\u0005\u0012\u0015\n\rchannel_width\u0018\u0005 \u0001(\u0005\u0012\u0015\n\rwifi_standard\u0018\u0006 \u0001(\u0005\u0012\u0014\n\fcapabilities\u0018\u0007 \u0001(\t\u0012\u001c\n\u0014is_passpoint_network\u0018\b \u0001(\b\u0012\u001a\n\u0012is_support_80211mc\u0018\t \u0001(\b\u0012\u0019\n\u0011scan_timestamp_ms\u0018\n \u0001(\u0004\"Û\u0003\n\u0017BleScanResultDataReport\u0012\u0014\n\fpackage_name\u0018\u0001 \u0001(\t\u0012\u0011\n\ttimestamp\u0018\u0002 \u0001(\u0003\u0012\u0012\n\nevent_type\u0018\u0003 \u0001(\r\u0012\u0014\n\faddress_type\u0018\u0004 \u0001(\r\u0012\u000f\n\u0007address\u0018\u0005 \u0001(\t\u0012\u0018\n\u0010original_address\u0018\u0006 \u0001(\t\u0012\u0013\n\u000bprimary_phy\u0018\u0007 \u0001(\r\u0012\u0015\n\rsecondary_phy\u0018\b \u0001(\r\u0012\u0017\n\u000fadvertising_sid\u0018\t \u0001(\r\u0012\u0010\n\btx_power\u0018\n \u0001(\u0005\u0012\f\n\u0004rssi\u0018\u000b \u0001(\u0005\u0012\u0018\n\u0010periodic_adv_int\u0018\f \u0001(\r\u0012\u0013\n\u000bdevice_name\u0018\r \u0001(\t\u0012\u0017\n\u000fadvertise_flags\u0018\u000e \u0001(\u0005\u0012\u0015\n\rservice_uuids\u0018\u000f \u0001(\t\u0012\"\n\u001aservice_solicitation_uuids\u0018\u0010 \u0001(\t\u0012\"\n\u001amanufacturer_specific_Data\u0018\u0011 \u0001(\t\u0012\u0014\n\fservice_data\u0018\u0012 \u0001(\t\u0012 \n\u0018transport_discovery_data\u0018\u0013 \u0001(\t\"¯\u0003\n\u0018GpsLocationSummaryReport\u0012\u0010\n\blatitude\u0018\u0001 \u0001(\u0001\u0012\u0011\n\tlongitude\u0018\u0002 \u0001(\u0001\u0012\u0010\n\baltitude\u0018\u0003 \u0001(\u0001\u0012\u0010\n\baccuracy\u0018\u0004 \u0001(\u0002\u0012\r\n\u0005speed\u0018\u0005 \u0001(\u0002\u0012\u000f\n\u0007bearing\u0018\u0006 \u0001(\u0002\u0012\u0015\n\rlocation_time\u0018\u0007 \u0001(\u0004\u0012\u0010\n\bprovider\u0018\b \u0001(\t\u0012\u0019\n\u0011vertical_accuracy\u0018\t \u0001(\u0002\u0012\u0016\n\u000espeed_accuracy\u0018\n \u0001(\u0002\u0012\u0018\n\u0010bearing_accuracy\u0018\u000b \u0001(\u0002\u0012\u0017\n\u000fsatellite_count\u0018\f \u0001(\u0005\u0012\u0019\n\u0011used_in_fix_count\u0018\r \u0001(\u0005\u0012\u0014\n\favg_cn0_dbhz\u0018\u000e \u0001(\u0002\u0012\u0014\n\fmax_cn0_dbhz\u0018\u000f \u0001(\u0002\u0012\f\n\u0004hdop\u0018\u0010 \u0001(\u0002\u0012\f\n\u0004vdop\u0018\u0011 \u0001(\u0002\u0012\f\n\u0004pdop\u0018\u0012 \u0001(\u0002\u0012\u0015\n\rhas_ephemeris\u0018\u0013 \u0001(\b\u0012\u0013\n\u000bhas_almanac\u0018\u0014 \u0001(\b\"ÿ\u0003\n\u0014GpsMeasurementReport\u0012\f\n\u0004svid\u0018\u0001 \u0001(\u0005\u0012\u001a\n\u0012constellation_type\u0018\u0002 \u0001(\u0005\u0012\u001c\n\u0014carrier_frequency_hz\u0018\u0003 \u0001(\u0001\u0012\u0010\n\bcn0_dbhz\u0018\u0004 \u0001(\u0001\u0012\u0019\n\u0011baseband_cn0_dbhz\u0018\u0005 \u0001(\u0001\u0012\u0013\n\u000bpseudorange\u0018\u0006 \u0001(\u0001\u0012&\n\u001eaccumulated_delta_range_meters\u0018\u0007 \u0001(\u0001\u00122\n*accumulated_delta_range_uncertainty_meters\u0018\b \u0001(\u0001\u0012%\n\u001daccumulated_delta_range_state\u0018\t \u0001(\u0005\u0012\u001e\n\u0016received_sv_time_nanos\u0018\n \u0001(\u0003\u0012*\n\"received_sv_time_uncertainty_nanos\u0018\u000b \u0001(\u0003\u0012\u0019\n\u0011time_offset_nanos\u0018\f \u0001(\u0001\u0012\r\n\u0005state\u0018\r \u0001(\u0005\u0012\u001b\n\u0013multipath_indicator\u0018\u000e \u0001(\u0005\u0012\u0019\n\u0011elevation_degrees\u0018\u000f \u0001(\u0002\u0012\u0017\n\u000fazimuth_degrees\u0018\u0010 \u0001(\u0002\u0012\u0013\n\u000bused_in_fix\u0018\u0011 \u0001(\b\"r\n\u0018CellularCellRecordReport\u0012\u0018\n\u0010specific_cell_id\u0018\u0001 \u0001(\t\u0012\u001a\n\u0012leave_timestamp_ms\u0018\u0002 \u0001(\u0003\u0012\f\n\u0004rsrp\u0018\u0003 \u0001(\u0002\u0012\u0012\n\nstep_count\u0018\u0004 \u0001(\u0005B\u001cB\u0018CaeConnectivityDataEventP\u0001"}, new Descriptors.FileDescriptor[0]);
        Descriptors.Descriptor r8 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_obric_cae_connectivity_CaeConnectivityDataProto_descriptor = r8;
        internal_static_com_obric_cae_connectivity_CaeConnectivityDataProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r8, new String[]{"CaeConnectivityProto"});
        Descriptors.Descriptor r10 = getDescriptor().getMessageTypes().get(1);
        internal_static_com_obric_cae_connectivity_CaeConnectivityProtoData_descriptor = r10;
        internal_static_com_obric_cae_connectivity_CaeConnectivityProtoData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r10, new String[]{"DeviceTime", "Name", "WifiScanDataReport", "BleScanResultDataReport", "GpsLocationSummaryReport", "GpsMeasurementReport", "CellularCellRecordReport"});
        Descriptors.Descriptor r11 = getDescriptor().getMessageTypes().get(2);
        internal_static_com_obric_cae_connectivity_WifiScanDataReport_descriptor = r11;
        internal_static_com_obric_cae_connectivity_WifiScanDataReport_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r11, new String[]{"Ssid", "Bssid", "Level", "Frequency", "ChannelWidth", "WifiStandard", "Capabilities", "IsPasspointNetwork", "IsSupport80211Mc", "ScanTimestampMs"});
        Descriptors.Descriptor r12 = getDescriptor().getMessageTypes().get(3);
        internal_static_com_obric_cae_connectivity_BleScanResultDataReport_descriptor = r12;
        internal_static_com_obric_cae_connectivity_BleScanResultDataReport_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r12, new String[]{"PackageName", BwdlDropProvider.BwdlDropEntry.TIMESTAMP, "EventType", "AddressType", "Address", "OriginalAddress", "PrimaryPhy", "SecondaryPhy", "AdvertisingSid", "TxPower", "Rssi", "PeriodicAdvInt", "DeviceName", "AdvertiseFlags", "ServiceUuids", "ServiceSolicitationUuids", "ManufacturerSpecificData", "ServiceData", "TransportDiscoveryData"});
        Descriptors.Descriptor r13 = getDescriptor().getMessageTypes().get(4);
        internal_static_com_obric_cae_connectivity_GpsLocationSummaryReport_descriptor = r13;
        internal_static_com_obric_cae_connectivity_GpsLocationSummaryReport_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r13, new String[]{"Latitude", StarLocationDbManager.GeofenceEntry.LONGITUDE, "Altitude", "Accuracy", "Speed", "Bearing", "LocationTime", "Provider", "VerticalAccuracy", "SpeedAccuracy", "BearingAccuracy", "SatelliteCount", "UsedInFixCount", "AvgCn0Dbhz", "MaxCn0Dbhz", "Hdop", "Vdop", "Pdop", "HasEphemeris", "HasAlmanac"});
        Descriptors.Descriptor r14 = getDescriptor().getMessageTypes().get(5);
        internal_static_com_obric_cae_connectivity_GpsMeasurementReport_descriptor = r14;
        internal_static_com_obric_cae_connectivity_GpsMeasurementReport_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r14, new String[]{"Svid", "ConstellationType", "CarrierFrequencyHz", "Cn0Dbhz", "BasebandCn0Dbhz", "Pseudorange", "AccumulatedDeltaRangeMeters", "AccumulatedDeltaRangeUncertaintyMeters", "AccumulatedDeltaRangeState", "ReceivedSvTimeNanos", "ReceivedSvTimeUncertaintyNanos", "TimeOffsetNanos", "State", "MultipathIndicator", "ElevationDegrees", "AzimuthDegrees", "UsedInFix"});
        Descriptors.Descriptor r15 = getDescriptor().getMessageTypes().get(6);
        internal_static_com_obric_cae_connectivity_CellularCellRecordReport_descriptor = r15;
        internal_static_com_obric_cae_connectivity_CellularCellRecordReport_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r15, new String[]{"SpecificCellId", "LeaveTimestampMs", "Rsrp", "StepCount"});
    }

    private CaeConnectivityDataEvent() {
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
