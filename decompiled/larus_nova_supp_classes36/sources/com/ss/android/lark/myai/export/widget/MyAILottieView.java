package com.ss.android.lark.myai.export.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import com.airbnb.lottie.LottieAnimationView;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B)\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u000eJ\u0006\u0010\u0013\u001a\u00020\u000eJ\u0006\u0010\u0014\u001a\u00020\u000eJ\u0016\u0010\u0015\u001a\u00020\u000e2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u0016\u0010\u0017\u001a\u00020\u000e2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/myai/export/widget/MyAILottieView;", "Lcom/airbnb/lottie/LottieAnimationView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isInAnimation", "", "actionOnAnimationEnd", "Lkotlin/Function0;", "", "intro", "convert", "finishAvatar", "finishLogo", "showBorder", "showLogo", "donOnIdle", "action", "doOnPrepared", "myai-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class MyAILottieView extends LottieAnimationView {
    public boolean a;
    public Function0<Unit> b;

    public static final class a extends AnimatorListenerAdapter {
        public final /* synthetic */ MyAILottieView a;

        public a(MyAILottieView r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            MyAILottieView r4 = this.a;
            r4.a = false;
            Function0<Unit> r0 = r4.b;
            r4.b = null;
            if (r0 == null) goto L6;
            r0.invoke();
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.a = true;
        }
    }

    public MyAILottieView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MyAILottieView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public MyAILottieView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        setAnimation("onboarding.lottie");
        addAnimatorListener(new a(this));
    }

    public /* synthetic */ MyAILottieView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
