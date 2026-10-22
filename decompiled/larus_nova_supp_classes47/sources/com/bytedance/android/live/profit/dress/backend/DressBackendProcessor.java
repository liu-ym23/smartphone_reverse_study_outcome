package com.bytedance.android.live.profit.dress.backend;

import com.bytedance.revenue.platform.api.core.rx.q;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class DressBackendProcessor {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Single a(final String r1, final Function1 r2, final Function0 r3, final CompositeDisposable r4) {
        Intrinsics.checkNotNullParameter(r1, "roomId");
        Intrinsics.checkNotNullParameter(r2, "onSuccess");
        Intrinsics.checkNotNullParameter(r3, "onError");
        Intrinsics.checkNotNullParameter(r4, "cd");
        int r0 = q.a;
        final Function0<String> r5 = new DressBackendProcessor$processWithBackendData$1(r1, r3, r2, r4);
        return Single.fromCallable(new a(r5));
    }
}
