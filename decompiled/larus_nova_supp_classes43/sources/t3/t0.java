package t3;

import android.bluetooth.BluetoothGatt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class t0 {
    public final String a;
    public final BluetoothGatt b;
    public final s0 c;
    public volatile boolean d;
    public volatile int e;
    public volatile int f;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof t0) == true) goto L8;
        return false;
    L8:
        t0 r11 = (t0) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r11.d) goto L21;
        return false;
    L21:
        if (this.e == r11.e) goto L24;
        return false;
    L24:
        if (this.f == r11.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        if (this.d == false) goto L5;
        int r1 = 1231;
    L7:
        return ((((r0 + r1) * 31) + this.e) * 31) + this.f;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "GattSession(deviceId=" + this.a + ", gatt=" + this.b + ", callback=" + this.c + ", connected=" + this.d + ", mtu=" + this.e + ", lastRssi=" + this.f + ')';
    }

    public t0(String r10, BluetoothGatt r11, s0 r12) {
        Intrinsics.checkNotNullParameter(r10, "deviceId");
        Intrinsics.checkNotNullParameter(r11, "gatt");
        Intrinsics.checkNotNullParameter(r12, "callback");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = false;
        this.e = 23;
        this.f = 0;
    }
}
