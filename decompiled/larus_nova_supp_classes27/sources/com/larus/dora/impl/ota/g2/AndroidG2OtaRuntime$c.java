package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class AndroidG2OtaRuntime$c {
    private final e device;
    private final long operationId;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof AndroidG2OtaRuntime$c) == true) goto L8;
        return false;
    L8:
        AndroidG2OtaRuntime$c r9 = (AndroidG2OtaRuntime$c) r8;
        if (Intrinsics.areEqual(this.device, r9.device) == true) goto L12;
        return false;
    L12:
        if (this.operationId == r9.operationId) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.device.hashCode() * 31;
        long r1 = this.operationId;
        return r0 + ((int) (r1 ^ (r1 >>> 32)));
    }

    public final String toString() {
        return "OperationKey(device=" + this.device + ", operationId=" + this.operationId + ')';
    }

    public AndroidG2OtaRuntime$c(e r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "device");
        this.device = r2;
        this.operationId = r3;
    }
}
