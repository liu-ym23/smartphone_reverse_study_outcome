package sia;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b$a implements BluetoothProfile.ServiceListener {
    public final /* synthetic */ CountDownLatch a;
    public final /* synthetic */ BluetoothDevice[] b;
    public final /* synthetic */ BluetoothAdapter c;

    @Override // android.bluetooth.BluetoothProfile.ServiceListener
    public final void onServiceDisconnected(int r1) {
        this.a.countDown();
    }

    @Override // android.bluetooth.BluetoothProfile.ServiceListener
    public final void onServiceConnected(int r4, BluetoothProfile r5) {
        Intrinsics.checkNotNullParameter(r5, "proxy");
        BluetoothDevice[] r0 = this.b;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L15
        BluetoothDevice r2 = null;
        if ((r5 instanceof BluetoothHeadset) == false) goto L6;
        BluetoothHeadset r3 = (BluetoothHeadset) r5;     // Catch: Throwable -> L15
    L7:
        if (r3 == null) goto L13;
        List<BluetoothDevice> r6 = r3.getConnectedDevices();     // Catch: Throwable -> L15
        if (r6 == null) goto L12;
        r2 = (BluetoothDevice) CollectionsKt.firstOrNull(r6);     // Catch: Throwable -> L15
    L12:
        r0[0] = r2;     // Catch: Throwable -> L15
    L13:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L24:
        this.c.closeProfileProxy(r4, r5);     // Catch: Throwable -> L20
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L20
    L22:
        this.a.countDown();
        return;
    L20:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    L6:
        r3 = null;
    L15:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    }

    public b$a(CountDownLatch r1, BluetoothDevice[] r2, BluetoothAdapter r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
