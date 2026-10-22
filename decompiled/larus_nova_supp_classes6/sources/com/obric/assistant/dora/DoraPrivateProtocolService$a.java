package com.obric.assistant.dora;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class DoraPrivateProtocolService$a {
    public final IDoraPrivateProtocolCallback a;
    public final Set<DoraPrivateProtocolService$BatteryDeviceType> b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DoraPrivateProtocolService$a) == true) goto L8;
        return false;
    L8:
        DoraPrivateProtocolService$a r6 = (DoraPrivateProtocolService$a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        Set<DoraPrivateProtocolService$BatteryDeviceType> r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "CallbackRegistration(callback=" + this.a + ", deviceTypes=" + this.b + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DoraPrivateProtocolService$a(IDoraPrivateProtocolCallback r2, Set<? extends DoraPrivateProtocolService$BatteryDeviceType> r3) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.a = r2;
        this.b = r3;
    }
}
