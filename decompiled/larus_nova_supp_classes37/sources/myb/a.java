package myb;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.optrace.api.TracingCoreSpan;
import com.ss.android.lark.optrace.core.b;
import com.ss.android.lark.optrace.core.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a implements Runnable {
    public TracingCoreSpan a;
    public final Runnable b;

    public final void a() {
        c.a.getClass();
        b r0 = jyb.a.b;
        TracingCoreSpan r1 = this.a;
        r0.getClass();
        com.ss.android.lark.optrace.core.a r2 = new com.ss.android.lark.optrace.core.a(r0, r1);
        if (this.b != null) goto L5;
        Log.i("SpanWrappedRunnable", "no innerRunnable, do execute()");
    L7:
        if (r0.a.get() != r2) goto L11;
        r0.a.set(r2.b);
        return;
    L11:
        return;
    L5:
        Log.i("SpanWrappedRunnable", "has innerRunnable, ignore execute()");
        this.b.run();
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

    public a(Runnable r3) {
        this.b = r3;
        c.a.getClass();
        com.ss.android.lark.optrace.core.a r4 = jyb.a.b.a.get();
        if (r4 != null) goto L5;
        TracingCoreSpan r5 = null;
    L6:
        if (r5 != null) goto L8;
        Log.w("SpanWrappedRunnable", "no activeSpan for currentThread");
        c.a.getClass();
        r5 = jyb.a.c.generateSpan();
        c.a.getClass();
        b r0 = jyb.a.b;
        r0.getClass();
        new com.ss.android.lark.optrace.core.a(r0, r5);
    L8:
        this.a = r5.generateSpan();
        return;
    L5:
        r5 = r4.a;
        goto L6
    }
}
