package com.bytedance.android.live.liveinteract.plantform.performance;

import java.util.HashSet;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c0 {
    public final HashSet<String> a;
    public final Function1<? super Map<String, d0>, Unit> b;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c0) == false) goto L10;
        c0 r4 = (c0) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        HashSet<String> r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Function1<? super Map<String, d0>, Unit> r4 = this.b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "PerfAbilityCB(abilityKeys=" + this.a + ", cb=" + this.b + ")";
    }

    public c0(HashSet<String> r2, Function1<? super Map<String, d0>, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "abilityKeys");
        Intrinsics.checkNotNullParameter(r3, "cb");
        this.a = r2;
        this.b = r3;
    }
}
