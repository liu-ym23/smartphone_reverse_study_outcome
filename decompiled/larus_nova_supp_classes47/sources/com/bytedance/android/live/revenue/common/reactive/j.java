package com.bytedance.android.live.revenue.common.reactive;

import com.bytedance.revenue.platform.api.core.rx.l;
import io.reactivex.Observable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j {
    public static Observable b(c r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$asObservable");
        RxUtilsKt$asObservable$1 r0 = RxUtilsKt$asObservable$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r2, "$this$map");
        Intrinsics.checkNotNullParameter(r0, "mapper");
        return a(new a(r2, r0), true).flatMap(i.a);
    }

    public static final <T> Observable<T> a(e<T> r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$asObservable");
        l r0 = l.a;
        return Observable.create(new g(r1, r2));
    }
}
