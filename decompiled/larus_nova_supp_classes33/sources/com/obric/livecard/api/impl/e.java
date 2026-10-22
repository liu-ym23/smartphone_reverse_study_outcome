package com.obric.livecard.api.impl;

import java.util.function.Predicate;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class e implements Predicate {
    public final /* synthetic */ Function1 a;

    public /* synthetic */ e(Function1 r1) {
        this.a = r1;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object r2) {
        return IslandImpl.destroySession.2.a(this.a, r2);
    }
}
