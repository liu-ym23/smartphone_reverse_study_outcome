package com.bytedance.android.live.revenue.platform.container.impl;

import android.content.Context;
import com.bytedance.platform.aio.channel.RpcException;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class s0<T, R> implements Function {
    public final /* synthetic */ RpcMethodImpl a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ RpcMethodImpl.a c;

    public s0(RpcMethodImpl r1, Context r2, RpcMethodImpl.a r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object apply(Object r4) {
        RpcException r5 = (Throwable) r4;
        Intrinsics.checkNotNullParameter(r5, "throwable");
        this.a.getClass();
        if ((r5 instanceof RpcException) == false) goto L11;
        RpcException r0 = r5;
        if (Intrinsics.areEqual(r0.getRpcCategory(), "no_such_method") == false) goto L7;
    L10:
        boolean r1 = true;
    L12:
        if (r1 == false) goto L19;
        jy0.b.c("lifengji", "step into fallback, error is: " + r5, null, 4);
        RpcMethodImpl r6 = this.a;
        Context r2 = this.b;
        String r3 = r6.d;
        if (r3 == null) goto L16;
        Single r7 = Single.just(r3);
    L20:
        return r7.map(new r0(this)).toObservable();
    L16:
        RpcMethodImpl.c r8 = (RpcMethodImpl.c) r6.c.getValue();
        Intrinsics.checkNotNull(r8);
        String r9 = r8.a;
        Intrinsics.checkNotNullParameter(r9, "url");
        Intrinsics.checkNotNullParameter(r2, "context");
        r7 = Single.create(new com.bytedance.android.live.revenue.platform.router.impl.e(r9)).doOnSuccess(new t0(r6));
        goto L20
    L19:
        return Observable.error(r5);
    L7:
        if (Intrinsics.areEqual(r0.getRpcCategory(), "no_such_service") == true) goto L10;
        if (Intrinsics.areEqual(r0.getRpcCategory(), "interface_not_defined") == true) goto L10;
    L11:
        r1 = false;
        goto L12
    }
}
