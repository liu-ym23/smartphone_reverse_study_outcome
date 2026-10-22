package com.bytedance.android.ec.core.toolbox.rxanimation;

import android.animation.TimeInterpolator;
import android.view.View;
import io.reactivex.Completable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lio/reactivex/Completable;", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 3})
final class RxAnimationExtensionKt$translationY$1 extends Lambda implements Function1<View, Completable> {
    final /* synthetic */ Long $duration;
    final /* synthetic */ TimeInterpolator $interpolator;
    final /* synthetic */ boolean $reverse;
    final /* synthetic */ Long $startDelay;
    final /* synthetic */ float $translationY;

    public RxAnimationExtensionKt$translationY$1(float r1, Long r10, TimeInterpolator r11, Long r12, boolean r13) {
        this.$translationY = r1;
        this.$duration = r10;
        this.$interpolator = r11;
        this.$startDelay = r12;
        this.$reverse = r13;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((View) r1);
    }

    public final Completable invoke(View r10) {
        Intrinsics.checkNotNullParameter(r10, "it");
        return RxViewAnimationExtensionKt.q(r10, this.$translationY, this.$duration, this.$interpolator, this.$startDelay, this.$reverse);
    }
}
