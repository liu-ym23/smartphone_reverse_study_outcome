package com.bytedance.android.ec.core.imagex.common;

import android.os.Process;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class v implements Runnable {
    public boolean a;
    public Integer b;
    public final Integer c;

    public static final class a extends v {
        public final Runnable d;

        @Override // com.bytedance.android.ec.core.imagex.common.v
        public final void b() {
            this.d.run();
        }

        public a(Integer r10, Runnable r11) {
            Intrinsics.checkNotNullParameter(r11, "runnable");
            super(r10);
            this.d = r11;
        }
    }

    public v() {
        this(null);
    }

    public final void a() {
        Integer r0 = null;
        Integer r1 = Integer.valueOf(Process.getThreadPriority(Process.myTid()));     // Catch: Throwable -> L5
    L6:
        this.b = r1;
        if ((!Intrinsics.areEqual(r1, this.c)) == false) goto L16;
        Integer r10 = this.c;
        if (r10 == null) goto L16;
        int r11 = r10.intValue();
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L13
        Process.setThreadPriority(r11);     // Catch: Throwable -> L13
        Object r13 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        Result.box-impl(r13);
    L13:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
    L16:
        b();
        if (this.a == false) goto L40;
        r0 = Integer.valueOf(Process.getThreadPriority(Process.myTid()));     // Catch: Throwable -> L20
    L22:
        if ((!Intrinsics.areEqual(r0, this.b)) == false) goto L41;
        Integer r15 = this.b;
        if (r15 == null) goto L42;
        int r16 = r15.intValue();
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L28
        Process.setThreadPriority(r16);     // Catch: Throwable -> L28
        Object r18 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L28
    L30:
        Result.box-impl(r18);
        return;
    L28:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L30
    L42:
        return;
    L41:
        return;
    L40:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public abstract void b();

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

    public v(Integer r1) {
        this.c = r1;
        this.a = true;
    }
}
