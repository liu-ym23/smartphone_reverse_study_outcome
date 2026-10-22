package com.bytedance.bpea.entry.api.device.info;

import android.bluetooth.BluetoothAdapter;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.ReplayUIStateCode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, ReplayUIStateCode.IS_FOLD_OPEN})
final class BluetoothEntry$Companion$startDiscoveryUnsafe$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ BluetoothAdapter $this_startDiscoveryUnsafe;

    public BluetoothEntry$Companion$startDiscoveryUnsafe$1(BluetoothAdapter r1) {
        this.$this_startDiscoveryUnsafe = r1;
        super(0);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return Boolean.valueOf(m1601invoke());
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final boolean m1601invoke() {
        return INVOKEVIRTUAL_com_bytedance_bpea_entry_api_device_info_BluetoothEntry$Companion$startDiscoveryUnsafe$1_com_obric_performance_power_monitor_bluetooth_BluetoothLancet_startDiscovery(this.$this_startDiscoveryUnsafe);
    }

    public static boolean INVOKEVIRTUAL_com_bytedance_bpea_entry_api_device_info_BluetoothEntry$Companion$startDiscoveryUnsafe$1_com_obric_performance_power_monitor_bluetooth_BluetoothLancet_startDiscovery(BluetoothAdapter r2) {
        if (fna.g.d() == true) goto L6;
        Boolean r3 = Boolean.valueOf(r2.startDiscovery());
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.Boolean");
        return r3.booleanValue();
    L6:
        Boolean r4 = Boolean.valueOf(r2.startDiscovery());
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Boolean");
        boolean r5 = r4.booleanValue();
        ina.a.c++;
        return r5;
    }
}
