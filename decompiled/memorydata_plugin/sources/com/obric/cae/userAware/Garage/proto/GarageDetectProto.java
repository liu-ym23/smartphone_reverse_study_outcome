package com.obric.cae.userAware.Garage.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class GarageDetectProto {
    private static Descriptors.FileDescriptor descriptor;
    static final Descriptors.Descriptor internal_static_com_obric_cae_userAware_Garage_proto_GarageApScanResultRequest_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_userAware_Garage_proto_GarageApScanResultRequest_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_com_obric_cae_userAware_Garage_proto_GarageDetectEvent_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_userAware_Garage_proto_GarageDetectEvent_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_com_obric_cae_userAware_Garage_proto_GarageRuntimeStateRequest_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_userAware_Garage_proto_GarageRuntimeStateRequest_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_com_obric_cae_userAware_Garage_proto_GarageTelemetryChunk_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_userAware_Garage_proto_GarageTelemetryChunk_fieldAccessorTable = null;

    static {
        descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0012GarageDetect.proto\u0012$com.obric.cae.userAware.Garage.proto\"ú\u0004\n\u0019GarageApScanResultRequest\u0012\u000f\n\u0007scan_id\u0018\u0001 \u0002(\r\u0012L\n\nble_status\u0018\u0002 \u0002(\u000e28.com.obric.cae.userAware.Garage.proto.GarageApScanStatus\u0012\u0019\n\u0011bt_density_bucket\u0018\u0003 \u0002(\u0002\u0012\u0014\n\fbt_rssi_mean\u0018\u0004 \u0002(\u0002\u0012\u0013\n\u000bbt_rssi_std\u0018\u0005 \u0002(\u0002\u0012\u001e\n\u0016bt_strong_m80_fraction\u0018\u0006 \u0002(\u0002\u0012\u001c\n\u0014bt_has_uuid_fraction\u0018\u0007 \u0002(\u0002\u0012 \n\u0018bt_devicetype_2_fraction\u0018\b \u0002(\u0002\u0012 \n\u0018bt_devicetype_3_fraction\u0018\t \u0002(\u0002\u0012$\n\u001cbt_devclass_major_0_fraction\u0018\n \u0002(\u0002\u0012$\n\u001cbt_devclass_major_5_fraction\u0018\u000b \u0002(\u0002\u0012M\n\u000bgnss_status\u0018\f \u0002(\u000e28.com.obric.cae.userAware.Garage.proto.GarageApScanStatus\u0012\u0015\n\rgnss_sv_count\u0018\r \u0002(\u0002\u0012\u0015\n\rgnss_mean_cn0\u0018\u000e \u0002(\u0002\u0012\u0015\n\rgnss_top4_cn0\u0018\u000f \u0002(\u0002\u0012\u001a\n\u0012gnss_used_sv_count\u0018\u0010 \u0002(\u0002\u0012\u001a\n\u0012gnss_used_fraction\u0018\u0011 \u0002(\u0002\u0012\u001e\n\u0016ble_valid_unique_count\u0018\u0012 \u0002(\r\"j\n\u0019GarageRuntimeStateRequest\u0012\u000f\n\u0007version\u0018\u0001 \u0002(\r\u0012\u000f\n\u0007enabled\u0018\u0002 \u0002(\b\u0012\u0017\n\u000fcapability_mask\u0018\u0003 \u0002(\r\u0012\u0012\n\nrequest_id\u0018\u0004 \u0002(\r\"ï\u0001\n\u0011GarageDetectEvent\u0012H\n\u0006reason\u0018\u0002 \u0002(\u000e28.com.obric.cae.userAware.Garage.proto.GarageReportReason\u0012\u001b\n\u0013requested_scan_mask\u0018) \u0002(\r\u0012\u001b\n\u0013completed_scan_mask\u0018* \u0002(\r\u0012\u000f\n\u0007scan_id\u0018+ \u0002(\r\u0012\u0017\n\u000fruntime_enabled\u0018, \u0001(\b\u0012\u001a\n\u0012runtime_request_id\u0018- \u0001(\rJ\u0004\b\u0001\u0010\u0002J\u0004\b\u0003\u0010)J\u0004\b.\u0010H\"¶\u0005\n\u0014GarageTelemetryChunk\u0012\u000f\n\u0007version\u0018\u0001 \u0002(\r\u0012G\n\u0004type\u0018\u0002 \u0002(\u000e29.com.obric.cae.userAware.Garage.proto.GarageTelemetryType\u0012\u0013\n\u000bsnapshot_id\u0018\u0003 \u0002(\r\u0012\u0013\n\u000bchunk_index\u0018\u0004 \u0002(\r\u0012\u0013\n\u000bchunk_count\u0018\u0005 \u0002(\r\u0012\u0012\n\ntotal_size\u0018\u0006 \u0002(\r\u0012\r\n\u0005crc32\u0018\u0007 \u0002(\u0007\u0012\u0017\n\u000fwindow_start_ms\u0018\b \u0002(\u0004\u0012\u0015\n\rwindow_end_ms\u0018\t \u0002(\u0004\u0012\u0015\n\rquality_flags\u0018\n \u0002(\r\u0012\u001d\n\u0015pressure_sample_count\u0018\u000b \u0002(\r\u0012\u001a\n\u0012accel_sample_count\u0018\f \u0002(\r\u0012\u001b\n\u0013linacc_sample_count\u0018\r \u0002(\r\u0012\u0019\n\u0011gyro_sample_count\u0018\u000e \u0002(\r\u0012\u0015\n\rfeature_count\u0018\u000f \u0002(\r\u0012\u0013\n\u000brecord_size\u0018\u0010 \u0002(\r\u0012\u0017\n\u000fevent_direction\u0018\u0011 \u0001(\u0011\u0012\u0018\n\u0010event_confidence\u0018\u0012 \u0001(\u0002\u0012\u0014\n\fscan_purpose\u0018\u0013 \u0001(\r\u0012\u0013\n\u000bscan_result\u0018\u0014 \u0001(\r\u0012\u001b\n\u0013requested_scan_mask\u0018\u0015 \u0001(\r\u0012\u001b\n\u0013completed_scan_mask\u0018\u0016 \u0001(\r\u0012\u0013\n\u000bscene_valid\u0018\u0017 \u0001(\b\u0012\u0013\n\u000bscene_is_ug\u0018\u0018 \u0001(\b\u0012\u0018\n\u0010scene_confidence\u0018\u0019 \u0001(\u0002\u0012\u000f\n\u0007payload\u0018\u001a \u0002(\f\u0012\u000f\n\u0007scan_id\u0018\u001b \u0001(\r*ð\u0001\n\u0012GarageReportReason\u0012 \n\u001cGARAGE_REPORT_REASON_UNKNOWN\u0010\u0000\u0012\"\n\u001eGARAGE_REPORT_REASON_TRIGGERED\u0010\u0001\u0012\"\n\u001eGARAGE_REPORT_REASON_WIFI_DONE\u0010\u0002\u0012 \n\u001cGARAGE_REPORT_REASON_AP_DONE\u0010\u0003\u0012\u001e\n\u001aGARAGE_REPORT_REASON_ERROR\u0010\u0004\u0012.\n*GARAGE_REPORT_REASON_RUNTIME_STATE_CHANGED\u0010\u0005*\u0082\u0002\n\u0012GarageApScanStatus\u0012!\n\u001dGARAGE_AP_SCAN_STATUS_SUCCESS\u0010\u0000\u0012-\n)GARAGE_AP_SCAN_STATUS_SCANNER_UNAVAILABLE\u0010\u0001\u0012%\n!GARAGE_AP_SCAN_STATUS_SCAN_FAILED\u0010\u0002\u0012+\n'GARAGE_AP_SCAN_STATUS_PERMISSION_DENIED\u0010\u0003\u0012!\n\u001dGARAGE_AP_SCAN_STATUS_TIMEOUT\u0010\u0004\u0012#\n\u001fGARAGE_AP_SCAN_STATUS_CANCELLED\u0010\u0005*\u0086\u0001\n\u0013GarageTelemetryType\u0012!\n\u001dGARAGE_TELEMETRY_TYPE_UNKNOWN\u0010\u0000\u0012$\n GARAGE_TELEMETRY_TYPE_RAW_WINDOW\u0010\u0001\u0012&\n\"GARAGE_TELEMETRY_TYPE_SCAN_FEATURE\u0010\u0002B;\n$com.obric.cae.userAware.Garage.protoB\u0011GarageDetectProtoP\u0001"}, new Descriptors.FileDescriptor[0]);
        Descriptors.Descriptor r0 = (Descriptors.Descriptor) ZeusTransformUtils.preCheckCast(getDescriptor().getMessageTypes().get(0), Descriptors.Descriptor.class, "com.obric.memorydata.plugin");
        internal_static_com_obric_cae_userAware_Garage_proto_GarageApScanResultRequest_descriptor = r0;
        internal_static_com_obric_cae_userAware_Garage_proto_GarageApScanResultRequest_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r0, new String[]{"ScanId", "BleStatus", "BtDensityBucket", "BtRssiMean", "BtRssiStd", "BtStrongM80Fraction", "BtHasUuidFraction", "BtDevicetype2Fraction", "BtDevicetype3Fraction", "BtDevclassMajor0Fraction", "BtDevclassMajor5Fraction", "GnssStatus", "GnssSvCount", "GnssMeanCn0", "GnssTop4Cn0", "GnssUsedSvCount", "GnssUsedFraction", "BleValidUniqueCount"});
        Descriptors.Descriptor r1 = (Descriptors.Descriptor) ZeusTransformUtils.preCheckCast(getDescriptor().getMessageTypes().get(1), Descriptors.Descriptor.class, "com.obric.memorydata.plugin");
        internal_static_com_obric_cae_userAware_Garage_proto_GarageRuntimeStateRequest_descriptor = r1;
        internal_static_com_obric_cae_userAware_Garage_proto_GarageRuntimeStateRequest_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r1, new String[]{"Version", "Enabled", "CapabilityMask", "RequestId"});
        Descriptors.Descriptor r2 = (Descriptors.Descriptor) ZeusTransformUtils.preCheckCast(getDescriptor().getMessageTypes().get(2), Descriptors.Descriptor.class, "com.obric.memorydata.plugin");
        internal_static_com_obric_cae_userAware_Garage_proto_GarageDetectEvent_descriptor = r2;
        internal_static_com_obric_cae_userAware_Garage_proto_GarageDetectEvent_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r2, new String[]{"Reason", "RequestedScanMask", "CompletedScanMask", "ScanId", "RuntimeEnabled", "RuntimeRequestId"});
        Descriptors.Descriptor r3 = (Descriptors.Descriptor) ZeusTransformUtils.preCheckCast(getDescriptor().getMessageTypes().get(3), Descriptors.Descriptor.class, "com.obric.memorydata.plugin");
        internal_static_com_obric_cae_userAware_Garage_proto_GarageTelemetryChunk_descriptor = r3;
        internal_static_com_obric_cae_userAware_Garage_proto_GarageTelemetryChunk_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r3, new String[]{"Version", "Type", "SnapshotId", "ChunkIndex", "ChunkCount", "TotalSize", "Crc32", "WindowStartMs", "WindowEndMs", "QualityFlags", "PressureSampleCount", "AccelSampleCount", "LinaccSampleCount", "GyroSampleCount", "FeatureCount", "RecordSize", "EventDirection", "EventConfidence", "ScanPurpose", "ScanResult", "RequestedScanMask", "CompletedScanMask", "SceneValid", "SceneIsUg", "SceneConfidence", "Payload", "ScanId"});
    }

    private GarageDetectProto() {
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static void registerAllExtensions(ExtensionRegistry r0) {
        registerAllExtensions(r0);
    }

    public static void registerAllExtensions(ExtensionRegistryLite r0) {
    }
}
