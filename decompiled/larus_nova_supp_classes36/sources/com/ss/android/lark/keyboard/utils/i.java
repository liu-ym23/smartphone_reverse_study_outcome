package com.ss.android.lark.keyboard.utils;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.keyboard.base.r;
import com.ss.android.lark.log.Log;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i implements Runnable {
    public final /* synthetic */ com.ss.android.lark.keyboard.b a;
    public final /* synthetic */ com.ss.android.lark.keyboard.base.f b;
    public final /* synthetic */ Long c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ String e;
    public final /* synthetic */ r f;
    public final /* synthetic */ String g;

    public i(com.ss.android.lark.keyboard.b r1, com.ss.android.lark.keyboard.base.f r2, Long r3, String r4, r r5, String r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = false;
        this.e = r4;
        this.f = r5;
        this.g = r6;
    }

    public final void a() {
        com.ss.android.lark.keyboard.base.f r0 = this.b;
        Long r2 = this.c;
        boolean r3 = this.d;
        String r4 = this.e;
        r r5 = this.f;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        r0.F(false, r2, r3, r4, r5);     // Catch: Throwable -> L5
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        String r7 = this.g;
        Throwable r8 = Result.exceptionOrNull-impl(r6);
        if (r8 == null) goto L13;
        Log.e(r7, "sendContentByKeyboardEditor failed", r8);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
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
