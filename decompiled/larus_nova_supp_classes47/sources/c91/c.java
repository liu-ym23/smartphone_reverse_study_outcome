package c91;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bytedance.android.livesdk.message.model.j4;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c extends AnimatorListenerAdapter {
    public final /* synthetic */ a a;

    public c(a r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        a r4 = this.a;
        r4.h = null;
        if ((!r4.j.isEmpty()) == false) goto L6;
        a r5 = this.a;
        r5.a((j4) ListProtector.remove(r5.j, 0));
        return;
    }
}
