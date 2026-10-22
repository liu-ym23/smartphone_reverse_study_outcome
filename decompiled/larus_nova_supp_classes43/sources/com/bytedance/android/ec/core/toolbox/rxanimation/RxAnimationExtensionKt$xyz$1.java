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
final class RxAnimationExtensionKt$xyz$1 extends Lambda implements Function1<View, Completable> {
    final /* synthetic */ Long $duration;
    final /* synthetic */ TimeInterpolator $interpolator;
    final /* synthetic */ boolean $reverse;
    final /* synthetic */ Long $startDelay;
    final /* synthetic */ Float $x;
    final /* synthetic */ Float $y;
    final /* synthetic */ Float $z;

    public RxAnimationExtensionKt$xyz$1(Float r1, Float r10, Float r11, Long r12, TimeInterpolator r13, Long r14, boolean r15) {
        this.$x = r1;
        this.$y = r10;
        this.$z = r11;
        this.$duration = r12;
        this.$interpolator = r13;
        this.$startDelay = r14;
        this.$reverse = r15;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((View) r1);
    }

    public final Completable invoke(View r10) {
        Intrinsics.checkNotNullParameter(r10, "it");
        return RxViewAnimationExtensionKt.s(r10, this.$x, this.$y, this.$z, this.$duration, this.$interpolator, this.$startDelay, this.$reverse);
    }
}
