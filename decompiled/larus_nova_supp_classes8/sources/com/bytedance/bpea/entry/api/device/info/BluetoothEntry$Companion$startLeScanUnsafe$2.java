package com.bytedance.bpea.entry.api.device.info;

import android.bluetooth.BluetoothAdapter;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.ReplayUIStateCode;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, ReplayUIStateCode.IS_FOLD_OPEN})
final class BluetoothEntry$Companion$startLeScanUnsafe$2 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ BluetoothAdapter.LeScanCallback $callback;
    final /* synthetic */ UUID[] $serviceUuids;
    final /* synthetic */ BluetoothAdapter $this_startLeScanUnsafe;

    public BluetoothEntry$Companion$startLeScanUnsafe$2(BluetoothAdapter r1, UUID[] r2, BluetoothAdapter.LeScanCallback r3) {
        this.$this_startLeScanUnsafe = r1;
        this.$serviceUuids = r2;
        this.$callback = r3;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final boolean m1603invoke() {
        return INVOKEVIRTUAL_com_bytedance_bpea_entry_api_device_info_BluetoothEntry$Companion$startLeScanUnsafe$2_com_obric_performance_power_monitor_bluetooth_BluetoothLancet_startLeScan(this.$this_startLeScanUnsafe, this.$serviceUuids, this.$callback);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return Boolean.valueOf(m1603invoke());
    }

    public static boolean INVOKEVIRTUAL_com_bytedance_bpea_entry_api_device_info_BluetoothEntry$Companion$startLeScanUnsafe$2_com_obric_performance_power_monitor_bluetooth_BluetoothLancet_startLeScan(BluetoothAdapter r2, UUID[] r3, BluetoothAdapter.LeScanCallback r4) {
        Intrinsics.checkNotNullParameter(r3, "serviceUuids");
        if (fna.g.d() == true) goto L6;
        Boolean r5 = Boolean.valueOf(r2.startLeScan(r3, r4));
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Boolean");
        return r5.booleanValue();
    L6:
        Boolean r6 = Boolean.valueOf(r2.startLeScan(r3, r4));
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlin.Boolean");
        boolean r7 = r6.booleanValue();
        if (r4 == null) goto L9;
        int r8 = r4.hashCode();
    L10:
        ina.a.b(r8);
        return r7;
    L9:
        r8 = 0;
        goto L10
    }
}
