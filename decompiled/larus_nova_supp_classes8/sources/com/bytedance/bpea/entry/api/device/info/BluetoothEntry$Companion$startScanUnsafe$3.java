package com.bytedance.bpea.entry.api.device.info;

import android.app.PendingIntent;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanSettings;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.ReplayUIStateCode;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, ReplayUIStateCode.IS_FOLD_OPEN})
final class BluetoothEntry$Companion$startScanUnsafe$3 extends Lambda implements Function0<Integer> {
    final /* synthetic */ PendingIntent $callbackIntent;
    final /* synthetic */ List $filters;
    final /* synthetic */ ScanSettings $settings;
    final /* synthetic */ BluetoothLeScanner $this_startScanUnsafe;

    public BluetoothEntry$Companion$startScanUnsafe$3(BluetoothLeScanner r1, List r2, ScanSettings r3, PendingIntent r4) {
        this.$this_startScanUnsafe = r1;
        this.$filters = r2;
        this.$settings = r3;
        this.$callbackIntent = r4;
        super(0);
    }

    public final int invoke() {
        return this.$this_startScanUnsafe.startScan(this.$filters, this.$settings, this.$callbackIntent);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1606invoke() {
        return Integer.valueOf(invoke());
    }
}
