package com.bytedance.android.livesdk.chatroom.ui;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class v7<T> implements LottieListener {
    public final /* synthetic */ LiveSkeletonScreenLoadingView a;

    public v7(LiveSkeletonScreenLoadingView r1) {
        this.a = r1;
    }

    public final void onResult(Object r2) {
        LottieComposition r3 = (LottieComposition) r2;
        LottieAnimationView r0 = this.a.a;
        if (r0 == null) goto L5;
        r0.setComposition(r3);
    L5:
        LottieAnimationView r4 = this.a.a;
        if (r4 == null) goto L9;
        r4.playAnimation();
        return;
    }
}
