package com.larus.voicecall.impl.tracer;

import java.util.concurrent.LinkedBlockingQueue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public final LinkedBlockingQueue<b> a;

    /* JADX INFO: renamed from: com.larus.voicecall.impl.tracer.a$a, reason: collision with other inner class name */
    public static final class C0023a {
    }

    static {
    }

    public a() {
        this.a = new LinkedBlockingQueue();
    }

    public final void a(b r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        this.a.put(r2);
    }
}
