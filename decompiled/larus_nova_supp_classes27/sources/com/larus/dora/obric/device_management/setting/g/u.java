package com.larus.dora.obric.device_management.setting.g;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class u {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final String d;

    public u() {
        boolean r2 = false;
        this(r2, r2, null, 15);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof u) == true) goto L8;
        return false;
    L8:
        u r6 = (u) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
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
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.b == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.c == true) goto L14;
        r1 = 1237;
    L14:
        int r5 = (r4 + r1) * 31;
        String r6 = this.d;
        if (r6 != null) goto L17;
        int r7 = 0;
    L19:
        return r5 + r7;
    L17:
        r7 = r6.hashCode();
        goto L19
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "DoraObricGSettingsUiState(isDeviceConnected=" + this.a + ", isReconnecting=" + this.b + ", showDeviceInfoRedDot=" + this.c + ", envObserveStatusText=" + this.d + ')';
    }

    public /* synthetic */ u(boolean r3, boolean r4, String r5, int r6) {
        if ((r6 & 1) == 0) goto L6;
        r3 = true;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = false;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = null;
    L11:
        this(r3, false, r4, r5);
    }

    public u(boolean r1, boolean r2, boolean r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public static u a(u r2, boolean r3, boolean r4, String r5, int r6) {
        if ((r6 & 1) == 0) goto L5;
        boolean r0 = r2.a;
    L7:
        if ((r6 & 2) == 0) goto L10;
        r3 = r2.b;
    L10:
        if ((r6 & 4) == 0) goto L13;
        r4 = r2.c;
    L13:
        if ((r6 & 8) == 0) goto L15;
        r5 = r2.d;
    L15:
        r2.getClass();
        return new u(r0, r3, r4, r5);
    L5:
        r0 = false;
        goto L7
    }
}
