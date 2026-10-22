package dxb;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class a {
    public final ntb.o.a a;

    public final synchronized void b() {
        monitor-enter(this);
        Map<String, Object> r0 = c();     // Catch: Throwable -> L14
        if (r0 == null) goto L8;
        boolean r1 = true;
        if ((!r0.isEmpty()) != true) goto L8;
    L9:
        if (r1 == false) goto L11;
        this.a.b();     // Catch: Throwable -> L14
    L11:
        this.a.flush();     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L8:
        r1 = false;
    L14:
        th = move-exception;
        throw th;
    }

    public abstract Map<String, Object> c();

    public a(String r1, ntb.o.b r2) {
        int r3 = com.ss.android.lark.officesdk.utils.di.l.a;
        ntb.o r4 = com.ss.android.lark.officesdk.utils.di.l.a.a();
        if (r4 == null) goto L6;
        ntb.o.a r5 = r4.d();
        if (r5 == null) goto L6;
    L7:
        this.a = r5;
        return;
    L6:
        r5 = new com.ss.android.lark.officesdk.utils.di.k();
        goto L7
    }

    public final void a(String r1, Object r2) {
        Intrinsics.checkNotNullParameter(r1, "key");
        this.a.a(r1);
    }
}
