package mpc;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public final List<String> a;
    public final String b;
    public final String c;
    public final boolean d;
    public final String e;
    public final boolean f;
    public final d g;
    public final String h;

    public c() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
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
        int r0 = this.a.hashCode() * 31;
        String r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (((r0 + r2) * 31) + this.c.hashCode()) * 31;
        int r4 = 1231;
        if (this.d == false) goto L9;
        int r5 = 1231;
    L10:
        int r6 = (((r3 + r5) * 31) + this.e.hashCode()) * 31;
        if (this.f == true) goto L15;
        r4 = 1237;
    L15:
        return ((((r6 + r4) * 31) + this.g.hashCode()) * 31) + this.h.hashCode();
    L9:
        r5 = 1237;
        goto L10
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "ForwardToDoubaoExecuteParams(larkMsgIds=" + this.a + ", extraNote=" + this.b + ", quasiTitle=" + this.c + ", isGroupChat=" + this.d + ", chatId=" + this.e + ", isThreadRootMsg=" + this.f + ", trackParams=" + this.g + ", originMergeForwardId=" + this.h + ')';
    }

    public c(List r3, String r4, String r5, boolean r6, String r7, boolean r8, String r9) {
        d r0 = new d(0);
        Intrinsics.checkNotNullParameter(r3, "larkMsgIds");
        Intrinsics.checkNotNullParameter(r5, "quasiTitle");
        Intrinsics.checkNotNullParameter(r7, "chatId");
        Intrinsics.checkNotNullParameter(r0, "trackParams");
        Intrinsics.checkNotNullParameter(r9, "originMergeForwardId");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r0;
        this.h = r9;
    }
}
