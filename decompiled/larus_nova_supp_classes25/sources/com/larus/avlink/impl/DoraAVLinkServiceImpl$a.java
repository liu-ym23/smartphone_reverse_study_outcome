package com.larus.avlink.impl;

import kotlin.jvm.internal.Intrinsics;
import r98.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class DoraAVLinkServiceImpl$a {
    public final b a;
    public final com.larus.avlink.gallery.business.c b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DoraAVLinkServiceImpl$a) == true) goto L8;
        return false;
    L8:
        DoraAVLinkServiceImpl$a r6 = (DoraAVLinkServiceImpl$a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "AlbumMediaListenerRegistration(lifecycleListener=" + this.a + ", changeListener=" + this.b + ')';
    }

    public DoraAVLinkServiceImpl$a(k r2, f r3) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleListener");
        Intrinsics.checkNotNullParameter(r3, "changeListener");
        this.a = r2;
        this.b = r3;
    }
}
