package com.bytedance.android.live.profit.scoreboard;

import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i0<T> implements Consumer {
    public final /* synthetic */ j0 a;

    public i0(j0 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        PublishSubject<dv0.h> r0 = this.a.a.c;
        r0.onNext((dv0.h) r2);
    }
}
