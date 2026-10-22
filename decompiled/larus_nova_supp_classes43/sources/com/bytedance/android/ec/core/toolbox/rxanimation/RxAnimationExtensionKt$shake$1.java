package com.bytedance.android.ec.core.toolbox.rxanimation;

import android.view.View;
import io.reactivex.Completable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lio/reactivex/Completable;", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 3})
final class RxAnimationExtensionKt$shake$1 extends Lambda implements Function1<View, Completable> {
    final /* synthetic */ long $duration;
    final /* synthetic */ float $nbShake;
    final /* synthetic */ float $shakeTranslation;

    public RxAnimationExtensionKt$shake$1(long r1, float r10, float r11) {
        this.$duration = r1;
        this.$nbShake = r10;
        this.$shakeTranslation = r11;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((View) r1);
    }

    public final Completable invoke(final View r10) {
        Intrinsics.checkNotNullParameter(r10, "it");
        final long r11 = this.$duration;
        final float r12 = this.$nbShake;
        final float r13 = this.$shakeTranslation;
        Intrinsics.checkNotNullParameter(r10, "$this$shake");
        return Completable.create(new RxViewAnimationExtensionKt$shake$1(r10, r11, r12, r13));
    }
}
