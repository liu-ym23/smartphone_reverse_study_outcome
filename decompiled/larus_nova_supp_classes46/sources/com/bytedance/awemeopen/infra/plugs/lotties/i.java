package com.bytedance.awemeopen.infra.plugs.lotties;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.LottieTask;
import com.bytedance.awemeopen.infra.base.anim.lottie.AoAnimationLottieView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i implements com.bytedance.awemeopen.servicesapi.ui.c {
    public final LottieTask<LottieComposition> a;

    public i(LottieTask<LottieComposition> r2) {
        Intrinsics.checkNotNullParameter(r2, "lottieTask");
        this.a = r2;
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.c
    public final i a(AoAnimationLottieView.d r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        Object r3 = r2.a;
        if ((r3 instanceof LottieListener) == false) goto L7;
        this.a.removeFailureListener((LottieListener) r3);
        return this;
    L7:
        throw new IllegalStateException("listener is not a LottieListener");
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.c
    public final i b(AoAnimationLottieView.e r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        Object r3 = r2.a;
        if ((r3 instanceof LottieListener) == false) goto L7;
        this.a.removeListener((LottieListener) r3);
        return this;
    L7:
        throw new IllegalStateException("listener is not a LottieListener");
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.c
    public final i c(final AoAnimationLottieView.e r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        final Function1<LottieComposition, Unit> r0 = new LottieTaskWrapperImpl$addListener$callback$1(r3);
        this.a.addListener(new g(r0));
        return this;
    }

    public final i d(final AoAnimationLottieView.d r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        final Function1<Throwable, Unit> r0 = new LottieTaskWrapperImpl$addFailureListener$callback$1(r3);
        r3.a = r0;
        this.a.addFailureListener(new h(r0));
        return this;
    }
}
