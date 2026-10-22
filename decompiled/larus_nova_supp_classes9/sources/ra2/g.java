package ra2;

import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.ui.ConfrontMsgView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g implements Runnable {
    public final /* synthetic */ ConfrontMsgView a;

    public g(ConfrontMsgView r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ConfrontMsgView r0 = this.a;     // Catch: Throwable -> L4
        r0.q = r0.n;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
