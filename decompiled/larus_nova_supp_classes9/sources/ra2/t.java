package ra2;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.ui.MatchHotMsgView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class t implements Runnable {
    public final /* synthetic */ MatchHotMsgView a;

    public t(MatchHotMsgView r1) {
        this.a = r1;
    }

    public final void a() {
        MatchHotMsgView r0 = this.a;
        MatchHotMsgView.b(r0.getScaleAnimatorSets());
        r0.removeCallbacks(r0.o);
        r0.removeCallbacks(r0.p);
        AnimatorSet r1 = new AnimatorSet();
        r0.D = r1;
        r1.play(ObjectAnimator.ofFloat(r0.d, "alpha", new float[]{1.0f, 0.0f}));
        AnimatorSet r2 = r0.D;
        if (r2 == null) goto L5;
        r2.setDuration(200);
    L5:
        AnimatorSet r3 = r0.D;
        if (r3 == null) goto L8;
        r3.addListener(new p(r0));
    L8:
        AnimatorSet r4 = r0.D;
        if (r4 == null) goto L12;
        r4.start();
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
