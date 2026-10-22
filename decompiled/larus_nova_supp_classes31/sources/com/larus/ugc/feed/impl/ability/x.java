package com.larus.ugc.feed.impl.ability;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class x {
    public final CreationFeedAbilityImpl a;
    public final m0a.i b;
    public final m0a.g c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof x) == true) goto L8;
        return false;
    L8:
        x r6 = (x) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "CreationFeedAndroidAbilityBinding(ability=" + this.a + ", initParams=" + this.b + ", initDependency=" + this.c + ')';
    }

    public x(CreationFeedAbilityImpl r2, m0a.i r3, m0a.g r4) {
        Intrinsics.checkNotNullParameter(r2, "ability");
        Intrinsics.checkNotNullParameter(r3, "initParams");
        Intrinsics.checkNotNullParameter(r4, "initDependency");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
