package com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements h {
    public final Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> a;

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.h
    public final void clear() {
        ((ArrayDeque) this.a).clear();
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.h
    public final int size() {
        return ((ArrayDeque) this.a).size();
    }

    public c() {
        this.a = new ArrayDeque();
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.h
    public final com.bytedance.android.livesdk.interactivity.api.entity.f<?> a(Function1<? super com.bytedance.android.livesdk.interactivity.api.entity.f<?>, Boolean> r4) {
        Intrinsics.checkNotNullParameter(r4, "predicate");
        Iterator r0 = ((ArrayDeque) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (((Boolean) r4.invoke(r1)).booleanValue() == false) goto L4;
    L10:
        return (com.bytedance.android.livesdk.interactivity.api.entity.f) r1;
    L8:
        r1 = null;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.h
    public final List<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> b(Function1<? super com.bytedance.android.livesdk.interactivity.api.entity.f<?>, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "predicate");
        return com.bytedance.android.livesdk.interactivity.common.utils.k.c(this.a, r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.h
    public final List<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> e(Function1<? super com.bytedance.android.livesdk.interactivity.api.entity.f<?>, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "predicate");
        return com.bytedance.android.livesdk.interactivity.common.utils.k.d(this.a, r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.h
    public final com.bytedance.android.livesdk.interactivity.api.entity.f<?> c(k r1, boolean r2) {
        return (com.bytedance.android.livesdk.interactivity.api.entity.f) ((ArrayDeque) this.a).poll();
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.h
    public final void d(int r2, com.bytedance.android.livesdk.interactivity.api.entity.f<?> r3, Function2<? super com.bytedance.android.livesdk.interactivity.api.entity.f<?>, ? super List<? extends com.bytedance.android.livesdk.interactivity.api.entity.f<?>>, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r4, "callback");
        com.bytedance.android.livesdk.interactivity.common.utils.k.a(this.a, r2, r3, r4);
    }
}
