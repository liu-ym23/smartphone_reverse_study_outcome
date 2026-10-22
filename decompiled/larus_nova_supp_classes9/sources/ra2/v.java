package ra2;

import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.ui.MatchHotMsgView;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class v implements Runnable {
    public final /* synthetic */ MatchHotMsgView a;

    public v(MatchHotMsgView r1) {
        this.a = r1;
    }

    public final void a() {
        MatchHotMsgView r0 = this.a;
        int r1 = r0.v;
        AnimatedDrawable2 r2 = r0.r;
        if (r2 == null) goto L5;
        int r3 = r2.getFrameCount() - 1;
    L6:
        if (r1 >= r3) goto L8;
        this.a.v++;
    L8:
        MatchHotMsgView r4 = this.a;
        AnimatedDrawable2 r5 = r4.r;
        if (r5 == null) goto L11;
        r5.jumpToFrame(r4.v);
    L11:
        MatchHotMsgView r6 = this.a;
        r6.postDelayed(r6.p, r6.t);
        return;
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
