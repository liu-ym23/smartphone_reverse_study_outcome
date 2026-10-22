package com.bytedance.android.live.core.utils.rxutils;

import com.bytedance.android.live.base.model.exception.NetworkErrorException;
import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l implements Function<Observable<Throwable>, ObservableSource<?>> {
    public final int a;
    public final long b;
    public int c;
    public final a d;

    public static class a {
        public a() {
        }

        public boolean a(Throwable r3, int r4) {
            ALogger.w("ObservableRetryFunction", "exception=" + r3.getMessage() + " retryCount=" + r4);
            if ((r3 instanceof NetworkErrorException) == false) goto L10;
            NetworkErrorException r5 = (NetworkErrorException) r3;
            if (r5.getStatusCode() >= 500) goto L7;
            return false;
        L7:
            if (r5.getStatusCode() > 599) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }
    }

    public final Object apply(Object r2) throws Exception {
        return ((Observable) r2).flatMap(new k(this));
    }

    public l(int r2, long r3) {
        this(r2, r3, new a());
    }

    public l(int r3, long r4, a r6) {
        this.c = 0;
        if (r3 > 0) goto L6;
        r3 = 1;
    L6:
        this.a = r3;
        if (r4 > 0) goto L10;
        r4 = 500;
    L10:
        this.b = r4;
        this.d = r6;
    }
}
