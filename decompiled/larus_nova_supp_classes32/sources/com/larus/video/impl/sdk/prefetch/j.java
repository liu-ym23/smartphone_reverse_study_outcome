package com.larus.video.impl.sdk.prefetch;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class j {
    public final ConcurrentHashMap<String, c> a;

    public j() {
        this(0);
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof j) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((j) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "CachedUserFirstClickMessageVideoDataMapWrapper(cachedUserFirstClickMessageVideoDataMap=" + this.a + ')';
    }

    public j(ConcurrentHashMap<String, c> r2) {
        Intrinsics.checkNotNullParameter(r2, "cachedUserFirstClickMessageVideoDataMap");
        this.a = r2;
    }

    public /* synthetic */ j(int r1) {
        this(new ConcurrentHashMap());
    }
}
