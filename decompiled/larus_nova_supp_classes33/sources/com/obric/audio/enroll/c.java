package com.obric.audio.enroll;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class c {
    public final String a;
    public final int b;
    public final int c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b) * 31) + this.c;
    }

    public final String toString() {
        return "EnrolledDeviceBluetoothInfo(deviceName=" + this.a + ", blueDeviceTypeValue=" + this.b + ", blueProductIdValue=" + this.c + ')';
    }

    public c(String r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "deviceName");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
