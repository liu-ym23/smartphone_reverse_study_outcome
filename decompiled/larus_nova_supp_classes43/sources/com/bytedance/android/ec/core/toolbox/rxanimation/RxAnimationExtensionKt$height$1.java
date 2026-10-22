package com.bytedance.android.ec.core.toolbox.rxanimation;

import android.view.View;
import android.view.animation.Interpolator;
import io.reactivex.Completable;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lio/reactivex/Completable;", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 3})
final class RxAnimationExtensionKt$height$1 extends Lambda implements Function1<View, Completable> {
    final /* synthetic */ Long $duration;
    final /* synthetic */ int $height;
    final /* synthetic */ Interpolator $interpolator;
    final /* synthetic */ boolean $reverse;

    public RxAnimationExtensionKt$height$1(int r1, Long r10, Interpolator r11, boolean r12) {
        this.$height = r1;
        this.$duration = r10;
        this.$interpolator = r11;
        this.$reverse = r12;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((View) r1);
    }

    public final Completable invoke(View r10) {
        Intrinsics.checkNotNullParameter(r10, "it");
        int r11 = this.$height;
        Long r12 = this.$duration;
        Interpolator r13 = this.$interpolator;
        boolean r14 = this.$reverse;
        Intrinsics.checkNotNullParameter(r10, "$this$height");
        return Observable.just(Integer.valueOf(r10.getHeight())).flatMapCompletable(new c(r10, r11, r12, r13, r14));
    }
}
