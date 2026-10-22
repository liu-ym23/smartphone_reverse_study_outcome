package com.larus.bmhome.chat.tips;

import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static final Lazy<LinkedHashMap<Integer, Integer>> e = null;
    public final int a;
    public final String b;
    public final String c;
    public final long d;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.tips.a$a, reason: collision with other inner class name */
    public static final class C0010a {
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
        return false;
    L8:
        a r9 = (a) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        long r1 = this.d;
        return r0 + ((int) (r1 ^ (r1 >>> 32)));
    }

    public final String toString() {
        return "GuideTip(tipType=" + this.a + ", tipContent=" + this.b + ", tipSubContent=" + this.c + ", duration=" + this.d + ')';
    }

    static {
        e = LazyKt.lazy(new jo8.a());
    }

    public /* synthetic */ a(int r7, String r8, String r9) {
        this(r7, r8, r9, 0);
    }

    public a(@GuideTipType int r2, String r3, String r4, long r5) {
        Intrinsics.checkNotNullParameter(r3, "tipContent");
        Intrinsics.checkNotNullParameter(r4, "tipSubContent");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
