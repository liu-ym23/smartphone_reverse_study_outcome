package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q0 extends com.bytedance.android.livesdk.gift.platform.business.effect.assets.o {
    public final /* synthetic */ LifecycleOwner a;
    public final /* synthetic */ LottieAnimationView b;
    public final /* synthetic */ LandscapeToolbarMoreBehavior c;

    public final String d() {
        return "LandscapeToolbarMoreBehavior.loadLottie";
    }

    public final void onFailed(Throwable r1) {
    }

    public final void c(long r2, final String r4) {
        super.c(r2, r4);
        LandscapeToolbarMoreBehavior r3 = this.c;
        SingleSubscribeProxy r5 = (SingleSubscribeProxy) Single.create(new o0(r4)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this.a));
        final LottieAnimationView r6 = this.b;
        r3.R = r5.subscribe(new p0(r6));
    }

    public q0(LandscapeToolbarMoreBehavior r1, FragmentActivity r2, LottieAnimationView r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
