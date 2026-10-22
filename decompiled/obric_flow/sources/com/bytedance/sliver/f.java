package com.bytedance.sliver;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f7516a;

    public f(String r5) {
        this.f7516a = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (SliverAllThreadSupport.access$000(this.f7516a) == true) goto L5;
        return;
    L5:
        Iterator r5 = SliverAllThreadSupport.access$100().iterator();
    L7:
        if (r5.hasNext() == false) goto L31;
        g r10 = (g) r5.next();
        String r11 = this.f7516a;
        monitor-enter(r10);
        BufferedWriter r12 = null;
        BufferedWriter r13 = new BufferedWriter(new FileWriter(r11, true));     // Catch: Throwable -> L44
        Iterator r14 = r10.f7519c.iterator();     // Catch: Throwable -> L19
    L14:
        if (r14.hasNext() == false) goto L20;
        Thread r15 = (Thread) r14.next();     // Catch: Throwable -> L19
        long r16 = Sliver.getThreadPeer(r15);     // Catch: Throwable -> L19
        if (r16 == 0) goto L14;
        r13.write("# thread_info:" + SliverAllThreadSupport.access$800(r16) + ":" + r15.getName() + "\n");     // Catch: Throwable -> L19
        goto L14
    L20:
        r13.flush();     // Catch: Throwable -> L19
        r13.close();     // Catch: Throwable -> L22 IOException -> L43
    L22:
        th = move-exception;
        throw th;
    L29:
        monitor-exit(r10);
    L19:
        r12 = r13;
    L24:
        if (r12 == null) goto L29;
        r12.close();     // Catch: Throwable -> L22 IOException -> L43
        goto L29
    L31:
        Iterator r17 = SliverAllThreadSupport.access$100().iterator();
    L33:
        if (r17.hasNext() == false) goto L42;
        g r18 = (g) r17.next();
        String r19 = this.f7516a;
        monitor-enter(r18);
        SliverAllThreadSupport.access$900(r18.d, r19);     // Catch: Throwable -> L39
        monitor-exit(r18);
    L39:
        th = move-exception;
        throw th;
    }
}
