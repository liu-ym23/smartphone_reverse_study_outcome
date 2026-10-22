package com.obric.miniapp.alarm;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class e0 {
    public final String a;
    public final q b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e0) == true) goto L8;
        return false;
    L8:
        e0 r6 = (e0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "PendingEntry(alarmId='" + this.a + "', payload=" + this.b + ')';
    }

    public e0(String r2, q r3) {
        Intrinsics.checkNotNullParameter(r2, "alarmId");
        Intrinsics.checkNotNullParameter(r3, "payload");
        this.a = r2;
        this.b = r3;
    }
}
