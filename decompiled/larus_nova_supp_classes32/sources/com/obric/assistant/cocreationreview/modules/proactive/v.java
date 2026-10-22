package com.obric.assistant.cocreationreview.modules.proactive;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class v {
    public static final /* synthetic */ int d = 0;
    public final Function1<Runnable, Unit> a;
    public final Function0<Unit> b;
    public final AtomicBoolean c;

    public static final class a {
        /* JADX WARN: Type inference failed for: r2v0, types: [com.obric.assistant.cocreationreview.modules.proactive.t] */
        /* JADX WARN: Type inference failed for: r3v0, types: [com.obric.assistant.cocreationreview.modules.proactive.u] */
        public static v a() {
            Intrinsics.checkNotNullParameter("proactive-agent-load", "threadName");
            final ExecutorService r0 = PThreadExecutorsUtils.newSingleThreadExecutor(new s());
            return new v(new t(r0), new u(r0));
        }
    }

    static {
    }

    public v(t r2, u r3) {
        Intrinsics.checkNotNullParameter(r2, "dispatch");
        Intrinsics.checkNotNullParameter(r3, "release");
        this.a = r2;
        this.b = r3;
        this.c = new AtomicBoolean(false);
    }
}
