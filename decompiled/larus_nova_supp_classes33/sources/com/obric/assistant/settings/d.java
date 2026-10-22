package com.obric.assistant.settings;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class d {
    public final ObricAppListMode a;
    public final Set<String> b;
    public final Set<String> c;
    public final Set<String> d;
    public final Set<String> e;

    public d() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    }

    public final String toString() {
        return "AutoActionAppFilterPolicy(mode=" + this.a + ", blacklistNames=" + this.b + ", whitelistNames=" + this.c + ", saepRestrictedAppNames=" + this.d + ", saepDeclaredAppNames=" + this.e + ')';
    }

    public /* synthetic */ d(int r7) {
        this(ObricAppListMode.BLACK_LIST, SetsKt.emptySet(), SetsKt.emptySet(), SetsKt.emptySet(), SetsKt.emptySet());
    }

    public d(ObricAppListMode r2, Set<String> r3, Set<String> r4, Set<String> r5, Set<String> r6) {
        Intrinsics.checkNotNullParameter(r2, "mode");
        Intrinsics.checkNotNullParameter(r3, "blacklistNames");
        Intrinsics.checkNotNullParameter(r4, "whitelistNames");
        Intrinsics.checkNotNullParameter(r5, "saepRestrictedAppNames");
        Intrinsics.checkNotNullParameter(r6, "saepDeclaredAppNames");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
