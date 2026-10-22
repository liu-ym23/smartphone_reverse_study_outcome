package com.bytedance.android.ec.core.toolbox.rxanimation;

import android.animation.TimeInterpolator;
import android.widget.TextView;
import io.reactivex.Completable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g<T, R> implements Function {
    public final /* synthetic */ TextView a;
    public final /* synthetic */ long b;
    public final /* synthetic */ TimeInterpolator c;
    public final /* synthetic */ Long d;
    public final /* synthetic */ String e;
    public final /* synthetic */ boolean f;

    public g(TextView r1, long r10, TimeInterpolator r11, Long r12, String r13, boolean r14) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
    }

    public final Object apply(Object r18) {
        final String r1 = (String) r18;
        Intrinsics.checkNotNullParameter(r1, "defaultText");
        TextView r10 = this.a;
        long r11 = 2;
        Long r12 = Long.valueOf(this.b / r11);
        TimeInterpolator r13 = this.c;
        Long r14 = this.d;
        Intrinsics.checkNotNullParameter(r10, "$this$fadeOut");
        Completable r15 = RxViewAnimationExtensionKt.c(r10, 0.0f, r12, r13, r14, false).doOnComplete(new f(this));
        TextView r16 = this.a;
        Long r17 = Long.valueOf(this.b / r11);
        TimeInterpolator r19 = this.c;
        Intrinsics.checkNotNullParameter(r16, "$this$fadeIn");
        return RxViewAnimationExtensionKt.h(r15.andThen(RxViewAnimationExtensionKt.c(r16, 1.0f, r17, r19, 300L, false)), this.f, new RxViewAnimationExtensionKt$text$1$2(this, r1));
    }
}
