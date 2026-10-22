package com.larus.dora.impl.device.ota;

import com.bytedance.dora.device.DoraDevice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraOTAManagement$a {
    public final DoraDevice a;
    public final String b;
    public final z39.a c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DoraOTAManagement$a) == true) goto L8;
        return false;
    L8:
        DoraOTAManagement$a r6 = (DoraOTAManagement$a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        String r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + this.c.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "StartDataTransferParams(device=" + this.a + ", filePath=" + this.b + ", response=" + this.c + ')';
    }

    public DoraOTAManagement$a(DoraDevice r2, String r3, z39.a r4) {
        Intrinsics.checkNotNullParameter(r2, "device");
        Intrinsics.checkNotNullParameter(r4, "response");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
