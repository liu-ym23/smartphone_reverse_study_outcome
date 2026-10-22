package com.bytedance.apm.trace.api;

import com.bytedance.apm.trace.model.cross.NativeSpan;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.apm.trace.model.a f1437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1438b;
    private boolean c;

    public synchronized void a(String r6, ArrayList<NativeSpan> r7) {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L4:
        if (this.c == false) goto L6;
    L21:
        monitor-exit(this);
        return;
    L6:
        if (this.f1438b == false) goto L21;
        boolean r0 = true;
        Iterator<NativeSpan> r8 = r7.iterator();     // Catch: Throwable -> L23
    L9:
        if (r8.hasNext() == false) goto L19;
        NativeSpan r1 = (NativeSpan) ZeusTransformUtils.preCheckCast(r8.next(), NativeSpan.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        if (r1 == null) goto L9;
        c r2 = r1.parseToSpan(this.f1437a);     // Catch: Throwable -> L23
        if (r0 == false) goto L17;
        r2.a(Long.parseLong(r6));     // Catch: Throwable -> L23
    L17:
        r2.a(r1.getStartTime(), r1.getFinishTime());     // Catch: Throwable -> L23
        r0 = false;
        goto L9
    L19:
        monitor-exit(this);
    }

    public synchronized void b(String r6, ArrayList<NativeSpan> r7) {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L4:
        if (this.c == false) goto L6;
    L21:
        monitor-exit(this);
        return;
    L6:
        if (this.f1438b == false) goto L21;
        boolean r0 = true;
        Iterator<NativeSpan> r8 = r7.iterator();     // Catch: Throwable -> L23
    L9:
        if (r8.hasNext() == false) goto L19;
        NativeSpan r1 = (NativeSpan) ZeusTransformUtils.preCheckCast(r8.next(), NativeSpan.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        if (r1 == null) goto L9;
        c r2 = r1.parseToSpan(this.f1437a);     // Catch: Throwable -> L23
        if (r0 == false) goto L17;
        r2.b(Long.parseLong(r6));     // Catch: Throwable -> L23
    L17:
        r2.a(r1.getStartTime(), r1.getFinishTime());     // Catch: Throwable -> L23
        r0 = false;
        goto L9
    L19:
        monitor-exit(this);
    }
}
