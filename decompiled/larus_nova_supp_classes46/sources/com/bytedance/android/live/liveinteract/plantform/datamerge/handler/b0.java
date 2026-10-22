package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b0<T> implements Predicate {
    public static final b0 a = null;

    static {
        a = new b0();
    }

    public b0() {
    }

    public final boolean test(Object r2) {
        b.C0054b r3 = (b.C0054b) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return r3.c;
    }
}
