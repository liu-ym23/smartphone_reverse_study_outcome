package com.ss.android.lark.conditional.access.traffic;

import com.larus.apm.impl.protector.RunnableProtector;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ a b;
    public final /* synthetic */ byte[] c;

    public c(String r1, a r2, byte[] r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        String r1 = this.a;
        a r2 = this.b;
        byte[] r3 = this.c;
        String r4 = qqb.a.d();     // Catch: Throwable -> L9
        qqb.a.f(r1);     // Catch: Throwable -> L7
        a.a(r2, r3);     // Catch: Throwable -> L7
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r4, "traceId");
        qqb.a.g(r4);
        return;
    L7:
        th = th;
    L11:
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r4, "traceId");
        qqb.a.g(r4);
        throw th;
    L9:
        th = th;
        r4 = BuildConfig.FLAVOR;
        goto L11
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
