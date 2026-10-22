package so8;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.FrameLayout;
import com.larus.utils.e1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h extends AnimatorListenerAdapter {
    public final /* synthetic */ f a;

    public h(f r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        FrameLayout r3 = this.a.c;
        if (r3 == null) goto L5;
        e1.o(r3);
    L5:
        FrameLayout r4 = this.a.c;
        if (r4 == null) goto L8;
        r4.removeAllViews();
    L8:
        this.a.getClass();
    }
}
