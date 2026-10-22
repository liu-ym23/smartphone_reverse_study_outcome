package com.bytedance.android.live.revenue.common;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o0 implements ObservableOnSubscribe<Object> {
    public final /* synthetic */ Function1 a;

    public o0(Function1 r1) {
        this.a = r1;
    }

    public final void subscribe(ObservableEmitter<Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "emitter");
        this.a.invoke(r2);
    }
}
