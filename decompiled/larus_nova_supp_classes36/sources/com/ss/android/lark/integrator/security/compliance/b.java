package com.ss.android.lark.integrator.security.compliance;

import android.content.Context;
import com.larksuite.framework.thread.ThreadUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements Runnable {
    public final /* synthetic */ Context a;

    public static final class a implements Runnable {
        public final /* synthetic */ Context a;

        public a(Context r1) {
            this.a = r1;
        }

        public final void a() {
            long r0 = System.currentTimeMillis();
            int r2 = com.ss.android.lark.scs.policy.engine.manage.d.c;
            com.ss.android.lark.scs.policy.engine.manage.d.a.a().b();
            com.ss.android.lark.integrator.security.compliance.psda.b.a();
            int r3 = g8b.b.a;
            g8b.b.a.a().init(this.a);
            d.a();
            r4c.a.a();
            int r4 = ScsLogger.a;
            ScsLogger.d("InitSecurityComplianceTask", "execute finish time in ui thread: " + (System.currentTimeMillis() - r0));
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

    public b(Context r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ScsLogger.d("InitSecurityComplianceTask", "execute serial init settings");     // Catch: Throwable -> L4
        w4c.c.a();     // Catch: Throwable -> L4
        ScsLogger.d("InitSecurityComplianceTask", "execute serial init settings done");     // Catch: Throwable -> L4
        ThreadUtils.runOnUIThread(new a(this.a));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
