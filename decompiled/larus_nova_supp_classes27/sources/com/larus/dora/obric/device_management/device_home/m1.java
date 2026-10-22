package com.larus.dora.obric.device_management.device_home;

import com.larus.dora.impl.resource.DoraResourceDeviceType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class m1 {
    public final DoraObricDeviceHomeQuickActionType a;
    public final String b;
    public final int c;
    public final String d;
    public final DoraResourceDeviceType e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof m1) == true) goto L8;
        return false;
    L8:
        m1 r6 = (m1) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c) * 31;
        String r1 = this.d;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        DoraResourceDeviceType r5 = this.e;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "DoraObricDeviceHomeQuickAction(type=" + this.a + ", title=" + this.b + ", iconResId=" + this.c + ", iconResourceName=" + this.d + ", iconResourceDeviceType=" + this.e + ')';
    }

    public final DoraObricDeviceHomeQuickActionType getType() {
        return this.a;
    }

    public m1(DoraObricDeviceHomeQuickActionType r2, String r3, int r4, String r5, DoraResourceDeviceType r6) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "title");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }

    public /* synthetic */ m1(DoraObricDeviceHomeQuickActionType r7, String r8, int r9, String r10, int r11) {
        if ((r11 & 8) == 0) goto L5;
        r10 = null;
    L5:
        this(r7, r8, r9, r10, null);
    }
}
