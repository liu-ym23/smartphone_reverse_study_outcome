package ra2;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.base.model.message.g3;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.ui.MatchHotMsgView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.PriorityBlockingQueue;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class s implements Runnable {
    public final /* synthetic */ MatchHotMsgView a;

    public s(MatchHotMsgView r1) {
        this.a = r1;
    }

    public final void a() {
        MatchHotMsgView r1 = this.a;
        PriorityBlockingQueue<g3> r2 = r1.z;
        if (r2 != null) goto L5;
    L37:
        MatchHotMsgView r3 = this.a;
        r3.postDelayed(r3.l, r3.x);
        return;
    L5:
        if ((!r2.isEmpty()) != true) goto L37;
        PriorityBlockingQueue<g3> r4 = r1.z;
        String r5 = null;
        if (r4 == null) goto L9;
        g3 r6 = r4.poll();
    L10:
        r1.A = r6;
        if (r6 == null) goto L13;
        Long r7 = Long.valueOf(r6.getCount());
    L14:
        TextView r8 = r1.i;
        if (r8 == null) goto L19;
        if (r7 == null) goto L18;
        r5 = String.valueOf(r7.longValue());
    L18:
        r8.setText(r5);
    L19:
        r1.E = new AnimatorSet();
        AnimatorSet r9 = new AnimatorSet();
        Animator[] r10 = new Animator[2];
        int r11 = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.a;
        ViewGroup r13 = r1.g;
        if (r13 == null) goto L37;
        r10[0] = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.b(r13, "scaleX", 1.0f, 1.15f, 50, 0.0f, 0.0f, 1.0f, 1.0f);
        ViewGroup r14 = r1.g;
        if (r14 == null) goto L37;
        r10[1] = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.b(r14, "scaleY", 1.0f, 1.15f, 50, 0.0f, 0.0f, 1.0f, 1.0f);
        r9.playTogether(r10);
        AnimatorSet r15 = new AnimatorSet();
        Animator[] r16 = new Animator[2];
        ViewGroup r17 = r1.g;
        if (r17 == null) goto L37;
        r16[0] = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.b(r17, "scaleX", 1.15f, 1.0f, 350, 0.0f, 0.0f, 1.0f, 1.0f);
        ViewGroup r18 = r1.g;
        if (r18 == null) goto L37;
        r16[1] = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.b(r18, "scaleY", 1.15f, 1.0f, 350, 0.0f, 0.0f, 1.0f, 1.0f);
        r15.playTogether(r16);
        AnimatorSet r19 = r1.E;
        if (r19 == null) goto L34;
        r19.playSequentially(new Animator[]{r9, r15});
    L34:
        AnimatorSet r20 = r1.E;
        if (r20 == null) goto L37;
        r20.start();
        goto L37
    L13:
        r7 = null;
        goto L14
    L9:
        r6 = null;
        goto L10
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
