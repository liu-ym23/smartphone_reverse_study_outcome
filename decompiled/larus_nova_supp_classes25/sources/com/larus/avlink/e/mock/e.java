package com.larus.avlink.e.mock;

import com.larus.utils.logger.FLogger;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e {
    public static final e a = null;
    public static g b;
    public static f c;
    public static final AtomicBoolean d = null;
    public static final Lazy e = null;

    public e() {
    }

    static {
        a = new e();
        d = new AtomicBoolean(false);
        e = LazyKt.lazy(new d());
    }

    public final void a() {
        if (d.get() == true) goto L6;
        b(this);
        return;
    }

    public static void b(e r4) {
        r4.getClass();
        if (d.getAndSet(true) == true) goto L17;
        b = new g();
        c = new f();
        g r5 = b;
        if ((r5 instanceof g) == true) goto L10;
        r5 = null;
    L10:
        if (r5 == null) goto L12;
        r5.c.set(10);
        FLogger.a.i("CameraMockRecorder", "📹 Recording mode set: mode=10, dataSetId=" + r5.d.get());
    L12:
        g r6 = b;
        if (r6 == null) goto L15;
        r6.i();
    L15:
        FLogger.a.i("CameraMockManager", "CameraMockManager initialized with mode=10 (recording enabled by default)");
        return;
    }
}
