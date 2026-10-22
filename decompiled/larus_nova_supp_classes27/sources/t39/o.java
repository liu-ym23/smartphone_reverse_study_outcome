package t39;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class o {
    public final String a;
    public final int b;
    public final int c;
    public final int d;
    public final long e;
    public final int f;
    public final int g;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof o) == true) goto L8;
        return false;
    L8:
        o r9 = (o) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31;
        long r1 = this.e;
        return ((((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.f) * 31) + this.g;
    }

    public final String toString() {
        return "BluetoothBandwidthPhoneEnvironmentInfo(networkStatus=" + this.a + ", a2dpPlayingState=" + this.b + ", bluetoothConnectedDeviceCount=" + this.c + ", glassesConnectedPhoneCount=" + this.d + ", glassesConnectedPhoneCountUpdateTimeMs=" + this.e + ", transportRttAvg=" + this.f + ", transportRttMax=" + this.g + ')';
    }

    public o(String r2, int r3, int r4, int r5, long r6, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r2, "networkStatus");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r8;
        this.g = r9;
    }
}
