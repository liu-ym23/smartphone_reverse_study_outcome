package com.bytedance.awemeopen.infra.plugs.lotties;

import com.airbnb.lottie.LottieComposition;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/airbnb/lottie/LottieComposition;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class BdpAnimationViewImpl$onSuccess$1 extends Lambda implements Function1<LottieComposition, Unit> {
    final /* synthetic */ BdpAnimationViewImpl this$0;

    public BdpAnimationViewImpl$onSuccess$1(BdpAnimationViewImpl r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(LottieComposition r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        this.this$0.setComposition(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((LottieComposition) r1);
        return Unit.INSTANCE;
    }
}
