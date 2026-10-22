package ra2;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.ui.MatchHotMsgView;
import com.bytedance.android.livesdk.utils.q4;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class r implements Runnable {
    public final /* synthetic */ MatchHotMsgView a;

    public r(MatchHotMsgView r1) {
        this.a = r1;
    }

    public final void a() {
        MatchHotMsgView r0 = this.a;
        int r1 = MatchHotMsgView.P;
        r0.getClass();
        AnimatorSet r2 = new AnimatorSet();
        Animator[] r3 = new Animator[3];
        int r4 = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.a;
        ViewGroup r5 = r0.d;
        if (r5 == null) goto L16;
        Intrinsics.checkNotNullParameter(r5, "view");
        q4.j.getClass();
        ValueAnimator r6 = q4.a.b(r5, "alpha", new float[]{0.0f, 1.0f});
        r6.setDuration(500);
        r3[0] = r6;
        ViewGroup r7 = r0.d;
        if (r7 == null) goto L17;
        r3[1] = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.c(r7, "scaleX");
        ViewGroup r8 = r0.d;
        if (r8 == null) goto L18;
        r3[2] = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.c(r8, "scaleY");
        r2.playTogether(r3);
        Unit r9 = Unit.INSTANCE;
        r0.B = r2;
        r2.addListener(new o(r0));
        AnimatorSet r10 = r0.B;
        if (r10 == null) goto L15;
        r10.start();
        return;
    L15:
        return;
    L18:
        return;
    L17:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
