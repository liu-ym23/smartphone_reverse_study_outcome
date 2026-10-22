package b02;

import android.animation.Animator;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo.ComboEffectAnimationView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements Runnable {
    public final /* synthetic */ ComboEffectAnimationView a;
    public final /* synthetic */ LottieAnimationView b;
    public final /* synthetic */ Ref.ObjectRef c;

    public static final class a extends o12.b {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        @Override // o12.b, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            b r3 = this.a;
            if (r3.a.indexOfChild(r3.b) < 0) goto L6;
            b r4 = this.a;
            r4.a.removeView(r4.b);
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationEnd(r2, r3);
            b r4 = this.a;
            if (r4.a.indexOfChild(r4.b) < 0) goto L6;
            b r5 = this.a;
            r5.a.removeView(r5.b);
            return;
        }
    }

    public b(ComboEffectAnimationView r1, LottieAnimationView r2, Ref.ObjectRef r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.setAnimation((String) this.c.element);     // Catch: Throwable -> L4
        this.b.addAnimatorListener(new a(this));     // Catch: Throwable -> L4
        this.b.playAnimation();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
