package com.bytedance.android.live.revenue.platform.container.impl;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p0<T> implements Consumer {
    public final /* synthetic */ RpcMethodImpl a;
    public final /* synthetic */ RpcMethodImpl.a b;
    public final /* synthetic */ Function1 c;
    public final /* synthetic */ Function1 d;
    public final /* synthetic */ Function0 e;
    public final /* synthetic */ CompositeDisposable f;

    public p0(RpcMethodImpl r1, RpcMethodImpl.a r2, Function1 r3, Function1 r4, Function0 r5, CompositeDisposable r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public final void accept(Object r5) {
        com.bytedance.platform.aio.a r6 = (com.bytedance.platform.aio.a) r5;
        Intrinsics.checkNotNullParameter(r6, "jsDriver");
        RpcMethodImpl r0 = this.a;
        Observable r7 = r6.c(r0.e, r0.a, RpcMethodImpl.c(this.b, r0.b)).a;
        Function1 r1 = this.c;
        if (r1 == null) goto L5;
        r1 = new RpcMethodImpl.e(r1);
    L5:
        Consumer r2 = (Consumer) r1;
        Function1 r3 = this.d;
        if (r3 == null) goto L8;
        r3 = new RpcMethodImpl.e(r3);
    L8:
        Consumer r4 = (Consumer) r3;
        Function0 r8 = this.e;
        if (r8 == null) goto L11;
        r8 = new RpcMethodImpl.d(r8);
    L11:
        RxUtilKt.c(r7.subscribe(r2, r4, (Action) r8), this.f);
    }
}
