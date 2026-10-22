package com.obric.cae.smartNetwork.networkRateLimit;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;

/* JADX INFO: loaded from: classes2.dex */
public final class NetworkRateLimitEvent {
    private static Descriptors.FileDescriptor descriptor;
    static final Descriptors.Descriptor internal_static_com_obric_cae_smartNetwork_networkRateLimit_CommonData_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_smartNetwork_networkRateLimit_CommonData_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_com_obric_cae_smartNetwork_networkRateLimit_NetworkRateLimitCancelData_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_smartNetwork_networkRateLimit_NetworkRateLimitCancelData_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_com_obric_cae_smartNetwork_networkRateLimit_NetworkRateLimitData_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_smartNetwork_networkRateLimit_NetworkRateLimitData_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_com_obric_cae_smartNetwork_networkRateLimit_NetworkRateLimitProto_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_smartNetwork_networkRateLimit_NetworkRateLimitProto_fieldAccessorTable = null;

    static {
        descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016NetworkRateLimit.proto\u0012+com.obric.cae.smartNetwork.networkRateLimit\"ì\u0001\n\u0015NetworkRateLimitProto\u0012b\n\u0017network_rate_limit_data\u0018\u0001 \u0001(\u000b2A.com.obric.cae.smartNetwork.networkRateLimit.NetworkRateLimitData\u0012o\n\u001enetwork_rate_limit_cancel_data\u0018\u0002 \u0001(\u000b2G.com.obric.cae.smartNetwork.networkRateLimit.NetworkRateLimitCancelData\"{\n\u0014NetworkRateLimitData\u0012\u0015\n\rstrategy_type\u0018\u0001 \u0001(\r\u0012L\n\u000bcommon_data\u0018\u0002 \u0001(\u000b27.com.obric.cae.smartNetwork.networkRateLimit.CommonData\"j\n\u001aNetworkRateLimitCancelData\u0012L\n\u000bcommon_data\u0018\u0001 \u0001(\u000b27.com.obric.cae.smartNetwork.networkRateLimit.CommonData\"\u009e\u0002\n\nCommonData\u0012\u000f\n\u0007if_name\u0018\u0001 \u0001(\t\u0012\u001c\n\u0014rate_ctrl_uid_number\u0018\u0002 \u0001(\r\u0012\u0013\n\u000btemperature\u0018\u0003 \u0001(\u0002\u0012%\n\u001dmax_bandwidth_estimated_value\u0018\u0004 \u0001(\r\u0012\u001f\n\u0017foreground_app_pkg_name\u0018\u0005 \u0001(\t\u0012&\n\u001eforeground_app_is_in_whitelist\u0018\u0006 \u0001(\b\u0012\u001b\n\u0013foreground_app_rate\u0018\u0007 \u0001(\r\u0012\"\n\u001aforeground_app_rtt_average\u0018\b \u0001(\r\u0012\u001b\n\u0013background_app_rate\u0018\t \u0001(\rB\u0019B\u0015NetworkRateLimitEventP\u0001"}, new Descriptors.FileDescriptor[0]);
        Descriptors.Descriptor r8 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_obric_cae_smartNetwork_networkRateLimit_NetworkRateLimitProto_descriptor = r8;
        internal_static_com_obric_cae_smartNetwork_networkRateLimit_NetworkRateLimitProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r8, new String[]{"NetworkRateLimitData", "NetworkRateLimitCancelData"});
        Descriptors.Descriptor r10 = getDescriptor().getMessageTypes().get(1);
        internal_static_com_obric_cae_smartNetwork_networkRateLimit_NetworkRateLimitData_descriptor = r10;
        internal_static_com_obric_cae_smartNetwork_networkRateLimit_NetworkRateLimitData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r10, new String[]{"StrategyType", "CommonData"});
        Descriptors.Descriptor r11 = getDescriptor().getMessageTypes().get(2);
        internal_static_com_obric_cae_smartNetwork_networkRateLimit_NetworkRateLimitCancelData_descriptor = r11;
        internal_static_com_obric_cae_smartNetwork_networkRateLimit_NetworkRateLimitCancelData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r11, new String[]{"CommonData"});
        Descriptors.Descriptor r12 = getDescriptor().getMessageTypes().get(3);
        internal_static_com_obric_cae_smartNetwork_networkRateLimit_CommonData_descriptor = r12;
        internal_static_com_obric_cae_smartNetwork_networkRateLimit_CommonData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r12, new String[]{"IfName", "RateCtrlUidNumber", "Temperature", "MaxBandwidthEstimatedValue", "ForegroundAppPkgName", "ForegroundAppIsInWhitelist", "ForegroundAppRate", "ForegroundAppRttAverage", "BackgroundAppRate"});
    }

    private NetworkRateLimitEvent() {
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
