package com.larus.bmhome.taskskill.service;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class i {
    public final List<h> a;
    public final boolean b;
    public final boolean c;

    public i() {
        this(false, 7);
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
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        int r2 = 1231;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.c == true) goto L11;
        r2 = 1237;
    L11:
        return r3 + r2;
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "ProjectListSnapshot(items=" + this.a + ", hasMore=" + this.b + ", isInitialized=" + this.c + ')';
    }

    public /* synthetic */ i(boolean r4, int r5) {
        if ((r5 & 1) == 0) goto L5;
        List r0 = CollectionsKt.emptyList();
    L7:
        if ((r5 & 2) == 0) goto L9;
        boolean r1 = true;
    L11:
        if ((r5 & 4) == 0) goto L13;
        r4 = false;
    L13:
        this(r0, r1, r4);
        return;
    L9:
        r1 = false;
        goto L11
    L5:
        r0 = null;
        goto L7
    }

    public static i a(i r2, List r3) {
        boolean r0 = r2.b;
        boolean r1 = r2.c;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "items");
        return new i(r3, r0, r1);
    }

    public i(List<h> r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "items");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
