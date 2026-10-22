package com.obric.cae.bluetooth;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.obric.cae.BWDL.BwdlDrop.provider.BwdlDropProvider;

/* JADX INFO: loaded from: classes.dex */
public final class CaeBluetoothEvent {
    private static Descriptors.FileDescriptor descriptor;
    static final Descriptors.Descriptor internal_static_com_obric_cae_bluetooth_A2dpJitterEventData_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_bluetooth_A2dpJitterEventData_fieldAccessorTable = null;

    static {
        descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0012CaeBluetooth.proto\u0012\u0017com.obric.cae.bluetooth\"\u0080\u0003\n\u0013A2dpJitterEventData\u0012\u0019\n\u0011Delta_Retrans_Sum\u0018\u0001 \u0001(\u0002\u0012\u0012\n\nNoRx_Ratio\u0018\u0002 \u0001(\u0002\u0012\u0018\n\u0010Silence_Duration\u0018\u0003 \u0001(\u0002\u0012\u001a\n\u0012host_buffer_margin\u0018\u0004 \u0001(\u0002\u0012\u0019\n\u0011mAclTxQueueLength\u0018\u0005 \u0001(\u0005\u0012\u0014\n\fmGlitchCount\u0018\u0006 \u0001(\u0005\u0012\u0011\n\tmNakCount\u0018\u0007 \u0001(\u0005\u0012\u0012\n\nmNoRxCount\u0018\b \u0001(\u0005\u0012\u0016\n\u000emOverflowCount\u0018\t \u0001(\u0005\u0012\u0013\n\u000bmPacketType\u0018\n \u0001(\t\u0012\u0015\n\rmTxPowerLevel\u0018\u000b \u0001(\u0005\u0012\f\n\u0004prob\u0018\f \u0001(\u0002\u0012\r\n\u0005label\u0018\r \u0001(\u0005\u0012\u0011\n\ttimestamp\u0018\u000e \u0001(\u0003\u0012\u001d\n\u0015time_to_bt_restart_ms\u0018\u000f \u0001(\u0003\u0012\u0019\n\u0011time_to_revert_ms\u0018\u0010 \u0001(\u0003B\u0015B\u0011CaeBluetoothEventP\u0001"}, new Descriptors.FileDescriptor[0]);
        Descriptors.Descriptor r8 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_obric_cae_bluetooth_A2dpJitterEventData_descriptor = r8;
        internal_static_com_obric_cae_bluetooth_A2dpJitterEventData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r8, new String[]{"DeltaRetransSum", "NoRxRatio", "SilenceDuration", "HostBufferMargin", "MAclTxQueueLength", "MGlitchCount", "MNakCount", "MNoRxCount", "MOverflowCount", "MPacketType", "MTxPowerLevel", "Prob", "Label", BwdlDropProvider.BwdlDropEntry.TIMESTAMP, "TimeToBtRestartMs", "TimeToRevertMs"});
    }

    private CaeBluetoothEvent() {
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
