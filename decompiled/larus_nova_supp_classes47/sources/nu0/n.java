package nu0;

import android.animation.Animator;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n implements Animator.AnimatorListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ TextView b;
    public final /* synthetic */ String c;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animator");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animator");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animator");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animator");
        ViewUtilsKt.e(this.a);
        this.b.setText(this.c);
    }

    public n(View r1, TextView r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
