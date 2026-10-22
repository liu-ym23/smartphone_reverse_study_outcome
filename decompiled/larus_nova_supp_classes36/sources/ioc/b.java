package ioc;

import com.larus.apm.impl.protector.RunnableProtector;
import com.suite.lark.platform.component.cta.newstyle.adapter.VersionInfoAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ VersionInfoAdapter b;
    public final /* synthetic */ int c;

    public b(int r1, VersionInfoAdapter r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r0 = this.a;     // Catch: Throwable -> L7
        if (r0 == (-1)) goto L5;
        this.b.notifyItemChanged(r0);     // Catch: Throwable -> L7
    L5:
        this.b.notifyItemChanged(this.c);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
