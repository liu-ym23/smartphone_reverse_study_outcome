package ebb;

import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.framework.assembly.diskmanage.DiskManageProvider;
import com.ss.android.lark.log.Log;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements Runnable {
    public final /* synthetic */ b a;
    public final /* synthetic */ cbb.d b;
    public final /* synthetic */ IGetDataCallback<Boolean> c;

    public c(b r1, cbb.d r2, DiskManageProvider.performRemoteClean.1 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        long r0 = System.currentTimeMillis();
        Iterator<g> r2 = this.a.a.values().iterator();
        boolean r4 = false;
    L4:
        if (r2.hasNext() == false) goto L13;
        g r5 = r2.next();
        long r7 = System.currentTimeMillis();
        cbb.a r9 = r5.a(this.b);
        long r10 = System.currentTimeMillis() - r7;
        if (r4 == false) goto L8;
    L11:
        r4 = true;
    L12:
        Log.i("DiskCleanTaskManager", "remoteClean, biz: " + r5.getBiz() + ", cost time: " + r10 + ", result: " + r9);
        goto L4
    L8:
        if (r9.a == true) goto L11;
        r4 = false;
        goto L12
    L13:
        Log.i("DiskCleanTaskManager", "remoteClean, total cost: " + (System.currentTimeMillis() - r0));
        this.c.onSuccess(Boolean.valueOf(r4));
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
