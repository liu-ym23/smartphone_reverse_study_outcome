package com.larus.dora.obric.device_management.setting.common.name;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class i {
    public final String a;
    public final String b;
    public final boolean c;

    public i() {
        this(0);
    }

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
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        String r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (r0 + r2) * 31;
        if (this.c == false) goto L9;
        int r4 = 1231;
    L11:
        return r3 + r4;
    L9:
        r4 = 1237;
        goto L11
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "DoraObricDeviceNameUiState(deviceName=" + this.a + ", macAddress=" + this.b + ", doubleConfirm=" + this.c + ')';
    }

    public /* synthetic */ i(int r3) {
        this("", null, false);
    }

    public i(String r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "deviceName");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
