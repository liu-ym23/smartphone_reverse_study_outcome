package com.bytedance.android.live.schema.helper;

import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.keva.Keva;
import io.reactivex.Completable;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b<T, R> implements Function {
    public final /* synthetic */ Keva a;

    public b(Keva r1) {
        this.a = r1;
    }

    public final Object apply(Object r7) {
        Long r8 = (Long) r7;
        Intrinsics.checkNotNullParameter(r8, "timestamp");
        final long r0 = System.currentTimeMillis() / ((long) WebcastRedirectException.UNKNOWN);
        long r2 = TimeUnit.DAYS.toSeconds(1);
        if ((r0 - r8.longValue()) <= r2) goto L6;
        return Completable.fromCallable(new LynxCacheHelper$evictCacheIfNeed$1$1(this, r0));
    L6:
        return Completable.complete();
    }
}
