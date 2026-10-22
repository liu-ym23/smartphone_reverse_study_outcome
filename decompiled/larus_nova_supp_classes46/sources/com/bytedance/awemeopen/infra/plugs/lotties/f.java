package com.bytedance.awemeopen.infra.plugs.lotties;

import com.airbnb.lottie.LottieComposition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f implements com.bytedance.awemeopen.servicesapi.ui.a {
    public final LottieComposition a;

    @Override // com.bytedance.awemeopen.servicesapi.ui.a
    public final LottieComposition getComposition() {
        return this.a;
    }

    public f(LottieComposition r2) {
        Intrinsics.checkNotNullParameter(r2, "composition");
        this.a = r2;
    }
}
