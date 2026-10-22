package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.view.View;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f0 {
    public final String a;
    public final x1 b;
    public final CompositeDisposable c;
    public int d;
    public boolean e;
    public final com.bytedance.android.livesdk.sharedpref.e<Long> f;
    public final View g;
    public final View h;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ f0 a;

        public a(f0 r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Long r4 = (Long) r3;
            f0 r5 = this.a;
            r5.e = true;
            f0.b(r5, r5.g, r5.h);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ f0 a;

        public b(f0 r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Long r4 = (Long) r3;
            f0 r5 = this.a;
            r5.e = false;
            f0.b(r5, r5.h, r5.g);
        }
    }

    public final void c() {
        this.b.getClass();
        TimeUnit r0 = TimeUnit.SECONDS;
        RxUtilKt.c(Observable.timer(15, r0).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this)), this.c);
        this.b.getClass();
        this.b.getClass();
        this.b.getClass();
        RxUtilKt.c(Observable.timer(21, r0).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this)), this.c);
    }

    public f0(LottieAnimationView r3, View r4) {
        Intrinsics.checkNotNullParameter(r3, "mOldView");
        Intrinsics.checkNotNullParameter(r4, "mNewView");
        this.g = r3;
        this.h = r4;
        this.a = "AudienceMoreShareGuider";
        this.b = new x1();
        this.c = new CompositeDisposable();
        this.d = 1;
        this.f = new com.bytedance.android.livesdk.sharedpref.e("live_last_share_guide_show_time", 0L);
    }

    public static final void a(f0 r0, View r1, int r2) {
        r0.getClass();
        r1.setAlpha((r2 * 1.0f) / 255);
    }

    public static final void b(f0 r1, View r2, View r3) {
        r1.getClass();
        com.bytedance.android.livesdk.utils.q4.b r4 = com.bytedance.android.livesdk.utils.u4.c(new AudienceMoreShareGuider$startReplace$animator$1(r1, r3, r2));
        RxUtilKt.c(Disposables.fromAction(new g0(r4)), r1.c);
        r4.c();
    }
}
