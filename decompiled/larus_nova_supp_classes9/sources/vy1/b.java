package vy1;

import com.bytedance.android.livesdk.gift.grouplive.component.GroupComponentState;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements Runnable {
    public final /* synthetic */ ty1.c a;
    public final /* synthetic */ GroupComponentState.Style b;
    public final /* synthetic */ int c;
    public final /* synthetic */ a d;

    public b(ty1.c r1, GroupComponentState.Style r2, int r3, a r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.d.p(this.a, this.b, this.c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
