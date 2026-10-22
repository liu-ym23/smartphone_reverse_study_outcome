package com.larus.bmhome.social.page.datasource.event;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c<T> implements a<T> {
    public final List<T> a;
    public final long b;
    public final List<b> c;
    public final String d;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof c) == true) goto L8;
        return false;
    L8:
        c r9 = (c) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        long r1 = this.b;
        return ((((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public final String toString() {
        return "ListUpdateEvent(version=" + this.b + ", size=" + this.a.size() + ", rt=" + this.d + ')';
    }

    public /* synthetic */ c(List r7, long r8, List r10) {
        this(r7, r8, r10, "");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(List<? extends T> r2, long r3, List<? extends b> r5, String r6) {
        Intrinsics.checkNotNullParameter(r2, "listData");
        Intrinsics.checkNotNullParameter(r5, "actions");
        Intrinsics.checkNotNullParameter(r6, "refreshTraceId");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r6;
    }

    public static c a(c r6, List r7, long r8, List r10, String r11, int r12) {
        if ((r12 & 1) == 0) goto L5;
        r7 = r6.a;
    L5:
        List r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r8 = r6.b;
    L8:
        long r2 = r8;
        if ((r12 & 4) == 0) goto L11;
        r10 = r6.c;
    L11:
        List r4 = r10;
        if ((r12 & 8) == 0) goto L14;
        r11 = r6.d;
    L14:
        String r5 = r11;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r1, "listData");
        Intrinsics.checkNotNullParameter(r4, "actions");
        Intrinsics.checkNotNullParameter(r5, "refreshTraceId");
        return new c(r1, r2, r4, r5);
    }
}
