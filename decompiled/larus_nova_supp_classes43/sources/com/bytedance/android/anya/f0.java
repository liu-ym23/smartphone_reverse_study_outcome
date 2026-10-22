package com.bytedance.android.anya;

import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f0 {
    public final com.bytedance.android.anya.internal.b a;
    public final Function2<m, Map<Object, ? extends j<?>>, Unit> b;
    public final Function0<Unit> c;

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof f0) == false) goto L12;
        f0 r11 = (f0) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        com.bytedance.android.anya.internal.b r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        Function2<m, Map<Object, ? extends j<?>>, Unit> r12 = this.b;
        if (r12 == null) goto L9;
        int r13 = r12.hashCode();
    L10:
        int r14 = (r11 + r13) * 31;
        Function0<Unit> r15 = this.c;
        if (r15 == null) goto L14;
        r1 = r15.hashCode();
    L14:
        return r14 + r1;
    L9:
        r13 = 0;
        goto L10
    L5:
        r10 = 0;
        goto L6
    }

    public final String toString() {
        return "MutateExternalCallback(executor=" + this.a + ", callback=" + this.b + ", batchDiffCallback=" + this.c + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f0(com.bytedance.android.anya.internal.b r1, Function2<? super m, ? super Map<Object, ? extends j<?>>, Unit> r10, Function0<Unit> r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }
}
