package com.larus.platform.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class s4 {
    public final OpenPushReminderScene a;
    public final t4 b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof s4) == true) goto L8;
        return false;
    L8:
        s4 r6 = (s4) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        t4 r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "OpenPushReminderData(scene=" + this.a + ", bizInfo=" + this.b + ')';
    }

    public s4(OpenPushReminderScene r2, t4 r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        this.a = r2;
        this.b = r3;
    }
}
