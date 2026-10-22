package com.bytedance.bpea.entry.api.device.info;

import android.bluetooth.BluetoothAdapter;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.ReplayUIStateCode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, ReplayUIStateCode.IS_FOLD_OPEN})
final class BluetoothEntry$Companion$startLeScanUnsafe$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ BluetoothAdapter.LeScanCallback $callback;
    final /* synthetic */ BluetoothAdapter $this_startLeScanUnsafe;

    public BluetoothEntry$Companion$startLeScanUnsafe$1(BluetoothAdapter r1, BluetoothAdapter.LeScanCallback r2) {
        this.$this_startLeScanUnsafe = r1;
        this.$callback = r2;
        super(0);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return Boolean.valueOf(m1602invoke());
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final boolean m1602invoke() {
        return INVOKEVIRTUAL_com_bytedance_bpea_entry_api_device_info_BluetoothEntry$Companion$startLeScanUnsafe$1_com_obric_performance_power_monitor_bluetooth_BluetoothLancet_startLeScan(this.$this_startLeScanUnsafe, this.$callback);
    }

    public static boolean INVOKEVIRTUAL_com_bytedance_bpea_entry_api_device_info_BluetoothEntry$Companion$startLeScanUnsafe$1_com_obric_performance_power_monitor_bluetooth_BluetoothLancet_startLeScan(BluetoothAdapter r2, BluetoothAdapter.LeScanCallback r3) {
        if (fna.g.d() == true) goto L6;
        Boolean r4 = Boolean.valueOf(r2.startLeScan(r3));
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Boolean");
        return r4.booleanValue();
    L6:
        Boolean r5 = Boolean.valueOf(r2.startLeScan(r3));
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Boolean");
        boolean r6 = r5.booleanValue();
        if (r3 == null) goto L9;
        int r7 = r3.hashCode();
    L10:
        ina.a.b(r7);
        return r6;
    L9:
        r7 = 0;
        goto L10
    }
}
