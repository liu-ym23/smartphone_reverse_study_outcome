package dxb;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class s implements Runnable {
    public final /* synthetic */ cxb.a a;

    public s(cxb.a r1, long r2) {
        this.a = r1;
    }

    public final void a() {
        c.a r0 = c.a;
        cxb.a r1 = this.a;
        int r2 = com.ss.android.lark.officesdk.utils.di.l.a;
        ntb.o r3 = com.ss.android.lark.officesdk.utils.di.l.a.a();
        if (r3 == null) goto L6;
        ntb.o.a r4 = r3.d();
        if (r4 == null) goto L6;
    L7:
        Intrinsics.checkNotNullParameter("duration", "key");
        r4.a("duration");
        if (r1 != null) goto L23;
        Map<String, Object> r5 = null;
    L13:
        if (r5 == null) goto L17;
        boolean r6 = true;
        if ((!r5.isEmpty()) != true) goto L17;
    L18:
        if (r6 == false) goto L20;
        r4.b();     // Catch: Throwable -> L10
    L20:
        r4.flush();     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    L17:
        r6 = false;
        goto L18
    L23:
        r5 = r1.getCommonParams();     // Catch: Throwable -> L10
    L6:
        r4 = new com.ss.android.lark.officesdk.utils.di.k();
        goto L7
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
