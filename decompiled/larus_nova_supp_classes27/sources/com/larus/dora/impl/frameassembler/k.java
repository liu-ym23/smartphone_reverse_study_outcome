package com.larus.dora.impl.frameassembler;

import com.larus.dora.impl.file.DoraFileStreamingSink;
import g49.d;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class k implements d {
    public final e a;
    public final j b;
    public final f c;
    public final g d;
    public final ConcurrentHashMap<i, l> e;
    public final CoroutineScope f;
    public volatile boolean g;

    public static final class a {
    }

    static {
    }

    public final void shutdown() {
        this.g = true;
        CoroutineScopeKt.cancel$default(this.f, null, 1, null);
        Iterator<Map.Entry<i, l>> r0 = this.e.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().getValue().i(DoraIncompleteReason.EXPLICIT_CLOSE, null, null);
        goto L4
    L6:
        this.e.clear();
    }

    public final void b() {
        d.d("DoraStreamingFrameAssem", "cleanupExpiredSessions");
        long r1 = System.currentTimeMillis();
        Iterator<Map.Entry<i, l>> r3 = this.e.entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L19;
        Map.Entry<i, l> r4 = r3.next();
        i r5 = r4.getKey();
        l r6 = r4.getValue();
        if (r6.o == false) goto L8;
    L10:
        boolean r7 = false;
    L11:
        if (r7 == false) goto L4;
        r6.l();     // Catch: Throwable -> L14
    L17:
        if (this.e.remove(r5, r6) == false) goto L4;
        this.d.b();
    L14:
        th = move-exception;
        d.c("DoraStreamingFrameAssem", "session.onTimeout error, key=" + r5, th);
        goto L17
    L8:
        if ((r1 - r6.h) < r6.b.a) goto L10;
        r7 = true;
        goto L11
    }

    public k(e r8, DoraFileStreamingSink.c r9) {
        Intrinsics.checkNotNullParameter(r8, "config");
        Intrinsics.checkNotNullParameter(r9, "consumer");
        this.a = r8;
        this.b = r9;
        this.c = new f();
        this.d = new g(r8);
        this.e = new ConcurrentHashMap();
        CoroutineScope r1 = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault().plus(SupervisorKt.SupervisorJob$default(null, 1, null)).plus(new a0("frame-assembler-cleaner-stream")));
        this.f = r1;
        BuildersKt.launch$default(r1, null, null, new DoraStreamingFrameAssembler$1(r8.b, this, null), 3, null);
    }

    public final void a(long r17, int r110, int r20, int r21, int r22, byte[] r23, long r24, byte[] r26) {
        Intrinsics.checkNotNullParameter(r23, "data");
        if (this.g == false) goto L5;
        return;
    L5:
        i r1 = new i(r17, r24, r110, r20);
        long r14 = System.currentTimeMillis();
        l r2 = this.e.get(r1);
        if (r2 != null) goto L22;
        g r3 = this.d;
    L8:
        int r4 = r3.b.get();
        if (r4 >= r3.a.c) goto L10;
        if (r3.b.compareAndSet(r4, r4 + 1) == false) goto L8;
        boolean r5 = true;
    L14:
        if (r5 == true) goto L19;
        h r12 = new h(r1, r14, r14, r22, false, 0);
        this.b.c(r12, new ByteArrayOutputStream(), new IllegalStateException("Too many sessions"));     // Catch: Exception -> L29
    L17:
        this.c.b();
        return;
    L19:
        r2 = new l(r1, this.a, this.d, this.c, this.b, r14);
        this.c.a.incrementAndGet();
        l r6 = this.e.putIfAbsent(r1, r2);
        if (r6 == null) goto L22;
        this.d.b();
        l r9 = r6;
    L23:
        r9.g(r110, r20, r21, r22, r23, r26);
        if (r9.o == true) goto L26;
        return;
    L26:
        if (this.e.remove(r1, r9) == false) goto L36;
        this.d.b();
        return;
    L36:
        return;
    L10:
        r5 = false;
    L22:
        r9 = r2;
        goto L23
    }
}
