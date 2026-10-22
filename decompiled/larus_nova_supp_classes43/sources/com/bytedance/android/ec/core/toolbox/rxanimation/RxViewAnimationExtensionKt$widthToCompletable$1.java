package com.bytedance.android.ec.core.toolbox.rxanimation;

import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.animation.Interpolator;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class RxViewAnimationExtensionKt$widthToCompletable$1 implements CompletableOnSubscribe {
    public final /* synthetic */ View a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Long c;
    public final /* synthetic */ Interpolator d;

    public RxViewAnimationExtensionKt$widthToCompletable$1(View r1, int r10, Long r11, Interpolator r12) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
    }

    public final void subscribe(final CompletableEmitter r10) {
        Intrinsics.checkNotNullParameter(r10, "it");
        float r1 = this.b;
        Resources r11 = Resources.getSystem();
        RxViewAnimationExtensionKt.b(ValueAnimator.ofInt(new int[]{this.a.getWidth(), (int) (r1 * WindowDisplayMetricsOverride.apply(r11, r11.getDisplayMetrics()).density)}), this.c, this.d, new AnonymousClass1(r10), new AnonymousClass2(this));
    }
}
