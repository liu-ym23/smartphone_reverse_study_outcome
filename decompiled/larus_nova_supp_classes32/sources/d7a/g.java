package d7a;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class g implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ f c;

    public final void a() {
        f r0 = this.c;
        int r1 = this.a;
        int r2 = this.b;
        if (r0.p0 == false) goto L5;
    L10:
        f.c r3 = r0.g2;
    L11:
        v7a.f r4 = r0.c(r1, r2, r0.d);
        if (r4 == null) goto L17;
        r0.G = r4;
        r0.S1 = System.currentTimeMillis();
        c r5 = r0.c;
        f.e r6 = r0.V1;
        LynxContext r7 = r0.b;
        r5.getClass();
        TraceEvent.beginSection("LynxImageServiceProxy.fetchImage");
        if (r5.b == true) goto L16;
        r5.a.fetchImage(r4, r6, r3, r7);
        TraceEvent.endSection("LynxImageServiceProxy.fetchImage");
        return;
    L16:
        throw null;
    L17:
        return;
    L5:
        if (r0.Z == true) goto L10;
        if (r0.k0 == true) goto L10;
        r3 = null;
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

    public g(f r1, int r2, int r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
