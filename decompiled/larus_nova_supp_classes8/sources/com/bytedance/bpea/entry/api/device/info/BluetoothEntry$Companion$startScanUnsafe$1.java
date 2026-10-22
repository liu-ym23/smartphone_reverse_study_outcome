package com.bytedance.bpea.entry.api.device.info;

import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.ReplayUIStateCode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, ReplayUIStateCode.IS_FOLD_OPEN})
final class BluetoothEntry$Companion$startScanUnsafe$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ScanCallback $callback;
    final /* synthetic */ BluetoothLeScanner $this_startScanUnsafe;

    public BluetoothEntry$Companion$startScanUnsafe$1(BluetoothLeScanner r1, ScanCallback r2) {
        this.$this_startScanUnsafe = r1;
        this.$callback = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1604invoke() {
        INVOKEVIRTUAL_com_bytedance_bpea_entry_api_device_info_BluetoothEntry$Companion$startScanUnsafe$1_com_obric_performance_power_monitor_bluetooth_BluetoothLancet_startScan(this.$this_startScanUnsafe, this.$callback);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1604invoke();
        return Unit.INSTANCE;
    }

    public static void INVOKEVIRTUAL_com_bytedance_bpea_entry_api_device_info_BluetoothEntry$Companion$startScanUnsafe$1_com_obric_performance_power_monitor_bluetooth_BluetoothLancet_startScan(BluetoothLeScanner r1, ScanCallback r2) {
        if (fna.g.d() == true) goto L6;
        r1.startScan(r2);
        return;
    L6:
        r1.startScan(r2);
        if (r2 == null) goto L9;
        int r3 = r2.hashCode();
    L10:
        ina.a.b(r3);
        return;
    L9:
        r3 = 0;
        goto L10
    }
}
