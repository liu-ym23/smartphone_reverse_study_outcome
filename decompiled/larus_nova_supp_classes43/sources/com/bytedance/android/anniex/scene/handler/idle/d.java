package com.bytedance.android.anniex.scene.handler.idle;

import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d implements Runnable {
    public final /* synthetic */ c<?> a;

    public d(c<?> r1) {
        this.a = r1;
    }

    public final void a() {
        long r0 = System.currentTimeMillis();
        h r10 = h.a;
        h.b(this.a, TaskStatus.RUNNING);
        c<?> r11 = this.a;     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type com.bytedance.android.anniex.scene.handler.idle.IdleTask<kotlin.Any>");     // Catch: Throwable -> L5
        r11.a(this.a.getContext());     // Catch: Throwable -> L5
        boolean r12 = true;
    L7:
        long r13 = System.currentTimeMillis() - r0;
        h r1 = h.a;
        c<?> r14 = this.a;
        if (r12 == false) goto L10;
        TaskStatus r15 = TaskStatus.SUCCESS;
    L11:
        h.b(r14, r15);
        HybridLogger r16 = HybridLogger.a;
        HybridLogger.f("IdleTaskQueue", "[Parallel] " + this.a.b + '-' + this.a.a + " duration=" + r13 + "ms", null, 12);
        return;
    L10:
        r15 = TaskStatus.FAILED;
    L5:
        th = move-exception;
        String r17 = this.a.a;
        th.getMessage();
        r12 = false;
        goto L7
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
