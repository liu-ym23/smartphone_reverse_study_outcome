package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m2<T> implements Predicate {
    public final /* synthetic */ Ref.LongRef a;

    public m2(Ref.LongRef r1) {
        this.a = r1;
    }

    public final boolean test(Object r5) {
        Intrinsics.checkNotNullParameter((Long) r5, "it");
        if (this.a.element <= 0) goto L5;
        return true;
    L5:
        return false;
    }
}
