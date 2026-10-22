package com.bytedance.android.ec.core.toolbox.rxanimation;

import android.view.View;
import android.view.animation.Interpolator;
import io.reactivex.Completable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h<T, R> implements Function {
    public final /* synthetic */ View a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Long c;
    public final /* synthetic */ Interpolator d;
    public final /* synthetic */ boolean e;

    public h(View r1, int r10, Long r11, Interpolator r12, boolean r13) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
    }

    public final Object apply(Object r10) {
        final Integer r11 = (Integer) r10;
        Intrinsics.checkNotNullParameter(r11, "defaultWidth");
        return RxViewAnimationExtensionKt.h(Completable.create(new RxViewAnimationExtensionKt$widthToCompletable$1(this.a, this.b, this.c, this.d)), this.e, new RxViewAnimationExtensionKt$width$1$1(this, r11));
    }
}
