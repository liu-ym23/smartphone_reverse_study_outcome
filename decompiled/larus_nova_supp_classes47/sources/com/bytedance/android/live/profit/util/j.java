package com.bytedance.android.live.profit.util;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j<T, R> implements Function {
    public final /* synthetic */ com.bytedance.android.livesdk.revenue.service.user.a a;
    public final /* synthetic */ HashMap b;
    public final /* synthetic */ Ref.IntRef c;
    public final /* synthetic */ Ref.LongRef d;
    public final /* synthetic */ Ref.IntRef e;

    public j(com.bytedance.android.livesdk.revenue.service.user.a r1, HashMap r2, Ref.IntRef r3, Ref.LongRef r4, Ref.IntRef r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final Object apply(Object r2) {
        Intrinsics.checkNotNullParameter((Long) r2, "it");
        return this.a.W1(this.b).toObservable().onErrorResumeNext(Observable.empty()).map(new i(this));
    }
}
