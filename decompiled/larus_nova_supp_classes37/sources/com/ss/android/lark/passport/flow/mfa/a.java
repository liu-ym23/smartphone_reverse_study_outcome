package com.ss.android.lark.passport.flow.mfa;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public final ExternalBidpCallbackPhase a;
    public final long b;

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
        if (this.b == r9.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        long r1 = this.b;
        return r0 + ((int) (r1 ^ (r1 >>> 32)));
    }

    public final String toString() {
        return "ExternalBidpCallbackStatus(phase=" + this.a + ", attempt=" + this.b + ')';
    }

    public a(ExternalBidpCallbackPhase r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "phase");
        this.a = r2;
        this.b = r3;
    }

    public static a a(a r2, ExternalBidpCallbackPhase r3) {
        long r0 = r2.b;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "phase");
        return new a(r3, r0);
    }
}
