package com.bytedance.android.livesdk.gift.platform.business.effect.delete;

import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class StorageService implements com.bytedance.android.scope.o {
    public long a;
    public final CompositeDisposable b;
    public final Lazy c;
    public long d;

    public static final class a implements SingleOnSubscribe<Long> {
        public a() {
        }

        public final void subscribe(SingleEmitter<Long> r3) {
            Intrinsics.checkNotNullParameter(r3, "emitter");
            r3.onSuccess(Long.valueOf(com.bytedance.android.live.revenue.core.util.f.a(uy0.b.class).q5()));
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ StorageService a;

        public b(StorageService r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            StorageService r0 = this.a;
            r0.a = ((Long) r6).longValue() / ((long) 1048576);
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public final void a() {
        if (((com.bytedance.android.livesdk.gift.configmodel.q) this.c.getValue()).getEnable() == true) goto L5;
        return;
    L5:
        com.bytedance.live.kmp.util.c r0 = com.bytedance.live.kmp.util.c.a;
        long r1 = System.currentTimeMillis() / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
        if ((r1 - this.d) >= ((com.bytedance.android.livesdk.gift.configmodel.q) this.c.getValue()).L4()) goto L8;
        return;
    L8:
        this.d = r1;
        int r2 = com.bytedance.revenue.platform.api.core.rx.q.a;
        Single r3 = Single.create(new a());
        int r4 = com.bytedance.revenue.platform.api.core.rx.p.a;
        Disposable r5 = r3.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this), c.a);
        this.b.add(r5);
    }

    public final void onStop() {
        this.b.clear();
    }

    public StorageService() {
        this.b = new CompositeDisposable();
        this.c = LazyKt.lazy(StorageService$deviceConfig$2.INSTANCE);
    }

    public final void onStart() {
        a();
    }
}
