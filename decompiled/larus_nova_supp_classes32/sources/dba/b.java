package dba;

import android.os.Handler;
import android.os.SystemClock;
import com.obric.assistant.activation.presentation.runtime.gesture.scheduler.ObricAiKeyGestureTimeout;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b implements c {
    public final Handler a;
    public final Map<ObricAiKeyGestureTimeout, Runnable> b;

    @Override // dba.c
    public final void a() {
        Collection r0 = ((LinkedHashMap) this.b).values();
        Handler r1 = this.a;
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.removeCallbacks((Runnable) r2.next());
        goto L4
    L6:
        ((LinkedHashMap) this.b).clear();
    }

    public b(Handler r2) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        this.a = r2;
        this.b = new LinkedHashMap();
    }

    @Override // dba.c
    public final void b(ObricAiKeyGestureTimeout r2) {
        Intrinsics.checkNotNullParameter(r2, "timeout");
        Runnable r3 = this.b.remove(r2);
        if (r3 == null) goto L6;
        this.a.removeCallbacks(r3);
        return;
    }

    @Override // dba.c
    public final void c(final ObricAiKeyGestureTimeout r4, long r5, final cba.a r7) {
        Intrinsics.checkNotNullParameter(r4, "timeout");
        Intrinsics.checkNotNullParameter(r7, "callback");
        b(r4);
        Runnable r0 = new a(this, r4, r7);
        this.b.put(r4, r0);
        this.a.postAtTime(r0, Math.max(r5, SystemClock.uptimeMillis()));
    }
}
