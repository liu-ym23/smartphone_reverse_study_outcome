package y6a;

import android.view.Choreographer;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.u0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d implements f {
    public final LynxContext a;

    public d(LynxContext r1) {
        this.a = r1;
    }

    @Override // y6a.f
    public final void a(u0 r4) {
        if (TraceEvent.isTracingStarted() == false) goto L5;
        TraceEvent.beginSection("ChoreographerLayoutTick.requestLayout");
    L5:
        Choreographer.getInstance().postFrameCallback(new c(this, r4));
        if (TraceEvent.isTracingStarted() == false) goto L9;
        TraceEvent.endSection("ChoreographerLayoutTick.requestLayout");
        return;
    }
}
