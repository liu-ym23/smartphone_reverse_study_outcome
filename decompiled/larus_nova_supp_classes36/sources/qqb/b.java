package qqb;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ Runnable b;

    public b(String r1, Runnable r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r1 = this.a;     // Catch: Throwable -> L12
        Runnable r2 = this.b;     // Catch: Throwable -> L12
        String r3 = a.d();     // Catch: Throwable -> L8
        a.f(r1);     // Catch: Throwable -> L6
        r2.run();     // Catch: Throwable -> L6
        a.a();     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r3, "traceId");     // Catch: Throwable -> L12
        a.g(r3);     // Catch: Throwable -> L12
        return;
    L6:
        th = th;
    L10:
        a.a();     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r3, "traceId");     // Catch: Throwable -> L12
        a.g(r3);     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L8:
        th = th;
        r3 = "";
    L12:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L22;
        throw th;
    }
}
