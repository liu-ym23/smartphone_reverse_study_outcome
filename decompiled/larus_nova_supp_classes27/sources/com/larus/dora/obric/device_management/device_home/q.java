package com.larus.dora.obric.device_management.device_home;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class q {
    public final String a;
    public final r b;
    public final DoraObricDeviceModeEntryProduct c;
    public final h3 d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof q) == true) goto L8;
        return false;
    L8:
        q r6 = (q) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public final String toString() {
        return "DoraObricDeviceHomeDeviceCardItem(deviceMac=" + this.a + ", card=" + this.b + ", modeEntryProduct=" + this.c + ", glassesMode=" + this.d + ')';
    }

    public q(String r2, r r3, DoraObricDeviceModeEntryProduct r4, h3 r5) {
        Intrinsics.checkNotNullParameter(r2, "deviceMac");
        Intrinsics.checkNotNullParameter(r3, "card");
        Intrinsics.checkNotNullParameter(r4, "modeEntryProduct");
        Intrinsics.checkNotNullParameter(r5, "glassesMode");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
