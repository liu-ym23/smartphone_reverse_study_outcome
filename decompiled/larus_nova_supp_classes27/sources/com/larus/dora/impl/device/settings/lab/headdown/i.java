package com.larus.dora.impl.device.settings.lab.headdown;

import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class i {
    public final a a;
    public final boolean b;

    public i() {
        this(false, 3);
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
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "HeadDownDetectionUiState(page=" + this.a + ", isWearing=" + this.b + ')';
    }

    public final boolean b() {
        a r0 = this.a;
        if ((r0 instanceof a.c) == false) goto L5;
    L14:
        return true;
    L5:
        if ((r0 instanceof a.d) == true) goto L14;
        if ((r0 instanceof a.C0049a) == true) goto L14;
        if ((r0 instanceof a.e) == true) goto L14;
        if ((r0 instanceof a.b) == true) goto L14;
        return false;
    }

    public /* synthetic */ i(boolean r2, int r3) {
        if ((r3 & 1) == 0) goto L5;
        a.c r0 = a.c.a;
    L7:
        if ((r3 & 2) == 0) goto L9;
        CopyOnWriteArraySet r4 = t69.g.a;
        r2 = t69.g.b();
    L9:
        this(r0, r2);
        return;
    L5:
        r0 = null;
        goto L7
    }

    public i(a r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "page");
        this.a = r2;
        this.b = r3;
    }

    public static i a(i r1, a r2, boolean r3, int r4) {
        if ((r4 & 1) == 0) goto L6;
        r2 = r1.a;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = r1.b;
    L8:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "page");
        return new i(r2, r3);
    }
}
