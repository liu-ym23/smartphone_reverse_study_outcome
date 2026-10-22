package rx9;

import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class k {
    public static final AtomicInteger h = null;
    public final String a;
    public final boolean b;
    public final AtomicLong c;
    public final AtomicLong d;
    public final String e;
    public final String f;
    public volatile boolean g;

    public static final class a {
    }

    static {
        h = new AtomicInteger(1);
    }

    public final void a() {
        if (rx9.a.a.get() == true) goto L6;
        return;
    L6:
        if (this.c.get() != 0) goto L10;
        s.a(this.e, this.f + " end failure, no start");
        return;
    L10:
        if (this.d.compareAndSet(0, SystemClock.elapsedRealtime()) == false) goto L12;
        Lazy r0 = q.a;
        Intrinsics.checkNotNullParameter(this, "task");
        q.a(new o(this));
        s.a(this.e, this.f + " end success");
        return;
    L12:
        s.a(this.e, this.f + " end failure, completed");
    }

    public final void b() {
        if (rx9.a.a.get() == true) goto L6;
        return;
    L6:
        if (this.d.get() == 0) goto L10;
        s.a(this.e, this.f + " start failure, completed");
        return;
    L10:
        if (this.c.compareAndSet(0, SystemClock.elapsedRealtime()) == false) goto L12;
        Lazy r0 = q.a;
        Intrinsics.checkNotNullParameter(this, "task");
        q.a(new n(this));
        s.a(this.e, this.f + " start success");
        return;
    L12:
        s.a(this.e, this.f + " start failure, started");
    }

    public k(String r4) {
        Intrinsics.checkNotNullParameter(r4, "taskName");
        this.a = r4;
        this.b = true;
        this.c = new AtomicLong(0);
        this.d = new AtomicLong(0);
        StringBuilder r0 = new StringBuilder("TickTask@");
        Intrinsics.checkNotNullParameter(this, "<this>");
        r0.append(Integer.toHexString(hashCode()));
        this.e = r0.toString();
        this.f = r4 + '#' + h.getAndIncrement();
        AtomicBoolean r5 = rx9.a.a;
        this.g = rx9.a.f;
    }
}
