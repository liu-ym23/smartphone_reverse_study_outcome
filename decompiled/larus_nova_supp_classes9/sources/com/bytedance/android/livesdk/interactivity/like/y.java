package com.bytedance.android.livesdk.interactivity.like;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class y<T> implements Predicate {
    public final /* synthetic */ DiggWidget.c a;

    public y(DiggWidget.c r1) {
        this.a = r1;
    }

    public final boolean test(Object r2) {
        Intrinsics.checkNotNullParameter((Long) r2, "it");
        if (this.a.e <= 0) goto L5;
        return true;
    L5:
        return false;
    }
}
