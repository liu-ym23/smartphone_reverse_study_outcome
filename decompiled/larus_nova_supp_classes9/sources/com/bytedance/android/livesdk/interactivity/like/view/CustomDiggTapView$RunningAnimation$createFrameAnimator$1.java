package com.bytedance.android.livesdk.interactivity.like.view;

import android.view.animation.AccelerateDecelerateInterpolator;
import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/utils/q4;", BuildConfig.FLAVOR, "invoke", "(Lcom/bytedance/android/livesdk/utils/q4;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class CustomDiggTapView$RunningAnimation$createFrameAnimator$1 extends Lambda implements Function1<q4, Unit> {
    final /* synthetic */ AccelerateDecelerateInterpolator $accelerateDecelerateInterpolator;
    final /* synthetic */ CustomDiggTapView.a $alphaStage1;
    final /* synthetic */ CustomDiggTapView.a $rotateStage1;
    final /* synthetic */ CustomDiggTapView.a $rotateStage2;
    final /* synthetic */ CustomDiggTapView.a $rotateStage3;
    final /* synthetic */ CustomDiggTapView.a $scaleStage1;
    final /* synthetic */ CustomDiggTapView.a $scaleStage2;
    final /* synthetic */ CustomDiggTapView.a $scaleStage3;
    final /* synthetic */ CustomDiggTapView.a $scaleStage4;
    final /* synthetic */ CustomDiggTapView.c this$0;

    public CustomDiggTapView$RunningAnimation$createFrameAnimator$1(CustomDiggTapView.c r1, CustomDiggTapView.a r2, AccelerateDecelerateInterpolator r3, CustomDiggTapView.a r4, CustomDiggTapView.a r5, CustomDiggTapView.a r6, CustomDiggTapView.a r7, CustomDiggTapView.a r8, CustomDiggTapView.a r9, CustomDiggTapView.a r10) {
        this.this$0 = r1;
        this.$scaleStage1 = r2;
        this.$accelerateDecelerateInterpolator = r3;
        this.$scaleStage2 = r4;
        this.$scaleStage3 = r5;
        this.$scaleStage4 = r6;
        this.$rotateStage1 = r7;
        this.$rotateStage2 = r8;
        this.$rotateStage3 = r9;
        this.$alphaStage1 = r10;
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
