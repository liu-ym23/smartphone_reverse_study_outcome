package h84;

import android.accounts.Account;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements Runnable {
    public final /* synthetic */ Account a;
    public final /* synthetic */ c b;

    public final void a() {
    L17:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (this.b.e.size() <= 0) goto L16;
        c r0 = this.b;     // Catch: Exception -> L17
        if (r0.b == null) goto L28;
        Iterator r1 = r0.e.entrySet().iterator();     // Catch: Exception -> L17
    L9:
        if (r1.hasNext() == false) goto L14;
        Map.Entry r2 = (Map.Entry) r1.next();     // Catch: Exception -> L17
        if (r2 == null) goto L9;
        this.b.b.setUserData(this.a, (String) r2.getKey(), (String) r2.getValue());     // Catch: Exception -> L17
        goto L9
    L14:
        this.b.e.clear();     // Catch: Exception -> L17
        return;
    L28:
        return;
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

    public b(c r1, Account r2) {
        this.b = r1;
        this.a = r2;
    }
}
