package com.bytedance.android.live.liveinteract.plantform.datamergev2.handler;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class u<T> implements Predicate {
    public static final u a = null;

    static {
        a = new u();
    }

    public u() {
    }

    public final boolean test(Object r2) {
        com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.C0054b r3 = (com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.C0054b) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return r3.c;
    }
}
