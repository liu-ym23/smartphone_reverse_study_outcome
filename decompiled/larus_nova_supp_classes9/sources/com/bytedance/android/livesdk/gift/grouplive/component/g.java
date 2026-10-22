package com.bytedance.android.livesdk.gift.grouplive.component;

import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ h a;

    public g(h r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        PublishSubject<fa0.b> r0 = this.a.a;
        r0.onNext((fa0.b) r2);
    }
}
