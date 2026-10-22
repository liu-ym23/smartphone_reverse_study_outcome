package com.ss.android.lark.larkconfig.userconfig;

import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements Runnable {
    public final /* synthetic */ tpb.a a;
    public final /* synthetic */ e b;

    public class a implements Runnable {
        public final /* synthetic */ tpb.b a;
        public final /* synthetic */ d b;

        @Override // java.lang.Runnable
        public final void run() {
            tpb.b r0 = this.a;     // Catch: Throwable -> L4
            tpb.a r1 = this.b.a;     // Catch: Throwable -> L4
            r0.a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(d r1, tpb.b r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator r0 = ((ConcurrentHashMap) this.b.d).keySet().iterator();     // Catch: Throwable -> L7
    L4:
        if (r0.hasNext() == false) goto L16;
        tpb.b r1 = (tpb.b) r0.next();     // Catch: Throwable -> L7
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new a(this, r1));     // Catch: Throwable -> L7
        goto L4
    L16:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }

    public d(e r1, tpb.a r2) {
        this.b = r1;
        this.a = r2;
    }
}
