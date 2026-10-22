package com.larus.common.account.platform.larklogin;

import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarkOAuthSessionCoordinator$a {
    public final LarkOAuthSessionCoordinator$e a;
    public final LarkOAuthSessionCoordinator$Kind b;
    public final LarkOAuthSessionCoordinator$d c;
    public final Function3<String, String, String, Unit> d;
    public final List<Function1<LarkOAuthSessionCoordinator$c, Unit>> e;
    public LarkOAuthSessionCoordinator$Phase f;
    public String g;
    public Long h;

    public LarkOAuthSessionCoordinator$a() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof LarkOAuthSessionCoordinator$a) == true) goto L8;
        return false;
    L8:
        LarkOAuthSessionCoordinator$a r6 = (LarkOAuthSessionCoordinator$a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        LarkOAuthSessionCoordinator$d r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((((((r0 + r3) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
        String r5 = this.g;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Long r8 = this.h;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "ActiveSession(session=" + this.a + ", kind=" + this.b + ", requestKey=" + this.c + ", exchange=" + this.d + ", completions=" + this.e + ", phase=" + this.f + ", authorizationCode=" + this.g + ", codeSequence=" + this.h + ')';
    }

    public LarkOAuthSessionCoordinator$a(LarkOAuthSessionCoordinator$e r3, LarkOAuthSessionCoordinator$Kind r4, LarkOAuthSessionCoordinator$d r5, Function3 r6, List r7) {
        LarkOAuthSessionCoordinator$Phase r0 = LarkOAuthSessionCoordinator$Phase.AUTHORIZING;
        Intrinsics.checkNotNullParameter(r3, "session");
        Intrinsics.checkNotNullParameter(r4, "kind");
        Intrinsics.checkNotNullParameter(r6, "exchange");
        Intrinsics.checkNotNullParameter(r7, "completions");
        Intrinsics.checkNotNullParameter(r0, "phase");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r0;
        this.g = null;
        this.h = null;
    }
}
