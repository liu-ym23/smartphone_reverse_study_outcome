package y6a;

import android.view.Choreographer;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.u0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c implements Choreographer.FrameCallback {
    public final /* synthetic */ Runnable a;
    public final /* synthetic */ d b;

    public class a implements Runnable {
        public final /* synthetic */ c a;

        @Override // java.lang.Runnable
        public final void run() {
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        L16:
            return;
        L3:
            if (TraceEvent.isTracingStarted() == false) goto L5;
            TraceEvent.beginSection("ChoreographerLayoutTick.triggerLayout");     // Catch: Throwable -> L9
        L5:
            this.a.a.run();     // Catch: Throwable -> L9
            if (TraceEvent.isTracingStarted() == false) goto L12;
            TraceEvent.endSection("ChoreographerLayoutTick.triggerLayout");     // Catch: Throwable -> L9
            return;
        }

        public a(c r1) {
            this.a = r1;
        }
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r1) {
        if (this.b.a.hasLayoutThreadChanged() == false) goto L6;
        this.b.a.runOnLayoutThread(new a(this));
        return;
    L6:
        if (TraceEvent.isTracingStarted() == false) goto L8;
        TraceEvent.beginSection("ChoreographerLayoutTick.triggerLayout");
    L8:
        this.a.run();
        if (TraceEvent.isTracingStarted() == false) goto L13;
        TraceEvent.endSection("ChoreographerLayoutTick.triggerLayout");
        return;
    }

    public c(d r1, u0 r2) {
        this.b = r1;
        this.a = r2;
    }
}
