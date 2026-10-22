package com.bytedance.android.anniex.scene.handler.idle;

import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f implements Runnable {
    public final /* synthetic */ c<?> a;

    public static final class a implements Runnable {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            h.a.d();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public f(c<?> r1) {
        this.a = r1;
    }

    public final void a() {
        long r0 = System.currentTimeMillis();
        h r10 = h.a;
        h.b(this.a, TaskStatus.RUNNING);
        boolean r11 = true;
        c<?> r12 = this.a;     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type com.bytedance.android.anniex.scene.handler.idle.IdleTask<kotlin.Any>");     // Catch: Throwable -> L5
        r12.a(this.a.getContext());     // Catch: Throwable -> L5
        boolean r13 = true;
    L7:
        long r14 = System.currentTimeMillis() - r0;
        h r1 = h.a;
        c<?> r15 = this.a;
        if (r13 == false) goto L10;
        TaskStatus r16 = TaskStatus.SUCCESS;
    L11:
        h.b(r15, r16);
        HybridLogger r17 = HybridLogger.a;
        Long r18 = null;
        HybridLogger.f("IdleTaskQueue", "[Serial] " + this.a.b + '-' + this.a.a + " duration=" + r14 + "ms", null, 12);
        h.f.set(false);
        Long r19 = Long.valueOf(this.a.f);
        if (r19.longValue() > 0) goto L15;
        r11 = false;
    L15:
        if (r11 == false) goto L17;
        r18 = r19;
    L17:
        if (r18 == null) goto L19;
        long r20 = r18.longValue();
    L20:
        h.d.schedule(a.a, r20, TimeUnit.MILLISECONDS);
        return;
    L19:
        r20 = 1000;
        goto L20
    L10:
        r16 = TaskStatus.FAILED;
    L5:
        th = move-exception;
        String r21 = this.a.a;
        th.getMessage();
        r13 = false;
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
