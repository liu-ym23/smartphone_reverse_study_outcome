package com.larus.bmhome.resource.access;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class y {
    public static final y a = null;

    static {
        a = new y();
    }

    public y() {
    }

    public static f a(w r13) {
        Intrinsics.checkNotNullParameter(r13, "request");
        x0 r0 = x0.a;
        Intrinsics.checkNotNullParameter(r13, "request");
        Object r1 = x0.f;
        monitor-enter(r1);
        x0.b();     // Catch: Throwable -> L74
        StateFlowImpl r2 = s.a;     // Catch: Throwable -> L74
        Intrinsics.checkNotNullParameter(r13, "<this>");     // Catch: Throwable -> L74
        x r3 = r13.a;     // Catch: Throwable -> L74
        String r4 = r13.d.a;     // Catch: Throwable -> L74
        boolean r5 = false;
        if (r4.length() <= 0) goto L7;
        boolean r6 = true;
    L9:
        if (r6 == true) goto L12;
        r4 = null;
    L12:
        if (r4 != null) goto L14;
        r4 = r13.b.a();     // Catch: Throwable -> L74
    L14:
        r0 r8 = new r0(r3, r4, r13.c, r13.d.c);     // Catch: Throwable -> L74
        ConcurrentHashMap<r0, f> r7 = x0.d;     // Catch: Throwable -> L74
        f r9 = r7.get(r8);     // Catch: Throwable -> L74
        if (r9 != null) goto L17;
    L22:
        f r10 = new f(UUID.randomUUID().toString(), r8, r13);     // Catch: Throwable -> L74
        x0.c.put(r10.a, r10);     // Catch: Throwable -> L74
        r7.put(r8, r10);     // Catch: Throwable -> L74
        String r14 = r13.d.a;     // Catch: Throwable -> L74
        if (r14.length() != 0) goto L25;
        boolean r11 = true;
    L26:
        if (r11 == true) goto L33;
        ConcurrentHashMap<r0, f> r12 = new ConcurrentHashMap();     // Catch: Throwable -> L74
        ConcurrentHashMap<r0, f> r15 = x0.e.putIfAbsent(r14, r12);     // Catch: Throwable -> L74
        if (r15 == null) goto L32;
        r12 = r15;
    L32:
        r12.put(r8, r10);     // Catch: Throwable -> L74
    L33:
        x0.d(r10, ResourceTraceResult.CREATED, null);     // Catch: Throwable -> L74
        x0.a r16 = new x0.a(r10, true);     // Catch: Throwable -> L74
    L34:
        monitor-exit(r1);
        if (r16.b == false) goto L73;
        CoroutineScope r17 = x0.b;
        Job r18 = BuildersKt.launch$default(r17, null, null, new ResourceTaskManager$submit$job$1(r16, null), 3, null);
        f r19 = r16.a;
        r19.getClass();
        Intrinsics.checkNotNullParameter(r18, "job");
        if (r19.c() == false) goto L40;
        Job.DefaultImpls.cancel$default(r18, null, 1, null);
    L48:
        f r20 = r16.a;
        d0 r21 = r20.c.d.l;
        Long r22 = r21.a;
        if (r22 != null) goto L51;
    L56:
        boolean r23 = false;
    L57:
        if (r23 == true) goto L68;
        Long r24 = r21.b;
        if (r24 != null) goto L61;
    L66:
        boolean r25 = false;
    L67:
        if (r25 == true) goto L68;
    L69:
        if (r5 == false) goto L73;
        BuildersKt.launch$default(r17, null, null, new ResourceTaskManager$startTimeoutWatchdog$1(r20, r21, null), 3, null);
        goto L73
    L61:
        if (r24.longValue() <= 0) goto L63;
        boolean r26 = true;
    L64:
        if (r26 != true) goto L66;
        r25 = true;
        goto L67
    L63:
        r26 = false;
    L68:
        r5 = true;
        goto L69
    L51:
        if (r22.longValue() <= 0) goto L53;
        boolean r27 = true;
    L54:
        if (r27 != true) goto L56;
        r23 = true;
        goto L57
    L53:
        r27 = false;
        goto L54
    L40:
        Job r28 = r19.h.getAndSet(r18);
        if (r28 == null) goto L44;
        Job.DefaultImpls.cancel$default(r28, null, 1, null);
    L44:
        if (r19.c() == false) goto L48;
        Job r29 = r19.h.getAndSet(null);
        if (r29 == null) goto L48;
        Job.DefaultImpls.cancel$default(r29, null, 1, null);
    L73:
        return r16.a;
    L25:
        r11 = false;
        goto L26
    L17:
        if (r9.c() == false) goto L20;
        r9 = null;
    L20:
        if (r9 == null) goto L22;
        x0.d(r9, ResourceTraceResult.REUSE_ACTIVE, null);     // Catch: Throwable -> L74
        r16 = new x0.a(r9, false);     // Catch: Throwable -> L74
        goto L34
    L7:
        r6 = false;
    L74:
        th = move-exception;
        throw th;
    }

    public final z query(String r2) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        return x0.a.query(r2);
    }
}
