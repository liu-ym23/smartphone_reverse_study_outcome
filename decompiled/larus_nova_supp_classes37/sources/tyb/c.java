package tyb;

import android.os.SystemClock;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.passport.base.core.log.PassportLog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c implements Runnable {
    public final /* synthetic */ a.b a;

    public c(a.b r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L15;
        throw th;
    L15:
        return;
    L3:
        if (a.e == null) goto L5;
        PassportLog.b("n_action_bdturing", "ignore turing request because another request is waiting");     // Catch: Throwable -> L7
    L12:
        return;
    L5:
        a.e = this.a;     // Catch: Throwable -> L7
        a.b(a.a, this.a, SystemClock.elapsedRealtime());     // Catch: Throwable -> L7
        goto L12
    }
}
