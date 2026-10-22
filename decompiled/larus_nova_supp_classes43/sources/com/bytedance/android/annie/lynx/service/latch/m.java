package com.bytedance.android.annie.lynx.service.latch;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class m<T, R> implements Function {
    public final /* synthetic */ k a;

    public m(k r1) {
        this.a = r1;
    }

    public final Object apply(Object r10) {
        com.bytedance.android.annie.service.prefetch.n r11 = (com.bytedance.android.annie.service.prefetch.n) r10;
        Intrinsics.checkNotNullParameter(r11, "loader");
        return Observable.fromIterable((Iterable) this.a.a.invoke()).map(new l(this.a, r11));
    }
}
