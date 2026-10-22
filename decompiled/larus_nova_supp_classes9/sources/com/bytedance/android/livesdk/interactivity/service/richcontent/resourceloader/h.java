package com.bytedance.android.livesdk.interactivity.service.richcontent.resourceloader;

import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieTask;
import com.bytedance.android.live.core.utils.s1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h implements hk6.a<ob2.e> {

    public static final class a {
    }

    static {
    }

    public h() {
    }

    public final void a(ek6.b r3, ak6.f r4, ek6.d r5, hk6.d r6) {
        ob2.e r7 = (ob2.e) r3;
        Intrinsics.checkNotNullParameter(r7, "resourceInfo");
        Intrinsics.checkNotNullParameter(r4, "loadConfig");
        Intrinsics.checkNotNullParameter(r5, "content");
        Intrinsics.checkNotNullParameter(r6, "callback");
        com.bytedance.android.livesdk.interactivity.service.richcontent.config.a.a.info("LiveLottieResourceLoader, load lottie resource " + r7);     // Catch: Exception -> L5
        LottieTask r8 = LottieCompositionFactory.fromAsset(s1.getContext(), r7.a);     // Catch: Exception -> L5
        r8.addListener(new i(this, r5, r7, r6));     // Catch: Exception -> L5
        r8.addFailureListener(new j(r7, r6));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        com.bytedance.android.livesdk.interactivity.service.richcontent.config.a.a.error("LiveLottieResourceLoader, load lottie resource error " + r7, e);
        r6.a("load error", e);
    }
}
