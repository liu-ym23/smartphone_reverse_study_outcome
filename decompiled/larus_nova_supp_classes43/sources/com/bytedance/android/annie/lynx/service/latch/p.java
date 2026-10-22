package com.bytedance.android.annie.lynx.service.latch;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class p<T> implements Predicate {
    public static final p<T> a = null;

    static {
        a = new p();
    }

    public p() {
    }

    public final boolean test(Object r10) {
        b r11 = (b) r10;
        Intrinsics.checkNotNullParameter(r11, "it");
        if (r11 == b.c) goto L5;
        return true;
    L5:
        return false;
    }
}
