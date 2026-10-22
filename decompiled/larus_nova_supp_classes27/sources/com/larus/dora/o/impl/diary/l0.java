package com.larus.dora.o.impl.diary;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class l0 {
    public final int a;
    public final String b;
    public final String c;
    public final int d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof l0) == true) goto L8;
        return false;
    L8:
        l0 r6 = (l0) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.a * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d;
    }

    public final String toString() {
        return "ODiaryFeedbackTarget(targetType=" + this.a + ", targetId=" + this.b + ", snapshotJson=" + this.c + ", diaryVersion=" + this.d + ')';
    }

    public l0(int r2, String r3, String r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "targetId");
        Intrinsics.checkNotNullParameter(r4, "snapshotJson");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
