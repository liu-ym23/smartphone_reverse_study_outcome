package com.bytedance.android.livesdk.gamesticker.hok;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b<T> implements Predicate {
    public final /* synthetic */ long a;
    public final /* synthetic */ long b;

    public b(long r1, long r3) {
        this.a = r1;
        this.b = r3;
    }

    public final boolean test(Object r6) {
        Long r7 = (Long) r6;
        Intrinsics.checkNotNullParameter(r7, "it");
        long r0 = r7.longValue();
        long r2 = this.a;
        if (r0 == r2) goto L8;
        long r1 = this.b + r2;
        if (r7.longValue() == r1) goto L8;
        return false;
    L8:
        return true;
    }
}
