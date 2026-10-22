package com.bytedance.android.livesdk.gecko;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p implements Executor {
    public static final p a = null;

    public static final class a<T> implements Consumer {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final void accept(Object r1) {
            ((Runnable) r1).run();
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r3) {
            ALogger.e("AAM.Source.TC21GeckoClientImpl", "exec error: " + ((Throwable) r3));
        }
    }

    static {
        a = new p();
    }

    public p() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r3) {
        Observable.just(r3).subscribeOn(Schedulers.io()).subscribe(a.a, b.a);
    }
}
