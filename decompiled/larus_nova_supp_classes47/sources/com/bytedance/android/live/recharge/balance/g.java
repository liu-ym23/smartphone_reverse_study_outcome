package com.bytedance.android.live.recharge.balance;

import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g {
    public static final List<a> a = null;
    public static final g b = null;

    public interface a {
        void a(f r1, com.bytedance.android.live.recharge.l r2);

        void b(uz0.c r1, f r2);

        Observable<com.bytedance.android.live.recharge.l> c(Observable<com.bytedance.android.live.recharge.l> r1);

        void d(f r1);

        void e(f r1, Throwable r2);
    }

    public g() {
    }

    static {
        b = new g();
        a = new ArrayList();
    }
}
