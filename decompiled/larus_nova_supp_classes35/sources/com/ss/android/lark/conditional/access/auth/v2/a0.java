package com.ss.android.lark.conditional.access.auth.v2;

import android.content.Context;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.security.compliance.api.model.filepolicy.AuthEntity;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ResultType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a0 {
    public final com.ss.android.lark.conditional.access.auth.v2.a a;
    public f b;

    public static final class a implements Runnable {
        public final /* synthetic */ a0 a;
        public final /* synthetic */ Context b;

        public a(a0 r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a0 r0 = this.a;     // Catch: Throwable -> L4
            r0.b = new f(this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b {
    }

    static {
    }

    public a0(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this.a = new com.ss.android.lark.conditional.access.auth.v2.a();
        if (w4c.c.a().p() == true) goto L6;
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new a(this, r3));
        return;
    }

    public final void a(List<ValidateResult> r4, AuthEntity r5) {
        Iterator<T> r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L9;
        ValidateResult r0 = (ValidateResult) r6.next();
        if (r0.getResult() == ResultType.DENY) goto L4;
        if (r5 == null) goto L4;
        ValidateResult r1 = this.a.a(r5, null);
        r0.setResult(r1.getResult());
        r0.setResultPolicy(r1.getResultPolicy());
        r0.setErrorReason(r1.getErrorReason());
        r0.setPolicyMethod(r1.getPolicyMethod());
        r0.setCredible(r1.isCredible());
        goto L4
    }
}
