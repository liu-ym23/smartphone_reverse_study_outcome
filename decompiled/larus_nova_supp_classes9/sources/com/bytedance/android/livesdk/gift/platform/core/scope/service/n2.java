package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n2<T> implements Consumer {
    public final /* synthetic */ o2 a;
    public final /* synthetic */ Ref.LongRef b;
    public final /* synthetic */ Ref.LongRef c;

    public n2(o2 r1, Ref.LongRef r2, Ref.LongRef r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r6) {
        Long r7 = (Long) r6;
        Ref.LongRef r8 = this.b;
        long r0 = r8.element;
        Ref.LongRef r2 = this.c;
        long r1 = r0 - r2.element;
        r8.element = r1;
        long r3 = r2.element;
        if (r1 >= r3) goto L5;
        o2.a(this.a, r3, true);
        return;
    L5:
        o2.a(this.a, r3, false);
    }
}
