package y6a;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.u0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class q implements Runnable {
    public final /* synthetic */ Runnable a;
    public final /* synthetic */ r b;

    @Override // java.lang.Runnable
    public final void run() {
    L12:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L19;
        throw th;
    L19:
        return;
    L3:
        if (TraceEvent.isTracingStarted() == false) goto L5;
        TraceEvent.beginSection("ViewLayoutTick.requestLayout");     // Catch: Throwable -> L12
    L5:
        View r0 = this.b.a;     // Catch: Throwable -> L12
        if (r0 == null) goto L8;
        r0.requestLayout();     // Catch: Throwable -> L12
    L8:
        r r1 = this.b;     // Catch: Throwable -> L12
        r1.b = this.a;     // Catch: Throwable -> L12
        if (TraceEvent.isTracingStarted() == false) goto L15;
        TraceEvent.endSection("ViewLayoutTick.requestLayout");     // Catch: Throwable -> L12
        return;
    }

    public q(r r1, u0 r2) {
        this.b = r1;
        this.a = r2;
    }
}
