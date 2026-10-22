package ra2;

import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.ui.MatchHotMsgView;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class u implements Runnable {
    public final /* synthetic */ MatchHotMsgView a;

    public u(MatchHotMsgView r1) {
        this.a = r1;
    }

    public final void a() {
        MatchHotMsgView r0 = this.a;
        int r1 = r0.u;
        AnimatedDrawable2 r2 = r0.q;
        if (r2 == null) goto L5;
        int r3 = r2.getFrameCount() - 1;
    L6:
        if (r1 >= r3) goto L8;
        this.a.u++;
    L9:
        MatchHotMsgView r4 = this.a;
        AnimatedDrawable2 r5 = r4.q;
        if (r5 == null) goto L12;
        r5.jumpToFrame(r4.u);
    L12:
        MatchHotMsgView r6 = this.a;
        r6.postDelayed(r6.o, r6.s);
        return;
    L8:
        MatchHotMsgView r7 = this.a;
        r7.u = 0;
        r7.v = 0;
        goto L9
    L5:
        r3 = 0;
        goto L6
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
