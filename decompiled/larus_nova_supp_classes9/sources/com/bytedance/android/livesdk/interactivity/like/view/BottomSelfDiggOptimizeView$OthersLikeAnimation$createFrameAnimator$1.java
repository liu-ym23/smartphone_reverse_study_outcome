package com.bytedance.android.livesdk.interactivity.like.view;

import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/utils/q4;", BuildConfig.FLAVOR, "invoke", "(Lcom/bytedance/android/livesdk/utils/q4;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class BottomSelfDiggOptimizeView$OthersLikeAnimation$createFrameAnimator$1 extends Lambda implements Function1<q4, Unit> {
    final /* synthetic */ com.bytedance.android.livesdk.interactivity.like.utils.a $alphaStage1;
    final /* synthetic */ long $animDurationMs;
    final /* synthetic */ com.bytedance.android.livesdk.interactivity.like.utils.a $scaleStage1;
    final /* synthetic */ long $startDelayMs;
    final /* synthetic */ BottomSelfDiggOptimizeView.b this$0;

    public BottomSelfDiggOptimizeView$OthersLikeAnimation$createFrameAnimator$1(BottomSelfDiggOptimizeView.b r1, long r2, long r4, com.bytedance.android.livesdk.interactivity.like.utils.a r6, com.bytedance.android.livesdk.interactivity.like.utils.a r7) {
        this.this$0 = r1;
        this.$animDurationMs = r2;
        this.$startDelayMs = r4;
        this.$scaleStage1 = r6;
        this.$alphaStage1 = r7;
        super(1);
    }

    public final void invoke(q4 r2) {
        Intrinsics.checkNotNullParameter(r2, "$receiver");
        r2.b(new AnonymousClass1(this));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((q4) r1);
        return Unit.INSTANCE;
    }
}
