package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo;

import android.animation.Animator;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;
import o12.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements Runnable {
    public final /* synthetic */ ComboBottomAnimationView.c a;
    public final /* synthetic */ LottieAnimationView b;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo.a$a, reason: collision with other inner class name */
    public static final class C0048a extends b {
        public final /* synthetic */ a a;

        public C0048a(a r1) {
            this.a = r1;
        }

        @Override // o12.b, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            FrameLayout r4 = (FrameLayout) this.a.a.a.a(2131367234);
            if (r4 == null) goto L5;
            Integer r5 = Integer.valueOf(r4.indexOfChild(this.a.b));
        L7:
            if (r5.intValue() < 0) goto L12;
            FrameLayout r6 = (FrameLayout) this.a.a.a.a(2131367234);
            if (r6 == null) goto L13;
            r6.removeView(this.a.b);
            return;
        L13:
            return;
        L12:
            return;
        L5:
            r5 = null;
            goto L7
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationEnd(r2, r3);
            FrameLayout r4 = (FrameLayout) this.a.a.a.a(2131367234);
            if (r4 == null) goto L5;
            Integer r5 = Integer.valueOf(r4.indexOfChild(this.a.b));
        L7:
            if (r5.intValue() < 0) goto L12;
            FrameLayout r6 = (FrameLayout) this.a.a.a.a(2131367234);
            if (r6 == null) goto L13;
            r6.removeView(this.a.b);
            return;
        L13:
            return;
        L12:
            return;
        L5:
            r5 = null;
            goto L7
        }
    }

    public a(ComboBottomAnimationView.c r1, LottieAnimationView r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.setAnimation("combo/ttlive_gift_combo_bottom_effect.json");     // Catch: Throwable -> L4
        this.b.addAnimatorListener(new C0048a(this));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
