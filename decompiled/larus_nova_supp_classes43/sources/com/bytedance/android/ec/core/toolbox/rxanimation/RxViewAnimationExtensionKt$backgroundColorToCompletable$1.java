package com.bytedance.android.ec.core.toolbox.rxanimation;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Interpolator;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class RxViewAnimationExtensionKt$backgroundColorToCompletable$1 implements CompletableOnSubscribe {
    public final /* synthetic */ View a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Long d;
    public final /* synthetic */ Interpolator e;

    public RxViewAnimationExtensionKt$backgroundColorToCompletable$1(View r1, int r10, int r11, Long r12, Interpolator r13) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
    }

    public final void subscribe(final CompletableEmitter r10) {
        Intrinsics.checkNotNullParameter(r10, "it");
        RxViewAnimationExtensionKt.b(ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(this.b), Integer.valueOf(this.c)}), this.d, this.e, new AnonymousClass1(r10), new AnonymousClass2(this));
    }
}
