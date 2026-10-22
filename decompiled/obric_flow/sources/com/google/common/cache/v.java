package com.google.common.cache;

import com.google.common.collect.p7;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class v implements BiPredicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Predicate f8772b;

    public /* synthetic */ v(Predicate r5, int r10) {
        this.f8771a = r10;
        this.f8772b = r5;
    }

    @Override // java.util.function.BiPredicate
    public final boolean test(Object r5, Object r10) {
        switch(this.f8771a) {
            case 0: goto L6;
            default: goto L5;
        };
    L6:
        Map.Entry r11 = p7.L(r5, r10);
        return this.f8772b.test(r11);
    L5:
        return this.f8772b.test(r10);
    }
}
