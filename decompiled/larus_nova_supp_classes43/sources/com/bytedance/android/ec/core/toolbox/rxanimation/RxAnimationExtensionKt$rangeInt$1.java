package com.bytedance.android.ec.core.toolbox.rxanimation;

import android.view.View;
import android.view.animation.Interpolator;
import io.reactivex.Completable;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lio/reactivex/Completable;", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 3})
final class RxAnimationExtensionKt$rangeInt$1 extends Lambda implements Function1<View, Completable> {
    final /* synthetic */ Function1 $action;
    final /* synthetic */ Long $duration;
    final /* synthetic */ int $end;
    final /* synthetic */ Interpolator $interpolator;
    final /* synthetic */ boolean $reverse;
    final /* synthetic */ int $start;

    public RxAnimationExtensionKt$rangeInt$1(int r1, int r10, Long r11, Interpolator r12, boolean r13, Function1 r14) {
        this.$start = r1;
        this.$end = r10;
        this.$duration = r11;
        this.$interpolator = r12;
        this.$reverse = r13;
        this.$action = r14;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((View) r1);
    }

    public final Completable invoke(View r10) {
        Intrinsics.checkNotNullParameter(r10, "it");
        return RxViewAnimationExtensionKt.g(TuplesKt.to(Integer.valueOf(this.$start), Integer.valueOf(this.$end)), this.$duration, this.$interpolator, this.$reverse, this.$action);
    }
}
