package t3;

import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class i extends ScanCallback {
    public i() {
    }

    @Override // android.bluetooth.le.ScanCallback
    public final void onBatchScanResults(List<ScanResult> r10) {
        Intrinsics.checkNotNullParameter(r10, "results");
        com.bytedance.ai.bridge.method.device.a r0 = com.bytedance.ai.bridge.method.device.a.a;
        Iterator<T> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        com.bytedance.ai.bridge.method.device.a.a(r0, (ScanResult) r11.next());
        goto L4
    }

    @Override // android.bluetooth.le.ScanCallback
    public final void onScanFailed(int r1) {
        com.bytedance.ai.bridge.method.device.a r10 = com.bytedance.ai.bridge.method.device.a.a;
    }

    @Override // android.bluetooth.le.ScanCallback
    public final void onScanResult(int r1, ScanResult r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_RESULT);
        com.bytedance.ai.bridge.method.device.a.a(com.bytedance.ai.bridge.method.device.a.a, r10);
    }
}
