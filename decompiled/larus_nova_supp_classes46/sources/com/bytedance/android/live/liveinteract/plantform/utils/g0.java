package com.bytedance.android.live.liveinteract.plantform.utils;

import androidx.lifecycle.LifecycleOwner;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g0 {

    public class a extends com.bytedance.android.livesdk.gift.platform.business.effect.assets.o {
        public final /* synthetic */ LifecycleOwner a;
        public final /* synthetic */ LottieAnimationView b;

        public final String d() {
            return "LottieResourceUtils.loadLottie";
        }

        public final void onFailed(Throwable r1) {
        }

        public a(LifecycleOwner r1, LottieAnimationView r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void c(long r1, final String r3) {
            super.c(r1, r3);
            SingleSubscribeProxy r2 = (SingleSubscribeProxy) Single.create(new e0(r3)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this.a));
            final LottieAnimationView r4 = this.b;
            r2.subscribe(new f0(r4));
        }
    }

    public static void a(long r1, LottieAnimationView r3, LifecycleOwner r4) {
        a r0 = new a(r4, r3);
        boolean r5 = com.bytedance.android.live.revenue.core.util.h.a;
        com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class).getAssetsManager().j4(r1, r0, 2);
    }
}
