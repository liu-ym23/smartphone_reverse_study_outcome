package com.bytedance.android.livesdk.interactivity.service.richcontent.resourceloader;

import com.airbnb.lottie.LottieListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j<T> implements LottieListener {
    public final /* synthetic */ ob2.e a;
    public final /* synthetic */ hk6.b.a b;

    public j(ob2.e r1, hk6.d r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onResult(Object r4) {
        Throwable r5 = (Throwable) r4;
        com.bytedance.android.livesdk.interactivity.service.richcontent.config.a.a.error("LiveLottieResourceLoader, load lottie resource failed " + this.a, r5);
        hk6.b.a.a.a(this.b, null, r5, 1);
    }
}
