package com.bytedance.android.livesdk.chatroom.vs_host.impl;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.vscore_impl.component.tabs.d0;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ vr1.b a;
    public final /* synthetic */ CompositeDisposable b;

    public d(d0 r1, CompositeDisposable r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        sh6.b r4 = (sh6.b) r3;
        c r0 = new c(this);
        s22.e r1 = (s22.e) sh6.c.b(r4);
        if (r1 == null) goto L5;
        r1.addListener(r0);
    L5:
        RxUtilKt.c(Disposables.fromAction(new b(r4, r0)), this.b);
        this.a.b();
    }
}
