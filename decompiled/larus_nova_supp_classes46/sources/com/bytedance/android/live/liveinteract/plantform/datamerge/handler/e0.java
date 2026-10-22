package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e0<T> implements Predicate {
    public static final e0 a = null;

    static {
        a = new e0();
    }

    public e0() {
    }

    public final boolean test(Object r2) {
        b.C0054b r3 = (b.C0054b) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return r3.d;
    }
}
