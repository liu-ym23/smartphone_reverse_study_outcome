package ra2;

import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.ui.ConfrontMsgView;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.ui.GroupMsgView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements Runnable {
    public final /* synthetic */ ConfrontMsgView a;

    public c(ConfrontMsgView r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        GroupMsgView r0 = this.a.b;     // Catch: Throwable -> L9
        if (r0 == null) goto L5;
        r0.h();     // Catch: Throwable -> L9
    L5:
        GroupMsgView r1 = this.a.c;     // Catch: Throwable -> L9
        if (r1 == null) goto L12;
        r1.h();     // Catch: Throwable -> L9
        return;
    L12:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
