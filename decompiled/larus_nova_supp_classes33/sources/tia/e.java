package tia;

import com.larus.utils.logger.FLogger;
import com.obric.capabilitykit.common.Ext;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class e implements hga.c {
    public final f a;
    public final hga.e b;
    public final Function1<Long, Boolean> c;
    public final Function1<e, Unit> d;
    public volatile long e;
    public final AtomicBoolean f;
    public final AtomicBoolean g;
    public final int h;

    public static final class a {
    }

    static {
    }

    @Override // hga.c
    public final void release() {
        if (this.g.compareAndSet(false, true) == false) goto L6;
        this.d.invoke(this);
        return;
    }

    @Override // hga.c
    public final void start() {
        this.f.set(true);
    }

    @Override // hga.c
    public final void stop() {
        this.f.set(false);
    }

    @Override // hga.c
    public final int a() {
        return this.h;
    }

    @Override // hga.c
    public final long d(long r1) {
        return tia.a.a(r1);
    }

    @Override // hga.c
    public final int read(byte[] r6) {
        Intrinsics.checkNotNullParameter(r6, "buffer");
        if (this.f.get() == true) goto L5;
        return 0;
    L5:
        if (this.g.get() == true) goto L29;
        f r0 = this.a;
        monitor-enter(r0);
        d r7 = this.a.b(this.e, r6);     // Catch: Throwable -> L22
        monitor-exit(r0);
        if (r7.c <= 0) goto L14;
        FLogger.a.i("WakeupCaptureReader", "reader missing audio scene=" + this.b.a + " reason=" + this.b.c + " missingMs=" + r7.c);
    L14:
        this.e = r7.b;
        if (r7.a != 0) goto L21;
        if (((Boolean) this.c.invoke(Long.valueOf(this.e))).booleanValue() == false) goto L21;
        return -1;
    L21:
        return r7.a;
    L22:
        th = move-exception;
        throw th;
    L29:
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(f r2, hga.e r3, Function1<? super Long, Boolean> r4, Function1<? super e, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "ringBuffer");
        Intrinsics.checkNotNullParameter(r3, Ext.KEY_REQUEST);
        Intrinsics.checkNotNullParameter(r4, "shouldStopOnEmpty");
        Intrinsics.checkNotNullParameter(r5, "onRelease");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r3.b;
        this.f = new AtomicBoolean(false);
        this.g = new AtomicBoolean(false);
        this.h = 5120;
    }
}
