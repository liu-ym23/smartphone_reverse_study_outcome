package com.obric.livecard.api;

import java.util.function.Predicate;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class a implements Predicate {
    public final /* synthetic */ Function1 a;

    public /* synthetic */ a(Function1 r1) {
        this.a = r1;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object r2) {
        return LiveCard.a(this.a, r2);
    }
}
