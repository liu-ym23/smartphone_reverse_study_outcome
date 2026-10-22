package com.larus.video.impl.sdk.prefetch;

import com.larus.platform.api.w4;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f {
    public final ConcurrentHashMap<String, w4> a;

    public f() {
        this(0);
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof f) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((f) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "CachedPreloadErrorReasonDataMapWrapper(cachedUserPreloadErrorReasonDataMap=" + this.a + ')';
    }

    public f(ConcurrentHashMap<String, w4> r2) {
        Intrinsics.checkNotNullParameter(r2, "cachedUserPreloadErrorReasonDataMap");
        this.a = r2;
    }

    public /* synthetic */ f(int r1) {
        this(new ConcurrentHashMap());
    }
}
