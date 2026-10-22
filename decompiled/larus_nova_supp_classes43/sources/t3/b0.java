package t3;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b0 extends ScanCallback {
    public final /* synthetic */ y a;
    public final /* synthetic */ BluetoothAdapter b;

    @Override // android.bluetooth.le.ScanCallback
    public final void onBatchScanResults(List<ScanResult> r10) {
        Intrinsics.checkNotNullParameter(r10, "results");
        y r0 = this.a;
        Iterator<T> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r0.h((ScanResult) r11.next());
        goto L4
    }

    @Override // android.bluetooth.le.ScanCallback
    public final void onScanFailed(int r10) {
        this.a.i = null;
        this.a.d = false;
        this.a.k(this.b.isEnabled(), false, false);
    }

    public b0(y r1, BluetoothAdapter r10) {
        this.a = r1;
        this.b = r10;
    }

    @Override // android.bluetooth.le.ScanCallback
    public final void onScanResult(int r1, ScanResult r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_RESULT);
        this.a.h(r10);
    }
}
