package b74;

import com.bytedance.badger.C.a;
import com.bytedance.badger.e;
import com.bytedance.badger.monitor.TriggerStage;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.TypeCastException;
import x64.l;
import z64.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements Runnable {
    public final /* synthetic */ a a;

    public c(a r1) {
        this.a = r1;
    }

    public final void a() {
        f r0 = this.a.c;     // Catch: Exception -> L11
        if ((r0 instanceof f) == false) goto L8;
        if (r0 == null) goto L7;
        f r1 = r0;     // Catch: Exception -> L11
        String r2 = r1.e;     // Catch: Exception -> L11
        String r9 = r1.f;     // Catch: Exception -> L11
        String r8 = r2;
    L9:
        com.bytedance.badger.C.b r3 = x64.b.a;     // Catch: Exception -> L11
        x64.b.a(new l(TriggerStage.manual, r0.getSceneId(), false, a.c, r8, r9), new b(this));     // Catch: Exception -> L11
        return;
    L7:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.badger.data.LoginBadgerRequest");     // Catch: Exception -> L11
    L8:
        r8 = "";
        r9 = r8;
    L11:
        e = move-exception;
        e.c("CompensationManager", "attemptCompensationIfNeeded# error", e);
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
