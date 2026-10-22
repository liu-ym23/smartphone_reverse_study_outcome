package com.obric.assistant.dora;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class i {
    public final String a;
    public final DoraBleDevice b;
    public final boolean c;
    public final t39.d d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i) == true) goto L8;
        return false;
    L8:
        i r6 = (i) r5;
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
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        if (this.c == false) goto L5;
        int r1 = 1231;
    L7:
        return ((r0 + r1) * 31) + this.d.hashCode();
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "PendingAutoBindRequest(requestId=" + this.a + ", device=" + this.b + ", isH=" + this.c + ", doraDeviceInfo=" + this.d + ')';
    }

    public i(String r2, DoraBleDevice r3, boolean r4, t39.d r5) {
        Intrinsics.checkNotNullParameter(r2, "requestId");
        Intrinsics.checkNotNullParameter(r3, "device");
        Intrinsics.checkNotNullParameter(r5, "doraDeviceInfo");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
