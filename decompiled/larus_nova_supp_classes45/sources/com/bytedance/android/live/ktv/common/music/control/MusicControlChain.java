package com.bytedance.android.live.ktv.common.music.control;

import android.os.Looper;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class MusicControlChain {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final g d;

    public final CopyOnWriteArrayList<IMusicControlNode> c() {
        return (CopyOnWriteArrayList) this.b.getValue();
    }

    public final CopyOnWriteArrayList<IMusicControlNode> d() {
        return (CopyOnWriteArrayList) this.a.getValue();
    }

    public MusicControlChain(g r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.d = r2;
        this.a = LazyKt.lazy(MusicControlChain$waitingList$2.INSTANCE);
        this.b = LazyKt.lazy(MusicControlChain$runningList$2.INSTANCE);
        this.c = LazyKt.lazy(MusicControlChain$interceptors$2.INSTANCE);
    }

    public final void b(d r2) {
        Intrinsics.checkNotNullParameter(r2, "node");
        d().add(r2);
        e("addNode");
    }

    public final void e(String r6) {
        Intrinsics.checkNotNullParameter(r6, "source");
        if ((!Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper()))) == false) goto L6;
        LocalTestManager.a(new Class[]{wy.a.class});
        return;
    L6:
        com.bytedance.android.live.ktv.common.util.g.a("MusicControlChain#loop, source: " + r6 + ", waitingList size: " + d().size() + ",running size:" + c().size());
        if (d().isEmpty() == false) goto L9;
        return;
    L9:
        Iterator<IMusicControlNode> r0 = d().iterator();
    L11:
        if (r0.hasNext() == false) goto L18;
        IMusicControlNode r1 = r0.next();
        h r2 = (h) ((Map) this.c.getValue()).get(r1.getType());
        if (r2 == null) goto L17;
        if (r2.a(r1, d(), c()) == true) goto L17;
        d().remove(r1);
        c().add(r1);
        r1.b(this.d);
    L17:
        com.bytedance.android.live.ktv.common.util.g.a("intercept node, ".concat(r6));
        goto L11
    }

    public final void f(IMusicControlNode r2) {
        Intrinsics.checkNotNullParameter(r2, "node");
        c().remove(r2);
        e("removeNode");
    }

    public final void a(IMusicControlNode.OperationType r2, h r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "interceptor");
        ((Map) this.c.getValue()).put(r2, r3);
    }
}
