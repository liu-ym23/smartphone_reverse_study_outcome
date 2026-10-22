package com.bytedance.android.ec.core.toolbox.rxanimation;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Interpolator;
import io.reactivex.Completable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lio/reactivex/Completable;", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 3})
final class RxAnimationExtensionKt$startValueAnimator$1 extends Lambda implements Function1<View, Completable> {
    final /* synthetic */ Function1 $action;
    final /* synthetic */ Long $duration;
    final /* synthetic */ Interpolator $interpolator;
    final /* synthetic */ ValueAnimator $valueAnimator;

    public RxAnimationExtensionKt$startValueAnimator$1(ValueAnimator r1, Long r10, Interpolator r11, Function1 r12) {
        this.$valueAnimator = r1;
        this.$duration = r10;
        this.$interpolator = r11;
        this.$action = r12;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((View) r1);
    }

    public final Completable invoke(View r10) {
        Intrinsics.checkNotNullParameter(r10, "it");
        final ValueAnimator r11 = this.$valueAnimator;
        final Long r0 = this.$duration;
        final Interpolator r1 = this.$interpolator;
        final Function1 r12 = this.$action;
        Intrinsics.checkNotNullParameter(r11, "$this$start");
        Intrinsics.checkNotNullParameter(r12, "action");
        return Completable.create(new RxViewAnimationExtensionKt$start$2(r11, r0, r1, r12));
    }
}
