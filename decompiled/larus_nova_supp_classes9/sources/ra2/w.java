package ra2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.ui.MatchHotMsgView;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class w extends AnimatorListenerAdapter {
    public final /* synthetic */ MatchHotMsgView a;

    public w(MatchHotMsgView r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        MatchHotMsgView r3 = this.a;
        if (r3.F == true) goto L5;
        return;
    L5:
        if (r3.getStatus() == this.a.getNeedExit()) goto L17;
        MatchHotMsgView r4 = this.a;
        r4.u = 0;
        r4.v = 0;
        AnimatedDrawable2 r0 = r4.r;
        if (r0 == null) goto L9;
        r0.stop();
    L9:
        AnimatedDrawable2 r5 = r4.r;
        if (r5 == null) goto L12;
        r5.start();
    L12:
        AnimatorSet r6 = this.a.getScaleAnimatorSets();
        if (r6 == null) goto L18;
        r6.start();
        return;
    L18:
        return;
    }
}
