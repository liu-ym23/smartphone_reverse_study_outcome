package nu0;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o {

    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ TextView a;

        public a(TextView r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Intrinsics.checkNotNullParameter(r2, "animator");
            TextView r0 = this.a;
            Object r3 = r2.getAnimatedValue();
            if (r3 == null) goto L7;
            r0.setTextColor(((Integer) r3).intValue());
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ Drawable a;

        public b(Drawable r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Intrinsics.checkNotNullParameter(r2, "animator");
            Drawable r0 = this.a;
            Object r3 = r2.getAnimatedValue();
            if (r3 == null) goto L7;
            r0.setTint(((Integer) r3).intValue());
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    public static final Animator a(Drawable r3, long r4, int r6, int r7) {
        Intrinsics.checkNotNullParameter(r3, "$this$getColorAnim");
        ValueAnimator r8 = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(r6), Integer.valueOf(r7)});
        r8.setDuration(r4);
        r8.addUpdateListener(new b(r3));
        return r8;
    }

    public static final Animator b(TextView r3, long r4, int r6, int r7) {
        Intrinsics.checkNotNullParameter(r3, "$this$getColorAnim");
        ValueAnimator r8 = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(r6), Integer.valueOf(r7)});
        r8.setDuration(r4);
        r8.addUpdateListener(new a(r3));
        return r8;
    }
}
