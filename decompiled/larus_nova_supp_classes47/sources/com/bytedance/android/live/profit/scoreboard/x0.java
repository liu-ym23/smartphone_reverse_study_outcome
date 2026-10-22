package com.bytedance.android.live.profit.scoreboard;

import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class x0<T> implements Consumer {
    public final /* synthetic */ r0 a;
    public final /* synthetic */ dv0.f b;

    public x0(r0 r1, dv0.f r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        PublishSubject r0 = this.a.c.o();
        dv0.f r1 = this.b;
        r0.onNext(TuplesKt.to(r1, (Boolean) r3));
    }
}
