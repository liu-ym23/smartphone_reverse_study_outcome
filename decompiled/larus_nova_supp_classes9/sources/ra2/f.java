package ra2;

import com.bytedance.android.live.base.model.message.g3;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.ui.ConfrontMsgView;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.ui.GroupMsgView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.PriorityBlockingQueue;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f implements Runnable {
    public final /* synthetic */ ConfrontMsgView a;

    public f(ConfrontMsgView r1) {
        this.a = r1;
    }

    public final void a() {
        ConfrontMsgView r0 = this.a;
        r0.getClass();
        PriorityBlockingQueue<g3> r1 = b.a;
        boolean r2 = true;
        if (r1 != null) goto L5;
    L6:
        PriorityBlockingQueue<g3> r3 = b.b;
        if (r3 != null) goto L9;
    L11:
        r2 = false;
    L12:
        if (r2 == false) goto L29;
        PriorityBlockingQueue<g3> r4 = b.a;
        g3 r5 = null;
        if (r4 == null) goto L16;
        g3 r6 = r4.poll();
    L17:
        if (r6 == null) goto L21;
        b.c = r6;
        GroupMsgView r7 = r0.b;
        if (r7 == null) goto L21;
        r7.g(Long.valueOf(r6.getCount()), m.a.a(r0));
    L21:
        PriorityBlockingQueue<g3> r8 = b.b;
        if (r8 == null) goto L24;
        r5 = r8.poll();
    L24:
        if (r5 == null) goto L28;
        b.d = r5;
        GroupMsgView r9 = r0.c;
        if (r9 == null) goto L28;
        r9.g(Long.valueOf(r5.getCount()), m.a.a(r0));
    L28:
        r0.b();
        goto L29
    L16:
        r6 = null;
    L29:
        ConfrontMsgView r10 = this.a;
        r10.postDelayed(r10.j, r10.t);
        return;
    L9:
        if ((!r3.isEmpty()) != true) goto L11;
    L5:
        if ((!r1.isEmpty()) == true) goto L12;
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
